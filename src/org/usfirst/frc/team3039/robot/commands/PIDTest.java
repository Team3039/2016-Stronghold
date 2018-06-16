package org.usfirst.frc.team3039.robot.commands;

import org.usfirst.frc.team3039.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDTest extends Command {

    public PIDTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    // Robot.pidcontrol.enablePID();
	//System.out.println("Value is " + Robot.pidcontrol.encoderPID.getRate());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.pidcontrol.disablePID();
    	//Robot.pidcontrol.pidMotor.disable();
    	//Robot.pidcontrol.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.pidcontrol.disablePID();
    	//Robot.pidcontrol.pidMotor.disable();
    	//Robot.pidcontrol.disable();
    }
}
