package org.spectrum3847.robot.commands.drivetrain;

import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.MatchType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestVelocityMode extends Command {

	public TestVelocityMode() {
		requires(Robot.drive);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.setTimeout(10);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.leftSRX.set(ControlMode.Velocity, 10000, 0);
		Robot.drive.rightSRX.set(ControlMode.Velocity, 10000, 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
