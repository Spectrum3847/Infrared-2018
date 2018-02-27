/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LEDs extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	I2C i2c;
	byte[] tosend = new byte[1];
	
	public LEDs() {
		super();
		i2c = new I2C(I2C.Port.kOnboard, 5);
	}
	
	public void setColor(String color) {
		switch(color) {
			case "red":
			case "orange":
			case "green":
			case "blue":
			case "indigo":
			case "violet":
			case "white":
			default:
		}
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	//Add the dashboard values for this subsystem
	public void dashboard() {
	}
}
