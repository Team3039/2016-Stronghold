package frc.robot;



import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.commands.Brake;
import frc.robot.commands.RaiseShooter;
import frc.robot.commands.RunShooter;
import frc.robot.commands.ShootBoulder;
import frc.robot.commands.SlowTurnDriving;
import frc.robot.commands.StartPickup;
import frc.robot.commands.ToggleTomahawks;
import frc.util.PS4Copad;
import frc.util.PS4Gamepad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS

	public PS4Gamepad gp = new PS4Gamepad(RobotMap.HID_Controller);
	public PS4Copad cp = new PS4Copad(RobotMap.HID_Copilot);

	Button ButtonL1 = gp.getL1();
	Button ButtonR1 = gp.getR1();
	Button ButtonX = gp.getButtonX();
	Button ButtonCircle = gp.getButtonCircle();
	Button ButtonTriangle = gp.getButtonTriangle();
	Button ButtonSquare = gp.getButtonSquare();
	Button ButtonStart = gp.getStartButton();
//	Button DialLeftHome = cpb.getDialLeftHome();
//	Button DialLeftOne = cpb.getDialLeftOne();
//	Button DialLeftTwo = cpb.getDialLeftTwo();
//	Button DrivingSwitch = cpb.getTomahawkSwitch();
	Button ButtonL2 = gp.getL2();
	Button ButtonR2 = gp.getR2();
	
	Button coButtonX = cp.getButtonX();
	Button coButtonCircle = cp.getButtonCircle();
	Button coButtonSquare = cp.getButtonSquare();
	Button coButtonTriangle = cp.getButtonTriangle();
	Button coButtonL2 = cp.getL2();
	Button coButtonR2 = cp.getR2();
	Button coButtonL1 = cp.getL1();
	Button coButtonR1 = cp.getR1();
	public double speed;

	public OI() {
		//sets the robot to high shooting mode, turns on shooting motors and raises shooter
		//DialLeftTwo.whenPressed(new SetHighMode());

		//sets the robot to low shooting mode, turns on shooting motors and lowers shooter
		//DialLeftOne.whileHeld(new Low());
		//DialLeftOne.whenActive(new SetLowMode());

		//raises the tomahawks
		//TomahawkSwitch.whileHeld(new RaiseTomahawks());
		ButtonR2.toggleWhenPressed(new ToggleTomahawks());
		ButtonTriangle.toggleWhenPressed(new ToggleTomahawks());
		ButtonStart.toggleWhenPressed(new Brake());
		coButtonX.toggleWhenPressed(new SlowTurnDriving());
		coButtonR1.toggleWhenPressed(new RaiseShooter());
		//activates launcher to launch a boulder
		//ButtonA.whileHeld(new LaunchBoulder());

//		DrivingSwitch.whenReleased(new SetForward());
//		DrivingSwitch.whenPressed(new SetBackward());



		//activates side shooter to shoot a boulder
		//Exits the shooting mode
		//ButtonTriangle.toggleWhenPressed(new PIDTest());
		//ButtonTriangle.whenPressed(new StopPIDControl());
		//lowers the tomahawks
		//TomahawkSwitch.whenReleased(new LowerTomahawks());

		//starts pickup
		ButtonL2.whileHeld(new RunShooter(.5));
		ButtonR1.toggleWhenPressed(new RaiseShooter());
		ButtonL1.whileHeld(new RunShooter(.95));
		ButtonCircle.toggleWhenPressed(new StartPickup());
		ButtonR2.toggleWhenPressed(new ToggleTomahawks());
		ButtonStart.toggleWhenPressed(new Brake());
		ButtonX.whileHeld(new ShootBoulder());


		
	}

	public PS4Gamepad getGamepad() {
		return gp;

	}

}

