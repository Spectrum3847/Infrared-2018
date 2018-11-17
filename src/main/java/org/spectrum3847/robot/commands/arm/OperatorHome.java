/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;

import org.spectrum3847.lib.controllers.SpectrumThumbStick;
import org.spectrum3847.lib.controllers.SpectrumXboxController;
import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.subsystems.Arm.Position;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * An example command.  You can replace me with your own command.
 */
public class OperatorHome extends Command {
	boolean done = false;
	boolean fwd = true;
	public OperatorHome() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.arm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.arm.armSRX.configForwardSoftLimitEnable(false);
		Robot.arm.armSRX.configReverseSoftLimitEnable(false);
		done = false;
		if (OI.operatorController.leftBumper.get()) {
			fwd = false;
		} else {
			fwd = true;
		}
	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (!done) {
			if (!fwd) { //if reverse button
				Robot.arm.setOpenLoop(-.5);
				done = Robot.arm.getRevLimitSW();
			} else {
				Robot.arm.setOpenLoop(.5);
				done = Robot.arm.getFwdLimitSW();
			}
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (!fwd) {
			return  Robot.arm.getRevLimitSW();
		} else {
			return Robot.arm.getFwdLimitSW();
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		//Assign position based on which way we homed
		Robot.arm.setOpenLoop(0);
		if (fwd) {
			Robot.arm.armSRX.setSelectedSensorPosition(Robot.arm.fwdPositionLimit, 0); // Manually set it to FwdLimit
			Robot.arm.setPos(Position.FwdIntake);
		} else {
			Robot.arm.armSRX.setSelectedSensorPosition(0, 0); // Manually set it to FwdLimit
			Robot.arm.setPos(Position.RevIntake);
		}
		Robot.arm.armSRX.configForwardSoftLimitEnable(true);
		Robot.arm.armSRX.configReverseSoftLimitEnable(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
