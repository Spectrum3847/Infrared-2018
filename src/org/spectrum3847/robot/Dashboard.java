package org.spectrum3847.robot;

import edu.wpi.first.wpilibj.Timer;

import org.spectrum3847.lib.util.Util;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @author matthew, JAG
 */
public class Dashboard {
	
	public static final boolean ENABLE_DASHBOARD = true;
	
	
	static final double SHORT_DELAY = .025;
    static final double LONG_DELAY = .5;
    
    static double shortOldTime = 0.0;
    static double longOldTime = 0.0;


    public static void intializeDashboard() {
    	if(ENABLE_DASHBOARD){
    		
    		SmartDashboard.putBoolean("Reset NavX", false);
    		
    		SmartDashboard.putBoolean("Autonomous ENABLED", true);
    		//SmartDashboard.putBoolean("Auto Score Gear Bool", true);
    		//SmartDashboard.putBoolean("Fire Balls", false);
    		
    		//SmartDashboard.putNumber("Drive Deadband", .15);
    		//SmartDashboard.putBoolean("Drive Squared Inputs", false);
    		//SmartDashboard.putString("Drive Equation", "x");
    		//SmartDashboard.putNumber("Drivetrain Voltage Ramp", 60);
    		
    		//SmartDashboard.putNumber("Belt Bed Speed", -1);
    		//SmartDashboard.putNumber("Shooter Tower PID Speed", 6000);
    		//SmartDashboard.putNumber("Shooter Wheel PID Speed", 8000);
    		
    		//SmartDashboard.putNumber("Shooter Wheel P", 2.000);
    		//SmartDashboard.putNumber("Shooter Wheel I", 0.000);
    		//SmartDashboard.putNumber("Shooter Wheel D", 0.750);
    		//SmartDashboard.putNumber("Shooter Wheel F", 3.000);
    		//SmartDashboard.putNumber("Shooter Tower P",  10.000);
    		//SmartDashboard.putNumber("Shooter Tower I",  0.000);
    		//SmartDashboard.putNumber("Shooter Tower D",  0.00);
    		//SmartDashboard.putNumber("Shooter Tower F",  3.600);
    		
    		//SmartDashboard.putNumber("Gear Arm Deadband", .1);
    		//SmartDashboard.putNumber("Gear Intake Speed", 1);
    		//SmartDashboard.putNumber("Gear Outtake Speed", .75);
    		//SmartDashboard.putNumber("Gear Arm Ramp Factor", .25);
    		//SmartDashboard.putNumber("Gear Arm Down Angle", .71);
    		//SmartDashboard.putNumber("Gear Arm Score Angle", 0.2);
    		//SmartDashboard.putNumber("Gear Arm ScoreDown Angle", .3);
    		//SmartDashboard.putNumber("Gear Arm Up Angle", .03);
    		//SmartDashboard.putNumber("Gear Intake Current Limit", 12);
  		
    		//SmartDashboard.putNumber("Gear Arm kP",  1.8);
    		//SmartDashboard.putNumber("Gear Arm kD", 16);
    		
    		//SmartDashboard.putNumber("TurnPID kP", 0.014);
    		//SmartDashboard.putNumber("TurnPID kD", 0.003);

    		/*SmartDashboard.putNumber("MoveFeet P", 1000);
    		SmartDashboard.putNumber("MoveFeet I", 0);
    		SmartDashboard.putNumber("MoveFeetD", 0);
    		SmartDashboard.putNumber("MoveFeet F", 1000);
    		SmartDashboard.putNumber("MoveFeet Setpoint", 11.5);
    		SmartDashboard.putNumber("MoveFeet Timeout", 5);
    		*/
    		
    		//SmartDashboard.putNumber("Current Gear Auto Reverse Time", 1);
    		//SmartDashboard.putNumber("Current Gear Auto Reverse Throttle", -.4);
    		//SmartDashboard.getNumber("Current Gear Auto Current Trigger", .1);
    		//SmartDashboard.getNumber("Current gear Auto Throttle", .5);
    		
    		//SmartDashboard.putNumber("Gear Cam USB ID", 2);
    		
    	}
    }

