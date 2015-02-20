package org.usfirst.frc.team2212.robot.commands.driving;

import static org.usfirst.frc.team2212.robot.Robot.drivetrain;
import static org.usfirst.frc.team2212.robot.Robot.oi;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Drive forward using joystick
 * 
 * @author Alon
 *
 */
public class JoystickForward extends Command {

	@Override
	protected void initialize() {
		requires(drivetrain);
	}

	@Override
	protected void execute() {
		drivetrain.forward(oi.driver.getY());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		drivetrain.stop();
		drivetrain.reset();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
