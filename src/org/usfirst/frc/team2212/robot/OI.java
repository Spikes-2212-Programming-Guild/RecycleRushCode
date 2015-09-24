package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.driving.Forward;
import org.usfirst.frc.team2212.robot.commands.driving.Sideways;
import org.usfirst.frc.team2212.robot.commands.driving.Turn;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Down;
import org.usfirst.frc.team2212.robot.commands.forkLifter.GetDownToNext;
import org.usfirst.frc.team2212.robot.commands.forkLifter.GetUpToNext;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Open;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Up;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */extends JoystickMap {

	public OI() {
		UP_BUTTON.whileHeld(new Up());
		DOWN_BUTTON.whileHeld(new Down());
		OPEN_BUTTON.whileHeld(new Open());
		CLOSE_BUTTON.whileHeld(new Close());
		FORWARD_BUTTON.whileHeld(new Forward());
		SIDEWAYS_BUTTON.whileHeld(new Sideways());
		TURN_BUTTON.whileHeld(new Turn());
		FIX_UP_BUTTON.whenPressed(new GetUpToNext());
		FIX_DOWN_BUTTON.whenPressed(new GetDownToNext());
		SLOWNESS.whenPressed(new Command() {
			@Override
			protected boolean isFinished() {
				return true;
			}

			@Override
			protected void interrupted() {
			}

			@Override
			protected void initialize() {
				Robot.driveTrain.changeForwardSensitivity();
			}

			@Override
			protected void execute() {
			}

			@Override
			protected void end() {
			}
		});
	}

	public double getDriverY() {
		return driverJoystick.getY();
	}

	public double getDriverX() {
		return driverJoystick.getX();
	}

	public double getDriverTwist() {
		return driverJoystick.getTwist();
	}

	public double getNavY() {
		return navJoystick.getY();
	}

	public double getNavX() {
		return navJoystick.getX();
	}

}
