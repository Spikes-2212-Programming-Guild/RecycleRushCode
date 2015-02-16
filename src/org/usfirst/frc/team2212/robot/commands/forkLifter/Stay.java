/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.forkLifter;

import static org.usfirst.frc.team2212.robot.Robot.lifter;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_DT;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_KD;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_KI;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_KP;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_THRESHOLD;

import org.usfirst.frc.team2212.robot.RobotMap;

import components.PID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */
public class Stay extends Command {

	PID pid;

	public Stay() {
		requires(lifter);
		pid = new PID(lifter.getHeight(), ONE_TOTE_KP, ONE_TOTE_KI,
				ONE_TOTE_KD, ONE_TOTE_DT, ONE_TOTE_THRESHOLD);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		lifter.reset();
		pid.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		lifter.set(RobotMap.LIFTER_STAY_SPEED + pid.doPID(lifter.getHeight()));
		pid.waitForPID();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		lifter.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
