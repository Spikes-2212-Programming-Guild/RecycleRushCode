/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.forkLifter;

import static org.usfirst.frc.team2212.robot.Robot.lifter;

import org.usfirst.frc.team2212.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */
public class LiftALittle extends Command {

	public LiftALittle() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(lifter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(Commands.LIFT_A_LITTLE_TIMEOUT);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (!isFinished()) {
			lifter.set(Commands.LIFT_A_LITTLE_SPEED);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut() || lifter.isUp();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		lifter.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
