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

	protected MacroJoystick driverJoystick = new MacroJoystick(0);

	protected MacroJoystick navJoystick = new MacroJoystick(1);

	protected Button UP_BUTTON = new JoystickButton(navJoystick, 3);
	protected Button DOWN_BUTTON = new JoystickButton(navJoystick, 2);
	protected Button OPEN_BUTTON = new JoystickButton(navJoystick, 7);
	protected Button CLOSE_BUTTON = new JoystickButton(navJoystick, 6);

	protected Button FORWARD_BUTTON = new JoystickButton(driverJoystick, 9);
	protected Button SIDEWAYS_BUTTON = new JoystickButton(driverJoystick, 10);
	protected Button TURN_BUTTON = new JoystickButton(driverJoystick, 1);

	protected Button SLOWNESS = new JoystickButton(driverJoystick, 7);
	protected Button NORMAL = new JoystickButton(driverJoystick, 8);

	protected Button STOP_RECORDING = new JoystickButton(driverJoystick, 11);
	protected Button RECORDING = new JoystickButtonForRecord(driverJoystick, 12);
	protected Button PLAY = new JoystickButtonForRecord(driverJoystick, 5);

}
