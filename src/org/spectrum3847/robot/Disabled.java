package org.spectrum3847.robot;

import org.spectrum3847.robot.commands.AimingLightOn;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author matthew
 */
public class Disabled {

    static int t = 0;
    static boolean b = true;
    static boolean navxIsCalibrating = false;
    static Command aimingLight = new AimingLightOn();
    
    public static void init() {
    	Robot.aimingLight.turnOff(); //Turn the aming light off at the start
        Scheduler.getInstance().removeAll();
        //Init.sendCam.start();
        Robot.logger.close();
        //Robot.navX.reset();
        Robot.navX.zeroYaw();
        Robot.cams.intailizeCamera0();
    }

    //Periodic method called roughly once every 20ms
    public static void periodic() {
    	disabledFlash();
    	flashPurpleLEDS();

        if(SmartDashboard.getBoolean("Reset NavX", false)){
        	navxIsCalibrating = true;
        	Robot.navX.reset();
        
	        if(!Robot.navX.isCalibrating()){
	        	navxIsCalibrating = false;
	        	SmartDashboard.putBoolean("Reset NavX", false);
	        	Robot.navX.zeroYaw();
	        }
        }
        //Scheduler.getInstance().run();
        
        if (Robot.gearBackPack.getSoringSensor() || HW.Driver_Gamepad.getBackButton()){//DriverStation.getInstance().isFMSAttached()){
        	Robot.aimingLight.turnOn();
        } else{
        	Robot.aimingLight.turnOff();
        }
        

        SerialPort cam = new SerialPort(11520, SerialPort.Port.kUSB);

        try{
        	System.out.println(cam.readString());
        }catch(Exception e){
        	System.out.println("Error");
        }
        
        
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
    
    public static void flashPurpleLEDS(){
    	double time = Timer.getFPGATimestamp();
    	boolean blink = (time % (1 * 2)) < 1;
    	if (blink){
    		Robot.leds.purple();
    	} else{
    		Robot.leds.off();
    	}
    }
}
