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
public class Lifter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay elevator;
    DigitalInput up, down;

    public Lifter(Relay elevator, DigitalInput up, DigitalInput down) {
        this.elevator = elevator;
        this.up = up;
        this.down = down;
    }

    public Lifter(int elevatorPort, int upPort, int downPort) {
        this(new Relay(elevatorPort), new DigitalInput(upPort), new DigitalInput(downPort));
    }

    public void up() {
//        assuming forward for up
        elevator.set(Relay.Value.kForward);
    }

    public void down() {
//        assuming forward for up
        elevator.set(Relay.Value.kReverse);
    }

    public void stop() {
        elevator.set(Relay.Value.kOff);
    }

    public boolean isUp() {
        return up.get();
    }

    public boolean isDown() {
        return down.get();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
