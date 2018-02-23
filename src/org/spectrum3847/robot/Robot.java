/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.lib.util.SpectrumPreferences;
import org.spectrum3847.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.PigeonIMU;
import org.spectrum3847.lib.util.CrashTracker;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
    //Add Debug flags
	//You can have a flag for each subsystem, etc
	public static final String _controls = "CONTROL";
	public static final String _general = "GENERAL";
	public static final String _auton = "AUTON";
	public static final String _commands = "COMMAND";
	public static final String _drive = "DRIVE";
	public static final String _arm = "ARM";
	public static final String _extension = "EXTENSION";
	public static final String _hooks = "hooks";
	public static final String _intake = "INTAKE";
	
	
	public static Compressor compressor;
	
	public static SpectrumPreferences prefs;
	
	public static PigeonIMU pigeon;
	
	public static Drivetrain drive;
	
	public static TalonSRX armSRX;
	public static TalonSRX armBottomSRX;
	public static TalonSRX extensionSRX;
	public static TalonSRX extensionBottomSRX;
	public static TalonSRX intakeSRX;
	public static TalonSRX intakeBottomSRX;
	
	public static void setupSubsystems(){
    	prefs = SpectrumPreferences.getInstance();
    	
    	compressor = new Compressor(0);
    	
    	drive = new Drivetrain();
    	
    	boolean armInvert = false;
    	boolean armPhase = false;
    	armSRX = new TalonSRX(HW.ARM_TOP);
    	armSRX.configOpenloopRamp(0, HW.CANconfigTimeOut);
    	armSRX.configClosedloopRamp(0, HW.CANconfigTimeOut);
    	armSRX.setNeutralMode(NeutralMode.Brake);
    	armSRX.setInverted(armInvert);
    	armSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, HW.CANconfigTimeOut);
    	armSRX.setSensorPhase(armPhase);
    	armSRX.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled, HW.CANconfigTimeOut);
    	armSRX.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled, HW.CANconfigTimeOut);
    	armBottomSRX = new TalonSRX(HW.ARM_BOTTOM);
    	armBottomSRX.follow(armSRX);
    	armBottomSRX.setInverted(armInvert);
    	armBottomSRX.setNeutralMode(NeutralMode.Brake);
    	
    	armSRX.configNominalOutputForward(0, HW.CANconfigTimeOut);
    	armSRX.configNominalOutputReverse(0, HW.CANconfigTimeOut);
    	armSRX.configPeakOutputForward(prefs.getNumber("A: Peak Output Forward Percent", 0.8), HW.CANconfigTimeOut);
    	armSRX.configPeakOutputReverse(prefs.getNumber("A: Peak Output Forward Percent", -0.8), HW.CANconfigTimeOut);
    	armSRX.configVoltageCompSaturation(prefs.getNumber("A: Voltage Comp", 12), HW.CANconfigTimeOut);
    	armSRX.enableVoltageCompensation(true);
    	armSRX.configContinuousCurrentLimit((int)prefs.getNumber("A: Current Limit", 8.0), HW.CANconfigTimeOut);
    	armSRX.configPeakCurrentLimit((int)prefs.getNumber("A: Current Peak Limit", 10.0), HW.CANconfigTimeOut);
    	armSRX.configPeakCurrentDuration((int)prefs.getNumber("A: Current Peak Durration(ms)", 500), HW.CANconfigTimeOut);
    	armSRX.enableCurrentLimit(true);
    	
    	/** Arm Extension Config**/
    	boolean extensionInvert = false;
    	boolean extensionPhase = false;
    	extensionSRX = new TalonSRX(HW.EXTENSION_TOP);
    	extensionSRX.setNeutralMode(NeutralMode.Brake);
    	extensionSRX.setInverted(extensionInvert);
    	extensionSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, HW.CANconfigTimeOut);
    	extensionSRX.setSensorPhase(extensionPhase);
    	extensionSRX.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, HW.CANconfigTimeOut);
    	extensionSRX.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, HW.CANconfigTimeOut);

    	extensionBottomSRX = new TalonSRX(HW.EXTENSION_BOTTOM);
    	extensionBottomSRX.setNeutralMode(NeutralMode.Brake);
    	extensionBottomSRX.setInverted(extensionInvert);
    	extensionBottomSRX.follow(armSRX);
    	
    	extensionSRX.configNominalOutputForward(0, HW.CANconfigTimeOut);
    	extensionSRX.configNominalOutputReverse(0, HW.CANconfigTimeOut);
    	extensionSRX.configPeakOutputForward(prefs.getNumber("E: Peak Output Forward Percent", 0.8), HW.CANconfigTimeOut);
    	extensionSRX.configPeakOutputReverse(prefs.getNumber("E: Peak Output Forward Percent", -0.8), HW.CANconfigTimeOut);
    	extensionSRX.configVoltageCompSaturation(prefs.getNumber("E: Voltage Comp", 12), HW.CANconfigTimeOut);
    	extensionSRX.enableVoltageCompensation(true);
    	//Set extension Current limit to 8 amp if it's over 10 amps for more than half a second.
    	extensionSRX.configContinuousCurrentLimit((int)prefs.getNumber("E: Current Limit", 8.0), HW.CANconfigTimeOut);
    	extensionSRX.configPeakCurrentLimit((int)prefs.getNumber("E: Current Peak Limit", 10.0), HW.CANconfigTimeOut);
    	extensionSRX.configPeakCurrentDuration((int)prefs.getNumber("E: Current Peak Durration(ms)", 500), HW.CANconfigTimeOut);
    	extensionSRX.enableCurrentLimit(true);
    	
    	boolean intakeInvert = false;
    	intakeSRX = new TalonSRX(HW.INTAKE_TOP);
    	intakeSRX.setNeutralMode(NeutralMode.Brake);
    	intakeSRX.setInverted(intakeInvert);
    	intakeBottomSRX = new TalonSRX(HW.INTAKE_BOTTOM);
    	intakeBottomSRX.setNeutralMode(NeutralMode.Brake);
    	intakeBottomSRX.setInverted(!intakeInvert);
    	intakeBottomSRX.follow(intakeSRX);
    	intakeSRX.configNominalOutputForward(0, HW.CANconfigTimeOut);
    	intakeSRX.configNominalOutputReverse(0, HW.CANconfigTimeOut);
    	intakeSRX.configPeakOutputForward(1, HW.CANconfigTimeOut);
    	intakeSRX.configPeakOutputReverse(-1, HW.CANconfigTimeOut);
    	intakeSRX.configVoltageCompSaturation(12, HW.CANconfigTimeOut);
    	intakeSRX.enableVoltageCompensation(true);
    	
    	//Pigeon setup has to happen after SRXs are configured
    	pigeon = new PigeonIMU(intakeBottomSRX);
    }
	
	//Used to keep track of the robot current state easily
    public enum RobotState {
        DISABLED, AUTONOMOUS, TELEOP, TEST
    }

    public static RobotState s_robot_state = RobotState.DISABLED;

    public static RobotState getState() {
        return s_robot_state;
    }

    public static void setState(RobotState state) {
        s_robot_state = state;
    }
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
    	initDebugger();
    	CrashTracker.logRobotInit();
    	printInfo("Start robotInit()");
    	setupSubsystems(); //This has to be before the OI is created on the next line
		HW.oi = new OI();
        Dashboard.intializeDashboard();
	}

	//Add any code that needs to run in all states
	public void robotPeriodic() {
		Dashboard.updateDashboard();
	}
	
	 /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
        setState(RobotState.DISABLED);
        printInfo("Start disabledInit()");
        CrashTracker.logDisabledInit();
        Disabled.init();
        printInfo("End disableInit()");
    }
    /**
     * This function is called while in disabled mode.
     */    
    public void disabledPeriodic(){
    	Disabled.periodic();
    }


    public void autonomousInit() {
    	setState(RobotState.AUTONOMOUS);
    	printInfo("Start autonomousInit()");
    	CrashTracker.logAutoInit();
        Autonomous.init();
        printInfo("End autonomousInit()");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Autonomous.periodic();
    }

    public void teleopInit() {
    	setState(RobotState.TELEOP);
    	printInfo("Start teleopInit()");
    	CrashTracker.logTeleopInit();
        Teleop.init();
        printInfo("End teleopInit()");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Teleop.periodic();
    }
	
	public void testInit() {
		setState(RobotState.TEST);
		 Timer.delay(0.5);
		 
		 boolean results = true;
		 /** Examples of testing subsystems based on 254-2017 Code
	        results &= Feeder.getInstance().checkSystem();
	        results &= Drive.getInstance().checkSystem();
	        results &= Intake.getInstance().checkSystem();
	        results &= MotorGearGrabber.getInstance().checkSystem();
	        results &= Shooter.getInstance().checkSystem();
	        results &= Hopper.getInstance().checkSystem();
		  */
        if (!results) {
            System.out.println("CHECK ABOVE OUTPUT SOME SYSTEMS FAILED!!!");
        } else {
            System.out.println("ALL SYSTEMS PASSED");
        }
	        
	}
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
    private static void initDebugger(){
    	Debugger.setLevel(Debugger.verbose1); //Set the initial Debugger Level
    	Debugger.flagOn(_general); //Set all the flags on, comment out ones you want off
    	Debugger.flagOn(_controls);
    	Debugger.flagOn(_auton);
    	Debugger.flagOn(_commands);
    	Debugger.flagOn(_drive);
    	Debugger.flagOn(_intake);
    	Debugger.flagOn(_arm);
    	Debugger.flagOn(_extension);
    }
    
    public static void printDebug(String msg){
    	Debugger.println(msg, _general, Debugger.debug2);
    }
    
    public static void printInfo(String msg){
    	Debugger.println(msg, _general, Debugger.info3);
    }
    
    public static void printWarning(String msg) {
    	Debugger.println(msg, _general, Debugger.warning4);
    }
}
