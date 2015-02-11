package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int LEFT_FORWARD_VICTOR_PORT = 8;
	public static final int LEFT_BACKWARDS_VICTOR_PORT = 9;
	public static final int RIGHT_FORWARD_VICTOR_PORT = 0;
	public static final int RIGHT_BACKWARDS_VICTOR_PORT = 1;
	public static final int MIDDLE_FRONT_VICTOR_PORT = 4;
	public static final int MIDDLE_BACKWARDS_VICTOR_PORT = 5;
	public static final int LEFT_ENCODER_1_PORT = 3;
	public static final int LEFT_ENCODER_2_PORT = 4;
	public static final int RIGHT_ENCODER_1_PORT = 7;
	public static final int RIGHT_ENCODER_2_PORT = 8;
	public static final int FRONT_ENCODER_1_PORT = 17; // 7
	public static final int FRONT_ENCODER_2_PORT = 18; // 8, 9, 10
	public static final int REAR_ENCODER_1_PORT = 5;
	public static final int REAR_ENCODER_2_PORT = 6;

	public static final double MAX_TURN_SPEED = 0.3;
	public static final double WHEEL_DIAMETER = 6; // inches
	public static final double FIXED_TOLARANCE = 0;
	public static final double TURN_TOLERANCE = 0.01;
	public static final int ENCODER_TICKS_IN_FULL_TURN = 0;

	public static final int FORK_TALON_ID = 3;
	public static final int FORK_OPEN_DI_1_PORT = 1;
	public static final int FORK_OPEN_DI_2_PORT = 2;
	public static final int FORK_CLOSE_DI_PORT = 23; // 13

	public static final int LIFTER_TALON_1_ID = 1;
	public static final int LIFTER_TALON_2_ID = 2;
	public static final int LIFTER_UP_DI_PORT = 9;
	public static final int LIFTER_DOWN_DI_PORT = 0;
	public static final int LIFTER_ENCODER_PORT1 = 10; // 0
	public static final int LIFTER_ENCODER_PORT2 = 11; // 1, 2, 3
	public static final double LIFTER_UP_SPEED = 0.1;
	public static final double LIFTER_DOWN_SPEED = 0.1;
	public static final double LIFTER_LIFT_A_LITTLE_TIMEOUT = 0;
	public static final double LIFTER_LIFT_A_LITTLE_SPEED = 0;
	public static final double LIFTER_STAY_SPEED = 0.15;
	public static final double LIFTER_WHEEL_DIAMETER = 0;
	public static final int MAX_LIFTER_LEVEL = 6;

	public static final double AUTO_FORWARD_DEST = 0;
	public static final double AUTO_FORWARD_TOTE_SIZE = 0;
	public static final double AUTO_FORWARD_KP = 0;
	public static final double AUTO_FORWARD_KI = 0;
	public static final double AUTO_FORWARD_KD = 0;
	public static final long AUTO_FORWARD_DT = 0;
	public static final double AUTO_FORWARD_THRESHOLD = 0;

	public static final double AUTO_SIDEWAYS_DEST = 0;
	public static final double FULL_COURT_SIDEWAYS_DEST = 0;
	public static final double AUTO_SIDEWAYS_KP = 0;
	public static final double AUTO_SIDEWAYS_KI = 0;
	public static final double AUTO_SIDEWAYS_KD = 0;
	public static final long AUTO_SIDEWAYS_DT = 0;
	public static final double AUTO_SIDEWAYS_THRESHOLD = 0;

	public static final double ONE_TOTE_DEST = 0;
	public static final double ONE_TOTE_KP = 0;
	public static final double ONE_TOTE_KI = 0;
	public static final double ONE_TOTE_KD = 0;
	public static final long ONE_TOTE_DT = 0;
	public static final double ONE_TOTE_THRESHOLD = 0;

}
