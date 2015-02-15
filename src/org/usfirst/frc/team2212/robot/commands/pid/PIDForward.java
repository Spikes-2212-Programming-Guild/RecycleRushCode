/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.pid;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;

import java.util.Date;

import components.PID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author ThinkRedstone
 */
public class PIDForward extends Command {
	private PID pidLeft, pidRight;

	public PIDForward(double dest, double KP, double KI, double KD, long DT,
			double threshold) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(driveTrain);
		pidLeft = new PID(dest, KP, KI, KD, DT, threshold);
		pidRight = new PID(dest, KP, KI, KD, DT, threshold);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		driveTrain.reset();
		pidLeft.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		driveTrain.setTwoSides(pidLeft.doPID(driveTrain.getLeft()),
				pidRight.doPID(driveTrain.getRight()));
		pidLeft.waitForPID();
		SmartDashboard.putBoolean("left arrived", pidLeft.hasArrived());
		SmartDashboard.putBoolean("right arrived", pidRight.hasArrived());
		SmartDashboard.putNumber("left pid", pidLeft.getPID());
		SmartDashboard.putNumber("right pid", pidRight.getPID());
		SmartDashboard.putNumber("stia", pidLeft.speed() / pidRight.speed());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return pidLeft.hasArrived() && pidRight.hasArrived();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		driveTrain.forward(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
