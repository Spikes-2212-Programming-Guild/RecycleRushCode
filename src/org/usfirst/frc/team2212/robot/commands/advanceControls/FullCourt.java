/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.advanceControls;

import edu.wpi.first.wpilibj.command.CommandGroup;
import static org.usfirst.frc.team2212.robot.RobotMap.*;

import org.usfirst.frc.team2212.robot.commands.pid.PIDForward;
import org.usfirst.frc.team2212.robot.commands.pid.PIDSideways;

/**
 *
 * @author ThinkRedstone
 */
public class FullCourt extends CommandGroup {
    
    /**
     * Picks up a whole row of boxes and then goes over to the next
     */
    public FullCourt() {
        addSequential(new RepeatingCommandSchedular(3,new PickBoxInFront()));
        addSequential(new PIDForward(AUTO_FORWARD_TOTE_SIZE*-3, AUTO_FORWARD_KP, AUTO_FORWARD_KI, AUTO_FORWARD_KD, AUTO_FORWARD_DT, AUTO_FORWARD_THRESHOLD));
        addSequential(new PIDSideways(FULL_COURT_SIDEWAYS_DEST, AUTO_SIDEWAYS_KP, AUTO_SIDEWAYS_KI, AUTO_SIDEWAYS_KD, AUTO_SIDEWAYS_DT, AUTO_SIDEWAYS_THRESHOLD));
    }
}
