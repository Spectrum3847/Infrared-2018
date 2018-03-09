package org.spectrum3847.robot.commands.drivetrain;

import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.MatchType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	double turnPow = 2;

	public AutoDrive() {
		requires(Robot.drive);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		turnPow = Robot.prefs.getNumber("D: Turn Power *r", 2);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		boolean quickTurn = false;
		double moveValue = 1;
		double rotateValue = 0;
		Robot.drive.difDrive.curvatureDrive(moveValue, Math.pow(rotateValue, turnPow), quickTurn);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}