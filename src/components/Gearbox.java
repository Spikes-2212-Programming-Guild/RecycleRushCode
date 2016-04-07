/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author ThinkRedstone
 *  Synchronises two SC to work together
 * 
 *         This code is working!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
 */
public class Gearbox implements SpeedController {
	
	/*
	 * Phineas has only one speed controller,
	 * which controls both motors.
	 */
	private Talon talon;

    /**
     *
     * @param forward - forward Victor 
     * @param backwards - backwards Victor
     */
    public Gearbox(Talon talon) {
    	this.talon = talon;
	}

    /**
     *
     * @param forwardPort - port for forward Victor
     * @param backwardsPort - port for backwards Victor
     */
    public Gearbox(int port) {
		this(new Talon(port));
	}

	@Override
	public void set(double speed) {
		talon.set(speed);
	}

	@Override
	public void pidWrite(double output) {
		set(output);
	}

	@Override
	public double get() {
		return talon.get();
	}

	@Deprecated
	@Override
	public void set(double speed, byte syncGroup) {
		talon.set(speed, syncGroup);
	}

	@Override
	public void disable() {
		talon.disable();
	}
	
	@Override
	public void setInverted(boolean isInverted) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Do not call this function, it does not exist in the new WPILIB libraries.
	 */
	@Deprecated
	@Override
	public boolean getInverted() {
		// TODO Auto-generated method stub
		return false;
	}

}
