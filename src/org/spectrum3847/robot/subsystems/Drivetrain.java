package org.spectrum3847.robot.subsystems;

import java.util.ArrayList;
import java.util.Arrays;

import org.spectrum3847.lib.drivers.SpectrumTalonSRX;
import org.spectrum3847.lib.drivers.SpectrumVictorSPX;
import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.lib.util.Util;
import org.spectrum3847.lib.drivers.DriveSignal;
import org.spectrum3847.lib.drivers.LeaderTalonSRX;
import org.spectrum3847.lib.drivers.SpectrumDifferentialDrive;
import org.spectrum3847.lib.drivers.SpectrumDigitalInput;
import org.spectrum3847.lib.drivers.SpectrumSolenoid;
import org.spectrum3847.robot.HW;
import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.drivetrain.SpectrumDrive;

import com.ctre.PigeonImu;
import com.ctre.phoenix.motorcontrol.ControlFrame;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteFeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {

	public static final int LOW_GEAR_PROFILE = 0;
	public static final int TURN_PROFILE = 1;
	public static final double DRIVE_DEFAULT_RAMP_RATE = 0.1;

	StringBuilder _sb = new StringBuilder();
	private static int _loops = 0;

	public SpectrumVictorSPX leftBottomSPX = new SpectrumVictorSPX(HW.LEFT_DRIVE_FRONT_BOTTOM);
	public SpectrumVictorSPX leftMiddleSPX = new SpectrumVictorSPX(HW.LEFT_DRIVE_MIDDLE);
	public LeaderTalonSRX leftSRX = new LeaderTalonSRX(HW.LEFT_DRIVE_SRX_BACK, leftMiddleSPX, leftBottomSPX);
	public SpectrumVictorSPX rightBottomSPX = new SpectrumVictorSPX(HW.RIGHT_DRIVE_FRONT_BOTTOM);
	public SpectrumVictorSPX rightMiddleSPX = new SpectrumVictorSPX(HW.RIGHT_DRIVE_MIDDLE);
	public LeaderTalonSRX rightSRX = new LeaderTalonSRX(HW.RIGHT_DRIVE_SRX_BACK, rightMiddleSPX, rightBottomSPX);
	public SpectrumDifferentialDrive difDrive = new SpectrumDifferentialDrive(leftSRX, rightSRX);
	
	public SpectrumSolenoid shiftingSol = new SpectrumSolenoid(HW.SHIFT_SOL);
	public SpectrumSolenoid brakeSol = new SpectrumSolenoid(HW.DRIVE_BRAKE_SOL);
	
	public SpectrumDigitalInput lineSensor = new SpectrumDigitalInput(HW.LINE_SENSOR);
	
	public PigeonIMU imu = new PigeonIMU(Robot.intake.intakeBottomSRX);
	
	double targetAngle;
	double turnThrottle;
	
	double currentAngle;
	double currentAngularRate;
	public double error = 0;
	
	public Drivetrain() {
		setDefaultTalonConfig();

		leftBottomSPX.setFollowerFramePeriods();
		leftMiddleSPX.setFollowerFramePeriods();
		rightBottomSPX.setFollowerFramePeriods();
		rightMiddleSPX.setFollowerFramePeriods();
		
		setNeutralMode(NeutralMode.Brake);

		//this.configLeftPIDF(TURN_PROFILE, 0.0, 0.0, 0.0, 0);
		//this.configLeftPIDF(LOW_GEAR_PROFILE, 3.7818853855133057, 0.0, 0, 0.05883145332336426);
		

		//this.configRightPIDF(TURN_PROFILE, 0.0, 0.0, 0.0, 0);
		//this.configRightPIDF(LOW_GEAR_PROFILE, 2.6692757606506348, 0.0, 0,  0.059464216232299805);
		
		setLowGear();
		setBrakeOff();
		difDrive.setSafetyEnabled(false);

	}
	
	public void setDefaultTalonConfig() {
		leftSRX.setInverted(false);
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
		leftSRX.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, 0);
		leftSRX.config_kP(0, Robot.prefs.getNumber("D: Left P", 0.035));
		leftSRX.config_kF(0, Robot.prefs.getNumber("D: Left F", 0.059377));
		
		//RIGHT SIDE CONFIGURATION
		rightSRX.setInverted(true);//true
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
		rightSRX.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, 0);
		rightSRX.config_kP(0, Robot.prefs.getNumber("D: Right P", 0.035));
		rightSRX.config_kF(0, Robot.prefs.getNumber("D: Right F", 0.059377));

		setPositionTalonConfig();
		
		//Setup Pigeon
		/* turn off remote 0 */
		leftSRX.configRemoteFeedbackFilter(
				0x00, /* device ID does not matter since filter is off */
				RemoteSensorSource.Off,
				1, /* remote filter 0 */
				10); /* timeout ms */
		/* select a Pigeon on CAN Bus. */
		//leftSRX.configRemoteFeedbackFilter(
		//		imu.getDeviceID(),
		//		RemoteSensorSource.GadgeteerPigeon_Yaw,
		//		0, // remote filter 1
		//		10); // timeout ms 
		
		/* turn off remote 0 */
		rightSRX.configRemoteFeedbackFilter(
				0x00, /* device ID does not matter since filter is off */
				RemoteSensorSource.Off,
				1, /* remote filter 0 */
				10); /* timeout ms */
		/* select a Pigeon on CAN Bus. */
		/*rightSRX.configRemoteFeedbackFilter(
				imu.getDeviceID(),
				RemoteSensorSource.GadgeteerPigeon_Yaw,
				0, //remote filter 1
				10); // timeout ms */
		
		//Put Pigeon as Feedback Sensor 2
		//leftSRX.configSelectedFeedbackSensor(RemoteFeedbackDevice.RemoteSensor0, 1, 0);
		//rightSRX.configSelectedFeedbackSensor(RemoteFeedbackDevice.RemoteSensor0, 1, 0);
	}
	
	//Not needed sense you can't get velocity from the pigeon right now as a Talon Sensor
	public void setUpTurnTalonConfig() {
		leftSRX.configSelectedFeedbackSensor(RemoteFeedbackDevice.RemoteSensor0, 0, 0);
		leftSRX.setSensorPhase(false);
		rightSRX.configSelectedFeedbackSensor(RemoteFeedbackDevice.RemoteSensor0, 0, 0);
		rightSRX.setSensorPhase(true);
		leftSRX.setInverted(!leftSRX.getInverted());
		leftSRX.follow(rightSRX);
	}
	
	public void cleanUpTurnMotionMagic() {
		setPositionTalonConfig();
		Robot.drive.leftSRX.setInverted(!leftSRX.getInverted());
		this.difDrive.tankDrive(0, 0);
	}
	
	public void setPositionTalonConfig() {
		leftSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, LOW_GEAR_PROFILE);
		leftSRX.setSensorPhase(false);
		rightSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, LOW_GEAR_PROFILE);
		rightSRX.setSensorPhase(false);
	}
	
	public void zeroSensors() {
		leftSRX.getSensorCollection().setQuadraturePosition(0, 0);
		rightSRX.getSensorCollection().setQuadraturePosition(0, 0);
		imu.setYaw(0, 0);
		imu.setAccumZAngle(0, 0);
		imu.setFusedHeading(0, 0);
		printInfo("          [Sensors] All Drive sensors are zeroed.");
	}
	
	
	public void setTurnMotionMagic(double t) {
		Robot.drive.rightSRX.set(ControlMode.MotionMagic, t);
	}

	public void initDefaultCommand() {
		//set the default command for a subsystem here.
		setDefaultCommand(new SpectrumDrive());
		//setDefaultCommand(new DrivetrainVelocityPIDTest());
	}

	public void configLeftPIDF(int profile, double p, double i, double d, double f) {
		this.leftSRX.configPIDF(profile, p, i, d, f);
	}
	
	public void configRightPIDF(int profile, double p, double i, double d, double f) {
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
	
	public void stop() {
		drive(ControlMode.PercentOutput, 0,0);
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
		this.leftBottomSPX.setNeutralMode(neutralMode);
		this.leftMiddleSPX.setNeutralMode(neutralMode);
		this.rightBottomSPX.setNeutralMode(neutralMode);
		this.rightMiddleSPX.setNeutralMode(neutralMode);
	}
	
	public void setHighGear() {
		this.shiftingSol.set(true);
	}
	
	public void setLowGear() {
		this.shiftingSol.set(false);
	}
	
	public void setBrakeOn() {
		this.brakeSol.set(true);
	}
	
	public void setBrakeOff() {
		this.brakeSol.set(false);
	}
	
	@Override
	public void periodic() {
	}
	
	public double getTurnThrottlePID(double angle, double kP, double kD) {
		// forwardThrottle = 0;
		double kPgain = kP;// Robot.prefs.getNumber("D: Straight P", 0.04); /* percent throttle per degree
							// of error */
		double kDgain = kD;// Robot.prefs.getNumber("D: Straight D", 0.0004); /* percent throttle per
							// angular velocity dps */
		// kMaxCorrectionRatio = Robot.prefs.getNumber("D: MaxCorrectRatio",0.30 ); /*
		// cap corrective turning throttle to 30 percent of forward throttle */
		/** holds the current angle to servo to */
		targetAngle = angle;

		// Debugger.println("Turning", Robot.drivetrain, Debugger.debug2);
		currentAngle = getHeading();
		currentAngularRate = getYawRate();
		error = (targetAngle - currentAngle);

		turnThrottle = error * kPgain - (currentAngularRate) * kDgain;
		/*
		 * positive turnThrottle means turn to the left, this can be replaced with
		 * ArcadeDrive object, or teams drivetrain object
		 */
		turnThrottle = Util.limit(turnThrottle, 1.0);
		return turnThrottle;
	}
	
	public double getCubeX() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0);
	}
	
	public double getHeading() {
		double[] ypr_deg = new double[3];
		imu.getYawPitchRoll(ypr_deg);
		return ypr_deg[0];
		//return imu.getFusedHeading();
	}
	public double getYawRate() {
		double[] xyz_dps = new double[3];
		imu.getRawGyro(xyz_dps);
		return xyz_dps[0];
	}

	public void dashboard() {
		SmartDashboard.putNumber("Drive/Left Position", getLeftDriveLeadDistance());
		SmartDashboard.putNumber("Drive/Right Position", getRightDriveLeadDistance());
		SmartDashboard.putNumber("Drive/Left Velocity", getLeftDriveLeadVelocity());
		SmartDashboard.putNumber("Drive/Right Velocity", getRightDriveLeadVelocity());
		SmartDashboard.putNumber("Drive/Left SRX Current", leftSRX.getOutputCurrent());
		SmartDashboard.putNumber("Drive/Right SRX Current", rightSRX.getOutputCurrent());
		SmartDashboard.putNumber("Drive/Left Output", leftSRX.get());
		SmartDashboard.putNumber("Drive/Right Output", rightSRX.get());
	}
	
	public void imuDashboard() {
		SmartDashboard.putNumber("IMU/Angle", getHeading());
		SmartDashboard.putNumber("IMU/Angle Rate", getYawRate());
	}

	/*Modify this method to return false if there is a problem with the subsystem
	  Based on 254-2017 Code
	 */
	public boolean checkSystem() {
		System.out.println("Testing Drive Train.------------------------------");
	    final double kCurrentThres = 0.5;
	      
		this.leftSRX.set(ControlMode.PercentOutput, 0.0);
		this.leftBottomSPX.set(ControlMode.PercentOutput, 0.0);
		this.leftMiddleSPX.set(ControlMode.PercentOutput, 0.0);
		this.rightSRX.set(ControlMode.PercentOutput,0.0);
		this.rightBottomSPX.set(ControlMode.PercentOutput, 0.0);
		this.rightMiddleSPX.set(ControlMode.PercentOutput, 0.0);
		
		this.leftSRX.set(ControlMode.PercentOutput, 6.0);
		Timer.delay(4.0);
		final double currentLeftSRX = leftSRX.getOutputCurrent();
		this.leftSRX.set(ControlMode.PercentOutput, 0.0);
		
		Timer.delay(2.0);
		
		this.leftMiddleSPX.set(ControlMode.PercentOutput, 6.0);
		Timer.delay(4.0);
		final double currentLeftMiddleSPX = HW.PDP.getCurrent(HW.LEFT_DRIVE_MIDDLE_PDP);
		this.leftMiddleSPX.set(ControlMode.PercentOutput, 0.0);
		
		Timer.delay(2.0);
		
		this.leftBottomSPX.set(ControlMode.PercentOutput, 6.0);
		Timer.delay(4.0);
		final double currentLeftBottomSPX = HW.PDP.getCurrent(HW.LEFT_DRIVE_FRONT_BOTTOM_PDP);
		this.leftBottomSPX.set(ControlMode.PercentOutput, 0.0);
		
		Timer.delay(2.0);
		
		this.rightSRX.set(ControlMode.PercentOutput, 6.0);
		Timer.delay(4.0);
		final double currentRightSRX = rightSRX.getOutputCurrent();
		this.rightSRX.set(ControlMode.PercentOutput, 0.0);
		
		Timer.delay(2.0);
		
		this.rightMiddleSPX.set(ControlMode.PercentOutput, 6.0);
		Timer.delay(4.0);
		final double currentRightMiddleSPX = HW.PDP.getCurrent(HW.RIGHT_DRIVE_MIDDLE_PDP);
		this.rightMiddleSPX.set(ControlMode.PercentOutput, 0.0);
		
		Timer.delay(2.0);
		
		this.rightBottomSPX.set(ControlMode.PercentOutput, 6.0);
		Timer.delay(4.0);
		final double currentRightBottomSPX = HW.PDP.getCurrent(HW.RIGHT_DRIVE_FRONT_BOTTOM_PDP);
		this.rightBottomSPX.set(ControlMode.PercentOutput, 0.0);
		
		Timer.delay(2.0);
		
		System.out.println("Drive Train Left SRX: " + currentLeftSRX + " LeftMiddleSRX: " + currentLeftMiddleSPX + " LeftBottomSPX: " + currentLeftBottomSPX);
		System.out.println("Drive Train Right SRX: " + currentRightSRX + " RightMiddleSRX: " + currentRightMiddleSPX + " RightBottomSPX: " + currentRightBottomSPX);

	      boolean failure = false;

	      if (currentLeftSRX < kCurrentThres) {
	          failure = true;
	          System.out.println("!!!!!!!!!!!!!!!!! Drive Left SRX Current Low !!!!!!!!!!!!!!!!!");
	      }   
	      if (currentLeftMiddleSPX < kCurrentThres) {
	          failure = true;
	          System.out.println("!!!!!!!!!!!!!!!!! Drive Left Middle SPX Current Low !!!!!!!!!!!!!!!!!");
	      }	      
	      if (currentLeftBottomSPX < kCurrentThres) {
	          failure = true;
	          System.out.println("!!!!!!!!!!!!!!!!! Drive Left Bottom SPX Current Low !!!!!!!!!!!!!!!!!");
	      }
	      if (currentRightSRX < kCurrentThres) {
	          failure = true;
	          System.out.println("!!!!!!!!!!!!!!!!! Drive Right SRX Current Low !!!!!!!!!!!!!!!!!");
	      }   
	      if (currentRightMiddleSPX < kCurrentThres) {
	          failure = true;
	          System.out.println("!!!!!!!!!!!!!!!!! Drive Right Middle SPX Current Low !!!!!!!!!!!!!!!!!");
	      }	      
	      if (currentRightBottomSPX < kCurrentThres) {
	          failure = true;
	          System.out.println("!!!!!!!!!!!!!!!!! Drive Right Bottom SPX Current Low !!!!!!!!!!!!!!!!!");
	      }

	      if (!Util.allCloseTo(Arrays.asList(currentRightSRX, currentRightMiddleSPX, currentRightBottomSPX), currentRightSRX, 5.0)) {
	          failure = true;
	          System.out.println("!!!!!!!!!!!!!!!! Right Drive Currents Different !!!!!!!!!!!!!!!!!");
	      }
	      
	      if (!Util.allCloseTo(Arrays.asList(currentLeftSRX, currentLeftMiddleSPX, currentLeftBottomSPX), currentLeftSRX, 5.0)) {
	          failure = true;
	          System.out.println("!!!!!!!!!!!!!!!! Left Drive Currents Different !!!!!!!!!!!!!!!!!");
	      }
	      
	      //Set the SPXs back to follow mode
	      this.leftBottomSPX.follow(this.leftSRX);
	      this.leftMiddleSPX.follow(this.leftSRX);
	      this.rightBottomSPX.follow(this.rightSRX);
	      this.rightMiddleSPX.follow(this.rightSRX);

	      return !failure;
	}
		
		
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

	public void velocityPIDTest() {

		SpectrumTalonSRX _talon = this.leftSRX;
		double leftYstick = OI.operatorController.leftStick.getY();
		double motorOutput = _talon.getMotorOutputPercent();

		/* prepare line to print */
		_sb.append("\tout:");
		_sb.append(motorOutput);
		_sb.append("\tspd:");
		_sb.append(_talon.getSelectedSensorVelocity(this.TURN_PROFILE));
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
			_sb.append(_talon.getClosedLoopError(this.TURN_PROFILE));
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


    public static void printDebug(String msg){
    	Debugger.println(msg, Robot._intake, Debugger.debug2);
    }
    
    public static void printInfo(String msg){
    	Debugger.println(msg, Robot._intake, Debugger.info3);
    }
    
    public static void printWarning(String msg) {
    	Debugger.println(msg, Robot._intake, Debugger.warning4);
    }
}

