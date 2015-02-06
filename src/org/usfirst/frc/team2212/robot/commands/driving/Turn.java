/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.driving;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import static org.usfirst.frc.team2212.robot.Robot.oi;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */
public class Turn extends Command {

	public Turn() {
		requires(driveTrain);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		driveTrain.turn(oi.getDriverTwist());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		driveTrain.turn(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
