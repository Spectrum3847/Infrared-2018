/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.subsystems;

import org.spectrum3847.lib.drivers.SpectrumTalonSRX;
import org.spectrum3847.lib.drivers.LeaderTalonSRX;
import org.spectrum3847.lib.drivers.SRXGains;
import org.spectrum3847.robot.HW;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.arm.ExtensionManualControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Extension Subsystem
 */
public class Extension extends Subsystem {

	public final static int EXTENSION_UP = 0;
	public final static int EXTENSION_DOWN = 1;
	
	public final static int upPositionLimit = 50000;// needs to be determined manually
	public final static int downPositionLimit = 0;
	
	private int accel = 0;
	private int cruiseVel = 0;
	
	public SpectrumTalonSRX extensionBottomSRX = new SpectrumTalonSRX(HW.EXTENSION_BOTTOM);
	public LeaderTalonSRX extensionSRX = new LeaderTalonSRX(HW.EXTENSION_TOP, extensionBottomSRX);
	
	private SRXGains upGains = new SRXGains(EXTENSION_UP, 0.560, 0.0, 5.600, 0.620, 100);
	private SRXGains downGains = new SRXGains(EXTENSION_DOWN, 0.0, 0.0, 0.0, 0.427, 0);
	private boolean zeroWhenDownLimit = true;
	
	private int targetPosition = 0;
	
