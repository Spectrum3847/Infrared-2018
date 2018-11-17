package org.spectrum3847.robot.commands.extension;

import edu.wpi.first.wpilibj.command.Command;

import org.spectrum3847.lib.controllers.SpectrumThumbStick;
import org.spectrum3847.lib.controllers.SpectrumXboxController;
import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Zero the Extension
 */
public class ExtensionZero extends Command {
	public ExtensionZero() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.extension);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Arm.printDebug("Extension Zero");
		Robot.extension.extensionSRX.configReverseSoftLimitEnable(false);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.extension.setOpenLoop(-.7);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.extension.getRevLimitSW();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.extension.setOpenLoop(0);
		Robot.extension.extensionSRX.configReverseSoftLimitEnable(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
