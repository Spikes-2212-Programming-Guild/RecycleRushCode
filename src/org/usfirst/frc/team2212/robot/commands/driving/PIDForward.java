/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.driving;

import static org.usfirst.frc.team2212.robot.Robot.drivetrain;

import org.usfirst.frc.team2212.robot.Commands;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 * @author ThinkRedstone
 */
public class PIDForward extends PIDCommand {

	public static final double P = 0.25;
	public static final double I = 0;
	public static final double D = 0;

	public PIDForward(double distance) {
		super(P, I, D);
		requires(drivetrain);
		setInputRange(-1, 1);
		setSetpoint(distance);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		drivetrain.reset();

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Math.abs(getPosition() - getSetpoint()) < Commands.AUTO_FORWARD_THRESHOLD;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		drivetrain.forward(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected double returnPIDInput() {
		return drivetrain.getLeftSpeed();
	}

	@Override
	protected void usePIDOutput(double output) {
		drivetrain.forward(output);
	}
}
