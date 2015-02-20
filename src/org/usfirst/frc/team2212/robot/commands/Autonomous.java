/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Commands;
import org.usfirst.frc.team2212.robot.commands.driving.PIDForward;
import org.usfirst.frc.team2212.robot.commands.forkLifter.AddToteToStack;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Open;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This is the main Autonomous Command that should be run in competition.
 * 
 * @author ThinkRedstone
 */
public class Autonomous extends CommandGroup {

	public Autonomous() {
		// close the fork to hold the first tote
		addSequential(new Close(), Commands.AUTONOMOUS_CLOSE_TIMEOUT);
		// lift and move to the first tote
		addSequential(new LiftAndMove());
		// add the second tote to the stack
		addSequential(new AddToteToStack());
		// lift and move to third tote
		addSequential(new LiftAndMove());
		// add the third tote
		addSequential(new AddToteToStack());
		// move to autonomous area
		addSequential(new PIDForward(Commands.AUTO_FORWARD_DEST));
		// release the stack
		addSequential(new Open());
		// go back a little
		addSequential(new PIDForward(Commands.AUTO_FORWARD_TOTE_SIZE));
	}
}
