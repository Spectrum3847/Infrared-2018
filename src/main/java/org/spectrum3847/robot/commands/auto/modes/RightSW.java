package org.spectrum3847.robot.commands.auto.modes;

import org.spectrum3847.paths.CrossTheLine;
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
import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.commands.puncher.ShootPuncher;
import org.spectrum3847.robot.subsystems.Arm.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSW extends CommandGroup {

	public RightSW() {
		super("RightSW");
		//If the switch is on the left make sure we turn before driving
		this.addSequential(new FollowTrajectory(new CrossTheLine()),4);
		this.addParallel(new SetArmPos(Position.FwdPortal));
		this.addSequential(new InPlaceTurn(90),3);
		this.addSequential(new DriveUntilWall(.6),2);
		this.addSequential(new EjectCube(), 3);
		//this.addSequential(new DriveForTime(1,-.3));
	}


}
