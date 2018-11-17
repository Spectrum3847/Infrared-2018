package org.spectrum3847.lib.controllers;

import org.spectrum3847.lib.controllers.SpectrumXboxController.XboxButton;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class SpectrumButton extends JoystickButton {

	public SpectrumButton(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
	}

	public SpectrumButton(XboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}

	public SpectrumButton(SpectrumXboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}

}
