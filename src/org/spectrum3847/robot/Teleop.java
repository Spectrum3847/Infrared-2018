package org.spectrum3847.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Scheduler;


/**
 * The Driver Control period of the competition
 */
public class Teleop {
	
    public static void init() {
		//Robot.leftDrive.getTalon().changeControlMode(TalonControlMode.PercentVbus);
		//Robot.rightDrive.getTalon().changeControlMode(TalonControlMode.PercentVbus);
		
        Scheduler.getInstance().removeAll();
        Robot.compressor.start();
        Robot.compressor.setClosedLoopControl(true);
        
        //Do things if connected to FMS only, so when telop starts during a match but not during testing
        if (DriverStation.getInstance().isFMSAttached()){
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
