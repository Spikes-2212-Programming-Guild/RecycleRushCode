/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class Fork extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final CANTalon lock;
	private final DigitalInput open1, open2, close;

	public Fork(CANTalon lock, DigitalInput open1, DigitalInput open2,
			DigitalInput close) {
		this.lock = lock;
		this.open1 = open1;
		this.open2 = open2;
		this.close = close;
	}

	public Fork(int talonID, int open1Port, int open2Port, int closePort) {
		this(new CANTalon(talonID), new DigitalInput(open1Port),
				new DigitalInput(open2Port), new DigitalInput(closePort));
	}

	public void open() {
		// assuming forward for open
		lock.set(1);
	}

	public void close() {
		// assuming forward for open
		lock.set(-1);
	}

	public void stop() {
		lock.set(0);
	}

	public boolean isClosed() {
		return close.get();
	}

	public boolean isOpen() {
		return open1.get() || open2.get();
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
