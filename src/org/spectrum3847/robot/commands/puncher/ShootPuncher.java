/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.puncher;

import edu.wpi.first.wpilibj.command.Command;
import org.spectrum3847.robot.Robot;

public class ShootPuncher extends Command {
	
	private double shotTime;
	
	public ShootPuncher(double time) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.puncher);
		requires(Robot.intake);
		shotTime = time;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		this.setTimeout(shotTime);
		Robot.intake.solOpen();
		Robot.puncher.puncherFullExtend();
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.puncher.puncherSolRetract();
		Robot.intake.solClose();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		this.end();
	}
	
}
