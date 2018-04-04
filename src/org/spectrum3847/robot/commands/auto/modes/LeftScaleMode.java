package org.spectrum3847.robot.commands.auto.modes;

import org.spectrum3847.paths.LeftScale;
import org.spectrum3847.paths.TestSTurnAuto;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.FollowTrajectory;
import org.spectrum3847.robot.commands.arm.SetArmPos;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.DriveUntilLine;
import org.spectrum3847.robot.commands.auto.DriveUntilWall;
import org.spectrum3847.robot.commands.auto.InPlaceTurn;
import org.spectrum3847.robot.commands.intake.EjectCube;
import org.spectrum3847.robot.commands.puncher.ShootPuncher;
import org.spectrum3847.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScaleMode extends CommandGroup {

	public LeftScaleMode() {
		super("CeneterSWpigeon");
		//If the switch is on the left make sure we turn before driving
		this.addParallel(new SetArmPos(Arm.Position.FwdScore));
		this.addSequential(new FollowTrajectory(new LeftScale()));
		//this.addSequential(new DriveUntilLine(),3);
		this.addSequential(new ShootPuncher(), 1);
		this.addParallel(new SetArmPos(Arm.Position.CENTER));
		//this.addSequential(new DriveForTime(1,-.3));
	}


}
