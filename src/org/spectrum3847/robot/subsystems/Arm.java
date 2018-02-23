/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.subsystems;

import org.spectrum3847.lib.drivers.SpectrumTalonSRX;
import org.spectrum3847.lib.drivers.LeaderTalonSRX;
import org.spectrum3847.robot.HW;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.arm.ManualArmControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Arm Subsystem
 */
public class Arm extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public SpectrumTalonSRX armBottomSRX = new SpectrumTalonSRX(HW.ARM_BOTTOM);
	public LeaderTalonSRX armSRX = new LeaderTalonSRX(HW.ARM_TOP, armBottomSRX);
	
	public Arm() {
		boolean armInvert = false;
    	boolean armPhase = false;
    	armSRX.configOpenloopRamp(0);
    	armSRX.configClosedloopRamp(0);
    	armSRX.setNeutralMode(NeutralMode.Brake);
    	armSRX.setInverted(armInvert);
    	armSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0);
    	armSRX.setSensorPhase(armPhase);
    	armSRX.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    	armSRX.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    	armSRX.configNominalOutputForward(0);
    	armSRX.configNominalOutputReverse(0);
    	armSRX.configPeakOutputForward(Robot.prefs.getNumber("E: Peak Output Forward Percent", 0.8));
    	armSRX.configPeakOutputReverse(Robot.prefs.getNumber("E: Peak Output Forward Percent", -0.8));
    	armSRX.configVoltageCompSaturation(Robot.prefs.getNumber("E: Voltage Comp", 12));
    	armSRX.enableVoltageCompensation(true);
    	armSRX.configContinuousCurrentLimit((int)Robot.prefs.getNumber("E: Current Limit", 8.0));
    	armSRX.configPeakCurrentLimit((int)Robot.prefs.getNumber("E: Current Peak Limit", 10.0));
    	armSRX.configPeakCurrentDuration((int)Robot.prefs.getNumber("E: Current Peak Durration(ms)", 500));
    	armSRX.enableCurrentLimit(true);
	}

	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ManualArmControl());
	}
	
	public void setOpenLoop(double value) {
		armSRX.set(ControlMode.PercentOutput, value);
	}
	
	//Add the dashboard values for this subsystem
	public void dashboard() {
		SmartDashboard.putNumber("Arm Position", armSRX.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Arm Output", armSRX.get());
		SmartDashboard.putNumber("Arm Current Total", armSRX.getOutputCurrent() + armBottomSRX.getOutputCurrent());
		
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
