/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 * @author ThinkRedstone
 */
public class Gearbox implements SpeedController {

	private VictorSP forward, backwards;

	public Gearbox(VictorSP forward, VictorSP backwards) {
		this.forward = forward;
		this.backwards = backwards;
	}

	public Gearbox(int forwardPort, int backwardsPort) {
		this(new VictorSP(forwardPort), new VictorSP(backwardsPort));
	}

	@Override
	public void set(double speed) {
		forward.set(speed);
		backwards.set(speed);
	}

	@Override
	public void pidWrite(double output) {
		set(output);
	}

	@Override
	public double get() {
		return forward.get();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void set(double speed, byte syncGroup) {
		forward.set(speed, syncGroup);
		backwards.set(speed, syncGroup);

	}

	@Override
	public void disable() {
		forward.disable();
		backwards.disable();
	}

}
