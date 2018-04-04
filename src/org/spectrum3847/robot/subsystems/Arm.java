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
import org.spectrum3847.lib.drivers.SRXGains;
import org.spectrum3847.robot.HW;
import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.Robot.RobotState;
import org.spectrum3847.robot.commands.arm.ArmManualControl;
import org.spectrum3847.robot.commands.arm.ArmMotionMagicHold;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Arm Subsystem
 */
public class Arm extends Subsystem {
	
	public final static int ARM_UP = 0;
	public final static int ARM_DOWN = 1;
	
	public final static int fwdPositionLimit = 55400;// needs to be determined manually
	public final static int revPositionLimit = 0;
	
	public SpectrumTalonSRX armBottomSRX = new SpectrumTalonSRX(HW.ARM_BOTTOM);
	public LeaderTalonSRX armSRX = new LeaderTalonSRX(HW.ARM_TOP, armBottomSRX);
	
	private int accel = 0;
	private int cruiseVel = 0;
	

	public int posRevIntake = 500;
	public int posRevExchange = 2700;
	public int posRevPortal = 14000;
	public int posRevScore = 24000;
	public int posRevExtensionLimit = 22000;
	public int posRevHighScore = 24000;
	public int posCenterUp = fwdPositionLimit/2;
	public int posFwdHighScore = fwdPositionLimit - posRevHighScore;
	public int posFwdExtensionLimit = fwdPositionLimit - posRevExtensionLimit;
	public int posFwdScore = fwdPositionLimit - posRevScore;
	public int posFwdPortal = fwdPositionLimit - posRevPortal;
	public int posFwdExchange = fwdPositionLimit - posRevExchange;
	public int posFwdIntake = fwdPositionLimit - posRevIntake;// - posRevExchange;//FwdIntake is the same as FwdExchange for now
	public int pos2ndRowCube = fwdPositionLimit - 5000;

	
	private final SRXGains upGains = new SRXGains(ARM_UP, 0.560, 0.0, 5.600, 0.620, 100);
	private final SRXGains downGains = new SRXGains(ARM_DOWN, 0.0, 0.0, 0.0, 0.427, 0);
	
	private int targetPosition = 0;
	
	public enum Position {
		FwdIntake, FwdExchange, FwdPortal, FwdScore, FwdHighScore, CENTER, CenterClimb, RevHighScore, RevScore, RevPortal, RevExchange, RevIntake, NotZeroed
	}
	
