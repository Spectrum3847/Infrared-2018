package org.spectrum3847.lib.controllers;

import org.spectrum3847.lib.controllers.BobAxisButton.ThresholdType;
import org.spectrum3847.lib.controllers.BobXboxController.XboxAxis;
import org.spectrum3847.lib.controllers.BobXboxController.XboxDpad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class BobDpad {
	public final Joystick joy;
	public BobAxisButton Up;
	public BobAxisButton Down;
	public BobAxisButton Left;
	public BobAxisButton Right;
	public BobAxisButton UpLeft;
	public BobAxisButton UpRight;
	public BobAxisButton DownLeft;
	public BobAxisButton DownRight;
	
	public BobDpad(Joystick joystick) {
		this.joy = joystick;
		this.Up = new BobAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP.value, ThresholdType.POV);
		this.Down = new BobAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN.value, ThresholdType.POV);		
		this.Left = new BobAxisButton(joy, XboxAxis.DPAD, XboxDpad.LEFT.value, ThresholdType.POV);
		this.Right = new BobAxisButton(joy, XboxAxis.DPAD, XboxDpad.RIGHT.value, ThresholdType.POV);
		this.UpLeft = new BobAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP_LEFT.value, ThresholdType.POV);
		this.UpRight = new BobAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP_RIGHT.value, ThresholdType.POV);
		this.DownLeft = new BobAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN_LEFT.value, ThresholdType.POV);
		this.DownRight = new BobAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN_RIGHT.value, ThresholdType.POV);
	}
	
	public double getValue() {
		return joy.getRawAxis(XboxAxis.DPAD.value);
	}

}
