
package org.spectrum3847.robot.commands.auto;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class WaitBeforeAuton extends CommandGroup{
	
	public WaitBeforeAuton(double secs, Command cmd){
		this.addSequential(new WaitCommand(secs));
		this.addSequential(cmd);
	}

	protected void initialize(){
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
