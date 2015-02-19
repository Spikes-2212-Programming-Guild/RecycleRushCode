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

public class PIDMoveToLevel extends Command {

	private int level;
	boolean enabled;

	public PIDMoveToLevel(int level) {
		requires(lifter);
		// Same as up, only the other direction
		if (lifter.getLevel() != -1) {
			lifter.setSetpoint(level - lifter.getLevel()
					* Commands.ONE_TOTE_DEST);
			lifter.enable();
			enabled = true;
		}
		this.level = level;

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		lifter.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return lifter.onTarget() || lifter.isDown() || lifter.isUp()
				|| !enabled;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		if (enabled) {
			lifter.disable();
		}
		lifter.setLevel(level);
		lifter.set(0);
		lifter.verifyLevel();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		lifter.set(0);
		lifter.corruptLevel();
		if (enabled) {
			lifter.disable();
		}
	}
}
