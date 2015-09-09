/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot;

import macro.JoystickButtonForRecord;
import macro.MacroJoystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author ThinkRedstone
 */
public class JoystickMap {

    /**
     * Joystick for the driver
     */
    protected MacroJoystick driverJoystick = new MacroJoystick(0);

    /**
     * Joystick for the Navigator
     */
    protected MacroJoystick navJoystick = new MacroJoystick(1);

    /**
     * The button to move the lifter up
     */
    protected Button UP_BUTTON = new JoystickButton(navJoystick, 3);

    /**
     * The button to move the lifter down
     */
    protected Button DOWN_BUTTON = new JoystickButton(navJoystick, 2);

    /**
     * The button to open the fork
     */
    protected Button OPEN_BUTTON = new JoystickButton(navJoystick, 7);

    /**
     * The button to close the fork
     */
    protected Button CLOSE_BUTTON = new JoystickButton(navJoystick, 6);

    /**
     * The button to drive forward only
     */
    protected Button FORWARD_BUTTON = new JoystickButton(driverJoystick, 9);

    /**
     * The button to drive sideways only
     */
    protected Button SIDEWAYS_BUTTON = new JoystickButton(driverJoystick, 10);

    /**
     * The button to only turn
     */
    protected Button TURN_BUTTON = new JoystickButton(driverJoystick, 1);

    /**
     * Makes the robot go slow?
     */
    protected Button SLOWNESS = new JoystickButton(driverJoystick, 7);

    /**
     * @deprecated 
     */
    protected Button NORMAL = new JoystickButton(driverJoystick, 8);

    /**
     * Stops macro recoding 
     */
    protected Button STOP_RECORDING = new JoystickButton(driverJoystick, 11);

    /**
     * Starts macro recoding
     */
    protected Button RECORDING = new JoystickButtonForRecord(driverJoystick, 12);

    /**
     * Plays currently loaded macro
     */
    protected Button PLAY = new JoystickButtonForRecord(driverJoystick, 5);

}
