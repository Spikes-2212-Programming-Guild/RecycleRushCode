/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.driving.forkLifter;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.fork;

/**
 *
 * @author ThinkRedstone
 */
public class Close extends Command{
    
    public Close() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(fork);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        fork.close();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fork.isClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
        fork.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
