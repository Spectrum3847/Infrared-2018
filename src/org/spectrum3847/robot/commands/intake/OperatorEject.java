/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;

import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;

public class OperatorEject extends Command {
	
	public OperatorEject() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.puncher);
		requires(Robot.intake);
		//Make sure the command runs for at least two seconds
		this.setTimeout(1);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		double trigger = OI.operatorController.triggers.getLeft();
		
		//If we aren't opening keep it close
		if (trigger <= 0.1) {
			Robot.intake.setOpenLoop(-0.6);
		} else if (trigger > .95) {
			Robot.intake.setOpenLoop(-1);
		} else if (trigger > 0.1) {
			Robot.intake.solOpen();
		}
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut() && !OI.operatorController.rightBumper.get();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.puncher.puncherSolRetract();
		Robot.intake.solClose();
		Robot.intake.setOpenLoop(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		this.end();
	}
	
}
