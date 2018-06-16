package org.usfirst.frc.team3039.robot.subsystems;

import org.usfirst.frc.team3039.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
//public class PIDControl extends PIDSubsystem {
	
	//public Talon pidMotor = new Talon(RobotMap.PWM_PID_Motor);
	//public Encoder encoderPID = new Encoder(RobotMap.DIO_EncoderAPID, RobotMap.DIO_EncoderBPID, false, Encoder.EncodingType.k4X);

    // Initialize your subsystem here
	//public PIDControl() {
    	//super("PIDControl", 2, 2, 2);
    	//setAbsoluteTolerance(0.05);
		//getPIDController().setContinuous(false);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    //}

	//public void enablePID() {
		//enable();
	//}
	
	//public void disablePID() {
		//disable();
		/** we also need to turn off the speed controller at this point
		 we do not want to disable the speed controller because we would need to reinitialize its object,
		instead we just stop it.
		 * */
		//pidMotor.stopMotor();
	//}
	//public void stopPIDControl() {
		//pidMotor.stopMotor();
		//disable();
		//setOutputRange(0, 0);
		//pidMotor.pidWrite(0);
		//disable();
		//Do not use "stopPIDControl();" it shuts down the code
	//}

    //public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    //}

    //protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
      //  return encoderPID.getRate();
    //}

    //protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    //	pidMotor.pidWrite(.7);
  //  }
//}
