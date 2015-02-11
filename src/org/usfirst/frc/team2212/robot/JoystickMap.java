/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author ThinkRedstone
 */
public class JoystickMap {

	protected Joystick driverJoystick = new Joystick(0);
	protected Joystick navJoystick = new Joystick(1);

	protected Button UP_BUTTON = new JoystickButton(navJoystick, 3);
	protected Button DOWN_BUTTON = new JoystickButton(navJoystick, 2);
	protected Button OPEN_BUTTON = new JoystickButton(navJoystick, 5);
	protected Button CLOSE_BUTTON = new JoystickButton(navJoystick, 4);

	protected Button FORWARD_BUTTON = new JoystickButton(driverJoystick, 1);
	protected Button SIDEWAYS_BUTTON = new JoystickButton(driverJoystick, 2);
	protected Button TURN_BUTTON = new JoystickButton(driverJoystick, 3);

}
