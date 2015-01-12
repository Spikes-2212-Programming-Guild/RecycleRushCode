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
public class ForkLift extends Subsystem {

    Relay elevator, lock;
    DigitalInput open, close, up, down;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public ForkLift(Relay elevator, Relay lock, DigitalInput open, DigitalInput close, DigitalInput up, DigitalInput down) {
        this.elevator = elevator;
        this.lock = lock;
        this.open = open;
        this.close = close;
        this.up = up;
        this.down = down;
    }
    
    public ForkLift(int elevatorPort,int lockPort,int openPort,int closePort,int upPort, int downPort ){
        this(new Relay(elevatorPort),new Relay(lockPort), new DigitalInput(openPort), new DigitalInput(closePort), new DigitalInput(upPort), new DigitalInput(downPort));
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
