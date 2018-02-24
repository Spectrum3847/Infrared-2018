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
    		SmartDashboard.putBoolean("Autonomous ENABLED", true);
    		
    	}
    }

    private static void updatePutShort() {
    	Robot.drive.dashboard();
    	Robot.arm.dashboard();
    	Robot.extension.dashboard();
    	Robot.intake.dashboard();
    }

    private static void updatePutLong(){
    	SmartDashboard.putBoolean("Compressor", Robot.compressor.enabled());
		SmartDashboard.putString("*Auto Command*", Autonomous.AutoName); // Displays which auto should run
		SmartDashboard.putBoolean("Auton on Right?", Autonomous.isRight);
		
		//Can change to show a different message than "Yes" and "No"
		SmartDashboard.putString("Change Battery", Util.changeBattery() ? "Yes" : "No");
    }

    public static void updateDashboard() {
    	dashboardFlash();
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
    
    static int t = 0;
    static boolean b = true;
    
    public static void dashboardFlash(){
        //Flash a light on the dashboard while disabled, know that the dashboard is refreshing.
        if (t > 20) {
            t = 0;
            b = !b;
            SmartDashboard.putBoolean("Disabled Toggle", b);
        }
        t++;
    }
}
