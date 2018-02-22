package org.spectrum3847.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Disabled {

    static int t = 0;
    static boolean b = true;
    
    public static void init() {
        Scheduler.getInstance().removeAll();
    }

    //Periodic method called roughly once every 20ms
    public static void periodic() {
    	disabledFlash();
        Dashboard.updateDashboard();
        Autonomous.selectAuto();
        Timer.delay(0.001);
    }
    
    public static void disabledFlash(){
        //Flash a light on the dashboard while disabled, know that the dashboard is refreshing.
        if (t > 20) {
            t = 0;
            b = !b;
            SmartDashboard.putBoolean("Disabled Toggle", b);
        }
        t++;
    }
}
