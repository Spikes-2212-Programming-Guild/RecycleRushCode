/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.driving;

import static org.usfirst.frc.team2212.robot.Robot.drivetrain;
import static org.usfirst.frc.team2212.robot.Robot.oi;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */

public class Forward extends Command {

	private double speed;

	public Forward() {
		requires(drivetrain);
		speed = 0;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	public Forward(double speed) {
		this();
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (speed != 0)
			drivetrain.forward(speed);
		else {
			drivetrain.forward(oi.driver.getY());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		drivetrain.forward(0);
		drivetrain.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
