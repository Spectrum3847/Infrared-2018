package org.spectrum3847.robot.commands.auto.modes;

import org.spectrum3847.paths.LeftScale;
import org.spectrum3847.paths.LeftScaleM2;
import org.spectrum3847.paths.LeftScaleM3;
import org.spectrum3847.paths.TestSTurnAuto;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.FollowTrajectory;
import org.spectrum3847.robot.commands.arm.ArmFwdHome;
import org.spectrum3847.robot.commands.arm.ArmRevHome;
import org.spectrum3847.robot.commands.arm.SetArmPos;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.DriveUntilLine;
import org.spectrum3847.robot.commands.auto.DriveUntilWall;
import org.spectrum3847.robot.commands.auto.InPlaceTurn;
import org.spectrum3847.robot.commands.intake.EjectCube;
import org.spectrum3847.robot.commands.intake.OpenIntakeOn;
import org.spectrum3847.robot.commands.puncher.ShootPuncher;
import org.spectrum3847.robot.subsystems.Arm;
import org.spectrum3847.robot.subsystems.Arm.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScale2Cube extends CommandGroup {

	public LeftScale2Cube() {
		super("LeftScale");
		//If the switch is on the left make sure we turn before driving
		this.addParallel(new SetArmPos(Arm.Position.FwdScore));
		this.addSequential(new FollowTrajectory(new LeftScale()));
		this.addSequential(new ShootPuncher(), .75);
		this.addParallel(new ArmRevHome());
		this.addSequential(new InPlaceTurn(90),3);
		this.addParallel(new OpenIntakeOn(1));
		this.addSequential(new FollowTrajectory(new LeftScaleM2()));
		this.addParallel(new SetArmPos(Position.FwdScore));
		this.addSequential(new FollowTrajectory(new LeftScaleM3()));
		//this.addSequential(new DriveForTime(1,-.3));
	}


}
