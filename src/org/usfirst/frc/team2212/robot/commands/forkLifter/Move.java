/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.forkLifter;

import static org.usfirst.frc.team2212.robot.Robot.lifter;
import static org.usfirst.frc.team2212.robot.Robot.oi;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */
public class Move extends Command {

	public Move() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(lifter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double y = oi.navigator.getY();
		if (!((y > 0 && lifter.isUp()) || (y < 0 && lifter.isDown()))) {
			lifter.set(oi.navigator.getY());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return lifter.isDown() || lifter.isUp();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		lifter.verifyLevel();
		lifter.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
