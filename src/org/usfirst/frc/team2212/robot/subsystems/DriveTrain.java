/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import components.Gearbox;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class DriveTrain extends Subsystem {

    private Gearbox left, right;
    private VictorSP front, rear;

    public DriveTrain(Gearbox left, Gearbox right, VictorSP front, VictorSP rear) {
        this.left = left;
        this.right = right;
        this.front = front;
        this.rear = rear;
    }

    public DriveTrain(int leftForward, int leftBackwards, int rightForward, int rightBackwards, int middleFront, int middleRear) {
        this(new Gearbox(leftForward, leftBackwards), new Gearbox(rightForward, rightBackwards), new VictorSP(middleFront), new VictorSP(middleRear));
    }

    public void forward(double speed) {
        left.set(-speed);
        right.set(speed);
    }

    public void turn(double speed) {
        left.set(speed);
        right.set(speed);
//        omni turn inculded
        front.set(speed);
        rear.set(speed);
    }

    public void sideways(double speed) {
//        positive to go left
        front.set(speed);
        rear.set(-speed);
    }
    
    public void freeMovement(double forwardSpeed, double sidewaysSpeed){
        forward(forwardSpeed);
        sideways(sidewaysSpeed);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
