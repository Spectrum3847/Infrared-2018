package org.spectrum3847.robot.commands.AutoTune;

import org.spectrum3847.robot.Robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTuneDrivetrainLeft extends CommandGroup {

    public AutoTuneDrivetrainLeft() {

    	addSequential(new AutoTuneVelocityConfigure(Robot.drive, Robot.drive.leftSRX, 
    			Robot.drive.LOW_GEAR_PROFILE, FeedbackDevice.QuadEncoder, true, true));

    	addSequential(new AutoTuneVelocity(Robot.drive, Robot.drive.leftSRX,
    			Robot.drive.LOW_GEAR_PROFILE, 6000, 50));
    }
}
