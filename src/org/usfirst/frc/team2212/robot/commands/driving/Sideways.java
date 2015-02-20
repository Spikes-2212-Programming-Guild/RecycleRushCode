/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.driving;

import static org.usfirst.frc.team2212.robot.Robot.drivetrain;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */

public class Sideways extends Command {

	double speed;

	public Sideways(double speed) {
		requires(drivetrain);
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		drivetrain.sideways(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		drivetrain.sideways(0);
		drivetrain.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
