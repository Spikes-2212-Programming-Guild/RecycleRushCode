/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;

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

	boolean freeSensitive;

	private final Gearbox left, right;
	private final VictorSP front, rear;
	private final double wheelDiameter;
	private final BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	private final Encoder leftE, rightE, frontE, rearE;

	/**
	 *
	 * @param left
	 * @param right
	 * @param front
	 * @param rear
	 * @param leftE
	 * @param rightE
	 * @param frontE
	 * @param rearE
	 * @param wheelDiameter
	 */
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
		frontE.setDistancePerPulse(wheelDiameter * 2.54 * Math.PI / 360);
		leftE.setDistancePerPulse(wheelDiameter * 2.54 * Math.PI / 360);
		rightE.setDistancePerPulse(wheelDiameter * 2.54 * Math.PI / 360);
		rearE.setDistancePerPulse(wheelDiameter * 2.54 * Math.PI / 360);
	}

	/**
	 *
	 * @param leftForward
	 * @param leftBackwards
	 * @param rightForward
	 * @param rightBackwards
	 * @param middleFront
	 * @param middleRear
	 * @param leftEncoderPort1
	 * @param leftEncoderPort2
	 * @param rightEncoderPort1
	 * @param rightEncoderPort2
	 * @param frontEncoderPort1
	 * @param frontEncoderPort2
	 * @param rearEncoderPort1
	 * @param rearEncoderPort2
	 * @param wheelDiameter
	 */
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

	/**
	 *
	 * @param speed
	 */
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

	/**
	 *
	 * @param speed
	 */
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

	/**
	 *
	 * @param speed
	 */
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

	/**
	 *
	 * @param forwardSpeed
	 * @param sidewaysSpeed
	 */
	public void freeMovement(double forwardSpeed, double sidewaysSpeed) {
		forward(forwardSpeed);
		sideways(sidewaysSpeed);
	}

	/**
	 *
	 * @param forwardSpeed
	 * @param sidewaysSpeed
	 * @param turnSpeed
	 */
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

	/**
	 *
	 * @param speed
	 * @deprecated
	 */
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
	/**
	 *
	 * @param speed
	 * @deprecated
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

	/**
     *
     */
	public void reset() {
		rightE.reset();
		leftE.reset();
		frontE.reset();
		if (rearE != null) {
			rearE.reset();
		}
	}

	/**
	 *
	 * @return
	 */
	public double getRear() {
		return rearE == null ? 0 : -rearE.get();
	}

	/**
	 *
	 * @return
	 */
	public double getLeft() {
		return leftE.get();
	}

	/**
	 *
	 * @return
	 */
	public double getFront() {
		return frontE.get();
	}

	/**
	 *
	 * @return
	 */
	public double getRight() {
		return -rightE.get();
	}

	/**
	 *
	 * @return
	 */
	public double getXAcceleration() {
		return accelerometer.getX();
	}

	/**
	 *
	 * @return
	 */
	public double getYAcceleration() {
		return accelerometer.getY();
	}

	/**
	 *
	 * @return
	 */
	public double getLeftSpeed() {
		return left.get();
	}

	/**
	 *
	 * @return
	 */
	public double getRightSpeed() {
		return right.get();
	}

	/**
	 *
	 * @return
	 */
	public double getFrontSpeed() {
		return front.get();
	}

	/**
	 *
	 * @return
	 */
	public double getRearSpeed() {
		return rear.get();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new FreeMovement());
	}

	/**
     *
     */
	public void changeForwardSensitivity() {
		freeSensitive = !freeSensitive;
	}

	/**
	 *
	 * @return
	 */
	public boolean isForwardSensitive() {
		return freeSensitive;
	}
}
