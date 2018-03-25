/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.subsystems;

import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.robot.commands.leds.LEDController;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LEDs extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	I2C i2c;
	byte[] toSend = new byte[1];
	
	public double timeToDisplay = 0;
	public double startTime = Timer.getFPGATimestamp();
	public double blinkTime = 0;
	public final String defaultColor = "default";
	public String currentColor;
	public boolean blinking = false;
	
	public LEDs() {
		super();
		i2c = new I2C(I2C.Port.kOnboard, 5);
	}
	
	//display a color
	public void setColor(String color) {
		startTime = Timer.getFPGATimestamp();
		timeToDisplay = 0;
		currentColor = color;
	}
	
	//display a color for a set time
	public void setColor(String color, double time) {
		startTime = Timer.getFPGATimestamp();
		timeToDisplay = time;
		currentColor = color;
	}
	
	public void blinkOn() {
		blinking = true;
	}
	
	public void blinkOff() {
		blinking = false;
	}
	
	public boolean isBlinking() {
		return blinking;
	}
	
	public void displayColor() {
		switch(currentColor) {
			case"purple": 
				toSend[0] = 71;
			case"red": 
				toSend[0] = 72;
			case"yellow": 
				toSend[0] = 73;
			case"green": 
				toSend[0] = 74;
			case"default": 
				toSend[0] = 75;
		}
		i2c.transaction(toSend, 1, null, 0);
	}
	
	public void off() {
			toSend[0] = 70;
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new LEDController());
		
	}
	
	//Add the dashboard values for this subsystem
	public void dashboard() {
	}
	
	/*public void printGeneralInfo(String msg){
    	Debugger.println(msg, "LIGHTS", Debugger.info3);
    }*/
}
