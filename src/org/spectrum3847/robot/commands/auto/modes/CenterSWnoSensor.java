package org.spectrum3847.robot.commands.auto.modes;

import org.spectrum3847.lib.drivers.GameState;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.DriveUntilWall;
import org.spectrum3847.robot.commands.auto.SWTurnForTime;
import org.spectrum3847.robot.commands.auto.TurnForTime;
import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.commands.intake.OpenIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSWnoSensor extends CommandGroup {

	public CenterSWnoSensor() {
		super("CeneterSWnoSensor");
		//If the switch is on the left make sure we turn before driving
		this.addSequential(new SWTurnForTime(Robot.prefs.getNumber("2A: SW Turn Time", 1),
					Robot.prefs.getNumber("2A: SW Turn Throttle", -.3)));
		this.addSequential(new DriveUntilWall(),10);
		this.addSequential(new IntakeOn(-1));
		this.addSequential(new DriveForTime(1,-.3));
	}


}
