/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macro;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author ThinkRedstone
 */
public class MacroJoystick extends Joystick {

	private boolean overriding;

	private boolean[] buttons = new boolean[12];
	private double x, y, twist;

	public MacroJoystick(int port) {
		super(port);
	}

	public void setButton(int buttonNum, boolean pressed) {
		buttons[buttonNum - 1] = pressed;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setTwist(double twist) {
		this.twist = twist;
	}

	@Override
	public boolean getRawButton(int button) {
		if (overriding) {
			return buttons[button - 1];
		}
		return super.getRawButton(button);
	}

	public double getOverrideableX() {
		if (overriding) {
			return x;
		}
		return super.getX();
	}

	public double getOverrideableY() {
		if (overriding) {
			return y;
		}
		return super.getY();
	}

	public double getOverrideableTwist() {
		if (overriding) {
			return twist;
		}
		return super.getTwist();
	}

	public void setOverride(boolean override) {
		this.overriding = override;
	}

	public boolean getOverride() {
		return overriding;
	}

}