	public Extension() {
		super("Extension");
		boolean extensionInvert = true;
    	boolean extensionPhase = true;
    	extensionSRX.configOpenloopRamp(0);
    	extensionSRX.configClosedloopRamp(0);
    	extensionSRX.setNeutralMode(NeutralMode.Brake);
    	extensionSRX.setInverted(extensionInvert);
    	extensionSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0);
    	extensionSRX.setSensorPhase(extensionPhase);
    	extensionSRX.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    	extensionSRX.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    	extensionSRX.configNominalOutputForward(0);
    	extensionSRX.configNominalOutputReverse(0);
    	extensionSRX.configPeakOutputForward(Robot.prefs.getNumber("E: Peak Output Forward Percent", 0.8));
    	extensionSRX.configPeakOutputReverse(Robot.prefs.getNumber("E: Peak Output Reverse Percent", -0.8));
    	extensionSRX.configVoltageCompSaturation(Robot.prefs.getNumber("E: Voltage Comp", 12));
    	extensionSRX.enableVoltageCompensation(true);
    	extensionSRX.configContinuousCurrentLimit((int)Robot.prefs.getNumber("E: Current Limit", 8.0));
    	extensionSRX.configPeakCurrentLimit((int)Robot.prefs.getNumber("E: Current Peak Limit", 10.0));
    	extensionSRX.configPeakCurrentDuration((int)Robot.prefs.getNumber("E: Current Peak Durration(ms)", 500));
    	extensionSRX.enableCurrentLimit(true);
    	extensionSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10);
    	extensionSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10);
    	
    	extensionSRX.configForwardSoftLimitEnable(true);
    	extensionSRX.configForwardSoftLimitThreshold(upPositionLimit);
    	
    	extensionSRX.configReverseSoftLimitEnable(false);
    	extensionSRX.configReverseSoftLimitThreshold(downPositionLimit);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ExtensionManualControl());
	}
	
	public void periodic() {
		//If we want to zero when down and we are at the limit switch and greater than zero, then set us to zero
		if (zeroWhenDownLimit && this.getRevLimitSW() && extensionSRX.getSelectedSensorPosition(0) != 0) {
			extensionSRX.setSelectedSensorPosition(0, 0);
		}
		getPrefsGains();
		extensionSRX.setGains(upGains);
		extensionSRX.setGains(downGains);
	}
	
	public void getPrefsGains() {
		upGains.setGains(EXTENSION_UP,
		Robot.prefs.getNumber("E: up P", 0.0),
		Robot.prefs.getNumber("E: up I", 0.0),
		Robot.prefs.getNumber("E: up D", 0.0),
		Robot.prefs.getNumber("E: up F", 0.0),
		0);
		
		downGains.setGains(EXTENSION_DOWN,
		Robot.prefs.getNumber("E: down P", 0.0),
		Robot.prefs.getNumber("E: down I", 0.0),
		Robot.prefs.getNumber("E: down D", 0.0),
		Robot.prefs.getNumber("E: down F", 0.0),
		0);
	}
	
	public void setZeroWhenDownLimit(boolean val) {
		zeroWhenDownLimit = val;
	}
	
	public void setOpenLoop(double value) {
		extensionSRX.set(ControlMode.PercentOutput, value);
	}
	
	public void set(ControlMode controlMode, double signal) {
    	if(controlMode == ControlMode.MotionMagic) {
    		this.manageGainProfile(signal);
    	}
    	extensionSRX.set(controlMode, signal);
    }
	
	public boolean getFwdLimitSW() {
		return extensionSRX.getSensorCollection().isFwdLimitSwitchClosed();
	}
	
	public boolean getRevLimitSW() {
		return extensionSRX.getSensorCollection().isRevLimitSwitchClosed();
	}
	
	public int getCurrentPosition() {
    	return extensionSRX.getSelectedSensorPosition(0);
    }
	
	public int getTargetPosition() {
		return targetPosition;
	}
	
	public int getSRXTarget() {
		return extensionSRX.getClosedLoopTarget(0);
	}
	
    public void setTargetPosition(int position) {
    	targetPosition = position;
    }
	
	public int getError() {
		return extensionSRX.getClosedLoopError(0);
	}
	
	public double getOutput() {
		return extensionSRX.get();
	}
	
	public void manageGainProfile(double targetPosition) {
		double currentPosition = getCurrentPosition();
		if (currentPosition < targetPosition) {
				extensionSRX.selectProfileSlot(EXTENSION_UP, 0);
		} else {
			extensionSRX.selectProfileSlot(EXTENSION_DOWN, 0);
		}
	} 
	
	public void setMotionMagicValues(int acceleration, int cruiseVelocity) {
		if (accel != acceleration && cruiseVel != cruiseVelocity) {
			accel = acceleration;
			cruiseVel = cruiseVelocity;
			extensionSRX.configMotionAcceleration(accel);
			extensionSRX.configMotionCruiseVelocity(cruiseVel);
		}
	}
	
	 public void motionMagicControl() {
	    	manageGainProfile(targetPosition);
	    	extensionSRX.set(ControlMode.MotionMagic, targetPosition);
	 }
	
	//Add the dashboard values for this subsystem
	public void dashboard() {
		SmartDashboard.putNumber("Extension Position", getCurrentPosition());
		SmartDashboard.putNumber("Extension Output", getOutput());
		SmartDashboard.putNumber("Extension Target", getTargetPosition());
		SmartDashboard.putNumber("Extension Error", getError());
		SmartDashboard.putNumber("Extension Current Total", extensionSRX.getOutputCurrent() + extensionBottomSRX.getOutputCurrent());	
	}
	
	
	/*Modify this method to return false if there is a problem with the subsystem
	  Based on 254-2017 Code
	*/
	public boolean checkSystem() {
		return true;
		
		/** Example checkSystem from 254's 2017 Robot
		 System.out.println("Testing HOPPER.--------------------------------------");
        final double kCurrentThres = 0.5;

        mMasterTalon.changeControlMode(CANTalon.TalonControlMode.Voltage);
        mSlaveTalon.changeControlMode(CANTalon.TalonControlMode.Voltage);

        mMasterTalon.set(0.0);
        mSlaveTalon.set(0.0);

        mMasterTalon.set(-6.0f);
        Timer.delay(4.0);
        final double currentMaster = mMasterTalon.getOutputCurrent();
        mMasterTalon.set(0.0);

        Timer.delay(2.0);

        mSlaveTalon.set(6.0f);
        Timer.delay(4.0);
        final double currentSlave = mSlaveTalon.getOutputCurrent();
        mSlaveTalon.set(0.0);

        mMasterTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        mSlaveTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

        System.out.println("Hopper Master Current: " + currentMaster + " Slave current: " + currentSlave);

        boolean failure = false;

        if (currentMaster < kCurrentThres) {
            failure = true;
            System.out.println("!!!!!!!!!!!!!!!!! Hopper Master Current Low !!!!!!!!!!!!!!!!!");
        }

        if (currentSlave < kCurrentThres) {
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
