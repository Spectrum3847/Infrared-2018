package org.spectrum3847.robot.commands.hook;

import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.arm.ArmMotionMagicPos;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReadyClimb extends CommandGroup {

	public ReadyClimb() {
		this.addParallel(new ArmMotionMagicPos(Robot.arm.fwdPositionLimit/2));
		this.addParallel(new DeployHooks());
	}


}
