/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.lib.util.SpectrumPreferences;
import org.spectrum3847.robot.commands.leds.LEDController;
import org.spectrum3847.robot.subsystems.Arm;
import org.spectrum3847.robot.subsystems.Drivetrain;
import org.spectrum3847.robot.subsystems.Extension;
import org.spectrum3847.robot.subsystems.Hook;
import org.spectrum3847.robot.subsystems.Intake;
import org.spectrum3847.robot.subsystems.LEDs;
import org.spectrum3847.robot.subsystems.Pneumatics;
import org.spectrum3847.robot.subsystems.Puncher;
import org.spectrum3847.lib.drivers.GameState;

import com.ctre.phoenix.sensors.PigeonIMU;
import org.spectrum3847.lib.util.CrashTracker;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
	
	public static GameState gameState = new GameState("RRR");
	
	public static Compressor compressor;
	
	public static SpectrumPreferences prefs;
	
	public static PigeonIMU pigeon;
	
	public static Drivetrain drive;
	public static Arm arm;
	public static Extension extension;
	public static Intake intake;
	public static Puncher puncher;
	public static Hook hook;
	public static Pneumatics pneumatics;
	
	public static LEDs leds;
	
	public static void setupSubsystems(){
    	prefs = SpectrumPreferences.getInstance();
    	
    	compressor = new Compressor(0);
    	

    	intake = new Intake();
    	
    	//Intake must be declared before Drivetrain cause Pigeon is plugged into Intake
    	drive = new Drivetrain();
    	
    	arm = new Arm();
    	extension = new Extension();
    	puncher = new Puncher();
    	hook = new Hook();
    	
    	//leds = new LEDs();
    	
    	//Pigeon setup has to happen after SRXs are configured
    	pigeon = new PigeonIMU(intake.intakeBottomSRX);
    	
    	pneumatics = new Pneumatics();
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
		setPeriod(.02);
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
		 results &= drive.checkSystem();
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
    	Debugger.setLevel(Debugger.debug2); //Set the initial Debugger Level
    	Debugger.flagOff(_general); //Set all the flags on, comment out ones you want off
    	Debugger.flagOff(_controls);
    	Debugger.flagOn(_auton);
    	Debugger.flagOff(_commands);
    	Debugger.flagOn(_drive);
    	Debugger.flagOff(_intake);
    	Debugger.flagOn(_arm);
    	Debugger.flagOff(_extension);
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
