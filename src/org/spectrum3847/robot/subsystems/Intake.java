/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.subsystems;

import org.spectrum3847.lib.drivers.SpectrumTalonSRX;
import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.lib.drivers.LeaderTalonSRX;
import org.spectrum3847.lib.drivers.SpectrumSolenoid;
import org.spectrum3847.robot.HW;
import org.spectrum3847.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteFeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Arm Subsystem
 */
public class Intake extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public SpectrumTalonSRX intakeBottomSRX = new SpectrumTalonSRX(HW.INTAKE_BOTTOM);
	public LeaderTalonSRX intakeSRX = new LeaderTalonSRX(HW.INTAKE_TOP, intakeBottomSRX);
	
	public SpectrumSolenoid intakeSol = new SpectrumSolenoid(HW.INTAKE_SOL);
	
	public static double thresholdStart;
	private static boolean intakeComplete;
	
	public Intake() {
		intakeSRX.setInverted(true);
		intakeBottomSRX.setInverted(false);
    	intakeSRX.configOpenloopRamp(0);
    	intakeSRX.configClosedloopRamp(0);
    	intakeSRX.setNeutralMode(NeutralMode.Brake);
    	intakeSRX.configSelectedFeedbackSensor(FeedbackDevice.None, 0);
    	intakeSRX.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    	intakeSRX.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    	intakeSRX.configNominalOutputForward(0);
    	intakeSRX.configNominalOutputReverse(0);
    	intakeSRX.configPeakOutputForward(Robot.prefs.getNumber("I: Peak Output Forward Percent", 1));
    	intakeSRX.configPeakOutputReverse(Robot.prefs.getNumber("I: Peak Output Reverse Percent", -1));
    	intakeSRX.configVoltageCompSaturation(Robot.prefs.getNumber("I: Voltage Comp", 12));
    	intakeSRX.enableVoltageCompensation(true);
    	intakeSRX.configContinuousCurrentLimit((int)Robot.prefs.getNumber("I: Current Limit", 8.0));
    	intakeSRX.configPeakCurrentLimit((int)Robot.prefs.getNumber("I: Current Peak Limit", 15.0));
    	intakeSRX.configPeakCurrentDuration((int)Robot.prefs.getNumber("I: Current Peak Durration(ms)", 1000));
    	intakeSRX.enableCurrentLimit(true);
    	
    	intakeBottomSRX.setFollowerFramePeriods();
	}

	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand();
	}
	
	public void setOpenLoop(double value) {
		intakeSRX.set(ControlMode.PercentOutput, value);
	}
	
	public void stop() {
		setOpenLoop(0);
	}
	
	//retracts(opens) the intake
	public void solOpen() {
		intakeSol.set(true);
	}
	
	//extend(closes) the intake
	public void solClose() {
		intakeSol.set(false);
	}
	
	//returns the current from one of the SRXs 
	public double getCurrent() {
		return (intakeSRX.getOutputCurrent() + this.intakeBottomSRX.getOutputCurrent());
	}
	
	//check if the current has been above threshold value for enough time
	public boolean isIntakeComplete(double currentThreshold, double thresholdTime) {
		
		if(getCurrent() > currentThreshold) {
			
			if(thresholdStart == 0) {
				thresholdStart = Timer.getFPGATimestamp();
				
			} else {
				if(Timer.getFPGATimestamp() - thresholdStart > thresholdTime) {
					intakeComplete = true;		
					this.printDebug("Intate with Current Complete");
				}
				
			}
		} else {
			thresholdStart = 0;
			intakeComplete = false;
		}
		
		return intakeComplete;
	}
	
	//Add the dashboard values for this subsystem
	public void dashboard() {
		SmartDashboard.putNumber("Intake Output", intakeSRX.get());
		SmartDashboard.putNumber("Intake Current Total", getCurrent());
		
	}
	
    public static void printDebug(String msg){
    	Debugger.println(msg, Robot._intake, Debugger.debug2);
    }
    
    public static void printInfo(String msg){
    	Debugger.println(msg, Robot._intake, Debugger.info3);
    }
    
    public static void printWarning(String msg) {
    	Debugger.println(msg, Robot._intake, Debugger.warning4);
    }
	
	/*Modify this method to return false if there is a problem with the subsystem
	  Based on 254-2017 Code
	*/
	public boolean checkSystem() {
		return true;
		/*
		//Example checkSystem from 254's 2017 Robot
		System.out.println("Testing INTAKE.--------------------------------------");
        final double currentThres = 0.5;
        
        intakeSRX.set(0.0);

        intakeSRX.set(ControlMode.PercentOutput,-6.0);
        Timer.delay(4.0);
        final double currentLeader = intakeSRX.getOutputCurrent();
        intakeSRX.set(0.0);

        Timer.delay(2.0);

        intakeBottomSRX.set(ControlMode.PercentOutput,6.0);
        Timer.delay(4.0);
        final double currentFollower = intakeBottomSRX.getOutputCurrent();
        intakeBottomSRX.set(0.0);

        System.out.println("Hopper Leader Current: " + currentLeader + " Slave current: " + currentFollower);

        boolean failure = false;

        if (currentLeader < currentThres) {
            failure = true;
            System.out.println("!!!!!!!!!!!!!!!!! Hopper Master Current Low !!!!!!!!!!!!!!!!!");
        }

        if (currentFollower < currentThres) {
            failure = true;
            System.out.println("!!!!!!!!!!!!!!!! Hooper Slave Current Low !!!!!!!!!!!!!!!!!!!");
        }

        if (!Util.allCloseTo(Arrays.asList(currentMaster, currentSlave), currentMaster, 5.0)) {
            failure = true;
            System.out.println("!!!!!!!!!!!!!!!! Hopper Currents Different !!!!!!!!!!!!!!!!!");
        }

        return !failure;
        */
	}
}
