package org.usfirst.frc.team3039.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	//USB Ports
	//public static final int USBCamera = 0;
	
	//Drive Train Ports
    public static final int DT_RightFront = 1;
    public static final int DT_Left_Front = 2;
    public static final int DT_Left_Back = 8;
    public static final int DT_Right_Back = 7;
    
    //Side Shooter (SS) Ports
    public static final int SS_Pickup_Motor = 3;
    public static final int SS_StagingMotor = 4;
    public static final int PWM_Right_Shooting_Motor = 5;
    public static final int PWM_Left_Shooting_Motor = 6;

    //DIO Ports
    public static final int DIO_PickupSwitch = 0;
    //public static final int DIO_CameraSwitch = 1;
    public static final int DIO_EncoderALeft = 4;
    public static final int DIO_EncoderBLeft = 5;
    public static final int DIO_EncoderARight = 6;
    public static final int DIO_EncoderBRight = 7;
    public static final int DIO_PhotoElectric = 8;
    public static final int DIO_RotateRight = 1;
    public static final int DIO_RotateLeft = 9;
    //AIO Ports
    public static final int AIO_GYRO = 0;
    public static final int AIO_UltraSonic = 1;
    
    //Solenoid Ports   
    public static final int SOL_SS_SHOOTER_LIFT = 3;
    public static final int SOL_SS_TOMAHAWKS = 2;
    public static final int SOL_BRAKE = 1;
    
    //Winch Ports
    public static final int PWM_GUIDE_MOTOR = 7;
    public static final int PWM_WINCH_MOTOR_1 = 8;
    public static final int PWM_WINCH_MOTOR_2 = 9;
    
    //Other Motor Ports
    
    public static final int PWM_PID_Motor = 0;
    
    //HID Controller Ports
    public static final int HID_Controller = 0;
    public static final int HID_Copilot = 1;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
 