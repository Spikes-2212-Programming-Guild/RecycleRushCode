package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.driving.Forward;
import org.usfirst.frc.team2212.robot.commands.driving.Sideways;
import org.usfirst.frc.team2212.robot.commands.driving.Turn;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Down;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Open;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Up;
import org.usfirst.frc.team2212.robot.commands.macro.Play;
import org.usfirst.frc.team2212.robot.commands.macro.Record;

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
		RECORDING.whileHeld(new Record("test"));
		PLAY.whenPressed(new Play("test"));
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

	public void setOverride(boolean override) {
		driverJoystick.setOverride(override);
		navJoystick.setOverride(override);
	}

	public double getDriverY() {
		return driverJoystick.getY();
	}

	public boolean getNavigatorButton(int i) {
		return navJoystick.getRawButton(i);
	}

	public boolean getDriverButton(int button) {
		return driverJoystick.getRawButton(button);
	}

	public double getNavTwist() {
		return navJoystick.getOverrideableTwist();
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

	public void setDriverButton(int button, boolean state) {
		driverJoystick.setButton(button, state);
	}

	public void setDriverX(double value) {
		driverJoystick.setX(value);
	}

	public void setDriverY(double value) {
		driverJoystick.setY(value);
	}

	public void setDriverTwist(double value) {
		driverJoystick.setTwist(value);
	}

	public void setNavigatorButton(int button, boolean state) {
		navJoystick.setButton(button, state);
	}

	public void setNavigatorX(double value) {
		navJoystick.setX(value);
	}

	public void setNavigatorY(double value) {
		navJoystick.setY(value);
	}

	public void setNavigatorTwist(double value) {
		navJoystick.setTwist(value);
	}

}
