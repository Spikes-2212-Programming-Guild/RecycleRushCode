package org.usfirst.frc.team2212.robot.commands;

import static org.usfirst.frc.team2212.robot.Robot.accelometer;
import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import static org.usfirst.frc.team2212.robot.Robot.fork;
import static org.usfirst.frc.team2212.robot.Robot.lifter;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.pid.PIDForward;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PutData extends Command {

	private SendableChooser autoChooser;
	private int speedX;
	private int speedY;
	private long dt;
	private long prevTime;

	// private CameraServer camera;

	public PutData() {

		autoChooser = new SendableChooser();
		speedX = 0;
		speedY = 0;
		dt = 0;
		prevTime = 0;
		// camera = CameraServer.getInstance();
	}

	@Override
	protected void initialize() {
		autoChooser.addObject("Full Auto", new AutonomousCommand());
		autoChooser.addObject("Stupid Auto", new StupidAutoCommand());
		autoChooser.addObject("No Auto", null);
		autoChooser.addDefault("PID", new PIDForward(
				RobotMap.AUTO_FORWARD_DEST, RobotMap.AUTO_FORWARD_KP,
				RobotMap.AUTO_FORWARD_KI, RobotMap.AUTO_FORWARD_KD,
				RobotMap.AUTO_FORWARD_DT, RobotMap.AUTO_FORWARD_THRESHOLD));
		SmartDashboard.putData("Auto Chooser", autoChooser);
		/*
		 * Initializing the constants if not already initialized
		 */
		// SmartDashboard.putNumber("kp-f", SmartDashboard.getNumber("kp-f",
		// 0));
		// SmartDashboard.putNumber("ki-f", SmartDashboard.getNumber("ki-f",
		// 0));
		// SmartDashboard.putNumber("kd-f", SmartDashboard.getNumber("kd-f",
		// 0));
		// SmartDashboard.putNumber("threshold-f",
		// SmartDashboard.getNumber("threshold-f", 1));
		// SmartDashboard.putNumber("forward factor",
		// RobotMap.FREE_SENSITIVE_FACTOR);
		// camera.setQuality(50);
		// camera.startAutomaticCapture("cam0");
	}

	@Override
	protected void execute() {

		dt = System.currentTimeMillis() - prevTime;
		speedX += accelometer.getY() * dt + speedX;
		speedY += accelometer.getX() * dt + speedY;
		SmartDashboard.putNumber("speed in Y", speedY);
		SmartDashboard.putNumber("speed in X", speedX);
		SmartDashboard.putNumber("front left wheel", driveTrain.getLeft());
		SmartDashboard.putNumber("back left wheel", driveTrain.getLeft());
		SmartDashboard.putNumber("back right wheel", driveTrain.getRight());
		SmartDashboard.putNumber("back right wheel", driveTrain.getRight());
		SmartDashboard.putNumber("front wheel", driveTrain.getFront());
		SmartDashboard.putNumber("rear wheel", driveTrain.getRear());
		SmartDashboard.putNumber("height", lifter.getHeight());
		SmartDashboard.putNumber("level", lifter.getLevel());
		SmartDashboard.putBoolean("is up", lifter.isUp());
		SmartDashboard.putBoolean("is down", lifter.isDown());
		SmartDashboard.putBoolean("is colse", fork.isClosed());
		SmartDashboard.putBoolean("is open", fork.isOpen());

		// SmartDashboard.putNumber("angle", gyro.getAngle);
		prevTime = System.currentTimeMillis();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

	public Command getSelectedAutoCommand() {
		return autoChooser != null ? (Command) autoChooser.getSelected() : null;
	}

}
