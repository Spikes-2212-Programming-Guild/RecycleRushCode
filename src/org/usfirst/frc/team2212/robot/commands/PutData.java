package org.usfirst.frc.team2212.robot.commands;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import static org.usfirst.frc.team2212.robot.Robot.fork;
import static org.usfirst.frc.team2212.robot.Robot.lifter;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.pid.PIDForward;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PutData extends Command {

	SendableChooser autoChooser;
	CameraServer camera;

	public PutData() {
		autoChooser = new SendableChooser();
		camera = CameraServer.getInstance();
	}

	@Override
	protected void initialize() {
		autoChooser.addObject("Full Auto", new AutonomousCommand());
		autoChooser.addObject("Stupid Auto", new StupidAutoCommand());
		autoChooser.addObject("No Auto", null);
		autoChooser.addDefault("PID Auto", new PIDForward(RobotMap.AUTO_FORWARD_DEST));
		SmartDashboard.putData("Auto Chooser", autoChooser);
		camera.setQuality(50);
		camera.startAutomaticCapture("cam0");
	}

	@Override
	protected void execute() {
		SmartDashboard.putBoolean("Forward Sensitive",
				driveTrain.isSensitive());
		SmartDashboard.putNumber("Left Encoder", driveTrain.getLeft());
		SmartDashboard.putNumber("Right Encoder", driveTrain.getRight());
		SmartDashboard.putNumber("Front Encoder", driveTrain.getFront());
		SmartDashboard.putNumber("Rear Encoder", driveTrain.getRear());
		SmartDashboard.putNumber("Lifter Encoder", lifter.getHeight());
		SmartDashboard.putBoolean("Lifter Up", lifter.isUp());
		SmartDashboard.putBoolean("Lifter Down", lifter.isDown());
		SmartDashboard.putBoolean("Fork Open", fork.isOpen());
		SmartDashboard.putBoolean("Fork Closed", fork.isClosed());
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
		return (Command) autoChooser.getSelected();
	}

}
