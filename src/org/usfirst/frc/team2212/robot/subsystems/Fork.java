/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class Fork extends Subsystem {

	public static final double SPEED = 0.6;
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	CANTalon lock;
	DigitalInput open1, open2, close;

	public Fork() {
		this.lock = new CANTalon(RobotMap.FORK_TALON_ID);
		this.open1 = new DigitalInput(RobotMap.FORK_OPEN_DI_1_PORT);
		this.open2 = new DigitalInput(RobotMap.FORK_OPEN_DI_2_PORT);
		this.close = new DigitalInput(RobotMap.FORK_CLOSE_DI_PORT);
	}

	public void open() {
		// assuming forward for open
		lock.set(SPEED);
	}

	public void close() {
		// assuming forward for open
		lock.set(-SPEED);
	}

	public void stop() {
		lock.set(0);
	}

	public boolean isClosed() {
		return close.get();
	}

	public boolean isOpen() {
		return !open1.get() || !open2.get();
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
