package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.driving.Forward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StupidAutoCommand extends CommandGroup {

	public StupidAutoCommand() {
		addSequential(new Forward(RobotMap.STUPID_AUTO_SPEED),
				RobotMap.STUPID_AUTO_TIMEOUT);
	}

}
