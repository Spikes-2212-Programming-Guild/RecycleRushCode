/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import static org.usfirst.frc.team2212.robot.Robot.drivetrain;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.driving.JoystickFreeMovement;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class Drivetrain extends Subsystem {

	public static final double MAX_TURN_SPEED = 0.25;
	public static final double WHEEL_DIAMETER = 6; // inches
	public static final double FIXED_TOLARANCE = 0.5;
	public static final double TURN_TOLERANCE = 0.01;
	public static final double ENCODER_TICKS_IN_FULL_TURN = 360;
	public static final double MAX_ACCY = 0.1;
	public static final double MAX_ACCX = 0.1;
	public static final double DISTANCE_PER_PULSE = WHEEL_DIAMETER * Math.PI
			/ ENCODER_TICKS_IN_FULL_TURN;

	public static final double FREE_SENSITIVE_FACTOR = 0.5;

	public static final boolean FRONT_REVERSED = false;
	public static final boolean REAR_REVERSED = true;
	public static final boolean LEFT_REVERSED = false;
	public static final boolean RIGHT_REVERSED = true;

	boolean freeSensitive;
	Gearbox left, right;
	VictorSP front, rear;
	BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	Encoder leftE, rightE, frontE, rearE;

	public Drivetrain() {
		this.left = new Gearbox(RobotMap.LEFT_FRONT_VICTOR,
				RobotMap.LEFT_REAR_VICTOR);
		this.right = new Gearbox(RobotMap.RIGHT_FRONT_VICTOR,
				RobotMap.RIGHT_REAR_VICTOR);
		this.front = new VictorSP(RobotMap.MIDDLE_FRONT_VICTOR);
		this.rear = new VictorSP(RobotMap.MIDDLE_REAR_VICTOR);
		this.frontE = new Encoder(RobotMap.FRONT_ENCODER_A,
				RobotMap.FRONT_ENCODER_B);
		this.rearE = new Encoder(RobotMap.REAR_ENCODER_A,
				RobotMap.REAR_ENCODER_B);
		this.leftE = new Encoder(RobotMap.LEFT_ENCODER_A,
				RobotMap.LEFT_ENCODER_B);
		this.rightE = new Encoder(RobotMap.RIGHT_ENCODER_A,
				RobotMap.RIGHT_ENCODER_B);

		frontE.setDistancePerPulse(DISTANCE_PER_PULSE);
		rearE.setDistancePerPulse(DISTANCE_PER_PULSE);
		leftE.setDistancePerPulse(DISTANCE_PER_PULSE);
		rightE.setDistancePerPulse(DISTANCE_PER_PULSE);

		frontE.setReverseDirection(FRONT_REVERSED);
		rearE.setReverseDirection(REAR_REVERSED);
		leftE.setReverseDirection(LEFT_REVERSED);
		rightE.setReverseDirection(RIGHT_REVERSED);

	}

	public void stop() {
		left.set(0);
		right.set(0);
		front.set(0);
		rear.set(0);
	}

	public void forward(double speed) {
		speed = limitFree(speed);
		double expectedAccelerationY = speed - getRightSpeed();
		double dirAccY = Math.signum(expectedAccelerationY);
		double newSpeed = 0;
		if (Math.abs(expectedAccelerationY) > MAX_ACCY) {
			newSpeed = drivetrain.getRightSpeed() + dirAccY * MAX_ACCY;
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
		if (Math.abs(expectedAcceleration) > MAX_ACCY) {
			newSpeed = drivetrain.getRightSpeed() + dirAcc * MAX_ACCY;
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
		if (Math.abs(expectedAcceleration) > MAX_ACCX) {
			newSpeed = drivetrain.getFrontSpeed() + dirAccX * MAX_ACCX;
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
		if (Math.abs(turnSpeed) > TURN_TOLERANCE) {
			forwardSpeed = limitFree(forwardSpeed);
			sidewaysSpeed = limitFree(sidewaysSpeed);
			turnSpeed = limitTurn(turnSpeed);
			double expectedAccelerationY = forwardSpeed - getRightSpeed();
			double expectedAccelerationX = sidewaysSpeed - getFrontSpeed();
			double dirAccY = Math.signum(expectedAccelerationY);
			double dirAccX = Math.signum(expectedAccelerationX);
			double newForwardSpeed, newSidewaysSpeed;
			if (Math.abs(expectedAccelerationY) > MAX_ACCY) {
				newForwardSpeed = drivetrain.getRightSpeed() + dirAccY
						* MAX_ACCY;
			} else {
				newForwardSpeed = forwardSpeed;
			}
			if (Math.abs(expectedAccelerationX) > MAX_ACCX) {
				newSidewaysSpeed = drivetrain.getFrontSpeed() + dirAccX
						* MAX_ACCX;
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
		if (Math.abs(getFront() - getRear()) > FIXED_TOLARANCE) {
			speed = limitFree(speed);
			double expectedAccelerationX = speed - getFrontSpeed();
			double dirAccX = Math.signum(expectedAccelerationX);
			double newSpeed;
			if (Math.abs(expectedAccelerationX) > MAX_ACCX) {
				newSpeed = drivetrain.getFrontSpeed() + dirAccX * MAX_ACCX;
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
		if (Math.abs(getLeft() - getRight()) > FIXED_TOLARANCE) {
			speed = limitFree(speed);
			double expectedAccelerationY = speed - getRightSpeed();
			double dirAccY = Math.signum(expectedAccelerationY);
			double newSpeed;
			if (Math.abs(expectedAccelerationY) > MAX_ACCY) {
				newSpeed = drivetrain.getRightSpeed() + dirAccY * MAX_ACCY;
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
				* (!freeSensitive ? 1.0 : FREE_SENSITIVE_FACTOR)
				* Math.min(1, Math.abs(speed));
	}

	private static double limitTurn(double speed) {
		return Math.signum(speed) * MAX_TURN_SPEED
				* Math.min(1, Math.abs(speed));
	}

	public void reset() {
		rightE.reset();
		leftE.reset();
		frontE.reset();
		rearE.reset();
	}

	public double getRear() {
		return rearE.getDistance();
	}

	public double getLeft() {
		return leftE.getDistance();
	}

	public double getFront() {
		return frontE.getDistance();
	}

	public double getRight() {
		return rightE.getDistance();
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
		setDefaultCommand(new JoystickFreeMovement());
	}

	public void changeSensitivity() {
		freeSensitive = !freeSensitive;
	}

	public boolean isSensitive() {
		return freeSensitive;
	}
}
