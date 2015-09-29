/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot;

import macro.JoystickButtonForRecord;
import macro.MacroJoystick;
//import components.GoUp;
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
	public MacroJoystick driverJoystick = new MacroJoystick(0);

	/**
	 * Joystick for the Navigator
	 */
	public MacroJoystick navJoystick = new MacroJoystick(1);

	/**
	 * The button to move the lifter up
	 */
	public Button UP_BUTTON = new JoystickButton(navJoystick, 3);

	/**
	 * The button to move the lifter down
	 */
	public Button DOWN_BUTTON = new JoystickButton(navJoystick, 2);

	/**
	 * The button to open the fork
	 */
	public Button OPEN_BUTTON = new JoystickButton(navJoystick, 7);

	/**
	 * The button to close the fork
	 */
	public Button CLOSE_BUTTON = new JoystickButton(navJoystick, 6);

	/**
	 * The button to drive forward only
	 */
	public Button FORWARD_BUTTON = new JoystickButton(driverJoystick, 7);

	/**
	 * The button to drive sideways only
	 */
	public Button SIDEWAYS_BUTTON = new JoystickButton(driverJoystick, 10);

	/**
	 * The button to only turn
	 */
	public Button TURN_BUTTON = new JoystickButton(driverJoystick, 1);

	/**
	 * @deprecated
	 */
	@Deprecated
	public Button NORMAL = new JoystickButton(driverJoystick, 8);

	/**
	 * Stops macro recoding
	 */
	public Button STOP_RECORDING = new JoystickButton(driverJoystick, 11);

	/**
	 * Starts macro recoding
	 */
	public Button RECORDING = new JoystickButtonForRecord(driverJoystick, 12);

	/**
	 * Plays currently loaded macro
	 */
	public Button PLAY = new JoystickButtonForRecord(driverJoystick, 5);

	// public Trigger UP = new GoUp();
}
