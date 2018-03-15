package org.spectrum3847.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The Driver Control period of the competition
 */
public class Teleop {
	
    public static void init() {
        Scheduler.getInstance().removeAll();
        Robot.compressor.start();
        Robot.compressor.setClosedLoopControl(true);
        Robot.arm.setTargetToCurrentPosition();
        Robot.extension.setTargetToCurrentPosition();
        
        //Do things if connected to FMS only, so when telop starts during a match but not during testing
        if (DriverStation.getInstance().isFMSAttached()){
        }
   
        
        //Robot.logger.openFile();
    }

    public static void periodic() {
        Scheduler.getInstance().run();
		if (SmartDashboard.getBoolean("Compressor ENABLE", true)) {
			Robot.compressor.start();
		} else {
			Robot.compressor.stop();
		}
        //Robot.logger.logAll();
    }

    public static void cancel() {
    	System.out.println("Cancel");
        Scheduler.getInstance().removeAll();
    }
}
