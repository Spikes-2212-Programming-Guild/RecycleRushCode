package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.driving.Sideways;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StupidAutoCommand extends CommandGroup {

	public StupidAutoCommand() {
		addSequential(new Close(), RobotMap.AUTONOMOUS_CLOSE_TIMEOUT);
		addSequential(new Sideways(RobotMap.STUPID_AUTO_SPEED),
				RobotMap.STUPID_AUTO_TIMEOUT);
	}

}
