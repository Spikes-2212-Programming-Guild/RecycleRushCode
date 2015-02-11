/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.advanceControls;

import edu.wpi.first.wpilibj.command.CommandGroup;
import static org.usfirst.frc.team2212.robot.RobotMap.*;

import org.usfirst.frc.team2212.robot.commands.forkLifter.AddToteToStack;
import org.usfirst.frc.team2212.robot.commands.pid.MoveToLevel;
import org.usfirst.frc.team2212.robot.commands.pid.PIDForward;

/**
 *
 * @author ThinkRedstone
 */
public class PickBoxInFront extends CommandGroup {
    
    public PickBoxInFront() {
        addSequential(new MoveToLevel(1));
        addSequential(new PIDForward(AUTO_FORWARD_TOTE_SIZE, AUTO_FORWARD_KP, AUTO_FORWARD_KI, AUTO_FORWARD_KD, AUTO_FORWARD_DT, AUTO_FORWARD_THRESHOLD));
        addSequential(new AddToteToStack());
    }
}
