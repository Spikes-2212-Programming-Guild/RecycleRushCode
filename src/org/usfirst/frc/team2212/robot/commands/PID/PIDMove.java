/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.PID;

import components.PID;
import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.lifter;

/**
 *
 * @author ThinkRedstone
 */
public class PIDMove extends Command {

    private PID pid;

    public PIDMove(double DESTINATION, double KP, double KI, double KD, long DT, double THRESHOLD) {
        requires(lifter);
        pid = new PID(DESTINATION, KP, KI, KD, DT, THRESHOLD);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        lifter.reset();
        pid.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        lifter.set(pid.doPID(lifter.get()));
        pid.waitForPID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.hasArrived() || lifter.isDown() || lifter.isUp();
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
