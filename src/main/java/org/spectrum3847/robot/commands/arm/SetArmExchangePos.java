/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;

import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.extension.ExtensionZero;
import org.spectrum3847.robot.subsystems.Arm;
import org.spectrum3847.robot.subsystems.Arm.Position;

/**
 * An example command.  You can replace me with your own command.
 */
public class SetArmExchangePos extends Command {
	
	public SetArmExchangePos() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.arm);
		requires(Robot.extension);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Arm.printDebug("Set Arm to Exchange:");
		//if I'm not at the extension limit AND I either can't extend or I'm not an extension position, close first, then rotate.
		if (!Robot.extension.isDown()) {
			Arm.printDebug("Extension Setting to Zero");
			//Robot.extension.setTargetPosition(0);
			new ExtensionZero().start();
		} else if (Robot.arm.pos == Position.FwdIntake){
			Robot.arm.setPos(Position.FwdExchange);
		}	else if (Robot.arm.pos == Position.RevIntake) {
			Robot.arm.setPos(Position.RevExchange);
		} 
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.arm.motionMagicControl();
		Robot.extension.motionMagicControl();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
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
