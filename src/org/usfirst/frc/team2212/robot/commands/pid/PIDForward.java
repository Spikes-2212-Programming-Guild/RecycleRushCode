/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.pid;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;

import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author ThinkRedstone
 */
public class PIDForward extends PIDCommand {
	private double maximumOutput;

	/**
	 *
	 * @param dest
	 * @param KP
	 * @param KI
	 * @param KD
	 * @param DT
	 * @param threshold
	 */
	public PIDForward(double dest, double KP, double KI, double KD,
			double threshold) {
		super(KP, KI, KD);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(driveTrain);
		getPIDController().setAbsoluteTolerance(threshold);
		getPIDController().setOutputRange(-RobotMap.DRIVETRAIN_RANGE,
				RobotMap.DRIVETRAIN_RANGE);
		setSetpoint(dest);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		driveTrain.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		SmartDashboard.putBoolean("target", getPIDController().onTarget());
		return getPIDController().onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		driveTrain.sideways(0);
		driveTrain.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected double returnPIDInput() {

		return (driveTrain.getLeft() + driveTrain.getRight()) / 2;
	}

	@Override
	protected void usePIDOutput(double output) {
		maximumOutput = Math.max(Math.abs(output), maximumOutput);
		driveTrain.forward(output == 0 ? 0 : output / maximumOutput);
	}
}
