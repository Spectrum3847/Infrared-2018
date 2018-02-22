/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.lib.util.SpectrumPreferences;

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

	public static void setupSubsystems(){
    	prefs = SpectrumPreferences.getInstance();
    	
    	compressor = new Compressor(0);
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
