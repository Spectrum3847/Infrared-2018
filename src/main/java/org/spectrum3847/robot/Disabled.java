package org.spectrum3847.robot;

import org.spectrum3847.lib.drivers.GameState;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Disabled {
    
    public static void init() {
        Scheduler.getInstance().removeAll();
        Robot.intake.stop();
        Robot.puncher.stop();
    	Robot.arm.setOpenLoop(0.0); //Make sure the arm is stopped during disabled
    	Robot.drive.setNeutralMode(NeutralMode.Coast);
    }

    //Periodic method called roughly once every 20ms
    public static void periodic() {
        Dashboard.updateDashboard();
        Autonomous.selectAuto();
        Timer.delay(0.001);
        Robot.arm.setTargetToCurrentPosition();
        Robot.extension.setTargetToCurrentPosition();
		Robot.gameState = new GameState(DriverStation.getInstance().getGameSpecificMessage());
    }
}
