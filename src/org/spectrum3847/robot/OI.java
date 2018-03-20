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
import org.spectrum3847.robot.commands.arm.SetArmPos;
import org.spectrum3847.robot.commands.drivetrain.HighGear;
import org.spectrum3847.robot.commands.extension.ExtensionClimb;
import org.spectrum3847.robot.commands.extension.ExtensionManualControl;
import org.spectrum3847.robot.commands.extension.ExtensionMotionMagicHold;
import org.spectrum3847.robot.commands.extension.ExtensionMotionMagicPref;
import org.spectrum3847.robot.commands.extension.ExtensionZero;
import org.spectrum3847.robot.commands.hook.ReadyClimb;
import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.commands.intake.IntakeUntilCurrent;
import org.spectrum3847.robot.commands.intake.OpenIntake;
import org.spectrum3847.robot.commands.puncher.ShootPuncher;
import org.spectrum3847.robot.subsystems.Arm;
import org.spectrum3847.robot.commands.puncher.OperatorPuncher;

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
		driverController = new SpectrumXboxController(0, .02, .02);
		operatorController = new SpectrumXboxController(1, .10, .10);
		
		driverController.rightBumper.whileHeld(new HighGear());
		
		driverController.aButton.whileHeld(new OpenIntake());
		driverController.leftTriggerButton.whileHeld(new IntakeUntilCurrent());
		driverController.rightTriggerButton.whileHeld(new IntakeOn(-1));
		
		//Hold to force intake to continue past current limit, happens in IntakeUntilCurrent
		operatorController.rightTriggerButton.toggleWhenPressed(new IntakeUntilCurrent());
		
		//Left Trigger sets the speed of the punch either wheeled outtake, soft punch, full punch in OperatorPuncher() command
		operatorController.rightBumper.toggleWhenPressed(new OperatorPuncher());

		//Left Bumper reverses these positions in SetArmPos command
		operatorController.aButton.whileHeld(new SetArmPos(Arm.Position.FwdIntake));
		operatorController.xButton.whileHeld(new SetArmPos(Arm.Position.FwdScore));
		operatorController.bButton.whileHeld(new SetArmPos(Arm.Position.FwdPortal));
		operatorController.yButton.whileHeld(new SetArmPos(Arm.Position.FwdHighScore));
		operatorController.startButton.whenPressed(new ArmZero());
		operatorController.leftStickButton.toggleWhenPressed(new ArmManualControl());

		operatorController.selectButton.whenPressed(new ExtensionZero());
		operatorController.Dpad.Up.toggleWhenPressed(new ReadyClimb());
		operatorController.Dpad.Down.whileHeld(new ExtensionClimb());
		operatorController.rightStickButton.whenPressed(new ExtensionManualControl());
		
		
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
