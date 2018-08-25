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

/**
 * An example command.  You can replace me with your own command.
 */
public class SetArmPos extends Command {
	
	Arm.Position pos;
	public SetArmPos(Arm.Position p) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.arm);
		requires(Robot.extension);
		pos = p;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Arm.printDebug("Set Arm Pos Running:");
		
		
		if (Robot.arm.canExtend() && (pos == Arm.Position.FwdHighScore || pos == Arm.Position.RevHighScore || pos == Arm.Position.CenterClimb)) {
			Arm.printDebug("Setting Extension High");
			Robot.extension.setTargetPosition(Robot.extension.getHighScorePos());
		} 
		
		
		
		//if I'm not at the extension limit AND I either can't extend or I'm not an extension position, close first, then rotate.
		if (!Robot.extension.isDown() && (!Robot.arm.canExtend() 
				|| !(pos == Arm.Position.FwdHighScore || pos == Arm.Position.RevHighScore || pos == Arm.Position.CenterClimb))) {
			
			Arm.printDebug("Extension Setting to Zero");
			new ExtensionZero().start();
		} else {
			boolean neg = OI.operatorController.leftBumper.get();
			if (neg) {  //Reverse based on he left bumper
				Robot.arm.setPos(Robot.arm.reversePos(pos));
			} else {
				Robot.arm.setPos(pos);
			}
			Arm.printDebug("Postion: " + Robot.arm.getCurrentPosName().toString());
		}	
		
		if (pos != Arm.Position.CenterClimb) {
			Robot.hook.hooksRetract();
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
