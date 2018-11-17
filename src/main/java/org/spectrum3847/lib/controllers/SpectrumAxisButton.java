package org.spectrum3847.lib.controllers;

import org.spectrum3847.lib.controllers.SpectrumXboxController.XboxAxis;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class SpectrumAxisButton extends Button{
		private final GenericHID joy;
		private final int axis;
		private double targetVal;
		private ThresholdType thresholdType;
		private double cel = 1.1;
		
	public static enum ThresholdType
	{
			LESS_THAN, GREATER_THAN, EXACT, POV;	
	}

	public SpectrumAxisButton(Joystick joystick, int axis, double threshold, ThresholdType thresholdType) {
		this.joy = joystick;
		this.axis = axis;
		this.targetVal = threshold;
		this.thresholdType = thresholdType;
	}
		
	public SpectrumAxisButton(Joystick joystick, XboxAxis axis, double threshold, ThresholdType thresholdType) {
		this(joystick, axis.value, threshold, thresholdType);
	}
	

	public boolean get() {
		switch (this.thresholdType) {
		case EXACT:
			System.out.println("axis value: " + joy.getRawAxis(this.axis));
			return joy.getRawAxis(this.axis) == this.targetVal;
		case LESS_THAN:
			return joy.getRawAxis(this.axis) < this.targetVal;
		case GREATER_THAN:
			return joy.getRawAxis(this.axis) > this.targetVal;
		case POV:
			return joy.getPOV() == this.targetVal;
		default:
		return false;
		}
	}
	
}
