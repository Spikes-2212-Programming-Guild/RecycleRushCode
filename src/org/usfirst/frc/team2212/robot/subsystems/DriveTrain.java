/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import components.Gearbox;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2212.robot.RobotMap;

/**
 *
 * @author ThinkRedstone
 */
public class DriveTrain extends Subsystem {

    private Gearbox left, right;
    private VictorSP front, rear;
    private Encoder sideways, forward;
    private double wheelDiameter;

    public DriveTrain(Gearbox left, Gearbox right, VictorSP front, VictorSP rear, Encoder forward, Encoder sideways, double wheelDiameter) {
        this.left = left;
        this.right = right;
        this.front = front;
        this.rear = rear;
        this.forward = forward;
        this.sideways = sideways;
        this.wheelDiameter = wheelDiameter;
    }

    public DriveTrain(int leftForward, int leftBackwards, int rightForward, int rightBackwards, int middleFront, int middleRear, int forwardEncoderPort1, int forwardEncoderPort2, int sidewaysEncoderPort1, int sidewaysEncoderPort2, double wheelDiameter) {
        this(new Gearbox(leftForward, leftBackwards), new Gearbox(rightForward, rightBackwards), new VictorSP(middleFront), new VictorSP(middleRear), new Encoder(forwardEncoderPort1, forwardEncoderPort2), new Encoder(sidewaysEncoderPort1, sidewaysEncoderPort2), wheelDiameter);
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
//        positive to go right
        front.set(-speed);
        rear.set(speed);
    }

    public void freeMovement(double forwardSpeed, double sidewaysSpeed) {
        forward(forwardSpeed);
        sideways(sidewaysSpeed);
    }

    public double forwardGet() {
        return wheelDiameter * Math.PI * (forward.get() / RobotMap.ENCODER_TICKS_IN_FULL_TURN);
    }

    public double sidewaysGet() {
        return wheelDiameter * Math.PI * (sideways.get() / RobotMap.ENCODER_TICKS_IN_FULL_TURN);
    }
    
    public void reset(){
        sideways.reset();
        forward.reset();
    }

    public Gearbox getLeft() {
        return left;
    }

    public Gearbox getRight() {
        return right;
    }

    public VictorSP getFront() {
        return front;
    }

    public VictorSP getRear() {
        return rear;
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
