/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.advanceControls;

import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_DT;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_KD;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_KI;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_KP;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_THRESHOLD;
import static org.usfirst.frc.team2212.robot.RobotMap.AUTO_FORWARD_TOTE_SIZE;

import org.usfirst.frc.team2212.robot.commands.pid.MoveToLevelWithTimeout;
import org.usfirst.frc.team2212.robot.commands.pid.PIDForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author ThinkRedstone
 */
public class UnloadStack extends CommandGroup {

    /**
     *
     */
    public UnloadStack() {
		addSequential(new MoveToLevelWithTimeout(0));
		addSequential(new PIDForward(-AUTO_FORWARD_TOTE_SIZE, AUTO_FORWARD_KP,
				AUTO_FORWARD_KI, AUTO_FORWARD_KD, AUTO_FORWARD_DT,
				AUTO_FORWARD_THRESHOLD));
	}
}
