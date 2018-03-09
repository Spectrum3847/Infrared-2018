
package org.spectrum3847.robot.commands.auto;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TurnForTime extends Command{

	private double throttle;
	private double time;
	
	public TurnForTime(double time, double turnThrottle){
		this.requires(Robot.drive);
		this.time = time;
		this.setTimeout(time);
		this.throttle = turnThrottle;
	}

	public void initialize(){
		Debugger.println("TURN FOR TIME", Robot._auton, Debugger.info3);
	}
	
	public void execute(){
		Debugger.println("TIME : " + time +" Throttle: " + throttle, Robot._auton, Debugger.debug2);
		Robot.drive.difDrive.arcadeDrive(0, throttle);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	public void end(){
		Debugger.println("TURN FOR TIME FINISHED", Robot._auton, Debugger.info3);
		Robot.drive.difDrive.tankDrive(0, 0);
	}
	
	public void isInterrupted(){
		Debugger.println("TURN FOR TIME INTERRUPTED", Robot._auton, Debugger.info3);
		this.end();
	}
}