	public Position pos = Position.NotZeroed;
	
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
    	armSRX.configPeakOutputForward(1);
    	armSRX.configPeakOutputReverse(-1);
    	armSRX.configVoltageCompSaturation(12);
    	armSRX.enableVoltageCompensation(true);
    	armSRX.configContinuousCurrentLimit(20);
    	armSRX.configPeakCurrentLimit(20);
    	armSRX.configPeakCurrentDuration(500);
    	armSRX.enableCurrentLimit(true);
    	armSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10);
    	armSRX.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10);
		armSRX.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, 0);
    		
    	armSRX.configForwardSoftLimitEnable(false);
    	armSRX.configForwardSoftLimitThreshold(fwdPositionLimit);
    	
    	armSRX.configReverseSoftLimitEnable(false);
    	armSRX.configReverseSoftLimitThreshold(revPositionLimit);
    	
    	//Don't Clear Arm Position on Reverse Limit Switch
    	armSRX.configSetParameter(ParamEnum.eClearPositionOnLimitR, 0, 0, 0, 0);
    	
    	armBottomSRX.setFollowerFramePeriods();
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new ArmManualControl());
		setDefaultCommand(new ArmMotionMagicHold());
	}
	
	public void periodic() {
		if (Robot.prefs.getBoolean("A: Set Gains", false)) {
			Arm.printDebug("Setting Arm Gains");
			setMotionMagicValues((int)Robot.prefs.getNumber("A: MM Accel", 5000), (int)Robot.prefs.getNumber("A: MM CruiseVel", 2000));
			getPrefsGains();
			armSRX.setGains(upGains);
			armSRX.setGains(downGains);
		} 
	}
	
	public void setPos(Arm.Position pos) {
		int p = 0;
		switch(pos) {
			case FwdIntake:
				p = Robot.arm.posFwdIntake;
				break;
			case FwdExchange:
				p = Robot.arm.posFwdExchange;
				break;
			case FwdPortal:
				p = Robot.arm.posFwdPortal;
				break;
			case FwdScore:
				p = Robot.arm.posFwdScore;
				break;
			case FwdHighScore:
				p = Robot.arm.posFwdHighScore;
				break;
			case CENTER:
				p = Robot.arm.posCenterUp;
				break;
			case CenterClimb:
				p = Robot.arm.posCenterUp;
				break;
			case RevHighScore:
				p = Robot.arm.posRevHighScore;
				break;
			case RevScore:
				p = Robot.arm.posRevScore;
				break;
			case RevPortal:
				p = Robot.arm.posRevPortal;
				break;
			case RevExchange:
				p = Robot.arm.posRevExchange;
				break;
			case RevIntake:
				p = Robot.arm.posRevIntake;
				break;
			case NotZeroed:
				p = this.getCurrentPosition();
				break;
		}
		this.pos = pos;
		setTargetPosition(p);
		
	}
	
	public Position reversePos(Position pos) {
		Position p = Position.RevIntake;
		switch(pos) {
		case FwdIntake:
			p = Position.RevIntake;
			break;
		case FwdExchange:
			p = Position.RevExchange;
			break;
		case FwdPortal:
			p = Position.RevPortal;
			break;
		case FwdScore:
			p = Position.RevScore;
			break;
		case FwdHighScore:
			p = Position.RevHighScore;
			break;
		case CENTER:
			p = Position.CENTER;
			break;
		case CenterClimb:
			p = Position.CenterClimb;
			break;
		case RevHighScore:
			p = Position.FwdHighScore;
			break;
		case RevScore:
			p = Position.FwdScore;
			break;
		case RevPortal:
			p = Position.FwdPortal;
			break;
		case RevExchange:
			p = Position.FwdExchange;
			break;
		case RevIntake:
			p = Position.FwdIntake;
			break;
		case NotZeroed:
			p = Position.NotZeroed;
			break;
		}
		return p;
	}
	
	public Position getCurrentPosName() {
		return pos;
	}
	public void getPrefsGains() {
		upGains.setGains(ARM_UP,
		Robot.prefs.getNumber("A: up P", 0.0),
		Robot.prefs.getNumber("A: up I", 0.0),
		Robot.prefs.getNumber("A: up D", 0.0),
		Robot.prefs.getNumber("A: up F", 0.0),
		0);
		/*//Only useing Up gains
		downGains.setGains(ARM_DOWN,
		Robot.prefs.getNumber("A: down P", 0.0),
		Robot.prefs.getNumber("A: down I", 0.0),
		Robot.prefs.getNumber("A: down D", 0.0),
		Robot.prefs.getNumber("A: down F", 0.0),
		0);
		*/
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
		return armSRX.getMotorOutputVoltage();
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
	public int angleToPosition(double angle) {
		if (angle > 110) {
			angle = 130;
		} else if (angle < -110) {
			angle = -130;
		}
		
		angle -= 130; //Make angle 0-260 instead of -130 to 130
		angle *= -1;
		
		angle = angle * (this.fwdPositionLimit/260);
		
		return (int)angle;
	}
	//Start a command to hold the arm in a position
	public void hold() {
		new ArmMotionMagicHold().start();
	}
	
	public void setTargetToCurrentPosition() {
		int currentPosition = getCurrentPosition();
		if (currentPosition < 0) {
			currentPosition = 0;
			this.armSRX.setSelectedSensorPosition(0,0);
		}
		setTargetPosition(currentPosition);
	}
	
	public boolean canExtend() {
		int pos = getCurrentPosition();
		if (pos < this.posFwdExtensionLimit+2 &&
				pos > this.posRevExtensionLimit-2) {
			return true;
		} else {
			return false;
		}
	}
	
	public void disableLimitSwitches(boolean t) {
		armSRX.overrideLimitSwitchesEnable(!t);
	}
	
	public void motionMagicControl() {
    	//manageGainProfile(targetPosition);
		//armSRX.selectProfileSlot(ARM_UP, 0);
    	armSRX.set(ControlMode.MotionMagic, targetPosition);
    }
	
	public void setMotionMagicValues(int acceleration, int cruiseVelocity) {
		if (accel != acceleration && cruiseVel != cruiseVelocity) {
			accel = acceleration;
			cruiseVel = cruiseVelocity;
			armSRX.configMotionAcceleration(accel);
			armSRX.configMotionCruiseVelocity(cruiseVel);
			Arm.printDebug("MM Accerlation Set:" + accel);
			Arm.printDebug("MM Velocity Set:" + cruiseVel);
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
		SmartDashboard.putNumber("Arm/Position", getCurrentPosition());
		SmartDashboard.putNumber("Arm/Output", getOutput());
		SmartDashboard.putNumber("Arm/Velocity", armSRX.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Arm/Target", getTargetPosition());
		SmartDashboard.putNumber("Arm/Error", getError());
		SmartDashboard.putNumber("Arm/Current Total", armSRX.getOutputCurrent() + armBottomSRX.getOutputCurrent());	
		SmartDashboard.putNumber("Arm/Controller Polar", OI.operatorController.leftStick.getDirectionDegrees());
		SmartDashboard.putBoolean("Arm/Can Extend", canExtend());
		SmartDashboard.putBoolean("Arm/Rev Limit SW", this.getRevLimitSW());
		SmartDashboard.putBoolean("Arm/Fwd Limit SW", this.getFwdLimitSW());
		
		if (armSRX.getControlMode() == ControlMode.MotionMagic) {
			SmartDashboard.putNumber("Arm Acitve Traj Veloctiy", armSRX.getActiveTrajectoryVelocity());
			SmartDashboard.putNumber("Arm Acitve Traj Position", armSRX.getActiveTrajectoryPosition());
		} else {
			SmartDashboard.putNumber("Arm Acitve Traj Veloctiy", -1);
			SmartDashboard.putNumber("Arm Acitve Traj Position", -1);
		}
	}
	
    public static void printDebug(String msg){
    	Debugger.println(msg, Robot._arm, Debugger.debug2);
    }
    
    public static void printInfo(String msg){
    	Debugger.println(msg, Robot._arm, Debugger.info3);
    }
    
    public static void printWarning(String msg) {
    	Debugger.println(msg, Robot._arm, Debugger.warning4);
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
