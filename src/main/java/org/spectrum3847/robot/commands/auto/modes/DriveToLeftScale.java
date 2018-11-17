package org.spectrum3847.robot.commands.auto.modes;

import org.spectrum3847.paths.ArcLeft;
import org.spectrum3847.robot.commands.FollowTrajectory;
import org.spectrum3847.robot.commands.arm.SetArmPos;
import org.spectrum3847.robot.commands.auto.InPlaceTurn;
import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.subsystems.Arm.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveToLeftScale extends CommandGroup {

	public DriveToLeftScale() {
		super("Drive to Left Scale");
		this.addParallel(new IntakeOn(1));
		this.addSequential(new InPlaceTurn(120,false),1.5);
		this.addParallel(new SetArmPos(Position.FwdScore));
		this.addParallel(new IntakeOn(0));
		this.addSequential(new FollowTrajectory(new ArcLeft()));
	}


}
