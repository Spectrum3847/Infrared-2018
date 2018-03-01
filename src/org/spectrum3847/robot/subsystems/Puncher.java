/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.subsystems;

import org.spectrum3847.lib.drivers.SpectrumSolenoid;
import org.spectrum3847.robot.HW;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Puncher extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public SpectrumSolenoid puncherSolOne = new SpectrumSolenoid(HW.PUNCHER_ONE_SOL);
	public SpectrumSolenoid puncherSolTwo = new SpectrumSolenoid(HW.PUNCHER_TWO_SOL);
	
	public Puncher() {
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	//retracts the puncher
	public void puncherSolRetact() {
		puncherSolOne.set(false);
		puncherSolTwo.set(false);
	}
		
	//extends the puncher
	public void puncherSolExtend() {
		puncherSolOne.set(true);
		puncherSolTwo.set(true);
		
	}		
	//Add the dashboard values for this subsystem
	public void dashboard() {
	}
	
	
	/*Modify this method to return false if there is a problem with the subsystem
	  Based on 254-2017 Code
	*/
	public boolean checkSystem() {
		return true;
		
		/** Example checkSystem from 254's 2017 Robot
		 System.out.println("Testing HOPPER.--------------------------------------");
        final double kCurrentThres = 0.5;

        mMasterTalon.changeControlMode(CANTalon.TalonControlMode.Voltage);
        mSlaveTalon.changeControlMode(CANTalon.TalonControlMode.Voltage);

        mMasterTalon.set(0.0);
        mSlaveTalon.set(0.0);

        mMasterTalon.set(-6.0f);
        Timer.delay(4.0);
        final double currentMaster = mMasterTalon.getOutputCurrent();
        mMasterTalon.set(0.0);

        Timer.delay(2.0);

        mSlaveTalon.set(6.0f);
        Timer.delay(4.0);
        final double currentSlave = mSlaveTalon.getOutputCurrent();
        mSlaveTalon.set(0.0);

        mMasterTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
        mSlaveTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

        System.out.println("Hopper Master Current: " + currentMaster + " Slave current: " + currentSlave);

        boolean failure = false;

        if (currentMaster < kCurrentThres) {
            failure = true;
            System.out.println("!!!!!!!!!!!!!!!!! Hopper Master Current Low !!!!!!!!!!!!!!!!!");
        }

        if (currentSlave < kCurrentThres) {
            failure = true;
            System.out.println("!!!!!!!!!!!!!!!! Hooper Slave Current Low !!!!!!!!!!!!!!!!!!!");
        }

        if (!Util.allCloseTo(Arrays.asList(currentMaster, currentSlave), currentMaster, 5.0)) {
            failure = true;
            System.out.println("!!!!!!!!!!!!!!!! Hopper Currents Different !!!!!!!!!!!!!!!!!");
        }

        return !failure;
		 */
	}
}
