/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.forkLifter.AddToteToStack;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Open;
import org.usfirst.frc.team2212.robot.commands.pid.PIDForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author ThinkRedstone
 */
public class AutonomousCommand extends CommandGroup {

    /**
     *
     */
    public AutonomousCommand() {
		// close the fork to hold the first tote
		addSequential(new Close(), RobotMap.AUTONOMOUS_CLOSE_TIMEOUT);
		// lift and move to the first tote
		addSequential(new LiftAndMove());
		// add the second tote to the stack
		addSequential(new AddToteToStack());
		// lift and move to third tote
		addSequential(new LiftAndMove());
		// add the third tote
		addSequential(new AddToteToStack());
		// move to autonomous area
		addSequential(new PIDForward(RobotMap.AUTO_FORWARD_DEST,
				RobotMap.AUTO_FORWARD_KP, RobotMap.AUTO_FORWARD_KI,
				RobotMap.AUTO_FORWARD_KD, RobotMap.AUTO_FORWARD_DT,
				RobotMap.AUTO_FORWARD_THRESHOLD));
		// release the stack
		addSequential(new Open());
		// go back a little
		addSequential(new PIDForward(RobotMap.AUTO_FORWARD_TOTE_SIZE,
				RobotMap.AUTO_FORWARD_KP, RobotMap.AUTO_FORWARD_KI,
				RobotMap.AUTO_FORWARD_KD, RobotMap.AUTO_FORWARD_DT,
				RobotMap.AUTO_FORWARD_THRESHOLD));
	}
}
