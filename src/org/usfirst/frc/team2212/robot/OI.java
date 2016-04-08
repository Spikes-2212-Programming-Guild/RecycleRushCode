package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.driving.Forward;
import org.usfirst.frc.team2212.robot.commands.driving.Sideways;
import org.usfirst.frc.team2212.robot.commands.driving.Turn;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Down;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Open;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Up;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */extends JoystickMap {

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
	 * @return driver's joystick measured Y; or overriden value
	 */
	public double getDriverY() {
		return driverJoystick.getY();
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
		return navJoystick.getTwist();
	}

	/**
	 *
	 * @return driver's joystick measured X; or overriden value
	 */
	public double getDriverX() {
		return driverJoystick.getX();
	}

	/**
	 *
	 * @return driver's joystick measured twist; or overriden value
	 */
	public double getDriverTwist() {
		return driverJoystick.getTwist();
	}

	/**
	 *
	 * @return nav's joystick measured Y; or overriden value
	 */
	public double getNavY() {
		return navJoystick.getY();
	}

	/**
	 *
	 * @return nav's joystick measured X; or overriden value
	 */
	public double getNavX() {
		return navJoystick.getX();
	}
	
}