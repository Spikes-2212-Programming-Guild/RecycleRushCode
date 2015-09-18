package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int LEFT_FRONT_VICTOR = 0;
	public static final int LEFT_REAR_VICTOR = 1;
	public static final int RIGHT_FRONT_VICTOR = 8;
	public static final int RIGHT_REAR_VICTOR = 9;
	public static final int MIDDLE_FRONT_VICTOR = 4;
	public static final int MIDDLE_REAR_VICTOR = 5;
	public static final int LEFT_ENCODER_A = 1;
	public static final int LEFT_ENCODER_B = 19;
	public static final int RIGHT_ENCODER_A = 0;
	public static final int RIGHT_ENCODER_B = 20;
	public static final int FRONT_ENCODER_A = 2;
	public static final int FRONT_ENCODER_B = 18;
	public static final int REAR_ENCODER_A = 4;
	public static final int REAR_ENCODER_B = 5;

	public static final int FORK_TALON = 3;
	public static final int FORK_OPEN_DI_1 = 7;
	public static final int FORK_OPEN_DI_2 = 9;
	public static final int FORK_ENCODER_A = 10;
	public static final int FORK_ENCODER_B = 11;
	public static final int FORK_CLOSE_DI = 8;

	public static final int LIFTER_TALON_1 = 1;
	public static final int LIFTER_TALON_2 = 2;
	public static final int LIFTER_UP_DI = 6;
	public static final int LIFTER_DOWN_DI = 23;
	public static final int LIFTER_ENCODER_A = 3;
	public static final int LIFTER_ENCODER_B = 17;

	public static final double FIX_FORWARD_KP = 17;
	public static final double FIX_FORWARD_KI = 17;
	public static final double FIX_FORWARD_KD = 17;
}
