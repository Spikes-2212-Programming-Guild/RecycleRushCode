package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.PutData;
import org.usfirst.frc.team2212.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2212.robot.subsystems.Fork;
import org.usfirst.frc.team2212.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain(
			RobotMap.LEFT_FORWARD_VICTOR_PORT,
			RobotMap.LEFT_BACKWARDS_VICTOR_PORT,
			RobotMap.RIGHT_FORWARD_VICTOR_PORT,
			RobotMap.RIGHT_BACKWARDS_VICTOR_PORT,
			RobotMap.MIDDLE_FRONT_VICTOR_PORT,
			RobotMap.MIDDLE_BACKWARDS_VICTOR_PORT,
			RobotMap.LEFT_ENCODER_1_PORT, RobotMap.LEFT_ENCODER_2_PORT,
			RobotMap.RIGHT_ENCODER_1_PORT, RobotMap.RIGHT_ENCODER_2_PORT,
			RobotMap.FRONT_ENCODER_1_PORT, RobotMap.FRONT_ENCODER_2_PORT,
			RobotMap.REAR_ENCODER_1_PORT, RobotMap.REAR_ENCODER_2_PORT,
			RobotMap.WHEEL_DIAMETER);

	/**
	 *
	 */
	public static final Lifter lifter = new Lifter(RobotMap.LIFTER_TALON_1_ID,
			RobotMap.LIFTER_TALON_2_ID, RobotMap.LIFTER_UP_DI_PORT,
			RobotMap.LIFTER_DOWN_DI_PORT, RobotMap.LIFTER_ENCODER_PORT1,
			RobotMap.LIFTER_ENCODER_PORT2, RobotMap.LIFTER_WHEEL_DIAMETER);
	public static final Fork fork = new Fork(RobotMap.FORK_TALON_ID,
			RobotMap.FORK_OPEN_DI_1_PORT, RobotMap.FORK_OPEN_DI_2_PORT,
			RobotMap.FORK_CLOSE_DI_PORT);
	public static OI oi = new OI();

	// Command autonomousCommand;
	PutData putData;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// instantiate the command used for the autonomous period
		putData = new PutData();
		driveTrain.reset();
		lifter.reset();
		putData.start();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		if (!putData.isRunning()) {
			putData.start();
		}
		driveTrain.reset();
		lifter.reset();
		// autonomousCommand = new PIDForward(RobotMap.AUTO_FORWARD_DEST,
		// SmartDashboard.getNumber("kp-f", 0), SmartDashboard.getNumber(
		// "ki-f", 0) / 10000,
		// SmartDashboard.getNumber("kd-f", 0), RobotMap.AUTO_FORWARD_DT,
		// SmartDashboard.getNumber("threshold-f", 1));
		// autonomousCommand = putData.getSelectedAutoCommand();
		// if (autonomousCommand != null) {
		// autonomousCommand.start();
		// }

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		// if (autonomousCommand != null) {
		// autonomousCommand.cancel();
		// }
		if (!putData.isRunning()) {
			putData.start();
		}
		driveTrain.reset();
		lifter.reset();

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {
		try {
			putData.cancel();
			driveTrain.reset();

			lifter.reset();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
