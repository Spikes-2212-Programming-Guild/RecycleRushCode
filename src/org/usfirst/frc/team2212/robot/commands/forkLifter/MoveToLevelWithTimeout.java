package org.usfirst.frc.team2212.robot.commands.forkLifter;

import static org.usfirst.frc.team2212.robot.Robot.lifter;

import org.usfirst.frc.team2212.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

public class MoveToLevelWithTimeout extends Command {

	int level;
	boolean cantOperate;

	public MoveToLevelWithTimeout(int level) {
		requires(lifter);
		this.level = level;
		cantOperate = lifter.getLevel() == -1;
	}

	@Override
	protected void initialize() {
		lifter.reset();
		setTimeout(level * Commands.ONE_TOTE_TIMEOUT);
	}

	@Override
	protected void execute() {
		if (!cantOperate) {
			lifter.set(Commands.LIFTER_UP_SPEED);
		}
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut() || level > 0 ? lifter.isUp() : lifter.isDown() || cantOperate;
	}

	@Override
	protected void end() {
		lifter.set(0);
		lifter.setLevel(level);
		lifter.verifyLevel();
	}

	@Override
	protected void interrupted() {
		lifter.set(0);
		lifter.corruptLevel();
	}

}
