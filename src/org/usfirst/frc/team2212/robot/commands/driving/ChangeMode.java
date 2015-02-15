package org.usfirst.frc.team2212.robot.commands.driving;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeMode extends Command {

	public ChangeMode() {
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
		driveTrain.changeMode();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
