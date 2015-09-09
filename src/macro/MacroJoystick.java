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

    /**
     *
     * @param port the joystick port
     */
    public MacroJoystick(int port) {
        super(port);
    }

    /**
     *
     * @param buttonNum - number of the button
     * @param pressed - state for the button
     */
    public void setButton(int buttonNum, boolean pressed) {
        buttons[buttonNum - 1] = pressed;
    }

    /**
     *
     * @param x - x to set to the joystick
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @param y - y to set to the joystick
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @param twist - twist to set to the joystick
     */
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

    /**
     *
     * @return if overriding, the set x. else, same as getX()
     */
    public double getOverrideableX() {
        if (overriding) {
            return x;
        }
        return super.getX();
    }

    /**
     *
     * @return if overriding, the set y. else, same as getY()
     */
    public double getOverrideableY() {
        if (overriding) {
            return y;
        }
        return super.getY();
    }

    /**
     *
     * @return if overriding, the set twist. else, same as getTwist()
     */
    public double getOverrideableTwist() {
        if (overriding) {
            return twist;
        }
        return super.getTwist();
    }

    /**
     *
     * @param override - set weather data should be overriden
     */
    public void setOverride(boolean override) {
        this.overriding = override;
    }

    /**
     *
     * @return weather we are overriding or not
     */
    public boolean getOverride() {
        return overriding;
    }

}
