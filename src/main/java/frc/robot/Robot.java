
package frc.robot;


import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
	
	public static OI oi;
    public static DriveTrain drivetrain; //initialize drive train
    public static Shooter shooter; //initialize side shooter
	public static double Hippo;
   // public static PIDControl pidcontrol;
    Command autonomousCommand;
    @SuppressWarnings("rawtypes")
	SendableChooser autoChooser;
    
    public double[] areas;
	Preferences prefs;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void robotInit() {
		UsbCamera usbCamera = CameraServer.getInstance().startAutomaticCapture();
		usbCamera.setVideoMode(VideoMode.PixelFormat.kYUYV, 320, 180, 60);
    	prefs = Preferences.getInstance();
		Hippo = prefs.getDouble("Hippo", 1);
		
		//cameraserver.setQuality(50);
        // instantiate the command used for the autonomous period
        drivetrain = new DriveTrain();
        shooter = new Shooter();
       // pidcontrol = new PIDControl();
        //CameraServer server1 = CameraServer.getInstance();
    	//server1.setQuality(50);
    	//server1.startAutomaticCapture("cam1");
        //CameraServer server2 = CameraServer.getInstance();
    	//server2.setQuality(50);
       	//server2.startAutomaticCapture("cam2");

    	autoChooser = new SendableChooser();
    	// autoChooser.addDefault("None", new Unbrake());

    	
    	SmartDashboard.putData("Autonomous Chooser", autoChooser);
        
    	
        oi = new OI();
        
//         UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
// //		usbCamera.setWhiteBalanceAuto();
    }
        
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    @Override
	public void autonomousInit() {
        // schedule the autonomous command (example)
//    	autonomousCommand = new AutonomousRockWall();
    	autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
	public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
	public void teleopInit() {
    	Robot.drivetrain.resetGyro();

		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    
    public void robotPeriodic() {
    	//System.out.println("Hippo" + Hippo);

    }
    
	public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    @SuppressWarnings("deprecation")
	@Override
	public void teleopPeriodic() {
//    	System.out.println("Gyro" +Robot.drivetrain.getAngle());
    	
    	/*In order to get GRIP to publish to the network
    	 * you need to add a Publish ContoursReport block in
    	 * Grip. The network table can be viewed from eclipse
    	 * by using Run Outline Viewer in the WPILib tab and
    	 * then entering the IP Address of the camera (10.30.39.20)
    	 * and clicking start server.
    	 */
        Scheduler.getInstance().run();
        LiveWindow.run();
		log();
		
		//NetworkTable.flush();
		
		//this code works but doesnt ge the newest value, just a snapshot of an older network table...
	/*	double[] defaultValue = new double[0];				
		gripTable = NetworkTable.getTable("GRIP/myContoursReport");
		Set<String> gripsubs = gripTable.getKeys();
		double centerX = gripTable.getNumberArray("centerX", defaultValue)[0];
		//System.out.println(centerX);
		System.out.println(centerX); */

    }
    
    /**
     * This function is called periodically during test mode
     */
    @SuppressWarnings("deprecation")
	@Override
	public void testPeriodic() {
        LiveWindow.run();
    }
    
    private void log() {
		drivetrain.log();
	}
}
