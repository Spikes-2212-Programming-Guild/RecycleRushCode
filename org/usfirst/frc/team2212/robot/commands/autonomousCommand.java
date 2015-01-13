/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2212.robot.commands.forkLifter.AddToteToStack;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;

/**
 *
 * @author ThinkRedstone
 */
public class autonomousCommand extends CommandGroup {
    
    public autonomousCommand() {
//        close the fork to hold the first tote
        addSequential(new Close());
//        lift and move to the first tote
        addSequential(new LiftAndMove());
//        add the second tote to the stack
        addSequential(new AddToteToStack());
//        TODO: move to third toe and pick it up.
    }
}
