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
 *  Synchronises two SC to work together
 * 
 *         This code is working!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
 */
public class Gearbox implements SpeedController {

	private VictorSP forward, backwards;

    /**
     *
     * @param forward - forward Victor 
     * @param backwards - backwards Victor
     */
    public Gearbox(VictorSP forward, VictorSP backwards) {
		this.forward = forward;
		this.backwards = backwards;
	}

    /**
     *
     * @param forwardPort - port for forward Victor
     * @param backwardsPort - port for backwards Victor
     */
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

	@Deprecated
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

	@Override
	public void setInverted(boolean isInverted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getInverted() {
		// TODO Auto-generated method stub
		return false;
	}

}
