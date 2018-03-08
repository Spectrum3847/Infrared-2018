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
import org.spectrum3847.robot.commands.extension.ExtensionManualControl;
import org.spectrum3847.robot.commands.extension.ExtensionMotionMagicPref;
import org.spectrum3847.robot.commands.extension.ExtensionZero;
import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.commands.intake.IntakeUntilCurrent;

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
		
		if (driverController.getName().equals("") || DriverStation.getInstance().getMatchType() != MatchType.None) {

	    }

		//if (operatorController.getName().equals("") || DriverStation.getInstance().getMatchType() != MatchType.None) {
			operatorController.leftBumper.whenPressed(new IntakeUntilCurrent());
			operatorController.leftTriggerButton.whileHeld(new IntakeOn(Robot.prefs.getNumber("I: Intake Speed", 1)));
			operatorController.rightTriggerButton.whileHeld(new IntakeOn(-1* Robot.prefs.getNumber("I: Intake Speed", 1)));
			
			//operatorController.bButton.whileHeld(new ArmMotionMagicPref());
			//operatorController.Dpad.DownLeft.whenPressed(new ArmMotionMagicPos(Robot.arm.posFwdIntake, true));
			//operatorController.Dpad.Left.whenPressed(new ArmMotionMagicPos(Robot.arm.posFwdStraight, true));
			//operatorController.Dpad.UpLeft.whenPressed(new ArmMotionMagicPos(Robot.arm.posFwdScale, true));
			//operatorController.Dpad.Up.whenPressed(new ArmMotionMagicPos(Robot.arm.posCenterUp, true));
			//operatorController.Dpad.UpRight.whenPressed(new ArmMotionMagicPos(Robot.arm.posRevScale, true));
			//operatorController.Dpad.Right.whenPressed(new ArmMotionMagicPos(Robot.arm.posRevStraight, true));
			//operatorController.Dpad.DownRight.whenPressed(new ArmMotionMagicPos(Robot.arm.posRevIntake, true));
			operatorController.aButton.whileHeld(new ArmMotionMagicAngle());
			operatorController.startButton.whenPressed(new ArmZero());
			operatorController.leftStickButton.toggleWhenPressed(new ArmManualControl());
			
			operatorController.selectButton.whenPressed(new ExtensionZero());
			operatorController.yButton.whenPressed(new ExtensionMotionMagicPref());
			operatorController.xButton.whenPressed(new ExtensionManualControl());
			
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
