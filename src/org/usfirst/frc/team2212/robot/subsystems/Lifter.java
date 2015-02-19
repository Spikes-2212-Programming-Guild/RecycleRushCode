/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.pid.Stay;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author ThinkRedstone
 */
public class Lifter extends PIDSubsystem {

	public static final double P = 0.25;
	public static final double I = 0;
	public static final double D = 0;
	public static final double TOLERANCE = 0.125;
	// public static final double STAY_SPEED = 0.15;
	public static final double WHEEL_DIAMETER = 4;
	public static final int LIFTER_MAX_LEVEL = 6;
	public static final double ENCODER_TICKS_IN_FULL_TURN = 360;
	public static final double DISTANCE_PER_PULSE = Math.PI * WHEEL_DIAMETER
			/ ENCODER_TICKS_IN_FULL_TURN;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	CANTalon elevator1, elevator2;
	DigitalInput up, down;
	Encoder encoder;
	int currentLevel;

	public Lifter() {
		super(P, I, D);
		setSetpoint(0);
		setAbsoluteTolerance(TOLERANCE);
		this.elevator1 = new CANTalon(RobotMap.LIFTER_TALON_1_ID);
		this.elevator2 = new CANTalon(RobotMap.LIFTER_TALON_2_ID);
		this.up = new DigitalInput(RobotMap.LIFTER_UP_DI_PORT);
		this.down = new DigitalInput(RobotMap.LIFTER_DOWN_DI_PORT);
		this.encoder = new Encoder(RobotMap.LIFTER_ENCODER_PORT1,
				RobotMap.LIFTER_ENCODER_PORT2);
		encoder.setDistancePerPulse(DISTANCE_PER_PULSE);
	}

	public void set(double s) {
		elevator1.set(-s);
		elevator2.set(-s);
	}

	public boolean isUp() {
		return up.get();
	}

	public boolean isDown() {
		return down.get();
	}

	public double getHeight() {
		return encoder.getDistance();
	}

	public void reset() {
		encoder.reset();
	}

	public void levelUp() {
		// You can only level up if the level is not corrupted
		if (currentLevel != -1) {
			currentLevel++;
		}
	}

	public void levelDown() {
		if (currentLevel != -1) {
			currentLevel--;
		}
	}

	public void resetLevel() {
		currentLevel = 0;
	}

	public void corruptLevel() {
		currentLevel = -1;
	}

	public void setLevel(int level) {
		currentLevel = level;
	}

	public int getLevel() {
		return currentLevel;
	}

	public void verifyLevel() {
		if (down != null && down.get()) {
			this.resetLevel();
		}
		if (up != null && up.get()) {
			this.setLevel(LIFTER_MAX_LEVEL);
		}
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Stay());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public double returnPIDInput() {
		return getHeight();
	}

	@Override
	public void usePIDOutput(double output) {
		set(output);
	}
}
