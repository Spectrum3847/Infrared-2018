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
import org.spectrum3847.robot.commands.arm.ManualExtensionControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
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
	
	public SpectrumTalonSRX extensionBottomSRX = new SpectrumTalonSRX(HW.EXTENSION_BOTTOM);
	public LeaderTalonSRX extensionSRX = new LeaderTalonSRX(HW.EXTENSION_TOP, extensionBottomSRX);
	
	private final SRXGains UpGains = new SRXGains(EXTENSION_UP, 0.560, 0.0, 5.600, 0.620, 100);
	private final SRXGains DownGains = new SRXGains(EXTENSION_DOWN, 0.0, 0.0, 0.0, 0.427, 0);
	private boolean zeroWhenDownLimit = true;
	
	public Extension() {
		super("Extension");
		boolean extensionInvert = false;
    	boolean extensionPhase = false;
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
    	extensionSRX.configPeakOutputReverse(Robot.prefs.getNumber("E: Peak Output Forward Percent", -0.8));
    	extensionSRX.configVoltageCompSaturation(Robot.prefs.getNumber("E: Voltage Comp", 12));
    	extensionSRX.enableVoltageCompensation(true);
    	extensionSRX.configContinuousCurrentLimit((int)Robot.prefs.getNumber("E: Current Limit", 8.0));
    	extensionSRX.configPeakCurrentLimit((int)Robot.prefs.getNumber("E: Current Peak Limit", 10.0));
    	extensionSRX.configPeakCurrentDuration((int)Robot.prefs.getNumber("E: Current Peak Durration(ms)", 500));
    	extensionSRX.enableCurrentLimit(true);
    	
    	extensionSRX.configForwardSoftLimitEnable(true);
    	extensionSRX.configForwardSoftLimitThreshold(upPositionLimit);
    	
    	extensionSRX.configReverseSoftLimitEnable(true);
    	extensionSRX.configReverseSoftLimitThreshold(downPositionLimit);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ManualExtensionControl());
	}
	public void periodic() {
		//If we want to zero when down and we are at the limit switch and greater than zero, then set us to zero
		if (zeroWhenDownLimit && this.getRevLimitSW() && extensionSRX.getSelectedSensorPosition(0) >= 0) {
			extensionSRX.setSelectedSensorPosition(0, 0);
		}
	}
	
	public void setZeroWhenDownLimit(boolean val) {
		zeroWhenDownLimit = val;
	}
	
	public void setOpenLoop(double value) {
		extensionSRX.set(ControlMode.PercentOutput, value);
	}
	
	public boolean getFwdLimitSW() {
		return extensionSRX.getSensorCollection().isFwdLimitSwitchClosed();
	}
	
	public boolean getRevLimitSW() {
		return extensionSRX.getSensorCollection().isRevLimitSwitchClosed();
	}
	
	//Add the dashboard values for this subsystem
	public void dashboard() {
		SmartDashboard.putNumber("Extension Position", extensionSRX.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Extension Output", extensionSRX.get());
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
