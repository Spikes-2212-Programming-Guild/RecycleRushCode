/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.pid;

import components.PID;
import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2212.robot.Robot.lifter;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_DEST;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_DT;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_KD;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_KI;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_KP;
import static org.usfirst.frc.team2212.robot.RobotMap.ONE_TOTE_THRESHOLD;

/**
 *
 * @author ThinkRedstone
 */
public class MoveToLevel extends Command {

    private PID pid;
    private int level;
    private boolean cantOperate;

    public MoveToLevel(int level) {
        requires(lifter);
//        Same as up, only the other direction
        if (lifter.getLevel() != -1) {
            pid = new PID((level - lifter.getLevel()) * ONE_TOTE_DEST, ONE_TOTE_KP, ONE_TOTE_KI, ONE_TOTE_KD, ONE_TOTE_DT, ONE_TOTE_THRESHOLD);
        } else {
            cantOperate = true;
        }
        this.level = level;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pid.reset();
        lifter.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!cantOperate) {
            lifter.set(pid.doPID(lifter.getHeight()));
            pid.waitForPID();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.hasArrived() || lifter.isDown() || lifter.isUp() || cantOperate;
    }

    // Called once after isFinished returns true
    protected void end() {
        lifter.setLevel(level);
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
