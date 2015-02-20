package org.usfirst.frc.team2212.robot.commands.driving;

import static org.usfirst.frc.team2212.robot.Robot.drivetrain;
import static org.usfirst.frc.team2212.robot.Robot.oi;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickSideways extends Command {

	public JoystickSideways() {
		requires(drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drivetrain.sideways(oi.driver.getX());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		drivetrain.sideways(0);
		drivetrain.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
