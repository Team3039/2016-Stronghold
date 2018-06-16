package org.usfirst.frc.team3039.robot.commands;

import org.usfirst.frc.team3039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UltraSonicDrive extends Command {
	double speed;
	double angle;
	double targetDistance;
    public UltraSonicDrive(double speed, double angle, double targetDistance) {

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed = speed;
    	this.angle = angle;
    	this.targetDistance = targetDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.readUltraSonic();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.autoDrive(speed, angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.drivetrain.getUltraSonic() <= targetDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    	Robot.drivetrain.readUltraSonic();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
