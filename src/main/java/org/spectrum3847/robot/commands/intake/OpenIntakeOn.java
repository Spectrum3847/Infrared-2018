/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.subsystems.Intake;


public class OpenIntakeOn extends Command {
	double spd = 1;
	
	public OpenIntakeOn(double spd) {
		requires(Robot.intake);
		spd = this.spd;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.intake.setOpenLoop(1);
		Robot.intake.solOpen();
		Intake.printDebug("Open Intake Start");
	}
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.setOpenLoop(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.intake.setOpenLoop(0);
		Robot.intake.solClose();
		Robot.intake.printDebug("Open Intake End");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		this.end();
	}
}
