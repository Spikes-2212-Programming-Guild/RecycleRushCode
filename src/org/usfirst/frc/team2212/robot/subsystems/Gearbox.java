/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

public class Gearbox implements SpeedController {

	VictorSP front, rear;

	public Gearbox(int frontChannel, int rearChannel) {
		this.front = new VictorSP(frontChannel);
		this.rear = new VictorSP(rearChannel);
	}

	@Override
	public void set(double speed) {
		front.set(speed);
		rear.set(speed);
	}

	@Override
	public void pidWrite(double output) {
		set(output);
	}

	@Override
	public double get() {
		return front.get();
	}

	@Deprecated
	@Override
	public void set(double speed, byte syncGroup) {
		front.set(speed, syncGroup);
		rear.set(speed, syncGroup);

	}

	@Override
	public void disable() {
		front.disable();
		rear.disable();
	}

}
