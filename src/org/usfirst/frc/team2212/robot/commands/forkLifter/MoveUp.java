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
public class MoveUp extends Command {

	public MoveUp() {
		requires(lifter);
		lifter.setSetpoint(Commands.ONE_TOTE_DEST);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		lifter.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return lifter.onTarget() || lifter.isDown() || lifter.isUp();
	}

	// Called once after isFinished returns true
	protected void end() {
		lifter.levelUp();
		lifter.set(0);
		lifter.verifyLevel();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		lifter.set(0);
		lifter.corruptLevel();
	}
}