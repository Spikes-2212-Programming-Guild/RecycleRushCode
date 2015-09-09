/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.forkLifter;

import static org.usfirst.frc.team2212.robot.Robot.fork;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */
public class Close extends Command {

    /**
     *
     */
    public Close() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(fork);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(3);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (!isFinished())
			fork.close();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return fork.isClosed() || isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		fork.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
