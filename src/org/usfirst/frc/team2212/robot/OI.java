package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.driving.Forward;
import org.usfirst.frc.team2212.robot.commands.driving.Sideways;
import org.usfirst.frc.team2212.robot.commands.driving.Turn;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Down;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Open;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Up;
import org.usfirst.frc.team2212.robot.commands.macro.Record;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */extends JoystickMap {

	private Command record = new Record("test");

	/**
     *
     */
	public OI() {
		UP_BUTTON.whileActive(new Up());
		DOWN_BUTTON.whileHeld(new Down());
		OPEN_BUTTON.whileHeld(new Open());
		CLOSE_BUTTON.whileHeld(new Close());
		FORWARD_BUTTON.whileHeld(new Forward());
		SIDEWAYS_BUTTON.whileHeld(new Sideways());
		TURN_BUTTON.whileHeld(new Turn());
	}

	/**
	 *
	 * @param override
	 *            sets override for both joysticks
	 */
	public void setOverride(boolean override) {
		driverJoystick.setOverride(override);
		navJoystick.setOverride(override);
	}

	/**
	 *
	 * @return driver's joystick measured Y; or overriden value
	 */
	public double getDriverY() {
		return driverJoystick.getOverrideableY();
	}

	/**
	 *
	 * @param i
	 *            - number for the button
	 * @return nav's joystick measured button value; or overriden value
	 */
	public boolean getNavigatorButton(int i) {
		return navJoystick.getRawButton(i);
	}

	/**
	 *
	 * @param button
	 *            - number for the button
	 * @return Driver's joystick measured button value; or overriden value
	 */
	public boolean getDriverButton(int button) {
		return driverJoystick.getRawButton(button);
	}

	/**
	 *
	 * @return nav's joystick measured twist; or overriden value
	 */
	public double getNavTwist() {
		return navJoystick.getOverrideableTwist();
	}

	/**
	 *
	 * @return driver's joystick measured X; or overriden value
	 */
	public double getDriverX() {
		return driverJoystick.getOverrideableX();
	}

	/**
	 *
	 * @return driver's joystick measured twist; or overriden value
	 */
	public double getDriverTwist() {
		return driverJoystick.getOverrideableTwist();
	}

	/**
	 *
	 * @return nav's joystick measured Y; or overriden value
	 */
	public double getNavY() {
		return navJoystick.getOverrideableY();
	}

	/**
	 *
	 * @return nav's joystick measured X; or overriden value
	 */
	public double getNavX() {
		return navJoystick.getOverrideableX();
	}

	/**
	 *
	 * @param button
	 *            - the button
	 * @param state
	 *            - value to be set
	 */
	public void setDriverButton(int button, boolean state) {
		driverJoystick.setButton(button, state);
	}

	/**
	 *
	 * @param value
	 *            - value to be set
	 */
	public void setDriverX(double value) {
		driverJoystick.setX(value);
	}

	/**
	 *
	 * @param value
	 *            - value to be set
	 */
	public void setDriverY(double value) {
		driverJoystick.setY(value);
	}

	/**
	 *
	 * @param value
	 *            - value to be set
	 */
	public void setDriverTwist(double value) {
		driverJoystick.setTwist(value);
	}

	/**
	 *
	 * @param button
	 *            - the button number
	 * @param state
	 *            - value to be set
	 */
	public void setNavigatorButton(int button, boolean state) {
		navJoystick.setButton(button, state);
	}

	/**
	 *
	 * @param value
	 *            - value to be set
	 */
	public void setNavigatorX(double value) {
		navJoystick.setX(value);
	}

	/**
	 *
	 * @param value
	 *            - value to be set
	 */
	public void setNavigatorY(double value) {
		navJoystick.setY(value);
	}

	/**
	 *
	 * @param value
	 *            - value to be set
	 */
	public void setNavigatorTwist(double value) {
		navJoystick.setTwist(value);
	}

}
