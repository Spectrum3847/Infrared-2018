
package org.spectrum3847.robot.commands.auto;

import org.spectrum3847.lib.drivers.GameState.Side;
import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class SWTurnForTime extends Command{

	private double throttle;
	private double time;
	
	public SWTurnForTime(double time, double turnThrottle){
		this.requires(Robot.drive);
		this.time = time;
		this.setTimeout(time);
		this.throttle = turnThrottle;
	}

	public void initialize(){
		Debugger.println("SW TURN FOR TIME", Robot._auton, Debugger.info3);
			
	}
	
	public void execute(){
		if (Robot.gameState.mySwitchSide == Side.LEFT) {
			Debugger.println("TIME : " + time +" Throttle: " + Robot.drive.leftSRX.get(), Robot._auton, Debugger.debug2);
			//Robot.drive.drive(ControlMode.PercentOutput, -throttle, throttle);
			Robot.drive.difDrive.curvatureDrive(0, throttle, true);
		}
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
