package org.usfirst.frc.team2212.robot.commands.pid;

import static org.usfirst.frc.team2212.robot.Robot.lifter;

import org.usfirst.frc.team2212.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author thinkredstone
 */
public class MoveToLevelWithTimeout extends Command {

	private int level;
	private boolean cantOperate;

    /**
     *
     * @param level
     */
    public MoveToLevelWithTimeout(int level) {
		requires(lifter);
		this.level = level;
		if (lifter.getLevel() == -1)
			cantOperate = true;
		else
			cantOperate = false;
	}

	@Override
	protected void initialize() {
		lifter.reset();
		setTimeout(level * RobotMap.ONE_TOTE_TIMEOUT);
	}

	@Override
	protected void execute() {
		if (!cantOperate)
			lifter.set(RobotMap.LIFTER_UP_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut() || level > 0 ? lifter.isUp() : lifter.isDown();
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
