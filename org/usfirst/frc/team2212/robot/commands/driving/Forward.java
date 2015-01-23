/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.Driving;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import static org.usfirst.frc.team2212.robot.Robot.oi;
import org.usfirst.frc.team2212.robot.RobotMap;

/**
 *
 * @author ThinkRedstone
 */
public class Forward extends Command {
    private double currentSpeed;

    public Forward() {
        requires(driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double newSpeed;
        if (Math.abs(oi.getDriverY() - currentSpeed) < RobotMap.CHANGE_IN_SPEED) {
            newSpeed = oi.getDriverY();
        } else if (oi.getDriverY() - currentSpeed > 0) {
            newSpeed = currentSpeed + RobotMap.CHANGE_IN_SPEED;
        } else {
            newSpeed = currentSpeed - RobotMap.CHANGE_IN_SPEED;
        }
        driveTrain.forward(newSpeed);
        currentSpeed = newSpeed;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.forward(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
