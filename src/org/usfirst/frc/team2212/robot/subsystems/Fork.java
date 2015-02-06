/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class Fork extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private final TalonSRX lock;
	private final DigitalInput open, close;

	public Fork(TalonSRX lock, DigitalInput open, DigitalInput close) {
		this.lock = lock;
		this.open = open;
		this.close = close;
	}

	public Fork(int talonPort, int openPort, int closePort) {
		this(new TalonSRX(talonPort), new DigitalInput(openPort),
				new DigitalInput(closePort));
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
		return open.get();
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
