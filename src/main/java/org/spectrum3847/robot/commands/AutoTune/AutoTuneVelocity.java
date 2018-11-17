package org.spectrum3847.robot.commands.AutoTune;

import org.spectrum3847.lib.drivers.SpectrumTalonSRX;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Based on Bob319 2017 Code
 */
public class AutoTuneVelocity extends CommandGroup {

    public AutoTuneVelocity(Subsystem requiredSubsystem, SpectrumTalonSRX talon, int srxParameterSlot,
    		double desiredVelocity, int numSamplesRequired) {
    	
    	addSequential(new WaitCommand("safety_wait_command", 5.0));
    	
    	addSequential(new AutoTuneVelocitySpinUp(requiredSubsystem, talon, ControlMode.PercentOutput, 1.0));
    	
    	addSequential(new WaitCommand("spin_up_wait_command", 2.0));
    	
    	addSequential(new AutoTuneVelocityCalculateF(requiredSubsystem, talon, srxParameterSlot, numSamplesRequired));
    	
    	addSequential(new AutoTuneVelocitySpinDown(requiredSubsystem, talon));
    	
    	addSequential(new AutoTuneVelocitySpinUp(requiredSubsystem, talon, ControlMode.Velocity, desiredVelocity));
    	
    	addSequential(new WaitCommand("spin_up_wait_command", 5.0));
    	
    	addSequential(new AutoTuneVelocityCalculateP(requiredSubsystem, talon, srxParameterSlot, desiredVelocity, numSamplesRequired));
    	
    	addSequential(new AutoTuneVelocitySpinDown(requiredSubsystem, talon));
    	
    	addSequential(new AutoTuneVelocityEnd(requiredSubsystem, talon, srxParameterSlot));
    
    }
    
}