/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.PID.PIDMove;
import org.usfirst.frc.team2212.robot.commands.PID.PIDSideways;
import org.usfirst.frc.team2212.robot.commands.forkLifter.LiftALittle;

/**
 *
 * @author ThinkRedstone
 */
public class LiftAndMove extends CommandGroup {

    public LiftAndMove() {
        addSequential(new LiftALittle());
        addParallel(new PIDMove(RobotMap.ONE_TOTE_DEST, RobotMap.ONE_TOTE_KP, RobotMap.ONE_TOTE_KI, RobotMap.ONE_TOTE_KD, RobotMap.ONE_TOTE_DT, RobotMap.ONE_TOTE_THRESHOLD));
        addSequential(new PIDSideways(RobotMap.AUTO_SIDEWAYS_DEST, RobotMap.AUTO_SIDEWAYS_KP, RobotMap.AUTO_SIDEWAYS_KI, RobotMap.AUTO_SIDEWAYS_KD, RobotMap.AUTO_SIDEWAYS_DT, RobotMap.AUTO_SIDEWAYS_THRESHOLD));
    }

}
