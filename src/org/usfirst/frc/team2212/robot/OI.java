package org.usfirst.frc.team2212.robot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends JoystickMap {

	public double getDriverY() {
		return driverJ.getY();
	}

	public double getDriverX() {
		return driverJ.getX();
	}

	public double getNavY() {
		return navJ.getY();
	}

	public double getNavX() {
		return navJ.getX();
	}

}
