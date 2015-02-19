package org.usfirst.frc.team2212.robot;

public class Commands {
	public static final double UP_SPEED = 0.6;
	public static final double DOWN_SPEED = -0.142;
	public static final double LIFT_A_LITTLE_TIMEOUT = 0.2;
	public static final double LIFT_A_LITTLE_SPEED = 0.4;

	public static final double AUTO_FORWARD_DEST = 60;
	public static final double AUTO_FORWARD_TOTE_SIZE = 16.9;
	public static final double AUTO_FORWARD_KP = 0.25;
	public static final double AUTO_FORWARD_KI = 0;
	public static final double AUTO_FORWARD_KD = 0;
	public static final double AUTO_FORWARD_THRESHOLD = 1;

	public static final double AUTO_SIDEWAYS_DEST = (2 * 12 + 9) + (26.9 / 2); // 2*12+9+26.9/2
	public static final double FULL_COURT_SIDEWAYS_DEST = 0;
	public static final double AUTO_SIDEWAYS_KP = 0.25;
	public static final double AUTO_SIDEWAYS_KI = 0;
	public static final double AUTO_SIDEWAYS_KD = 0;
	public static final double AUTO_SIDEWAYS_THRESHOLD = 1;

	public static final double ONE_TOTE_DEST = 12.1;
	public static final double ONE_TOTE_KP = 0.25;// 1 / Math.E;
	public static final double ONE_TOTE_KI = 0;
	public static final double ONE_TOTE_KD = 0;
	public static final long ONE_TOTE_DT = 50;
	public static final double ONE_TOTE_THRESHOLD = 0.125;
	public static final int ONE_TOTE_TIMEOUT = 2;

	public static final double AUTONOMOUS_CLOSE_TIMEOUT = 0.5;

	public static final double STUPID_AUTO_TIMEOUT = 4;
	public static final double STUPID_AUTO_SPEED = 0.6;
}
