package org.spectrum3847.robot.commands.drivetrain;

import org.spectrum3847.lib.util.Util;
import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.MatchType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpectrumDrive extends Command {
	double turnPow = 2;
	double throttlePow = 2;

	public SpectrumDrive() {
		requires(Robot.drive);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		turnPow = Robot.prefs.getNumber("D: Turn Power *r", 2);
		throttlePow = Robot.prefs.getNumber("D: Throttle Power *r", 2);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		boolean quickTurn = Robot.drive.quickTurnController();
		double moveValue = OI.driverController.leftStick.getY() * -1;
		Drivetrain.printDebug("Throttle: " + moveValue);
		double rotateValue = OI.driverController.rightStick.getX();
		Drivetrain.printDebug("Rotate: " + rotateValue);
		moveValue = Util.powKeepSign(moveValue, throttlePow);
		rotateValue = Util.powKeepSign(rotateValue, turnPow);
		Drivetrain.printDebug("Throttle Filtered: " + moveValue);
		Drivetrain.printDebug("Rotate Filtered: " + rotateValue);
		Drivetrain.printDebug("Quick Turn: " + quickTurn);
		Robot.drive.difDrive.curvatureDrive(moveValue, rotateValue, quickTurn);
		System.out.println("Spectrum Driving: " + moveValue + ", " + rotateValue);
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
