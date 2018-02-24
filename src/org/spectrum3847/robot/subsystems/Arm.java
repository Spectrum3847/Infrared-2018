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
import org.spectrum3847.robot.commands.arm.ArmManualControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Arm Subsystem
 */
public class Arm extends Subsystem {
	
	public final static int ARM_UP = 0;
	public final static int ARM_DOWN = 1;
	
	public final static int fwdPositionLimit = 50000;// needs to be determined manually
	public final static int revPositionLimit = 0;
	
	public SpectrumTalonSRX armBottomSRX = new SpectrumTalonSRX(HW.ARM_BOTTOM);
	public LeaderTalonSRX armSRX = new LeaderTalonSRX(HW.ARM_TOP, armBottomSRX);
	
	private int accel = 0;
	private int cruiseVel = 0;
	
	private final SRXGains upGains = new SRXGains(ARM_UP, 0.560, 0.0, 5.600, 0.620, 100);
	private final SRXGains downGains = new SRXGains(ARM_DOWN, 0.0, 0.0, 0.0, 0.427, 0);
	
	private int targetPosition = 0;
	
	public Arm() {
		super("Arm");
		boolean armInvert = false;
    	boolean armPhase = true;
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
    	armSRX.configPeakOutputReverse(Robot.prefs.getNumber("E: Peak Output Reverse Percent", -0.8));
    	armSRX.configVoltageCompSaturation(Robot.prefs.getNumber("E: Voltage Comp", 12));
    	armSRX.enableVoltageCompensation(true);
    	armSRX.configContinuousCurrentLimit((int)Robot.prefs.getNumber("E: Current Limit", 8.0));
    	armSRX.configPeakCurrentLimit((int)Robot.prefs.getNumber("E: Current Peak Limit", 10.0));
    	armSRX.configPeakCurrentDuration((int)Robot.prefs.getNumber("E: Current Peak Durration(ms)", 500));
    	armSRX.enableCurrentLimit(true);
    	armSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10);
    	armSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10);
    		
    	armSRX.configForwardSoftLimitEnable(false);
    	armSRX.configForwardSoftLimitThreshold(fwdPositionLimit);
    	
    	armSRX.configReverseSoftLimitEnable(false);
    	armSRX.configReverseSoftLimitThreshold(revPositionLimit);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ArmManualControl());
	}
	
	public void periodic() {
		setMotionMagicValues((int)Robot.prefs.getNumber("A: MM Accel", 5000), (int)Robot.prefs.getNumber("A: MM CruiseVel", 2000));
		getPrefsGains();
		armSRX.setGains(upGains);
		armSRX.setGains(downGains);
	}
	
	public void getPrefsGains() {
		upGains.setGains(ARM_UP,
		Robot.prefs.getNumber("A: up P", 0.0),
		Robot.prefs.getNumber("A: up I", 0.0),
		Robot.prefs.getNumber("A: up D", 0.0),
		Robot.prefs.getNumber("A: up F", 0.0),
		0);
		
		downGains.setGains(ARM_DOWN,
		Robot.prefs.getNumber("A: down P", 0.0),
		Robot.prefs.getNumber("A: down I", 0.0),
		Robot.prefs.getNumber("A: down D", 0.0),
		Robot.prefs.getNumber("A: down F", 0.0),
		0);
	}
	
	public void setPositionToZero() {
		armSRX.setSelectedSensorPosition(0, 0);
	}
	
	public void setPositionToFullFwd() {
    	armSRX.setSelectedSensorPosition(fwdPositionLimit, 0);
	}

	
	public void setPostionToCenter() {
		armSRX.setSelectedSensorPosition(fwdPositionLimit/2, 0);
	}
	
	
	public void setOpenLoop(double value) {
		armSRX.set(ControlMode.PercentOutput, value);
	}
	
	public void set(ControlMode controlMode, double signal) {
    	if(controlMode == ControlMode.MotionMagic) {
    		this.manageGainProfile(signal);
    	}
    	armSRX.set(controlMode, signal);
    }
	
	public boolean getFwdLimitSW() {
		return armSRX.getSensorCollection().isFwdLimitSwitchClosed();
	}
	
	public boolean getRevLimitSW() {
		return armSRX.getSensorCollection().isRevLimitSwitchClosed();
	}
	
	public int getCurrentPosition() {
    	return armSRX.getSelectedSensorPosition(0);
    }
	
	public double getOutput() {
		return armSRX.get();
	}
	
	public int getTargetPosition() {
		return targetPosition;
	}
	
	public int getSRXTarget() {
		return armSRX.getClosedLoopTarget(0);
	}
	
    public void setTargetPosition(int position) {
    	targetPosition = position;
    }
	
	public int getError() {
		return armSRX.getClosedLoopError(0);
	}
	
	public void motionMagicControl() {
    	manageGainProfile(targetPosition);
    	armSRX.set(ControlMode.MotionMagic, targetPosition);
    }
	
	public void setMotionMagicValues(int acceleration, int cruiseVelocity) {
		if (accel != acceleration && cruiseVel != cruiseVelocity) {
			accel = acceleration;
			cruiseVel = cruiseVelocity;
			armSRX.configMotionAcceleration(accel);
			armSRX.configMotionCruiseVelocity(cruiseVel);
		}
	}
	
	public void manageGainProfile(double targetPosition) {
		double currentPosition = getCurrentPosition();
		//Check if the arm is behind us or in front of us and figure out which way is up and down
		if (currentPosition < fwdPositionLimit/2) {
			if (currentPosition < targetPosition) {
				armSRX.selectProfileSlot(ARM_UP, 0);
			} else {
				armSRX.selectProfileSlot(ARM_DOWN, 0);
			}
		} else {
			if (currentPosition < targetPosition) {
				armSRX.selectProfileSlot(ARM_DOWN, 0);
			} else {
				armSRX.selectProfileSlot(ARM_UP, 0);
			}	
		}
	} 

	
	//Add the dashboard values for this subsystem
	public void dashboard() {
		SmartDashboard.putNumber("Arm Position", getCurrentPosition());
		SmartDashboard.putNumber("Arm Output", getOutput());
		SmartDashboard.putNumber("Arm Target", getTargetPosition());
		SmartDashboard.putNumber("Arm Error", getError());
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
