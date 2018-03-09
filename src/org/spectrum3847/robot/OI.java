/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.spectrum3847.robot;

import org.spectrum3847.lib.controllers.SpectrumXboxController;
import org.spectrum3847.robot.commands.arm.ArmManualControl;
import org.spectrum3847.robot.commands.arm.ArmMotionMagicAngle;
import org.spectrum3847.robot.commands.arm.ArmMotionMagicPos;
import org.spectrum3847.robot.commands.arm.ArmMotionMagicPref;
import org.spectrum3847.robot.commands.arm.ArmZero;
import org.spectrum3847.robot.commands.drivetrain.HighGear;
import org.spectrum3847.robot.commands.extension.ExtensionManualControl;
import org.spectrum3847.robot.commands.extension.ExtensionMotionMagicPref;
import org.spectrum3847.robot.commands.extension.ExtensionZero;
import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.commands.intake.IntakeUntilCurrent;
import org.spectrum3847.robot.commands.puncher.ShootPuncher;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.MatchType;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
	public static SpectrumXboxController driverController;
	public static SpectrumXboxController operatorController;
	
	public OI() {
		driverController = new SpectrumXboxController(0, .15, .15);
		operatorController = new SpectrumXboxController(1, .15, .15);
		
		driverController.rightBumper.whileHeld(new HighGear());

		// if (operatorController.getName().equals("") ||
		// DriverStation.getInstance().getMatchType() != MatchType.None) {
		operatorController.leftBumper.toggleWhenPressed(new IntakeUntilCurrent());
		operatorController.leftTriggerButton.whileHeld(new IntakeOn(Robot.prefs.getNumber("I: Intake Speed", 1)));
		operatorController.rightTriggerButton.whileHeld(new IntakeOn(-1 * Robot.prefs.getNumber("I: Intake Speed", 1)));

		operatorController.aButton.whileHeld(new ArmMotionMagicAngle());
		operatorController.startButton.whenPressed(new ArmZero());
		operatorController.leftStickButton.toggleWhenPressed(new ArmManualControl());

		operatorController.selectButton.whenPressed(new ExtensionZero());
		operatorController.yButton.whenPressed(new ExtensionMotionMagicPref());
		operatorController.xButton.whenPressed(new ExtensionManualControl());

		operatorController.bButton.whenPressed(new ShootPuncher(1));
			
	   // }
		
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
