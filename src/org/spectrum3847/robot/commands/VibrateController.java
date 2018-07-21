package org.spectrum3847.robot.commands;

import org.spectrum3847.lib.controllers.SpectrumXboxController;
import org.spectrum3847.lib.drivers.Gamepad;
import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.lib.util.Util;
import org.spectrum3847.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class VibrateController extends Command {

	private SpectrumXboxController gp;
	private double duration;
	private double intensity;
	private double startTime;
	
	/**
	 * Vibrate the gamepad for a number of seconds at a certain intensity 0-1.
	 * @param name
	 * @param g
	 * @param d
	 * @param i
	 */
    public VibrateController(SpectrumXboxController g, double d, double i) {
    	super("vibrate");
    	gp = g;
    	duration = d; //In seconds
    	intensity = i;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	gp.setRumble(RumbleType.kRightRumble, intensity);
    	gp.setRumble(RumbleType.kLeftRumble, intensity);
    	startTime = Util.getTime();
    	Debugger.println("Vibrating!", Robot._general, Debugger.info3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double elapsed = Util.getTime() - startTime;
        if (duration != 0 && duration <= elapsed){
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	gp.setRumble(RumbleType.kRightRumble, 0.0);
    	gp.setRumble(RumbleType.kLeftRumble, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
