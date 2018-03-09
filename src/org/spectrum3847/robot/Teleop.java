package org.spectrum3847.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Scheduler;


/**
 * The Driver Control period of the competition
 */
public class Teleop {
	
    public static void init() {
        Scheduler.getInstance().removeAll();
        Robot.compressor.start();
        Robot.compressor.setClosedLoopControl(true);
        
        //Do things if connected to FMS only, so when telop starts during a match but not during testing
        if (DriverStation.getInstance().isFMSAttached()){
        }
   
        
        //Robot.logger.openFile();
    }

    public static void periodic() {
        Scheduler.getInstance().run();
        //Robot.logger.logAll();
    }

    public static void cancel() {
    	System.out.println("Cancel");
        Scheduler.getInstance().removeAll();
    }
}
