/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Stay;

/**
 *
 * @author ThinkRedstone
 */
public class Lifter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Talon elevator;
    private DigitalInput up, down;
    private Encoder encoder;
    private double wheelDiameter;
    
    public Lifter(Talon elevator, DigitalInput up, DigitalInput down, Encoder encoder,double wheelDiameter) {
        this.elevator = elevator;
        this.up = up;
        this.down = down;
        this.encoder = encoder;
        this.wheelDiameter = wheelDiameter;
    }

    public Lifter(int victorPort, int upPort, int downPort, int encoderPort1, int encoderPort2, double wheelDiameter) {
        this(new Talon(victorPort), new DigitalInput(upPort), new DigitalInput(downPort), new Encoder(encoderPort1, encoderPort2),wheelDiameter);
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
    
    public double get(){
        return encoder.get()*RobotMap.ENCODER_TICKS_IN_FULL_TURN*Math.PI*wheelDiameter;
    }
    
    public void reset(){
        encoder.reset();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Stay());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
