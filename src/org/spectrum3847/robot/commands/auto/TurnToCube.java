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
public class TurnToCube extends Command {
	boolean isCCW = true;
	double kP = 0;
	double kD = 0;
	double kF = 0;
	public TurnToCube(boolean ccw) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		isCCW = ccw;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//Backup values set on 3-12 to be good enough for 90 and 180 degree turns
		kP = Robot.prefs.getNumber("D: LLT P", 0.014);
		kD = Robot.prefs.getNumber("D: LLT D", 0.027);
		Debugger.println("LimeLight Turn");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		/*double throttle = -1* Robot.drive.getTurnThrottlePID(angle,
				kP, kD);
		Robot.drive.difDrive.curvatureDrive(0, throttle, true);
		Drivetrain.printDebug("Turn LimeLight Throttle: " + throttle);
		Drivetrain.printDebug("Turn LimeLight Error: " + Robot.drive.error);*/
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;//Util.closeTo((double)Robot.drive.getHeading(), angle, 0.5);
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
