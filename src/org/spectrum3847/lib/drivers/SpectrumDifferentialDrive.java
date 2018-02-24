package org.spectrum3847.lib.drivers;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class SpectrumDifferentialDrive extends DifferentialDrive {
	  public static final double kDefaultQuickStopThreshold = 0.2;
	  public static final double kDefaultQuickStopAlpha = 0.1;

	  private static int instances = 0;

	  private SpeedController m_leftMotor;
	  private SpeedController m_rightMotor;

	  private double m_quickStopThreshold = kDefaultQuickStopThreshold;
	  private double m_quickStopAlpha = kDefaultQuickStopAlpha;
	  private double m_quickStopAccumulator = 0.0;
	  private boolean m_reported = false;
	  
	  /**
	   * Construct a DifferentialDrive.
	   *
	   * <p>To pass multiple motors per side, use a {@link SpeedControllerGroup}. If a motor needs to be
	   * inverted, do so before passing it in.
	   */
	  public SpectrumDifferentialDrive(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
	    m_leftMotor = leftMotor;
	    m_rightMotor = rightMotor;
	    addChild(m_leftMotor);
	    addChild(m_rightMotor);
	    instances++;
	    setName("DifferentialDrive", instances);
	  }
	  
	  @SuppressWarnings("ParameterName")
	  public void curvatureDrive(double xSpeed, double zRotation, boolean isQuickTurn) {
	    if (!m_reported) {
	      // HAL.report(tResourceType.kResourceType_RobotDrive, 2, tInstances.kRobotDrive_Curvature);
	      m_reported = true;
	    }

	    xSpeed = limit(xSpeed);
	    xSpeed = applyDeadband(xSpeed, m_deadband);

	    zRotation = limit(zRotation);
	    zRotation = applyDeadband(zRotation, m_deadband);

	    double angularPower;
	    boolean overPower;

	    if (isQuickTurn) {
	      if (Math.abs(xSpeed) < m_quickStopThreshold) {
	        m_quickStopAccumulator = (1 - m_quickStopAlpha) * m_quickStopAccumulator
	            + m_quickStopAlpha * limit(zRotation) * 2;
	      }
	      overPower = true;
	      angularPower = zRotation;
	    } else {
	      overPower = false;
	      angularPower = Math.abs(xSpeed) * zRotation - m_quickStopAccumulator;

	      if (m_quickStopAccumulator > 1) {
	        m_quickStopAccumulator -= 1;
	      } else if (m_quickStopAccumulator < -1) {
	        m_quickStopAccumulator += 1;
	      } else {
	        m_quickStopAccumulator = 0.0;
	      }
	    }

	    double leftMotorOutput = xSpeed + angularPower;
	    double rightMotorOutput = xSpeed - angularPower;

	    // If rotation is overpowered, reduce both outputs to within acceptable range
	    if (overPower) {
	      if (leftMotorOutput > 1.0) {
	        rightMotorOutput -= leftMotorOutput - 1.0;
	        leftMotorOutput = 1.0;
	      } else if (rightMotorOutput > 1.0) {
	        leftMotorOutput -= rightMotorOutput - 1.0;
	        rightMotorOutput = 1.0;
	      } else if (leftMotorOutput < -1.0) {
	        rightMotorOutput -= leftMotorOutput + 1.0;
	        leftMotorOutput = -1.0;
	      } else if (rightMotorOutput < -1.0) {
	        leftMotorOutput -= rightMotorOutput + 1.0;
	        rightMotorOutput = -1.0;
	      }
	    }

	    // Normalize the wheel speeds
	    double maxMagnitude = Math.max(Math.abs(leftMotorOutput), Math.abs(rightMotorOutput));
	    if (maxMagnitude > 1.0) {
	      leftMotorOutput /= maxMagnitude;
	      rightMotorOutput /= maxMagnitude;
	    }

	    m_leftMotor.set(leftMotorOutput * m_maxOutput);
	    m_rightMotor.set(rightMotorOutput * m_maxOutput);

	    m_safetyHelper.feed();
	  }
	  

	  /**
	   * Sets the QuickStop speed threshold in curvature drive.
	   *
	   * <p>QuickStop compensates for the robot's moment of inertia when stopping after a QuickTurn.
	   *
	   * <p>While QuickTurn is enabled, the QuickStop accumulator takes on the rotation rate value
	   * outputted by the low-pass filter when the robot's speed along the X axis is below the
	   * threshold. When QuickTurn is disabled, the accumulator's value is applied against the computed
	   * angular power request to slow the robot's rotation.
	   *
	   * @param threshold X speed below which quick stop accumulator will receive rotation rate values
	   *                  [0..1.0].
	   */
	  public void setQuickStopThreshold(double threshold) {
	    m_quickStopThreshold = threshold;
	  }

	  /**
	   * Sets the low-pass filter gain for QuickStop in curvature drive.
	   *
	   * <p>The low-pass filter filters incoming rotation rate commands to smooth out high frequency
	   * changes.
	   *
	   * @param alpha Low-pass filter gain [0.0..2.0]. Smaller values result in slower output changes.
	   *              Values between 1.0 and 2.0 result in output oscillation. Values below 0.0 and
	   *              above 2.0 are unstable.
	   */
	  public void setQuickStopAlpha(double alpha) {
	    m_quickStopAlpha = alpha;
	  }
}


