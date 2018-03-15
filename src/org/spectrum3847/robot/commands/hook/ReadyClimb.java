package org.spectrum3847.robot.commands.hook;

import org.spectrum3847.robot.commands.arm.SetArmPos;
import org.spectrum3847.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReadyClimb extends CommandGroup {

	public ReadyClimb() {
		this.addParallel(new SetArmPos(Arm.Position.CenterClimb));
		this.addParallel(new DeployHooks());
	}


}
