package org.spectrum3847.lib.controllers;

import org.spectrum3847.lib.controllers.SpectrumXboxController.XboxAxis;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class SpectrumTriggers {
	Joystick controller;
	
	public SpectrumTriggers(Joystick controller) {
		this.controller = controller;
	}

	public double getLeft() {
		return this.controller.getRawAxis(XboxAxis.LEFT_TRIGGER.value);
	}
	
	public double getRight() {
		return this.controller.getRawAxis(XboxAxis.RIGHT_TRIGGER.value);
	}
	
	public double getTwist() {
		return getLeft() * - getRight();
	}
}
