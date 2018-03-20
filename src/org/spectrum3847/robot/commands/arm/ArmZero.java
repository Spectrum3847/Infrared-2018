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

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * An example command.  You can replace me with your own command.
 */
public class ArmZero extends Command {
	public ArmZero() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.arm);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.arm.armSRX.configReverseSoftLimitEnable(false);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.arm.setOpenLoop( -.4);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.arm.getRevLimitSW();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.arm.setOpenLoop(0);
		Robot.arm.armSRX.configReverseSoftLimitEnable(true);
		Robot.arm.armSRX.setSelectedSensorPosition(0, 0); // Manually set it to zero
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
