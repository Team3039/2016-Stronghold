package org.usfirst.frc.team3039.robot.commands;

import org.usfirst.frc.team3039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderDriveLeft extends Command {

	double target; 
	
    public EncoderDriveLeft(double target) {
    	this.target = target;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.drivetrain.resetEncoder();
		Robot.drivetrain.resetGyro();
		Robot.drivetrain.setDistancePerPulse();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.autoDrive(.65, 0);
    	System.out.println("Inches Are " + Robot.drivetrain.getInches());
    	System.out.println("Gyro Angle " + Robot.drivetrain.getAngle()); 
    	}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (target <= (Robot.drivetrain.getInches()));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
