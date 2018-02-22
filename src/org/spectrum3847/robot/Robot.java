/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.lib.util.SpectrumPreferences;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;


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
	public static final String controls = "CONTROL";
	public static final String general = "GENERAL";
	public static final String auton = "AUTON";
	public static final String commands = "COMMAND";
	public static final String drive = "DRIVE";
	public static final String arm = "ARM";
	public static final String extension = "EXTENSION";
	public static final String hooks = "hooks";
	public static final String intake = "INTAKE";
	
	
	public static Compressor compressor;
	
	public static SpectrumPreferences prefs;
	
	public static PigeonIMU pigeon;
	
	public static TalonSRX leftSRX;
	public static VictorSPX leftMiddleSPX;
	public static VictorSPX leftBottomSPX;
	public static TalonSRX rightSRX;
	public static VictorSPX rightMiddleSPX;
	public static VictorSPX rightBottomSPX;
	
	public static TalonSRX armSRX;
	public static TalonSRX armBottomSRX;
	public static TalonSRX extensionSRX;
	public static TalonSRX extensionBottomSRX;
	public static TalonSRX intakeSRX;
	public static TalonSRX intakeBottomSRX;
	
	public static void setupSubsystems(){
    	prefs = SpectrumPreferences.getInstance();
    	
    	compressor = new Compressor(0);
    	
    	int driveDefaultRampRate = 30;
    	leftSRX = new TalonSRX(HW.LEFT_DRIVE_SRX_BACK);
    	leftSRX.setNeutralMode(NeutralMode.Brake);
    	leftSRX.configOpenloopRamp(prefs.getNumber("D: Ramp Rate", driveDefaultRampRate), HW.CANconfigTimeOut);
    	leftSRX.configClosedloopRamp(0, HW.CANconfigTimeOut);
    	leftSRX.configNominalOutputForward(0, HW.CANconfigTimeOut);
    	leftSRX.configNominalOutputReverse(0, HW.CANconfigTimeOut);
    	leftSRX.configPeakOutputForward(1, HW.CANconfigTimeOut);
    	leftSRX.configPeakOutputReverse(-1, HW.CANconfigTimeOut);
    	leftSRX.configVoltageCompSaturation(12, HW.CANconfigTimeOut);
    	leftSRX.enableVoltageCompensation(true);
    	leftSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, HW.CANconfigTimeOut);
    	leftMiddleSPX = new VictorSPX(HW.LEFT_DRIVE_MIDDLE);
    	leftMiddleSPX.setNeutralMode(NeutralMode.Brake);
    	leftMiddleSPX.follow(leftSRX);
    	leftBottomSPX = new VictorSPX(HW.LEFT_DRIVE_FRONT_BOTTOM);
    	leftBottomSPX.setNeutralMode(NeutralMode.Brake);
    	leftBottomSPX.follow(leftSRX);
    	
    	rightSRX = new TalonSRX(HW.RIGHT_DRIVE_SRX_BACK);
    	rightSRX.setNeutralMode(NeutralMode.Brake);
    	rightSRX.configOpenloopRamp(prefs.getNumber("D: Ramp Rate", driveDefaultRampRate), HW.CANconfigTimeOut);
    	rightSRX.configClosedloopRamp(0, HW.CANconfigTimeOut);
    	rightSRX.configNominalOutputForward(0, HW.CANconfigTimeOut);
    	rightSRX.configNominalOutputReverse(0, HW.CANconfigTimeOut);
    	rightSRX.configPeakOutputForward(1, HW.CANconfigTimeOut);
    	rightSRX.configPeakOutputReverse(-1, HW.CANconfigTimeOut);
    	rightSRX.configVoltageCompSaturation(12, HW.CANconfigTimeOut);
    	rightSRX.enableVoltageCompensation(true);
    	rightSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, HW.CANconfigTimeOut);
    	rightMiddleSPX = new VictorSPX(HW.RIGHT_DRIVE_MIDDLE);
    	rightMiddleSPX.setNeutralMode(NeutralMode.Brake);
    	rightMiddleSPX.follow(rightSRX);
    	rightBottomSPX = new VictorSPX(HW.RIGHT_DRIVE_FRONT_BOTTOM);
    	rightBottomSPX.setNeutralMode(NeutralMode.Brake);
    	rightBottomSPX.follow(rightSRX);
    	
    	armSRX = new TalonSRX(HW.ARM_TOP);
    	armSRX.configOpenloopRamp(0, HW.CANconfigTimeOut);
    	armSRX.configClosedloopRamp(0, HW.CANconfigTimeOut);
    	armSRX.setNeutralMode(NeutralMode.Brake);
    	armSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, HW.CANconfigTimeOut);
    	armBottomSRX = new TalonSRX(HW.ARM_BOTTOM);
    	armBottomSRX.follow(armSRX);
    	armBottomSRX.setNeutralMode(NeutralMode.Brake);
    	
    	armSRX.configNominalOutputForward(0, HW.CANconfigTimeOut);
    	armSRX.configNominalOutputReverse(0, HW.CANconfigTimeOut);
    	armSRX.configPeakOutputForward(prefs.getNumber("A: Peak Output Forward Percent", 0.8), HW.CANconfigTimeOut);
    	armSRX.configPeakOutputReverse(prefs.getNumber("A: Peak Output Forward Percent", -0.8), HW.CANconfigTimeOut);
    	armSRX.configVoltageCompSaturation(prefs.getNumber("A: Voltage Comp", 12), HW.CANconfigTimeOut);
    	armSRX.enableVoltageCompensation(true);
    	//Set Arm Current limit to 8 amp if it's over 10 amps for more than half a second.
    	armSRX.configContinuousCurrentLimit((int)prefs.getNumber("A: Current Limit", 8.0), HW.CANconfigTimeOut);
    	armSRX.configPeakCurrentLimit((int)prefs.getNumber("A: Current Peak Limit", 10.0), HW.CANconfigTimeOut);
    	armSRX.configPeakCurrentDuration((int)prefs.getNumber("A: Current Peak Durration(ms)", 500), HW.CANconfigTimeOut);
    	
    	/** Arm Extension Config**/
    	extensionSRX = new TalonSRX(HW.EXTENSION_TOP);
    	extensionSRX.setNeutralMode(NeutralMode.Brake);
    	extensionBottomSRX = new TalonSRX(HW.EXTENSION_BOTTOM);
    	extensionBottomSRX.setNeutralMode(NeutralMode.Brake);
    	extensionSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, HW.CANconfigTimeOut);
    	
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
    	
    	intakeSRX = new TalonSRX(HW.INTAKE_TOP);
    	intakeSRX.setNeutralMode(NeutralMode.Brake);
    	intakeBottomSRX = new TalonSRX(HW.INTAKE_BOTTOM);
    	intakeBottomSRX.setNeutralMode(NeutralMode.Brake);
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
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
    	initDebugger();
    	printInfo("Start robotInit()");
    	setupSubsystems(); //This has to be before the OI is created on the next line
		HW.oi = new OI();
        Dashboard.intializeDashboard();
        TalonSRX m_Wheel = new TalonSRX(15);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
    private static void initDebugger(){
    	Debugger.setLevel(Debugger.verbose1); //Set the initial Debugger Level
    	Debugger.flagOn(general); //Set all the flags on, comment out ones you want off
    	Debugger.flagOn(controls);
    	Debugger.flagOn(auton);
    	Debugger.flagOn(commands);
    	Debugger.flagOn(drive);
    	Debugger.flagOn(intake);
    	Debugger.flagOn(arm);
    	Debugger.flagOn(extension);
    }
    
    public static void printDebug(String msg){
    	Debugger.println(msg, general, Debugger.debug2);
    }
    
    public static void printInfo(String msg){
    	Debugger.println(msg, general, Debugger.info3);
    }
    
    public static void printWarning(String msg) {
    	Debugger.println(msg, general, Debugger.warning4);
    }
}
