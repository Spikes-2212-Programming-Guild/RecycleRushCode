/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.advanceControls;

import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_KD;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_KI;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_KP;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_THRESHOLD;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_TOTE_SIZE;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_SIDEWAYS_KD;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_SIDEWAYS_KI;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_SIDEWAYS_KP;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_SIDEWAYS_THRESHOLD;
import static org.usfirst.frc.team2212.robot.RobotMap.FULL_COURT_SIDEWAYS_DEST;

import org.usfirst.frc.team2212.robot.commands.pid.PIDForward;
import org.usfirst.frc.team2212.robot.commands.pid.PIDSideways;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author ThinkRedstone
 */
public class FullCourt extends CommandGroup {

	/**
	 * Picks up a whole row of boxes and then goes over to the next
	 */
	public FullCourt() {
		addSequential(new RepeatingCommandSchedular(3, new PickBoxInFront()));
		addSequential(new PIDForward(AUTO_FORWARD_TOTE_SIZE * -3,
				AUTO_FORWARD_KP, AUTO_FORWARD_KI, AUTO_FORWARD_KD,
				AUTO_FORWARD_THRESHOLD));
		addSequential(new PIDSideways(FULL_COURT_SIDEWAYS_DEST,
				AUTO_SIDEWAYS_KP, AUTO_SIDEWAYS_KI, AUTO_SIDEWAYS_KD,
				AUTO_SIDEWAYS_THRESHOLD));
	}
}
