/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;

import org.spectrum3847.robot.HW;
import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ExtensionManualControl extends Command {
	public ExtensionManualControl() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.extension);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (OI.operatorController.xButton.get()) {
			Robot.extension.setOpenLoop(OI.operatorController.rightStick.getY()/2);
		} else {
			Robot.extension.setOpenLoop(0);
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
		Robot.arm.setOpenLoop(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
