/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.forkLifter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author ThinkRedstone
 */
public class AddToteToStack extends CommandGroup {
    
    public AddToteToStack() {
        addSequential(new Up());
        addSequential(new Open());
        addSequential(new Down());
        addSequential(new Close());
        addSequential(new LiftALittle());
    }
}