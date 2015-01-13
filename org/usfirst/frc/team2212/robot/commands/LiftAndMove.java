/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2212.robot.commands.forkLifter.LiftALittle;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Up;

/**
 *
 * @author ThinkRedstone
 */
public class LiftAndMove extends CommandGroup {

    public LiftAndMove() {
        addSequential(new LiftALittle());
//        TODO: DriveTo() parallel 
        addSequential(new Up());
    }

}
