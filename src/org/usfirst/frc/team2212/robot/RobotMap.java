package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static final int LEFT_FORWARD_TALON_PORT = 0;
    public static final int LEFT_BACKWARDS_TALON_PORT = 0;
    public static final int RIGHT_FORWARD_TALON_PORT = 0;
    public static final int RIGHT_BACKWARDS_TALON_PORT = 0;
    public static final int MIDDLE_FRONT_TALON_PORT = 0;
    public static final int MIDDLE_BACKWARDS_TALON_PORT = 0;
    public static final int FORWARD_ENCODER_1_PORT = 0;
    public static final int FORWARD_ENCODE2_2_PORT = 0;
    public static final int SIDEWAYS_ENCODER_1_PORT = 0;
    public static final int SIDEWAYS_ENCODER_2_PORT = 0;
    public static final double WHEEL_DIAMETER = 0;

    public static final int ENCODER_TICKS_IN_FULL_TURN = 1;

    public static final int FORK_LOCK_PORT = 0;
    public static final int FORK_OPEN_PORT = 0;
    public static final int FORK_CLOSE_PORT = 0;

    public static final int LIFTER_ELEVATOR_PORT = 0;
    public static final int LIFTER_UP_PORT = 0;
    public static final int LIFTER_DOWN_PORT = 0;
    public static final int LIFTER_ENCODER_PORT1 = 0;
    public static final int LIFTER_ENCODER_PORT2 = 0;
    public static final double LIFTER_DOWN_SPEED = -1;
    public static final double LIFTER_LIFT_A_LITTLE_TIMEOUT = 0;
    public static final double LIFTER_LIFT_A_LITTLE_SPEED = 0;
    public static final double LIFTER_STAY_SPEED = 0;
    public static final double LIFTER_WHEEL_DIAMETER = 0;

    public static final double AUTO_FORWARD_DEST = 0;
    public static final double AUTO_FORWARD_SMALL_DEST = 0;
    public static final double AUTO_FORWARD_KP = 0;
    public static final double AUTO_FORWARD_KI = 0;
    public static final double AUTO_FORWARD_KD = 0;
    public static final long AUTO_FORWARD_DT = 0;
    public static final double AUTO_FORWARD_THRESHOLD = 0;

    public static final double AUTO_SIDEWAYS_DEST = 0;
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
               // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

}
