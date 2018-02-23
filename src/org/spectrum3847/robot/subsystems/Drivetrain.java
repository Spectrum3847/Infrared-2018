package org.spectrum3847.robot.subsystems;

import java.util.ArrayList;

import org.spectrum3847.lib.drivers.SpectrumTalonSRX;
import org.spectrum3847.lib.drivers.SpectrumVictorSPX;
import org.spectrum3847.lib.drivers.DriveSignal;
import org.spectrum3847.lib.drivers.LeaderTalonSRX;
import org.spectrum3847.robot.HW;
import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.drivetrain.SpectrumDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {

	public static final int LOW_GEAR_PROFILE = 0;
	public static final int HIGH_GEAR_PROFILE = 1;
	public static final int DRIVE_DEFAULT_RAMP_RATE = 30;

	StringBuilder _sb = new StringBuilder();
	private static int _loops = 0;

	public SpectrumVictorSPX leftBottomSPX = new SpectrumVictorSPX(HW.LEFT_DRIVE_FRONT_BOTTOM);
	public SpectrumVictorSPX leftMiddleSPX = new SpectrumVictorSPX(HW.LEFT_DRIVE_MIDDLE);
	public LeaderTalonSRX leftSRX = new LeaderTalonSRX(HW.LEFT_DRIVE_SRX_BACK, leftMiddleSPX, leftBottomSPX);
	public SpectrumVictorSPX rightBottomSPX = new SpectrumVictorSPX(HW.RIGHT_DRIVE_FRONT_BOTTOM);
	public SpectrumVictorSPX rightMiddleSPX = new SpectrumVictorSPX(HW.RIGHT_DRIVE_MIDDLE);
	public LeaderTalonSRX rightSRX = new LeaderTalonSRX(HW.RIGHT_DRIVE_SRX_BACK, rightMiddleSPX, rightBottomSPX);
	public DifferentialDrive difDrive = new DifferentialDrive(leftSRX, rightSRX);

	public Drivetrain() {
		leftSRX.setInverted(true);
		leftSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0);
		leftSRX.setSensorPhase(true);
		leftSRX.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
		leftSRX.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
		leftSRX.configOpenloopRamp(Robot.prefs.getNumber("D: Ramp Rate", DRIVE_DEFAULT_RAMP_RATE));
		leftSRX.configClosedloopRamp(0);
		leftSRX.configNominalOutputForward(0);
		leftSRX.configNominalOutputReverse(0);
		leftSRX.configPeakOutputForward(1);
		leftSRX.configPeakOutputReverse(-1);
		leftSRX.configVoltageCompSaturation(12);
		leftSRX.enableVoltageCompensation(true);
		leftSRX.configContinuousCurrentLimit(60);
		leftSRX.configPeakCurrentLimit(8);
		leftSRX.configPeakCurrentDuration(500);
		leftSRX.enableCurrentLimit(true);

		//RIGHT SIDE CONFIGURATION
		rightSRX.setInverted(false);//true
		rightSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0);
		rightSRX.setSensorPhase(false);
		rightSRX.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
		rightSRX.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.Disabled);
		rightSRX.configOpenloopRamp(Robot.prefs.getNumber("D: Ramp Rate", DRIVE_DEFAULT_RAMP_RATE));
		rightSRX.configClosedloopRamp(0);
		rightSRX.configNominalOutputForward(0);
		rightSRX.configNominalOutputReverse(0);
		rightSRX.configPeakOutputForward(1);
		rightSRX.configPeakOutputReverse(-1);
		rightSRX.configVoltageCompSaturation(12);
		rightSRX.enableVoltageCompensation(true);
		rightSRX.configContinuousCurrentLimit(60);
		rightSRX.configPeakCurrentLimit(8);
		rightSRX.configPeakCurrentDuration(500);
		rightSRX.enableCurrentLimit(true);

		setNeutralMode(NeutralMode.Brake);

		this.configPIDF(HIGH_GEAR_PROFILE, 0.0, 0.0, 0.0, 0.146);
		this.configPIDF(LOW_GEAR_PROFILE, 2.400, 0.0, 48.00, 0.400);
		
		

	}

	public void initDefaultCommand() {
		//set the default command for a subsystem here.
		setDefaultCommand(new SpectrumDrive());
		//setDefaultCommand(new DrivetrainVelocityPIDTest());
	}

	public void configPIDF(int profile, double p, double i, double d, double f) {
		this.leftSRX.configPIDF(profile, p, i, d, f);
		this.rightSRX.configPIDF(profile, p, i, d, f);

	}

	public void drive(ControlMode controlMode, double left, double right){
		this.leftSRX.set(controlMode, left);
		this.rightSRX.set(controlMode, right);
	}

	public void drive(ControlMode controlMode, DriveSignal driveSignal) {
		//System.out.println(driveSignal.toString());
		this.drive(controlMode, driveSignal.getLeft(), driveSignal.getRight());
	}

	public boolean quickTurnController() {
		if (OI.driverController.leftStick.getY() < 0.2 && OI.driverController.leftStick.getY() > -0.2) {
			return true;	
		} else {
			return false;
		}
	}

	public double getLeftDriveLeadDistance() {
		return this.leftSRX.getSelectedSensorPosition(LOW_GEAR_PROFILE);
	}

	public double getRightDriveLeadDistance() {
		return this.rightSRX.getSelectedSensorPosition(LOW_GEAR_PROFILE);
	}

	public double getLeftDriveLeadVelocity() {
		return this.leftSRX.getSelectedSensorVelocity(LOW_GEAR_PROFILE);
	}

	public double getRightDriveLeadVelocity() {
		return this.rightSRX.getSelectedSensorVelocity(LOW_GEAR_PROFILE);
	}

	public void setDrivetrainPositionToZero() {
		this.leftSRX.setSelectedSensorPosition(0, LOW_GEAR_PROFILE);
		this.rightSRX.setSelectedSensorPosition(0, LOW_GEAR_PROFILE);
	}

	public double getLeftLeadVoltage() {
		return this.leftSRX.getMotorOutputVoltage();
	}

	public double getRightLeadVoltage() {
		return this.rightSRX.getMotorOutputVoltage();
	}

	public TalonSRX getLeftLeadTalon() {
		return this.leftSRX;
	}

	public TalonSRX getRightLeadTalon() {
		return this.rightSRX;
	}

	public void setNeutralMode(NeutralMode neutralMode) {
		this.leftSRX.setNeutralMode(neutralMode);
		this.rightSRX.setNeutralMode(neutralMode);
	}
	@Override
	public void periodic() {

	}

	public void dashboard() {
		SmartDashboard.putNumber("Left Drive Position", getLeftDriveLeadDistance());
		SmartDashboard.putNumber("Right Drive Position", getRightDriveLeadDistance());
		SmartDashboard.putNumber("Left Drive Velocity", getLeftDriveLeadVelocity());
		SmartDashboard.putNumber("Right Drive Velocity", getRightDriveLeadVelocity());
		SmartDashboard.putNumber("Left SRX Current", leftSRX.getOutputCurrent());
		SmartDashboard.putNumber("Right SRX Current", rightSRX.getOutputCurrent());
		SmartDashboard.putNumber("Left Drive Output", leftSRX.get());
		SmartDashboard.putNumber("Right Drive Output", rightSRX.get());
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

	public void velocityPIDTest() {

		SpectrumTalonSRX _talon = this.leftSRX;
		double leftYstick = OI.operatorController.leftStick.getY();
		double motorOutput = _talon.getMotorOutputPercent();

		/* prepare line to print */
		_sb.append("\tout:");
		_sb.append(motorOutput);
		_sb.append("\tspd:");
		_sb.append(_talon.getSelectedSensorVelocity(this.HIGH_GEAR_PROFILE));
		//_sb.append("LowLevelspeed:");
		//_sb.append(_talon.getSensorCollection());

		if (OI.operatorController.getRawButton(1)) {
			/* Speed mode */
			/* Convert 500 RPM to units / 100ms.
			 * 4096 Units/Rev * 500 RPM / 600 100ms/min in either direction:
			 * velocity setpoint is in units/100ms
			 */
			double targetVelocity_UnitsPer100ms = OI.operatorController.leftStick.getY() * 4700;
			/* 500 RPM in either direction */
			_talon.set(ControlMode.Velocity, targetVelocity_UnitsPer100ms);

			/* append more signals to print when in speed mode. */
			_sb.append("\terr:");
			_sb.append(_talon.getClosedLoopError(this.HIGH_GEAR_PROFILE));
			_sb.append("\ttrg:");
			_sb.append(targetVelocity_UnitsPer100ms);
		} else {
			/* Percent voltage mode */
			_talon.set(ControlMode.PercentOutput, leftYstick);
			System.out.println("y-axis" + OI.operatorController.leftStick.getY());
		}

		if (++_loops >= 10) {
			_loops = 0;
			System.out.println(_sb.toString());
		}
		_sb.setLength(0);
	}


}

