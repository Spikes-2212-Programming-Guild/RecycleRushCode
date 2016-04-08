/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.commands.forkLifter.StopLifter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
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

    /**
     *
     * @param elevator1
     * @param elevator2
     * @param up
     * @param down
     * @param encoder
     * @param wheelDiameter
     * 
     */
    public Lifter(CANTalon elevator1, CANTalon elevator2, DigitalInput up,
			DigitalInput down) {
		this.elevator1 = elevator1;
		this.elevator2 = elevator2;
		this.up = up;
		this.down = down;
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
    public Lifter(int talon1ID, int talon2ID, int upPort, int downPort) {
		this(new CANTalon(talon1ID), new CANTalon(talon2ID),
				upPort == -1 ? null : new DigitalInput(upPort),
				downPort == -1 ? null : new DigitalInput(downPort));
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

    

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new StopLifter());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
