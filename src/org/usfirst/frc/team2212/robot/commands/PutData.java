package org.usfirst.frc.team2212.robot.commands;

import static org.usfirst.frc.team2212.robot.Robot.driveTrain;
import static org.usfirst.frc.team2212.robot.Robot.fork;
import static org.usfirst.frc.team2212.robot.Robot.lifter;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PutData extends Command {

	public PutData() {

	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Left Encoder", driveTrain.getLeft());
		SmartDashboard.putNumber("Right Encoder", driveTrain.getRight());
		SmartDashboard.putNumber("Front Encoder", driveTrain.getFront());
		SmartDashboard.putNumber("Rear Encoder", driveTrain.getRear());
		SmartDashboard.putNumber("Lifter Encoder", lifter.get());
		SmartDashboard.putBoolean("Lifter Up", lifter.isUp());
		SmartDashboard.putBoolean("Lifter Down", lifter.isDown());
		SmartDashboard.putBoolean("Fork Open", fork.isOpen());
		SmartDashboard.putBoolean("Fork Closed", fork.isClosed());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