    private static void updatePutShort() {
    	//Robot.shooter.updateValuesToDashboard();
    	
    	//Drive Train
    	
    	//SmartDashboard.putNumber("Drive LeftY: ", HW.Driver_Gamepad.getY(Hand.kLeft));
    	//SmartDashboard.putNumber("Drive RightX: ", HW.Driver_Gamepad.getX(Hand.kRight));
    	//SmartDashboard.putNumber("Drive Trigger Left: ", HW.Driver_Gamepad.getTriggerAxis(Hand.kLeft));
    	//SmartDashboard.putNumber("Drive Trigger Right: ", HW.Driver_Gamepad.getTriggerAxis(Hand.kRight));
    	SmartDashboard.putNumber("Drive Left:", Robot.leftDrive.get());
    	SmartDashboard.putNumber("Drive Right:", Robot.rightDrive.get());
    	SmartDashboard.putNumber("Drive Position", Robot.leftDrive.getTalon().getPosition());
    	SmartDashboard.putNumber("Drive Vel", Robot.leftDrive.getTalon().getSpeed());
	    //if (Robot.left_drive_talon_1.getControlMode() == CANTalon.TalonControlMode.MotionMagic){
	    	//SmartDashboard.putNumber("Drive ActTrajPos", Robot.leftDrive.getTalon().getMotionMagicActTrajPosition());
	    	//SmartDashboard.putNumber("Drive ActTrajVel", Robot.leftDrive.getTalon().getMotionMagicActTrajVelocity());
	    //}
    	//SmartDashboard.putNumber("Drive Error", Robot.leftDrive.getTalon().getClosedLoopError());
    	//SmartDashboard.putNumber("Drive Get Setpoint", Robot.leftDrive.getTalon().getSetpoint());
    	//SmartDashboard.putNumber("Drive Left Applied Voltage", Robot.leftDrive.getTalon().getOutputVoltage());
    	//SmartDashboard.putNumber("Drive Left Get Current", Robot.leftDrive.getTalon().getOutputCurrent());
    	//SmartDashboard.putNumber("Drive Right Get Current", Robot.rightDrive.getTalon().getOutputCurrent());
    	
		SmartDashboard.putNumber("NavX Yaw:", Robot.navX.getYaw());
		SmartDashboard.putNumber("NavX Rate:", Robot.navX.getRate());
		
		SmartDashboard.putBoolean("NavX is Zero", Math.abs(Robot.navX.getYaw()) < 1);

		SmartDashboard.putNumber("Shooter Wheel Speed", Robot.shooterWheel.getSpeed());
		SmartDashboard.putNumber("Shooter Tower Speed", Robot.shooterTower.getSpeed());

		//shooterDashboard();
		//gearDashboard();
    	
		SmartDashboard.putBoolean("Backpack Score Sensor", Robot.gearBackPack.getSoringSensor());
		
		//SmartDashboard.putNumber("NavX Reading", Robot.navX.getYaw());


    }
    
    private static void shooterDashboard(){
    	//Shooter Wheel
    	
    	SmartDashboard.putNumber("Shooter Wheel Speed", Robot.shooterWheel.getSpeed());
    	SmartDashboard.putNumber("Shooter wheel Setpoint", Robot.shooterWheel.getTalon().getSetpoint());
        SmartDashboard.putNumber("Shooter Wheel Error", Robot.shooterWheel.getTalon().getError());
    	SmartDashboard.putBoolean("Shooter Wheel on Target", Robot.shooterWheel.onTarget());
    	SmartDashboard.putNumber("Shooter Wheel Applied Voltage", Robot.shooterWheel.getTalon().getOutputVoltage());
    	SmartDashboard.putNumber("Shooter Wheel Bus Voltage", Robot.shooterWheel.getTalon().getBusVoltage());
    	SmartDashboard.putNumber("Shooter Wheel  Current", Robot.shooterWheel.getTalon().getOutputCurrent());
    	
    	//Shooter Tower
        SmartDashboard.putNumber("Shooter Tower Speed", Robot.shooterTower.getSpeed());
    	SmartDashboard.putNumber("Shooter Tower  Current Setpoint", Robot.shooterTower.getTalon().getSetpoint());
    	SmartDashboard.putNumber("Shooter Tower  Error", Robot.shooterTower.getTalon().getError());
    	SmartDashboard.putBoolean("Shooter Tower  on Target", Robot.shooterTower.onTarget());
    	SmartDashboard.putNumber("Shooter Tower  Applied Voltage", Robot.shooterTower.getTalon().getOutputVoltage());
    	SmartDashboard.putNumber("Shooter Tower  Bus Voltage", Robot.shooterTower.getTalon().getBusVoltage());
    	SmartDashboard.putNumber("Shooter Tower  Current", Robot.shooterTower.getTalon().getOutputCurrent());
    	
    }
    
    private static void gearDashboard(){
    	//Gear Arm
    	SmartDashboard.putNumber("Gear Arm Encoder Value", Robot.gearIntake.getArmTalon().getPosition());
		SmartDashboard.putNumber("Gear Arm Motor Voltage", Robot.gearArmMotor.getTalon().getOutputVoltage());
		SmartDashboard.putNumber("Gear Setpoint", Robot.gearIntake.getArmTalon().getSetpoint());
		SmartDashboard.putNumber("Gear Error", Robot.gearIntake.getArmTalon().getError()/4096);
		SmartDashboard.putNumber("Gear Arm Current",  Robot.gearIntake.getArmTalon().getOutputCurrent());
		SmartDashboard.putNumber("Gear Intake Current",  Robot.gearIntake.getIntakeTalon().getOutputCurrent());
		
    }
    
    private static void updatePutLong(){
    	SmartDashboard.putBoolean("Compressor", Robot.compressor.enabled());
    	//SmartDashboard.putData(Robot.gearIntake);
		SmartDashboard.putString("*Auto Command*", Autonomous.AutoName); // Displays which auto should run
		SmartDashboard.putBoolean("Auton on Right?", Autonomous.isRight);
		
		//Can change to show a different message than "Yes" and "No"
		//Need to re-name class EdwardMessingAround
		SmartDashboard.putString("Change Battery", Util.changeBattery() ? "Yes" : "No");
    }

    
    public static void updateDashboard() {
    	if (ENABLE_DASHBOARD) {
            if ((Timer.getFPGATimestamp() - shortOldTime) > SHORT_DELAY) {
                shortOldTime = Timer.getFPGATimestamp();
                updatePutShort();
            }
            if ((Timer.getFPGATimestamp() - longOldTime) > LONG_DELAY) {
                //Thing that should be updated every LONG_DELAY
                longOldTime = Timer.getFPGATimestamp();
                updatePutLong();
            }
        }
    }
}
