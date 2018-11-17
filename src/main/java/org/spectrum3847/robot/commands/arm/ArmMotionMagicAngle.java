/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ArmMotionMagicAngle extends Command {
	private int position = 0;
	private double angle = 0;
	private double timestamp = 0;
	private boolean isSet = false;
	private boolean waitDelay = false;
	public ArmMotionMagicAngle() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.arm);
		timestamp = 0;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		if (waitDelay) {
			timestamp = Timer.getFPGATimestamp();
		} else {
			timestamp = 0;
		}
		isSet = false;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		angle = OI.operatorController.leftStick.getDirectionDegrees();
		if (angle != 180) { //Make sure the joystick is not centered
			Robot.arm.setTargetPosition(Robot.arm.angleToPosition(angle));
			Robot.arm.motionMagicControl();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
