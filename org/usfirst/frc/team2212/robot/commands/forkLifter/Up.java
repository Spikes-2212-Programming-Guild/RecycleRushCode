/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.forkLifter;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.lifter;

/**
 *
 * @author ThinkRedstone
 */
public class Up extends Command {
    
    public Up() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(lifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        lifter.up();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return lifter.isUp();
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}