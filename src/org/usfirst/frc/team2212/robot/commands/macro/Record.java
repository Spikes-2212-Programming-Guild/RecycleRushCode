/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.commands.macro;

//import static org.usfirst.frc.team2212.robot.Robot.lock;
import static org.usfirst.frc.team2212.robot.Robot.oi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import macro.Macro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author AtidSpikes
 */
public class Record extends Command {

	String macroName;
	Macro macro;

	public Record(String macroName) {
		this.macroName = macroName;
		// requires(lock);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		ArrayList<Boolean> drivingButtonsArray = new ArrayList<>();
		drivingButtonsArray.add(false);
		ArrayList<Double> drivingAxisArray = new ArrayList<>(3);
		for (int i = 1; i <= 10; i++) {
			drivingButtonsArray.add(oi.getDriverButton(i));
		}
		drivingAxisArray.add(0, oi.getDriverX());
		drivingAxisArray.add(1, oi.getDriverY());
		drivingAxisArray.add(2, oi.getDriverTwist());
		
		ArrayList<Boolean> navigatingButtonsArray = new ArrayList<>();
		navigatingButtonsArray.add(false);
		ArrayList<Double> navigatingAxisArray = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			navigatingButtonsArray.add(oi.getDriverButton(i));
		}
		navigatingAxisArray.add(oi.getDriverX());
		navigatingAxisArray.add(oi.getDriverY());
		navigatingAxisArray.add(oi.getDriverTwist());
		macro = new Macro(drivingButtonsArray, drivingAxisArray, navigatingButtonsArray, navigatingAxisArray );
		SmartDashboard.putBoolean("in end", false);
		SmartDashboard.putBoolean("in try", false);
		SmartDashboard.putBoolean("in fon", false);
		SmartDashboard.putBoolean("in io", false);
		SmartDashboard.putData(this);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		ArrayList<Boolean> buttonsArray = new ArrayList<>();
		buttonsArray.add(false);
		ArrayList<Double> axisArray = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			buttonsArray.add(oi.getDriverButton(i));
		}
		axisArray.add(0, oi.getDriverX());
		axisArray.add(1, oi.getDriverY());
		axisArray.add(2, oi.getDriverTwist());
		macro.addDataDriving(buttonsArray, axisArray);
		

		ArrayList<Boolean> navigatingButtonsArray = new ArrayList<>();
		navigatingButtonsArray.add(false);
		ArrayList<Double> navigatingAxisArray = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			navigatingButtonsArray.add(oi.getNavigatorButton(i));
		}
		SmartDashboard.putNumber("size: ", navigatingButtonsArray.size());
		navigatingAxisArray.add(0, oi.getNavX());
		navigatingAxisArray.add(1, oi.getNavY());
		navigatingAxisArray.add(2, oi.getNavTwist());
		macro.addDataNavigating(navigatingButtonsArray, navigatingAxisArray);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		ObjectOutputStream output = null;
		SmartDashboard.putBoolean("in end", true);
		try {
			File file = new File("/home/lvuser/Macros/" + macroName + ".ser");
			if (file.exists())
				Runtime.getRuntime().exec(
						"rm /home/lvuser/Macros/" + macroName + ".ser");
			Runtime.getRuntime().exec(
					"touch /home/lvuser/Macros/" + macroName + ".ser");
			Runtime.getRuntime().exec(
					"chmod 666 /home/lvuser/Macros/" + macroName + ".ser");
			SmartDashboard.putBoolean("file exists", file.exists());
			FileOutputStream fos = new FileOutputStream(file);
			output = new ObjectOutputStream(fos);
			output.writeObject(macro);
			SmartDashboard.putBoolean("in try", true);
		} catch (FileNotFoundException e) {
			SmartDashboard.putBoolean("in fon", true);
			e.printStackTrace();
		} catch (IOException e) {
			SmartDashboard.putBoolean("in io", true);
			e.printStackTrace();
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
