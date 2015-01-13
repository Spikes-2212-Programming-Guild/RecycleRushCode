/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author ThinkRedstone
 */
public class PID {

    private final double DESTINATION, KP, KI, KD, THRESHOLD;
    private final long DT;
    private double p, i, d, error, prevError;

    public PID(double DESTINATION, double KP, double KI, double KD, long DT,
            double THRESHOLD, double in) {
        this.DESTINATION = DESTINATION;
        this.KP = KP;
        this.KI = KI;
        this.KD = KD;
        this.DT = DT;
        this.THRESHOLD = THRESHOLD;
        reset(in);
    }

    public double doPID(double in) {
        prevError = error;
        error = DESTINATION - in;
        p = KP * error;
        i += KI * DT * error;
        d = KD * (prevError - error) / DT;
        return (p + i + d);
//		long prevTime = System.currentTimeMillis();
//		while (System.currentTimeMillis() - prevTime < DT)
//			prevTime = System.currentTimeMillis();

    }

    public boolean hasArrived() {
        return Math.abs(error) < THRESHOLD;
    }

    public void reset(double in) {
        p = 0;
        i = 0;
        d = 0;
        error = DESTINATION - in;
        prevError = error;
    }

}
