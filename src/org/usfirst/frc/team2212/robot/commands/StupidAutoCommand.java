package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Commands;
import org.usfirst.frc.team2212.robot.commands.driving.Forward;
import org.usfirst.frc.team2212.robot.commands.forkLifter.Close;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StupidAutoCommand extends CommandGroup {

	public StupidAutoCommand() {
		addSequential(new Close(), Commands.AUTONOMOUS_CLOSE_TIMEOUT);
		addSequential(new Forward(Commands.STUPID_AUTO_SPEED),
				Commands.STUPID_AUTO_TIMEOUT);
	}

}
