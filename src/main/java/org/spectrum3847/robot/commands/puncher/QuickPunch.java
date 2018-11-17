/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.puncher;

import edu.wpi.first.wpilibj.command.Command;
import org.spectrum3847.robot.Robot;

public class QuickPunch extends Command {

	private double shotTime = 0;
	
	public QuickPunch() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.puncher);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		shotTime = 0;
		Robot.puncher.puncherFullExtend();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		shotTime++;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return shotTime > 1;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.intake.setOpenLoop(0);
		Robot.puncher.puncherSolRetract();
		shotTime = 0;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		this.end();
	}
	
}
