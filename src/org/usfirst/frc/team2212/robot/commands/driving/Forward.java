/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.driving;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import static org.usfirst.frc.team2212.robot.Robot.oi;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */

public class Forward extends Command {

	private double speed;

    /**
     *
     */
    public Forward() {
		requires(driveTrain);
		speed = 0;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

    /**
     *
     * @param speed
     */
    public Forward(double speed) {
		this();
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (speed != 0)
			driveTrain.forward(speed);
		else {
			driveTrain.forward(oi.getDriverY());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		driveTrain.forward(0);
		driveTrain.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
