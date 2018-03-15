package org.spectrum3847.robot.commands.auto.modes;

import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.DriveUntilWall;
import org.spectrum3847.robot.commands.auto.InPlaceTurn;
import org.spectrum3847.robot.commands.intake.EjectCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSWpigeon extends CommandGroup {

	public CenterSWpigeon() {
		super("CeneterSWpigeon");
		//If the switch is on the left make sure we turn before driving
		this.addSequential(new InPlaceTurn(Robot.prefs.getNumber("2A: CenterSW Pigeon Angle", 90)));
		this.addSequential(new DriveUntilWall(),10);
		this.addSequential(new EjectCube(), 3);
		this.addSequential(new DriveForTime(1,-.3));
	}


}
