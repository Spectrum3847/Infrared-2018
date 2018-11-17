package org.spectrum3847.robot.commands.auto;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.robot.Autonomous;
import org.spectrum3847.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveUntilLine extends Command {

	private double cruiseCurrent = 40;
	private double throttle;
	private double turnAdjustment;
	private double initTime;
	private double lastUpdate;
	
	public DriveUntilLine() {
		this.requires(Robot.drive);
	}

	public void initialize(){
		Autonomous.printDebug("Driving to Line");
		this.throttle = Robot.prefs.getNumber("2A: Drive To Line Throttle", 5);
		this.turnAdjustment = Robot.prefs.getNumber("2A: Drive to Wall Drive Straight Adjust", -.05);
	}
	
	public void execute(){
		Robot.drive.difDrive.curvatureDrive(throttle, turnAdjustment, false);			
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (Robot.drive.lineSensor.get()){
			Autonomous.printDebug("Line Sensor Hit");
			return true;
		}
		return false;
	}
	
	protected void end(){
		Robot.drive.difDrive.arcadeDrive(0, 0);
	}
	
	protected void interrupted(){
		this.end();
	}

}
