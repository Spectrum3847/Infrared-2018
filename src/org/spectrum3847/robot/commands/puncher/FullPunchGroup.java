package org.spectrum3847.robot.commands.puncher;

import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.commands.intake.OpenIntake;
import org.spectrum3847.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class FullPunchGroup extends CommandGroup {
	public FullPunchGroup() {
		this.addParallel(new OpenIntake(), 5.1);
		this.addSequential(new WaitCommand(.1));
		this.addSequential(new ShootPuncher(1));
		
	}
	
	public void initialize() {
		Intake.printDebug("Full Punch");
	}
	
}
