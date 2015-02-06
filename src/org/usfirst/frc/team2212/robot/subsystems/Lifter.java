/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Stay;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class Lifter extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final TalonSRX elevator;
	private final DigitalInput up, down;
	private final Encoder encoder;
	private final double wheelDiameter;
	private int currentLevel;

	public Lifter(TalonSRX elevator, DigitalInput up, DigitalInput down,
			Encoder encoder, double wheelDiameter) {
		this.elevator = elevator;
		this.up = up;
		this.down = down;
		this.encoder = encoder;
		this.wheelDiameter = wheelDiameter;
	}

	public Lifter(int victorPort, int upPort, int downPort, int encoderPort1,
			int encoderPort2, double wheelDiameter) {
		this(new TalonSRX(victorPort), new DigitalInput(upPort),
				new DigitalInput(downPort), new Encoder(encoderPort1,
						encoderPort2), wheelDiameter);
	}

	public void set(double s) {
		elevator.set(s);
	}

	public boolean isUp() {
		return up.get();
	}

	public boolean isDown() {
		return down.get();
	}

	public double get() {
		return encoder.get() * RobotMap.ENCODER_TICKS_IN_FULL_TURN * Math.PI
				* wheelDiameter;
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
		if (down.get()) {
			this.resetLevel();
		}
		if (up.get()) {
			this.setLevel(RobotMap.MAX_LIFTER_LEVEL);
		}
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Stay());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
