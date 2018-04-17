/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;

import java.util.Arrays;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.lib.util.Util;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.subsystems.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * An example command.  You can replace me with your own command.
 */
public class InPlaceTurn extends Command {
	double angle = 0;
	double kP = 0;
	double kD = 0;
	double kF = 0;
	boolean r = true;
	public InPlaceTurn(double ang, boolean reset) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		angle = ang;
		r = reset;
	}
	
	public InPlaceTurn(double ang) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		angle = ang;
		r = true;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//Backup values set on 3-12 to be good enough for 90 and 180 degree turns
		kP = Robot.prefs.getNumber("D: IPT P", 0.014);
		kD = Robot.prefs.getNumber("D: IPT D", 0.027);
		if (r) {
			Robot.drive.zeroSensors();
		}
		Debugger.println("In place Turn");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double throttle = -1* Robot.drive.getTurnThrottlePID(angle,
				kP, kD);
		Robot.drive.difDrive.curvatureDrive(0, throttle, true);
		Drivetrain.printDebug("Turn In Place Throttle: " + throttle);
		Drivetrain.printDebug("Turn Error: " + Robot.drive.error);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Util.closeTo((double)Robot.drive.getHeading(), angle, 10);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
