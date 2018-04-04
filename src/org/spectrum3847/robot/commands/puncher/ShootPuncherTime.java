package org.spectrum3847.robot.commands.puncher;

import org.spectrum3847.robot.commands.intake.OpenIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ShootPuncherTime extends CommandGroup {
	public ShootPuncherTime(double t, double OpenT) {
		this.addParallel(new OpenIntake(), 1);
		this.addSequential(new WaitCommand(.1));
		this.addSequential(new QuickPunch());
	}
}
