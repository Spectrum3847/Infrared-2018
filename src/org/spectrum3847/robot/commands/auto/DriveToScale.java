
package org.spectrum3847.robot.commands.auto;

import org.spectrum3847.lib.drivers.GameState.Side;
import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.paths.ArcLeft;
import org.spectrum3847.paths.ArcRight;
import org.spectrum3847.paths.LeftSwitchCenter3;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.FollowTrajectory;
import org.spectrum3847.robot.commands.auto.modes.DriveToLeftScale;
import org.spectrum3847.robot.commands.auto.modes.DriveToRightScale;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToScale extends Command{

	private double throttle;
	private double time;
	
	public DriveToScale(){

	}

	protected void initialize(){
		if (Robot.gameState.scaleSide == Side.LEFT) {
			new DriveToLeftScale().start();
		} else {
			new DriveToRightScale().start();
		}
	}
	
	protected void execute(){
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end(){
	}
	
	public void isInterrupted(){
		this.end();
	}
}
