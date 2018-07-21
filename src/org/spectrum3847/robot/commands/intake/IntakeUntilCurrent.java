/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.subsystems.Intake;


public class IntakeUntilCurrent extends Command {
	
	private double speed;
	private double startTime = 0;
	
	public IntakeUntilCurrent() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		speed = 1;//Robot.prefs.getNumber("I: Intake Speed", 1);
		startTime = Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (Timer.getFPGATimestamp() - startTime > 2) {
			if (Robot.intake.getCurrent() < Robot.prefs.getNumber("I: stalled", 10)) {
				Robot.intake.setOpenLoop(speed, speed - Robot.prefs.getNumber("I: intake diff", .2));
			} else {
				Robot.intake.setOpenLoop(speed, -.15);
			}
		} else {
			Robot.intake.setOpenLoop(speed, speed - Robot.prefs.getNumber("I: intake diff", .2));
		}	
	}
		

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		//check if we have a cube and the left bumper isn't pressed
		return Robot.intake.isIntakeComplete(Robot.prefs.getNumber("I: Current Threshold", 8),
				Robot.prefs.getNumber("I: Threshold Time", 0.5)) && !OI.operatorController.rightTriggerButton.get();
		
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.intake.setOpenLoop(0);
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.intake.setOpenLoop(0);
	}
}
