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
public class ArmMotionMagicPos extends Command {
	private int position = 0;
	private double timestamp = 0;
	private boolean isSet = false;
	private boolean waitDelay = false;
	public ArmMotionMagicPos(int pos) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.arm);
		position = pos;
		timestamp = 0;
	}
	
	public ArmMotionMagicPos(int pos, boolean w) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.arm);
		position = pos;
		waitDelay = w;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("Arm Command Init waiting to set position");
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
		if ((Timer.getFPGATimestamp() - timestamp) > Robot.prefs.getNumber("A: Pos Button Delay", 0.25) && isSet == false) {
			Robot.arm.setTargetPosition(position);
			Robot.arm.motionMagicControl();
			isSet = true;
			System.out.println("Position Set: " + position + " Timestamp: " + timestamp);
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
