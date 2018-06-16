package org.usfirst.frc.team3039.robot.subsystems;

import org.usfirst.frc.team3039.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SideShooter extends Subsystem {
    private WPI_TalonSRX leftShooterMotor;
    private WPI_TalonSRX rightShooterMotor;
    private WPI_TalonSRX pickupMotor;
    private WPI_TalonSRX stagingMotor;
    private Solenoid tomahawkCylinders;
    private Solenoid shooterCylinders;
    private boolean raised = false;
    private boolean lowered = true;
    private boolean tomahawkState = false;
    public DigitalInput limitSwitch;
    public DigitalOutput cameraSwitch;
    double Kp = .03;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public SideShooter() {
    	leftShooterMotor = new WPI_TalonSRX(RobotMap.PWM_Left_Shooting_Motor);
    	rightShooterMotor = new WPI_TalonSRX(RobotMap.PWM_Right_Shooting_Motor);
    	tomahawkCylinders = new Solenoid(RobotMap.SOL_SS_TOMAHAWKS);
    	shooterCylinders = new Solenoid(RobotMap.SOL_SS_SHOOTER_LIFT);
    	pickupMotor = new WPI_TalonSRX(RobotMap.SS_Pickup_Motor);
    	stagingMotor = new WPI_TalonSRX(RobotMap.SS_StagingMotor);
    	limitSwitch = new DigitalInput(RobotMap.DIO_PickupSwitch);
    	
    }
    
    // Runs the shooter wheels fast
    // so that the robot can shoot in
    // the high goal
    
    public void runShooter(double speed) {
    	leftShooterMotor.set(-speed);
    	rightShooterMotor.set(speed);
    }
    
    
    //Turns off the shooting motors
    public void stopShooter() {
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    }
    
    //starts the pickup sequence 
    //by turning on the pickup and
    //staging motors
    public void startPickup() {
    	pickupMotor.set(-.8);
    	stagingMotor.set(-.3);
    }
    
    //turns off the pickup and
    //staging motors
    public void stopPickup() {
    	pickupMotor.set(0);
    	stagingMotor.set(0);
    }
    
    //Turns on the staging motor so 
    //that the ball is pushed into
    //the shooting motors
     public void shootBoulder() {
    	stagingMotor.set(-.85);
    }
     
     //Turns off the staging motor 
     public void stopShooting() {
    	 stagingMotor.set(0);
     }
     
    //Raises the tomahawks
    public void raiseTomahawks() {
    	tomahawkCylinders.set(raised);
    }
    
    //Lowers the tomahawks
    public void lowerTomahawks() {
    	tomahawkCylinders.set(lowered);
    }
    
    //Raises the shooter to aim at
    //the high goal
    public void raiseShooter() {
    	shooterCylinders.set(lowered);
    }
    
    //Lowers the shooter to aim at
    //the low goal
    public void lowerShooter() {
    	shooterCylinders.set(raised);
    }
    
    public void setCameraTrue() {
    	cameraSwitch.set(true);
    }
    
    public void setCameraFalse() {
    	cameraSwitch.set(false);
    }
    //Returns the state of the limit switch
    //as a boolean
    public boolean getLimitSwitch() {
    	return limitSwitch.get();
    }
    
    public boolean getTomahawkState() {
    	return tomahawkState;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

