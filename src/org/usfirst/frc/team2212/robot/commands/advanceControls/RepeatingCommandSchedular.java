/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.advanceControls;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author ThinkRedstone
 */
public class RepeatingCommandSchedular extends Command {

    private Command c;
    private int runs;
    private int repeats;

    public RepeatingCommandSchedular(int repeats, Command c) {
        this.repeats = repeats;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        runs = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!c.isRunning()) {
            c.start();
            runs++;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return runs == repeats && !c.isRunning();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        c.cancel();
    }
}
