package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.driving.PIDForward;
import org.usfirst.frc.team2212.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2212.robot.subsystems.Fork;
import org.usfirst.frc.team2212.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Lifter lifter = new Lifter();
	public static final Fork fork = new Fork();
	public static final OI oi = new OI();

	Command autonomousCommand;

	final SendableChooser autoChooser = new SendableChooser();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain.reset();
		lifter.reset();
	}

	@Override
	public void autonomousInit() {
		drivetrain.reset();
		lifter.reset();
		autonomousCommand = new PIDForward(100);
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {
		drivetrain.reset();
		lifter.reset();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		drivetrain.reset();
		lifter.reset();

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	public void log() {

		SmartDashboard.putNumber("Left Encoder", drivetrain.getLeft());
		SmartDashboard.putNumber("Right Encoder", drivetrain.getRight());
		SmartDashboard.putNumber("Front Encoder", drivetrain.getFront());
		SmartDashboard.putNumber("Rear Encoder", drivetrain.getRear());
		SmartDashboard.putNumber("Lifter Encoder", lifter.getHeight());
		SmartDashboard.putBoolean("Lifter Up", lifter.isUp());
		SmartDashboard.putBoolean("Lifter Down", lifter.isDown());
		SmartDashboard.putBoolean("Fork Open", fork.isOpen());
		SmartDashboard.putBoolean("Fork Closed", fork.isClosed());
	}
}
