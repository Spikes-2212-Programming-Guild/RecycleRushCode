/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class Fork extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private Relay lock;
	private DigitalInput open, close;

	public Fork(Relay lock, DigitalInput open, DigitalInput close) {
		this.lock = lock;
		this.open = open;
		this.close = close;
	}

	public Fork(int lockPort, int openPort, int closePort) {
		this(new Relay(lockPort), new DigitalInput(openPort), new DigitalInput(
				closePort));
	}

	public void open() {
		// assuming forward for open
		lock.set(Relay.Value.kForward);
	}

	public void close() {
		// assuming forward for open
		lock.set(Relay.Value.kReverse);
	}

	public void stop() {
		lock.set(Relay.Value.kOff);
	}

	public boolean isClosed() {
		return close.get();
	}

	public boolean isOpen() {
		return open.get();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
