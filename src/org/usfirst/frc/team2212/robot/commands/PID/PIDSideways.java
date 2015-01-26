/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.PID;

import components.PID;
import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.driveTrain;

/**
 *
 * @author ThinkRedstone
 */
public class PIDSideways extends Command {
    private PID pid;
    
    public PIDSideways(double dest, double KP, double KI, double KD, long DT, double threshold) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        pid = new PID(dest, KP, KI, KD, DT, threshold);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.reset();
        pid.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.sideways(pid.doPID(driveTrain.sidewaysGet()));
        pid.waitForPID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.hasArrived();
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.sideways(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
