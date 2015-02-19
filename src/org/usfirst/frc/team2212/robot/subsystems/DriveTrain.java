/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import static org.usfirst.frc.team2212.robot.RobotMap.ENCODER_TICKS_IN_FULL_TURN;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.driving.FreeMovement;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class DriveTrain extends Subsystem {

	boolean freeSensitive;

	Gearbox left, right;
	VictorSP front, rear;
	BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	Encoder leftE, rightE, frontE, rearE;

	public DriveTrain() {
		this.left = new Gearbox(RobotMap.LEFT_FORWARD_VICTOR_PORT,
				RobotMap.LEFT_BACKWARDS_VICTOR_PORT);
		this.right = new Gearbox(RobotMap.RIGHT_FORWARD_VICTOR_PORT,
				RobotMap.RIGHT_BACKWARDS_VICTOR_PORT);
		this.front = new VictorSP(RobotMap.MIDDLE_FRONT_VICTOR_PORT);
		this.rear = new VictorSP(RobotMap.MIDDLE_BACKWARDS_VICTOR_PORT);
		this.frontE = new Encoder(RobotMap.FRONT_ENCODER_1_PORT,
				RobotMap.FRONT_ENCODER_2_PORT);
		this.rearE = new Encoder(RobotMap.REAR_ENCODER_1_PORT,
				RobotMap.REAR_ENCODER_2_PORT);
		this.leftE = new Encoder(RobotMap.LEFT_ENCODER_1_PORT,
				RobotMap.LEFT_ENCODER_2_PORT);
		this.rightE = new Encoder(RobotMap.RIGHT_ENCODER_1_PORT,
				RobotMap.RIGHT_ENCODER_2_PORT);
	}

	public void forward(double speed) {
		speed = limitFree(speed);
		double expectedAccelerationY = speed - getRightSpeed();
		double dirAccY = Math.signum(expectedAccelerationY);
		double newSpeed = 0;
		if (Math.abs(expectedAccelerationY) > RobotMap.MAX_ACCY) {
			newSpeed = driveTrain.getRightSpeed() + dirAccY * RobotMap.MAX_ACCY;
		} else {
			newSpeed = speed;
		}
		left.set(-newSpeed);
		right.set(newSpeed);
	}

	public void turn(double speed) {
		speed = limitTurn(speed);
		double expectedAcceleration = speed - getRightSpeed();
		double dirAcc = Math.signum(expectedAcceleration);
		double newSpeed = 0;
		if (Math.abs(expectedAcceleration) > RobotMap.MAX_ACCY) {
			newSpeed = driveTrain.getRightSpeed() + dirAcc * RobotMap.MAX_ACCY;
		} else {
			newSpeed = speed;
		}
		left.set(newSpeed);
		right.set(newSpeed);
		// omni turn inculded
		front.set(newSpeed);
		rear.set(newSpeed);
	}

	public void sideways(double speed) {
		// positive to go right
		// don't be negative, it will make your life shorter
		speed = limitFree(speed);
		double expectedAcceleration = speed - getFrontSpeed();
		double dirAccX = Math.signum(expectedAcceleration);
		double newSpeed = 0;
		if (Math.abs(expectedAcceleration) > RobotMap.MAX_ACCX) {
			newSpeed = driveTrain.getFrontSpeed() + dirAccX * RobotMap.MAX_ACCX;
		} else {
			newSpeed = speed;
		}
		front.set(newSpeed);
		rear.set(-newSpeed);
	}

	public void freeMovement(double forwardSpeed, double sidewaysSpeed) {
		forward(forwardSpeed);
		sideways(sidewaysSpeed);
	}

	public void freeMovement(double forwardSpeed, double sidewaysSpeed,
			double turnSpeed) {
		if (Math.abs(turnSpeed) > RobotMap.TURN_TOLERANCE) {
			forwardSpeed = limitFree(forwardSpeed);
			sidewaysSpeed = limitFree(sidewaysSpeed);
			turnSpeed = limitTurn(turnSpeed);
			double expectedAccelerationY = forwardSpeed - getRightSpeed();
			double expectedAccelerationX = sidewaysSpeed - getFrontSpeed();
			double dirAccY = Math.signum(expectedAccelerationY);
			double dirAccX = Math.signum(expectedAccelerationX);
			double newForwardSpeed, newSidewaysSpeed;
			if (Math.abs(expectedAccelerationY) > RobotMap.MAX_ACCY) {
				newForwardSpeed = driveTrain.getRightSpeed() + dirAccY
						* RobotMap.MAX_ACCY;
			} else {
				newForwardSpeed = forwardSpeed;
			}
			if (Math.abs(expectedAccelerationX) > RobotMap.MAX_ACCX) {
				newSidewaysSpeed = driveTrain.getFrontSpeed() + dirAccX
						* RobotMap.MAX_ACCX;
			} else {
				newSidewaysSpeed = sidewaysSpeed;
			}
			front.set(newSidewaysSpeed + turnSpeed);
			rear.set(-newSidewaysSpeed + turnSpeed);
			left.set(newForwardSpeed + turnSpeed);
			right.set(-newForwardSpeed + turnSpeed);
		} else {
			freeMovement(forwardSpeed, sidewaysSpeed);
		}
	}

	@Deprecated
	public void fixedSideways(double speed) {
		if (Math.abs(getFront() - getRear()) > RobotMap.FIXED_TOLARANCE) {
			speed = limitFree(speed);
			double expectedAccelerationX = speed - getFrontSpeed();
			double dirAccX = Math.signum(expectedAccelerationX);
			double newSpeed;
			if (Math.abs(expectedAccelerationX) > RobotMap.MAX_ACCX) {
				newSpeed = driveTrain.getFrontSpeed() + dirAccX
						* RobotMap.MAX_ACCX;
			} else {
				newSpeed = speed;
			}
			if (getFront() > getRear()) {
				front.set(newSpeed * getRear() / getFront());
				rear.set(-newSpeed);
			} else {
				front.set(newSpeed);
				rear.set(-(newSpeed * getFront() / getRear()));
			}
		} else {
			sideways(speed);
		}
	}

	/*
	 * Ido was here . Gurny too .Yonatan was'nt;
	 */

	@Deprecated
	public void fixedForward(double speed) {
		if (Math.abs(getLeft() - getRight()) > RobotMap.FIXED_TOLARANCE) {
			speed = limitFree(speed);
			double expectedAccelerationY = speed - getRightSpeed();
			double dirAccY = Math.signum(expectedAccelerationY);
			double newSpeed;
			if (Math.abs(expectedAccelerationY) > RobotMap.MAX_ACCY) {
				newSpeed = driveTrain.getRightSpeed() + dirAccY
						* RobotMap.MAX_ACCY;
			} else {
				newSpeed = speed;
			}
			if (getLeft() > getRight()) {
				left.set(-(newSpeed * getRight() / getLeft()));
				right.set(newSpeed);
			} else {
				left.set(-newSpeed);
				right.set(newSpeed * getLeft() / getRight());
			}
		} else {
			forward(speed);
		}
	}

	private double limitFree(double speed) {
		return Math.signum(speed)
				* (!freeSensitive ? 1.0 : RobotMap.FREE_SENSITIVE_FACTOR)
				* Math.min(1, Math.abs(speed));
	}

	private double limitTurn(double speed) {
		return Math.signum(speed) * RobotMap.MAX_TURN_SPEED
				* Math.min(1, Math.abs(speed));
	}

	public void reset() {
		rightE.reset();
		leftE.reset();
		frontE.reset();
		if (rearE != null)
			rearE.reset();
	}

	public double getRear() {
		return -rearE.get() / (double) ENCODER_TICKS_IN_FULL_TURN * Math.PI
				* RobotMap.WHEEL_DIAMETER;
	}

	public double getLeft() {
		return leftE.get() / (double) ENCODER_TICKS_IN_FULL_TURN * Math.PI
				* RobotMap.WHEEL_DIAMETER;
	}

	public double getFront() {
		return frontE.get() / (double) ENCODER_TICKS_IN_FULL_TURN * Math.PI
				* RobotMap.WHEEL_DIAMETER;
	}

	public double getRight() {
		return -rightE.get() / (double) ENCODER_TICKS_IN_FULL_TURN * Math.PI
				* RobotMap.WHEEL_DIAMETER;
	}

	public double getXAcceleration() {
		return accelerometer.getX();
	}

	public double getYAcceleration() {
		return accelerometer.getY();
	}

	public double getLeftSpeed() {
		return left.get();
	}

	public double getRightSpeed() {
		return right.get();
	}

	public double getFrontSpeed() {
		return front.get();
	}

	public double getRearSpeed() {
		return rear.get();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new FreeMovement());
	}

	public void changeForwardSensitivity() {
		freeSensitive = !freeSensitive;
	}

	public boolean isSensitive() {
		return freeSensitive;
	}
}
