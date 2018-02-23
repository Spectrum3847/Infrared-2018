/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.subsystems;

import org.spectrum3847.lib.drivers.SpectrumTalonSRX;
import org.spectrum3847.lib.drivers.LeaderTalonSRX;
import org.spectrum3847.lib.drivers.SpectrumSolenoid;
import org.spectrum3847.robot.HW;
import org.spectrum3847.robot.Robot;

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
public class Intake extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public SpectrumTalonSRX intakeBottomSRX = new SpectrumTalonSRX(HW.INTAKE_BOTTOM);
	public LeaderTalonSRX intakeSRX = new LeaderTalonSRX(HW.INTAKE_TOP, intakeBottomSRX);
	
	public SpectrumSolenoid intakeSol = new SpectrumSolenoid(HW.INTAKE_SOL);
	
	public Intake() {
		boolean intakeInvert = false;
    	intakeSRX.configOpenloopRamp(0);
    	intakeSRX.configClosedloopRamp(0);
    	intakeSRX.setNeutralMode(NeutralMode.Brake);
    	intakeSRX.setInverted(intakeInvert);
    	intakeSRX.configSelectedFeedbackSensor(FeedbackDevice.None, 0);
    	intakeSRX.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    	intakeSRX.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
    	intakeSRX.configNominalOutputForward(0);
    	intakeSRX.configNominalOutputReverse(0);
    	intakeSRX.configPeakOutputForward(Robot.prefs.getNumber("I: Peak Output Forward Percent", 1));
    	intakeSRX.configPeakOutputReverse(Robot.prefs.getNumber("I: Peak Output Forward Percent", -1));
    	intakeSRX.configVoltageCompSaturation(Robot.prefs.getNumber("I: Voltage Comp", 12));
    	intakeSRX.enableVoltageCompensation(true);
    	intakeSRX.configContinuousCurrentLimit((int)Robot.prefs.getNumber("I: Current Limit", 8.0));
    	intakeSRX.configPeakCurrentLimit((int)Robot.prefs.getNumber("I: Current Peak Limit", 15.0));
    	intakeSRX.configPeakCurrentDuration((int)Robot.prefs.getNumber("I: Current Peak Durration(ms)", 1000));
    	intakeSRX.enableCurrentLimit(true);
	}

	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand();
	}
	
	public void setOpenLoop(double value) {
		intakeSRX.set(ControlMode.PercentOutput, value);
	}
	
	//Add the dashboard values for this subsystem
	public void dashboard() {
		SmartDashboard.putNumber("Intake Output", intakeSRX.get());
		SmartDashboard.putNumber("Intake Current Total", intakeSRX.getOutputCurrent() + intakeBottomSRX.getOutputCurrent());
		
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
