package org.usfirst.frc.team3039.robot.subsystems;

import org.usfirst.frc.team3039.robot.RobotMap;
import org.usfirst.frc.team3039.robot.commands.Driving;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.team3039.util.PS4Gamepad;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *Consists of everything that drives the robot
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(RobotMap.DT_Left_Front);
	public WPI_TalonSRX rearLeftMotor = new WPI_TalonSRX(RobotMap.DT_Left_Back);
	public WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(RobotMap.DT_RightFront);
	public WPI_TalonSRX rearRightMotor = new WPI_TalonSRX(RobotMap.DT_Right_Back);
	
    public SpeedControllerGroup leftDrivetrain = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
    public SpeedControllerGroup rightDrivetrain = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
    
    public DifferentialDrive driveArcade = new DifferentialDrive(leftDrivetrain, rightDrivetrain);

	public Solenoid brake = new Solenoid(RobotMap.SOL_BRAKE);
	public AnalogGyro gyro = new AnalogGyro(RobotMap.AIO_GYRO);

	public DigitalInput photoelectric = new DigitalInput(RobotMap.DIO_PhotoElectric);
	public AnalogInput ultrasonic = new AnalogInput(RobotMap.AIO_UltraSonic);
	public Encoder encoderLeft = new Encoder(RobotMap.DIO_EncoderALeft, RobotMap.DIO_EncoderBLeft, false, Encoder.EncodingType.k4X);
	public Encoder encoderRight = new Encoder(RobotMap.DIO_EncoderARight, RobotMap.DIO_EncoderBRight, false, Encoder.EncodingType.k4X);
	
	private final double Kp = .003;
	private final double Rp = -.027;
	public DigitalInput rotateLeft = DigitalInput(RobotMap.DIO_RotateLeft);
	public DigitalInput rotateRight = DigitalInput(RobotMap.DIO_RotateRight);

	
    private DigitalInput DigitalInput(int dioRotateleft) {
		// TODO Auto-generated method stub
		return null;
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Driving());
    }
	
	public void slowTurnLeft() {
		frontLeftMotor.set(.1);
		rearLeftMotor.set(.1);
		frontRightMotor.set(-.8);
		rearRightMotor.set(-.8);
	}
	
	public void slowTurnRight() {
		frontLeftMotor.set(.8);
		rearLeftMotor.set(.8);
		frontRightMotor.set(-.1);
		rearRightMotor.set(-.1);
	}
    
	public void driveArcade(PS4Gamepad gp){
    	driveArcade.arcadeDrive(-gp.getLeftYAxis()*.8, gp.getRightXAxis()*.9); 
		//driveArcade.tankDrive(-gp.getLeftYAxis()*.8, -gp.getRightYAxis()*.8);
    }
    
    public void slowTurnDrive(PS4Gamepad gp) {
    		driveArcade.arcadeDrive(-gp.getLeftYAxis() * .8, -gp.getRightXAxis() * .6);
    }
    
    public void feedbackTurn(double targetAngle) {
    	driveArcade.arcadeDrive(0, (targetAngle-getAngle())*Rp);
    	
    }

	
	public void printEncoder() {
		System.out.println("Left Value " + encoderLeft.get());
		System.out.println("Right Value " + encoderRight.get());
	}

	public void setDistancePerPulse() {
		encoderLeft.setDistancePerPulse(0.06527);
		encoderRight.setDistancePerPulse(0.06527);
	}
	
	public double getInches() {
		return encoderLeft.getDistance();
	}
	
	public void resetEncoder() {
		encoderRight.reset();
		encoderLeft.reset();
	}
    
    public void stop() {
    	driveArcade.stopMotor();
    }
    
	public void brake() {
		brake.set(false);
	}

	public void unbrake() {
		brake.set(true);
	}

	public void resetGyro() {
		gyro.reset();
	}
	
	public void autoDrive(double speed, double angle) {
		driveArcade.arcadeDrive(speed, angle);
	}
	
	public void tankDriveManual(double leftSpeed, double rightSpeed) {
		frontLeftMotor.set(leftSpeed);
		rearLeftMotor.set(leftSpeed);
		frontRightMotor.set(rightSpeed);
		rearRightMotor.set(rightSpeed);
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
	public boolean getPhotoElectricSensor() {
		return photoelectric.get();
	}
	
	public double getUltraSonic() {
		return ultrasonic.getVoltage()*1024/10;
	}
	
	public void readUltraSonic() {
		System.out.println(getUltraSonic());
	}
	
	public void rotateSlowRight() {
		driveArcade.arcadeDrive(0, -.4);
    }

public void rotateSlowLeft() {
	driveArcade.arcadeDrive(0, .4);
	}

public boolean readRightRotate() {
	return rotateRight.get();
}

public boolean readLeftRotate() {
	return rotateLeft.get();
}
	public void log() {
	}
}

