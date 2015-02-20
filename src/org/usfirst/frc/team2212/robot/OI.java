package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.driving.JoystickForward;
import org.usfirst.frc.team2212.robot.commands.driving.JoystickSideways;
import org.usfirst.frc.team2212.robot.commands.driving.Turn;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Down;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Open;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Up;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public final Joystick driver = new Joystick(0);
	public final Joystick navigator = new Joystick(1);

	Button up = new JoystickButton(navigator, 3);
	Button down = new JoystickButton(navigator, 2);
	Button open = new JoystickButton(navigator, 7);
	Button close = new JoystickButton(navigator, 6);
	Button forward = new JoystickButton(driver, 9);
	Button sideways = new JoystickButton(driver, 10);
	Button turn = new JoystickButton(driver, 1);
	Button slowness = new JoystickButton(driver, 7);

	public OI() {
		up.whileHeld(new Up());
		down.whileHeld(new Down());
		open.whileHeld(new Open());
		close.whileHeld(new Close());
		forward.whileHeld(new JoystickForward());
		sideways.whileHeld(new JoystickSideways());
		turn.whileHeld(new Turn());
		slowness.whenPressed(new Command() {
			@Override
			protected boolean isFinished() {
				return true;
			}

			@Override
			protected void interrupted() {
			}

			@Override
			protected void initialize() {
				Robot.drivetrain.changeForwardSensitivity();
			}

			@Override
			protected void execute() {
			}

			@Override
			protected void end() {
			}
		});
	}

}
