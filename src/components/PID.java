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
		 * When I wrote this code, only Tzoor and I understood it. Now, Tzoor
		 * only knows
		 */
		prevError = error;
		SmartDashboard.putNumber("error", error);
		error = destination - in;
		p = kp * error;
		i += ki * dt * error;
		d = kd * (prevError - error) / dt;
		return p + i + d;
		// long prevTime = System.currentTimeMillis();
		// while (System.currentTimeMillis() - prevTime < DT)
		// prevTime = System.currentTimeMillis();

	}

	public double getPID() {
		return p + i + d;
	}

	public void waitForPID() {
		long prevTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - prevTime < dt) {

		}
	}

	public boolean hasArrived() {
		return Math.abs(error) < threshold;
	}

	public void reset() {
		p = 0;
		i = 0;
		d = 0;
		error = destination;
		prevError = error;
	}

	public double speed() {
		return (prevError - error) / dt;
	}

}
