/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.extension;

import edu.wpi.first.wpilibj.command.Command;

import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * An example command.  You can replace me with your own command.
 */
public class ExtensionClimb extends Command {
	private boolean hold = false;
	
	public ExtensionClimb() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.extension);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.extension.setTargetPosition(0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (Robot.extension.getRevLimitSW()) {
			hold = true;
		}
		
		if (hold == true){
			Robot.extension.extensionSRX.overrideLimitSwitchesEnable(false);
			Robot.extension.setOpenLoop(Robot.prefs.getNumber("E: Climb Hold Percent", 4));
		} else {
			Robot.extension.motionMagicControl();
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
		Robot.extension.extensionSRX.overrideLimitSwitchesEnable(true);
		Robot.extension.setOpenLoop(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
