package org.spectrum3847.robot.commands.drivetrain;

import org.spectrum3847.robot.OI;
import org.spectrum3847.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.MatchType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpectrumDrive extends Command {
	double turnPow = 2;
	
    public SpectrumDrive() {
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
		//if (OI.driverController.getName().equals("") || DriverStation.getInstance().getMatchType() != MatchType.None) {
	    	boolean quickTurn = Robot.drive.quickTurnController();
	    	double moveValue = OI.driverController.leftStick.getY() * -1;
	    	double rotateValue = OI.driverController.rightStick.getX();
	    	Robot.drive.difDrive.curvatureDrive(moveValue, Math.pow(rotateValue, turnPow),  quickTurn);
	    //} else {
	    //	Robot.drive.stop();
	    //}
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
