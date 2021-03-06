/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Stay;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class Lifter extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final CANTalon elevator1, elevator2;
	private final DigitalInput up, down;
	private final Encoder encoder;
	private final double wheelDiameter;
	private int currentLevel;

    /**
     *
     * @param elevator1
     * @param elevator2
     * @param up
     * @param down
     * @param encoder
     * @param wheelDiameter
     */
    public Lifter(CANTalon elevator1, CANTalon elevator2, DigitalInput up,
			DigitalInput down, Encoder encoder, double wheelDiameter) {
		this.elevator1 = elevator1;
		this.elevator2 = elevator2;
		this.up = up;
		this.down = down;
		this.encoder = encoder;
		this.wheelDiameter = wheelDiameter;
	}

    /**
     *
     * @param talon1ID
     * @param talon2ID
     * @param upPort
     * @param downPort
     * @param encoderPort1
     * @param encoderPort2
     * @param wheelDiameter
     */
    public Lifter(int talon1ID, int talon2ID, int upPort, int downPort,
			int encoderPort1, int encoderPort2, double wheelDiameter) {
		this(new CANTalon(talon1ID), new CANTalon(talon2ID),
				upPort == -1 ? null : new DigitalInput(upPort),
				downPort == -1 ? null : new DigitalInput(downPort),
				new Encoder(encoderPort1, encoderPort2), wheelDiameter);
	}

    /**
     *
     * @param s
     */
    public void set(double s) {
		elevator1.set(-s);
		elevator2.set(-s);
	}

    /**
     *
     * @return
     */
    public boolean isUp() {
		if (up != null)
			return up.get();
		return false;
	}

    /**
     *
     * @return
     */
    public boolean isDown() {
		if (down != null)
			return down.get();
		return false;
	}

    /**
     *
     * @return
     */
    public double getHeight() {
		return encoder.get() / RobotMap.LIFTER_ENCODER_TICKS_IN_FULL_TURN
				* Math.PI * wheelDiameter;
	}

    /**
     *
     */
    public void reset() {
		encoder.reset();
	}

    /**
     *
     */
    public void levelUp() {
		// You can only level up if the level is not corrupted
		if (currentLevel != -1) {
			currentLevel++;
		}
	}

    /**
     *
     */
    public void levelDown() {
		if (currentLevel != -1) {
			currentLevel--;
		}
	}

    /**
     *
     */
    public void resetLevel() {
		currentLevel = 0;
	}

    /**
     *
     */
    public void corruptLevel() {
		currentLevel = -1;
	}

    /**
     *
     * @param level
     */
    public void setLevel(int level) {
		currentLevel = level;
	}

    /**
     *
     * @return
     */
    public int getLevel() {
		return currentLevel;
	}

    /**
     *
     */
    public void verifyLevel() {
		if (down != null && down.get()) {
			this.resetLevel();
		}
		if (up != null && up.get()) {
			this.setLevel(RobotMap.LIFTER_MAX_LEVEL);
		}
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Stay());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
