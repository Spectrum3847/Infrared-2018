/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot.commands.leds;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.spectrum3847.robot.Robot;


public class LEDController extends Command {
	public LEDController(String c, double seconds, boolean blink) {
		requires(Robot.leds);
		
		Robot.leds.timeToDisplay = seconds;
		Robot.leds.currentColor = c;
		Robot.leds.blinking = blink;
	}
	
	public LEDController(String c, boolean blink) {
		requires(Robot.leds);
		

		Robot.leds.currentColor = c;
		Robot.leds.blinking = blink;
	}
	
	public LEDController(String c) {
		requires(Robot.leds);
		
		Robot.leds.currentColor = c;
		Robot.leds.blinking = false;
	}
	
	public LEDController() {
		requires(Robot.leds);
		
		Robot.leds.currentColor = Robot.leds.defaultColor;
		Robot.leds.blinking = false;
	}
	
	// Called once right before the Command runs for the first time
	protected void initialize() {
		Robot.leds.displayColor();
		//System.out.println("Lights are a go.");
	}
	
	// Called repeatedly when the Command is scheduled to run
	protected void execute() {
		
		// Checks if the operator wishes to blink the lights
		if(Robot.leds.blinking) {
		
			Robot.leds.blinkTime = Timer.getFPGATimestamp();
    		boolean counter = (Robot.leds.blinkTime % (Robot.prefs.getNumber("L: Blinking Speed", 1) * 2)) < Robot.prefs.getNumber("L: Blinking Speed", 1);
    		if (counter){
    			Robot.leds.displayColor();
    		} else{
    			Robot.leds.off();
    		}
		}
		
		else if(Robot.leds.timeToDisplay == 0 || ((Timer.getFPGATimestamp() - Robot.leds.startTime) < Robot.leds.timeToDisplay)){
			Robot.leds.displayColor();
			//System.out.println("This time is: " + ((Timer.getFPGATimestamp() - Robot.leds.startTime) < Robot.leds.timeToDisplay));
		}
		else {
			Robot.leds.currentColor = Robot.leds.defaultColor;
			Robot.leds.timeToDisplay = 0;
			Robot.leds.displayColor();
		}
	}	
	
	// Called when isFinished() returns true
	protected void end() {
		Robot.leds.off();
	}
	
	// Called if the Command is interrupted at any point
	protected void interrupt() {
		 end();	
	}
	
	// Will return true when this Command no longer needs to run execute()
	// In this case, the command will run continuously when the robot is on
	protected boolean isFinished() {
		return false;
	}
}
