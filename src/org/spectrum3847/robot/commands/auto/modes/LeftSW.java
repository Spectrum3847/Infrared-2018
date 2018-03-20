package org.spectrum3847.robot.commands.auto.modes;

import org.spectrum3847.paths.LeftEasySwitch;
import org.spectrum3847.paths.LeftScale;
import org.spectrum3847.paths.TestSTurnAuto;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.FollowTrajectory;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.DriveUntilLine;
import org.spectrum3847.robot.commands.auto.DriveUntilWall;
import org.spectrum3847.robot.commands.auto.InPlaceTurn;
import org.spectrum3847.robot.commands.intake.EjectCube;
import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.commands.puncher.ShootPuncher;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSW extends CommandGroup {

	public LeftSW() {
		super("CeneterSWpigeon");
		//If the switch is on the left make sure we turn before driving
		this.addSequential(new FollowTrajectory(new LeftEasySwitch()),4);
		this.addSequential(new InPlaceTurn(-90),3);
		this.addSequential(new DriveUntilWall(),2);
		//this.addSequential(new IntakeOn(-1), 3);
		this.addSequential(new DriveForTime(1,-.3));
	}


}
