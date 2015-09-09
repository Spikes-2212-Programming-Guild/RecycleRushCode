package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.driving.Forward;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Up;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author thinkredstone
 * A time  based, stupid, autonomous command
 */
public class StupidAutoCommand extends CommandGroup {

    /**
     *
     */
    public StupidAutoCommand() {
		addSequential(new Close(), RobotMap.AUTONOMOUS_CLOSE_TIMEOUT);
		addSequential(new Up(), RobotMap.AUTONOMOUS_UP_TIMEOUT);
		addSequential(new Forward(RobotMap.STUPID_AUTO_SPEED),
				RobotMap.STUPID_AUTO_TIMEOUT);
	}

}
