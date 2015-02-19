/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.forkLifter.LiftALittle;
import org.usfirst.frc.team2212.robot.commands.pid.MoveToLevelWithTimeout;
import org.usfirst.frc.team2212.robot.commands.pid.PIDSideways;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author ThinkRedstone
 */
public class LiftAndMove extends CommandGroup {

	public LiftAndMove() {
		addSequential(new LiftALittle());
		addParallel(new MoveToLevelWithTimeout(1));
		addSequential(new PIDSideways(RobotMap.AUTO_SIDEWAYS_DEST));
	}

}
