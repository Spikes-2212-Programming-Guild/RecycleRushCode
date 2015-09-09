/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.pid;

import components.PID;
import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.lifter;
import static org.usfirst.frc.team2212.robot.RobotMap.*;

/**
 *
 * @author ThinkRedstone
 */
public class MoveDown extends Command {

    private PID pid;

    /**
     * Moves the lifter down by the height of one tote
     */
    public MoveDown() {
        requires(lifter);
//        Same as up, only the other direction
        pid = new PID(-ONE_TOTE_DEST, ONE_TOTE_KP, ONE_TOTE_KI, ONE_TOTE_KD, ONE_TOTE_DT, ONE_TOTE_THRESHOLD);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        lifter.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        lifter.set(pid.doPID(lifter.getHeight()));
        pid.waitForPID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.hasArrived() || lifter.isDown() || lifter.isUp();
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.levelDown();
        lifter.set(0);
        lifter.verifyLevel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        lifter.set(0);
        lifter.corruptLevel();
    }
}
