package org.spectrum3847.robot;

import org.spectrum3847.lib.drivers.GameState;
import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.modes.CenterSWnoSensor;
import org.spectrum3847.robot.commands.drivetrain.AutoDrive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {
	public static SendableChooser autonChooser;
	public static String AutoName = "Center SW No Sensor";
	public static int AutoNumber = 1;
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
			/*case (2): {
				AutoName = "Side Peg: BackPack";
				AutonCommand = new SideBackpackGearAutoPID(isRight, false);
				break;
			}
			case (3): {
				AutoName = "Fire Balls Than Side Peg: Backpack";
				AutonCommand = new Fire10BallsAndGear();
				break;
			}
			case (4): {
				AutoName = "Center: Ground Intake";
				AutonCommand = new CurrentStopGearAuto();
				break;
			}
			case (5): {
				AutoName = "Drive Straight";
				AutonCommand = new DriveDistance(Robot.prefs.getNumber("A5: Drive Only Distance", -100), 2);
				break;
			}
			case (6): {
				AutoName = "Hopper";
				AutonCommand = new HopperAuto(isRight);
				break;
			}*/

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
}
