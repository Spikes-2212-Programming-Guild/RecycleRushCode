/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author ThinkRedstone
 */
public class PID {

	private final double destination, kp, ki, kd, threshold;
	private final long dt;
	private double p, i, d, error, prevError;

	public PID(double destination, double kp, double ki, double kd, long dt,
			double threshold) {
		this.destination = destination;
		error = destination;
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
		this.dt = dt;
		this.threshold = threshold;
		reset();
	}

	public double doPID(double in) {
		/*
		 * When i wrote this code, only I and god knew what is written here.
		 * Now only Tzoor knows
		 */
		prevError = error;
		SmartDashboard.putNumber("error", error);
		error = destination - in;
		p = kp * error;
		i += ki * dt * error;
		d = kd * (prevError - error) / dt;
		return (p + i + d);
		// long prevTime = System.currentTimeMillis();
		// while (System.currentTimeMillis() - prevTime < DT)
		// prevTime = System.currentTimeMillis();

	}

	public void waitForPID() {
		long prevTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - prevTime < dt) {
			
		}
	}

	public boolean hasArrived() {
		boolean arrived = Math.abs(error) < threshold;
		SmartDashboard.putBoolean("arrived", arrived);
		return arrived;
	}

	public void reset() {
		p = 0;
		i = 0;
		d = 0;
		error = destination;
		prevError = error;
	}

}
