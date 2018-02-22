package org.spectrum3847.robot;

import org.spectrum3847.lib.util.Debugger;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {
	@SuppressWarnings("rawtypes")
	public static SendableChooser autonChooser;
	public static String AutoName = "Set to Default Auto";
	public static int AutoNumber = 1;
	public static boolean isRight = false;
	static Command AutonCommand;

	public static void init() {
		selectAuto();
		if (SmartDashboard.getBoolean("Autonomous ENABLED", true)) {
			AutonCommand.start();
		}
		Debugger.println("Auto Init is working", Robot.auton, Debugger.info3);
		Robot.compressor.stop();
	}

	// Periodic method called roughly once every 20ms
	public static void periodic() {
		// System.out.println("Auto is working");
		Scheduler.getInstance().run();
		Dashboard.updateDashboard();
	}

	public static void cancel() {
		Scheduler.getInstance().removeAll();
		Robot.compressor.start();
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
			/*case (1): {
				AutoName = "Center: Backpack";
				AutonCommand = new CenterBackpackGearAutoPID(isRight,
						Robot.prefs.getBoolean("1A: Finish Drive?", false));
				break;
			}
			case (2): {
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

	/*
	 * @SuppressWarnings({ "rawtypes", "unchecked" }) public static void
	 * createChooser(){ autonChooser = new SendableChooser();
	 * 
	 * autonChooser.addDefault("Score Gear", new CurrentStopGearAuto());
	 * autonChooser.addObject("Drive Distance", new DriveDistance(10,2));
	 * autonChooser.addObject("Drive Straight", new CurrentStopGearAuto(false));
	 * autonChooser.addObject("Fire 10 then Gear RED", new
	 * Fire10BallsAndGear(true));
	 * autonChooser.addObject("Fire 10 then Gear BLUE", new
	 * Fire10BallsAndGear(false)); autonChooser.addObject("Fire 10 ONLY Red",
	 * new Fire10Balls(true)); autonChooser.addObject("Fire 10 ONLY Blue", new
	 * Fire10Balls(false));
	 * 
	 * autonChooser.addObject("Side Gear Right Far", new SideGearAuto(true,
	 * false)); autonChooser.addObject("Side Gear Right Close", new
	 * SideGearAuto(true, true)); autonChooser.addObject("Side Gear Left Far",
	 * new SideGearAuto(false, false));
	 * autonChooser.addObject("Side Gear Left Close", new SideGearAuto(false,
	 * true)); SmartDashboard.putData("AutonChooser", new SendableChooser());
	 * SmartDashboard.putData("AutonChooser", autonChooser); }
	 */
}
