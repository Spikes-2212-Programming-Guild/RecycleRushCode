package org.usfirst.frc.team2212.robot.commands.driving;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class FixForward extends PIDCommand {

	public FixForward() {
		super(RobotMap.FIX_FORWARD_KP, RobotMap.FIX_FORWARD_KI,
				RobotMap.FIX_FORWARD_KD);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	@Override
	protected double returnPIDInput() {
		return Robot.drivetrain.getanglespeed();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.drivetrain.arcade(Robot.oi.driver.getY(), -output);
	}
}
