/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import static org.usfirst.frc.team2212.robot.RobotMap.ENCODER_TICKS_IN_FULL_TURN;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.driving.FreeMovement;

import components.Gearbox;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class DriveTrain extends Subsystem {

	private final Gearbox left, right;
	private final VictorSP front, rear;
	private final double wheelDiameter;
	private final BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	private final Encoder leftE, rightE, frontE, rearE;

	public DriveTrain(Gearbox left, Gearbox right, VictorSP front,
			VictorSP rear, Encoder leftE, Encoder rightE, Encoder frontE,
			Encoder rearE, double wheelDiameter) {
		this.left = left;
		this.right = right;
		this.front = front;
		this.rear = rear;
		this.frontE = frontE;
		this.rearE = rearE;
		this.leftE = leftE;
		this.rightE = rightE;
		this.wheelDiameter = wheelDiameter;
	}

	public DriveTrain(int leftForward, int leftBackwards, int rightForward,
			int rightBackwards, int middleFront, int middleRear,
			int leftEncoderPort1, int leftEncoderPort2, int rightEncoderPort1,
			int rightEncoderPort2, int frontEncoderPort1,
			int frontEncoderPort2, int rearEncoderPort1, int rearEncoderPort2,
			double wheelDiameter) {
		this(new Gearbox(leftForward, leftBackwards), new Gearbox(rightForward,
				rightBackwards), new VictorSP(middleFront), new VictorSP(
				middleRear), new Encoder(leftEncoderPort1, leftEncoderPort2),
				new Encoder(rightEncoderPort1, rightEncoderPort2), new Encoder(
						frontEncoderPort1, frontEncoderPort2),
				rearEncoderPort1 == -1 || rearEncoderPort2 == -1 ? null
						: new Encoder(rearEncoderPort1, rearEncoderPort2),
				wheelDiameter);
	}

	public void forward(double speed) {
		left.set(-speed);
		right.set(speed);
	}

	public void turn(double speed) {
		if (Math.abs(speed) > RobotMap.MAX_TURN_SPEED) {
			speed = Math.signum(speed) * RobotMap.MAX_TURN_SPEED;
		}
		left.set(speed);
		right.set(speed);
		// omni turn inculded
		front.set(speed);
		rear.set(speed);
	}

	public void sideways(double speed) {
		// positive to go right
		front.set(-speed);
		rear.set(speed);
	}

	public void freeMovement(double forwardSpeed, double sidewaysSpeed) {
		forward(forwardSpeed);
		sideways(sidewaysSpeed);
	}

	public void fixedForward(double speed) {
		if (Math.abs(getLeft() - getRight()) > RobotMap.FIXED_TOLARANCE) {
			if (getLeft() > getRight()) {
				front.set(-speed * (getRight() / getLeft()));
				rear.set(-speed);
			} else {
				front.set(-speed);
				rear.set(-speed * (getLeft() / getRight()));
			}
		}
		reset();
	}

	public void freeMovement(double forwardSpeed, double sidewaysSpeed,
			double turnSpeed) {
		if (Math.abs(turnSpeed) > RobotMap.TURN_TOLERANCE) {
			front.set(turnSpeed);
			rear.set(turnSpeed);
			left.set(forwardSpeed + turnSpeed);
			right.set(-forwardSpeed - turnSpeed);
		} else {
			freeMovement(forwardSpeed, sidewaysSpeed);
		}
	}

	public void reset() {
		rightE.reset();
		leftE.reset();
		frontE.reset();
		if (rearE != null)
			rearE.reset();
	}

	public double getRear() {
		return rearE == null ? 0 : rightE.get()
				/ (double) ENCODER_TICKS_IN_FULL_TURN * Math.PI * wheelDiameter;
	}

	public double getLeft() {
		return leftE.get() / (double) ENCODER_TICKS_IN_FULL_TURN * Math.PI
				* wheelDiameter;
	}

	public double getFront() {
		return frontE.get() / (double) ENCODER_TICKS_IN_FULL_TURN * Math.PI
				* wheelDiameter;
	}

	public double getRight() {
		return rightE.get() / (double) ENCODER_TICKS_IN_FULL_TURN * Math.PI
				* wheelDiameter;
	}

	public double getXAcceleration() {
		return accelerometer.getX();
	}

	public double getYAcceleration() {
		return accelerometer.getY();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new FreeMovement());
	}
}
