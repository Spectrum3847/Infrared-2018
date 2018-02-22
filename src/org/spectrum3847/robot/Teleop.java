package org.spectrum3847.robot;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.robot.commands.ArcTurn;
import org.spectrum3847.robot.commands.ArcadeDrive;
import org.spectrum3847.robot.commands.HeadlightsOn;
//import org.spectrum3847.robot.commands.GearArmDrive;
import org.spectrum3847.robot.commands.ManualClimb;
import org.spectrum3847.robot.commands.ManualIntake;
import org.spectrum3847.robot.commands.gear.FlapControl;
import org.spectrum3847.robot.commands.gear.GearArmPIDUp;
import org.spectrum3847.robot.commands.gear.ZeroGearArmCurrent;
import org.spectrum3847.robot.commands.leds.Purple;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Scheduler;


/**
 * The Driver Control period of the competition
 */
public class Teleop {
	
    public static void init() {
		Robot.leftDrive.getTalon().changeControlMode(TalonControlMode.PercentVbus);
		Robot.rightDrive.getTalon().changeControlMode(TalonControlMode.PercentVbus);
		
        Scheduler.getInstance().removeAll();
        Robot.compressor.start();
        Robot.compressor.setClosedLoopControl(true);
        Robot.headlights.headlightsOn();
	
        ArcadeDrive arcadeDrive = new ArcadeDrive();
        arcadeDrive.start();
        
        /*ManualClimb manualClimb = new ManualClimb();
        manualClimb.start();*/
        
        FlapControl flapControl = new FlapControl();
        flapControl.start();
        
        HeadlightsOn headlightsOn = new HeadlightsOn();
        headlightsOn.start();
        
        ManualIntake manualIntake = new ManualIntake();
        manualIntake.start();
        
        new Purple().start();
        
        if (DriverStation.getInstance().isFMSAttached()){
        	new ZeroGearArmCurrent().start();
        }
        
        //ManualGearIntake manualGearIntake = new ManualGearIntake();
        //manualGearIntake.start();
        
       //GearArmDrive gearDrive = new GearArmDrive();
       //gearDrive.start();
        
        //Robot.mecanumCollector.extend();
        
        //SpectrumSolenoid mecanum_sol = new SpectrumSolenoid(HW.MECANUM_RETRACT_SOL);
        //mecanum_sol.set(true);
        
        //Robot.logger.openFile();
    }

    public static void periodic() {
    	Dashboard.updateDashboard();
        Scheduler.getInstance().run();
        
    	
        //Tank Drive
        //Robot.drive.setOpenLoop(new DriveSignal(HW.Driver_Gamepad.getLeftY(), HW.Driver_Gamepad.getRightY()));
        
	//Robot.logger.logAll();
    }

    public static void cancel() {
    	System.out.println("Cancel");
        Scheduler.getInstance().removeAll();
    }
}
