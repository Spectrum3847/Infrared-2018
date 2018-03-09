package org.spectrum3847.robot;

import org.spectrum3847.lib.controllers.SpectrumXboxController;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	//Use ecplise refacotr tool to rename values for your specific robot
	
	public static int CANconfigTimeOut = 0;
	//OI
	public static OI oi;

	/*
	public static final Gamepad Driver_Gamepad = new Gamepad("Driver", HW.USBPORT_0);
    public static final Gamepad Operator_Gamepad = new Gamepad("Operator", HW.USBPORT_1);
	*/
	//PDP Panel
	public static PowerDistributionPanel PDP = new PowerDistributionPanel();
	
	//Minimum battery voltage before recommending change
	public static final int MIN_BATTERY_VOLTAGE = 12;
	
    /**PDP Slots**/

	public static final int LEFT_DRIVE_SRX_BACK_PDP = 13;
	public static final int LEFT_DRIVE_MIDDLE_PDP = 12;
	public static final int LEFT_DRIVE_FRONT_BOTTOM_PDP = 11;
	public static final int RIGHT_DRIVE_SRX_BACK_PDP = 2;
	public static final int RIGHT_DRIVE_MIDDLE_PDP = 3;
	public static final int RIGHT_DRIVE_FRONT_BOTTOM_PDP = 4;
	
	public static final int ARM_TOP_FRONT_PDP= 15;
	public static final int ARM_BOTTOM_BACK_PDP = 14;
	public static final int EXTENSION_TOP_PDP= 0;
	public static final int EXTENSION_BOTTOM_PDP = 1;
	
	public static final int INTAKE_TOP_PDP = 6;
	public static final int INTAKE_BOTTOM_PDP = 5;

	/**MOTOR ASSIGNMENTS**/
    public static final int LEFT_DRIVE_SRX_BACK = 10;
    public static final int LEFT_DRIVE_MIDDLE = 11;
    public static final int LEFT_DRIVE_FRONT_BOTTOM = 12;
    public static final int RIGHT_DRIVE_SRX_BACK = 20;
    public static final int RIGHT_DRIVE_MIDDLE = 21;
    public static final int RIGHT_DRIVE_FRONT_BOTTOM = 22;
    
    public static final int ARM_TOP  = 30;
    public static final int ARM_BOTTOM = 31;
    public static final int EXTENSION_TOP   = 40;
    public static final int EXTENSION_BOTTOM  = 41;
    
    public static final int INTAKE_TOP = 50;
    public static final int INTAKE_BOTTOM = 51;
    
    /**DIGITAL SENSOR ALLOCATIONS**/
    public static final int DIGITAL_IO_0 = 0;
    public static final int DIGITAL_IO_1 = 1; 
    public static final int DIGITAL_IO_2 = 2;
    public static final int DIGITAL_IO_3 = 3;
    public static final int DIGITAL_IO_4 = 4; 
    public static final int DIGITAL_IO_5 = 5;
    public static final int DIGITAL_IO_6 = 6; 
    public static final int DIGITAL_IO_7 = 7; 
    public static final int DIGITAL_IO_8 = 8;
    public static final int DIGITAL_IO_9 = 9;  
    
    /**Pneumatics**/
    public static final int SHIFT_SOL = 7;
    public static final int DRIVE_BRAKE_SOL = 6;
    public static final int ARM_BRAKE_SOL = 5;
    public static final int EXTENSION_BRAKE_SOL = 4;
    public static final int INTAKE_SOL = 3;
    public static final int HOOKS_SOL = 2;
    public static final int PUNCHER_ONE_SOL = 1;
    public static final int PUNCHER_TWO_SOL = 0;
    
    /**ANALOG SENSOR ALLOCATIONS**/
    public static final int PRESSURE_TRANSDUCER = 0;
    public static final int ANALOG_IN_1 = 1;
    public static final int ANALOG_IN_2 = 2;
    public static final int ANALOG_IN_3 = 3;
    
    /**RELAY ALLOCATIONS**/
    public static final int RELAY_ZERO = 0;
    public static final int RELAY_ONE = 1;
    public static final int RELAY_TWO = 2;
    public static final int RELAY_THREE = 3;

    /**JOYSTICKS/GAMEPAD ASSIGNMENTS**/
    public static final int USBPORT_0 = 0;
    public static final int USBPORT_1 = 1;
    public static final int USBPORT_2 = 2;
    public static final int USBPORT_3 = 3;
    public static final int USBPORT_4 = 4;
    public static final int DSControllerPort = 5;
}
