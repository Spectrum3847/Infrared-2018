package org.spectrum3847.robot;

import org.spectrum3847.lib.drivers.GameState;
import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.paths.CrossTheLine;
import org.spectrum3847.paths.FiveFeet;
import org.spectrum3847.paths.FiveFeetAndTurn;
import org.spectrum3847.paths.TestSTurnAuto;
import org.spectrum3847.paths.ThreeFeet;
import org.spectrum3847.robot.commands.FollowTrajectory;
import org.spectrum3847.robot.commands.AutoTune.AutoTuneVelocity;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.InPlaceTurn;
import org.spectrum3847.robot.commands.auto.modes.CenterSWnoSensor;
import org.spectrum3847.robot.commands.auto.modes.CenterSWpigeon;
import org.spectrum3847.robot.commands.drivetrain.TestVelocityMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {
	public static SendableChooser autonChooser;
	public static String AutoName = "Center SW Pigeon";
	public static int AutoNumber = 2;
	public static boolean isRight = false;
	static Command AutonCommand = new CenterSWnoSensor();

	public static void init() {
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().enable();
        Robot.drive.difDrive.setSafetyEnabled(false);
		Robot.gameState = new GameState(DriverStation.getInstance().getGameSpecificMessage());
		selectAuto();
		if (SmartDashboard.getBoolean("Autonomous ENABLED", true)) {
			AutonCommand.start();
		}
		Robot.compressor.stop();
		Debugger.println("Auto Init with GameState: " + Robot.gameState.message, Robot._auton, Debugger.info3);
	}

	// Periodic method called roughly once every 20ms
	public static void periodic() {
		// System.out.println("Auto is working");
		Scheduler.getInstance().run();
	}

	public static void cancel() {
		Scheduler.getInstance().removeAll();
		Robot.compressor.start();
        Robot.drive.difDrive.setSafetyEnabled(true);
	}

	public static void selectAuto() {
		if (AutoNumber != (int) Robot.prefs.getNumber("1A: AutoNumber", 1)
				|| isRight != Robot.prefs.getBoolean("1A: On Right Side", false)) {
			
			AutoNumber = (int) Robot.prefs.getNumber("1A: AutoNumber", 1);
			isRight = Robot.prefs.getBoolean("1A: On Right Side", false);
			switch (AutoNumber) {
			case (0): {
				AutoName = "Nothing Selected";
				AutonCommand = new Command(10) {
					
					@Override
					protected boolean isFinished() {
						// TODO Auto-generated method stub
						return true;
					}
				};
				break;
			}
			case (1): {
				AutoName = "Center SW No Sensor";
				AutonCommand = new CenterSWnoSensor();
				break;
			}
			case (2): {
				AutoName = "Center SW Pigeon";
				AutonCommand = new CenterSWpigeon();
				break;
			}
			case (11):{
				AutoName = "Cross The Line";
				AutonCommand = new FollowTrajectory(new CrossTheLine());
				break;
			}
			case (94):{
				AutoName = "90 Test IPT Turn Mode";
				AutonCommand = new InPlaceTurn(-90);
				break;
			}
			case (95):{
				AutoName = "45 Test IPT Turn Mode";
				AutonCommand = new InPlaceTurn(45);
				break;
			}
			case (96):{
				AutoName = "Test Velocity Mode";
				AutonCommand = new TestVelocityMode();
				break;
			}
			case (97):{
				AutoName = "Test Trajectory Follow";
				AutonCommand = new FollowTrajectory(new TestSTurnAuto());
				break;
			}
			case (98): {
				AutoName = "Auto Tune Left Velocity";
				AutonCommand = new AutoTuneVelocity(Robot.drive, Robot.drive.leftSRX, 0, Robot.prefs.getNumber("9A: Tune Velocity", 10000), 500);
				break;
			}
			case (99): {
				AutoName = "Auto Tune Right Velocity";
				AutonCommand = new AutoTuneVelocity(Robot.drive, Robot.drive.rightSRX, 0, Robot.prefs.getNumber("9A: Tune Velocity", 10000), 500);
				break;
			}

			//Change to what should be our default auto
			default: 
				AutoName = "Nothing Selected";
				AutonCommand = new Command(10) {
					
					@Override
					protected boolean isFinished() {
						// TODO Auto-generated method stub
						return true;
					}
				};
				break;
			}
		}
	}
	
    public static void printDebug(String msg){
    	Debugger.println(msg, Robot._auton, Debugger.debug2);
    }
    
    public static void printInfo(String msg){
    	Debugger.println(msg, Robot._auton, Debugger.info3);
    }
    
    public static void printWarning(String msg) {
    	Debugger.println(msg, Robot._auton, Debugger.warning4);
    }
}
