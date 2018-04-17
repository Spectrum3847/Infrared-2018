package org.spectrum3847.robot;

import org.spectrum3847.lib.drivers.GameState;
import org.spectrum3847.lib.drivers.GameState.Side;
import org.spectrum3847.lib.util.Debugger;
import org.spectrum3847.paths.ArcLeft;
import org.spectrum3847.paths.CrossTheLine;
import org.spectrum3847.paths.FiveFeet;
import org.spectrum3847.paths.FiveFeetAndTurn;
import org.spectrum3847.paths.LeftCrossScale;
import org.spectrum3847.paths.LeftSideRightScale;
import org.spectrum3847.paths.LeftSwitchCenter;
import org.spectrum3847.paths.LeftSwitchCenter2;
import org.spectrum3847.paths.TestSTurnAuto;
import org.spectrum3847.paths.ThreeFeet;
import org.spectrum3847.robot.commands.FollowTrajectory;
import org.spectrum3847.robot.commands.AutoTune.AutoTuneVelocity;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.InPlaceTurn;
import org.spectrum3847.robot.commands.auto.WaitBeforeAuton;
import org.spectrum3847.robot.commands.auto.modes.CenterSWnoSensor;
import org.spectrum3847.robot.commands.auto.modes.CenterSWpigeon;
import org.spectrum3847.robot.commands.auto.modes.LeftSW;
import org.spectrum3847.robot.commands.auto.modes.LeftSWOneAndHalf;
import org.spectrum3847.robot.commands.auto.modes.LeftSWOneAndHalfPlusArc;
import org.spectrum3847.robot.commands.auto.modes.LeftSWTwoAndHalf;
import org.spectrum3847.robot.commands.auto.modes.LeftScale2Cube;
import org.spectrum3847.robot.commands.auto.modes.LeftScaleMode;
import org.spectrum3847.robot.commands.auto.modes.LeftSneakyScaleMode;
import org.spectrum3847.robot.commands.auto.modes.RightSW;
import org.spectrum3847.robot.commands.auto.modes.RightSWOneAndHalf;
import org.spectrum3847.robot.commands.auto.modes.RightSWOneAndHalfPlusArc;
import org.spectrum3847.robot.commands.auto.modes.RightSWTwoAndHalf;
import org.spectrum3847.robot.commands.auto.modes.RightScaleMode;
import org.spectrum3847.robot.commands.auto.modes.RightSneakyScaleMode;
import org.spectrum3847.robot.commands.auto.modes.StraightSW;
import org.spectrum3847.robot.commands.drivetrain.TestVelocityMode;
import org.spectrum3847.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.NeutralMode;

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

	public static GameState gameState = new GameState("RRR");
	
	public static void init() {
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().enable();
        Robot.drive.zeroSensors();
        Robot.drive.difDrive.setSafetyEnabled(false);
    	Robot.drive.setNeutralMode(NeutralMode.Brake);
    	Robot.arm.armSRX.setSelectedSensorPosition(Robot.arm.posCenterUp, 0);
    	Robot.arm.setPos(Arm.Position.CENTER);
		Robot.gameState = new GameState(DriverStation.getInstance().getGameSpecificMessage());
		selectAuto();
		if (SmartDashboard.getBoolean("Auto ENABLED", true)) {
			Debugger.println("Auton Command: " + AutonCommand.getName(),Robot._auton, Debugger.info3);
			if (SmartDashboard.getBoolean("Auto DELAY", false)){
				new WaitBeforeAuton(Robot.prefs.getNumber("A: Delay Time", 0), AutonCommand).start();
			} else {
				AutonCommand.start();
			}
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
				|| isRight != Robot.prefs.getBoolean("1A: On Right Side", false)
				|| Autonomous.gameState != Robot.gameState) {
			
			Autonomous.gameState = Robot.gameState;
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
				AutoName = "Center SW Spline";
				if(Robot.gameState.mySwitchSide == Side.LEFT) {
					AutonCommand = new LeftSWTwoAndHalf();
				} else {
					AutonCommand = new RightSWTwoAndHalf();
				}
				break;
			}
			case (3): {
				AutoName = "Left Straight or SW";
				if(Robot.gameState.mySwitchSide == Side.LEFT) {
					AutonCommand = new LeftSW();
				} else {
					AutonCommand = new DriveForTime(3,.6);
				}
				break;
			}				
			case (4): {
				AutoName = "Right Straight or SW";
				if(Robot.gameState.mySwitchSide == Side.RIGHT) {
					AutonCommand = new RightSW();
				} else {
					AutonCommand = new DriveForTime(3,.6);
				}
				break;
			}				
			case (5): {
				AutoName = "Left SW Straight";
				if(Robot.gameState.mySwitchSide == Side.LEFT) {
					AutonCommand = new StraightSW();
				} else {
					AutonCommand = new DriveForTime(3,.6);
				}
				break;
			}	
			case (6): {
				AutoName = "Right SW Straight";
				if(Robot.gameState.mySwitchSide == Side.RIGHT) {
					AutonCommand = new StraightSW();
				} else {
					AutonCommand = new DriveForTime(3,.6);
				}
				break;
			}	
			
			case (10): {
				AutoName = "Cross Line No Sensors";
				AutonCommand = new DriveForTime(3,.6);
				break;
			}
			case (11):{
				AutoName = "Cross The Line";
				AutonCommand = new FollowTrajectory(new CrossTheLine());
				break;
			}		
			
			case (20):{
				AutoName = "Left Scale or straight";
				if(Robot.gameState.scaleSide == Side.LEFT) {
						AutonCommand = new LeftScaleMode();
				} //else if (Robot.gameState.mySwitchSide == Side.LEFT) {
					//AutonCommand = new LeftSW();
				 else {
					AutonCommand = new FollowTrajectory(new CrossTheLine());
				}
				break;
			}
			
			case (21):{
				AutoName = "Right Scale or straight";
				if(Robot.gameState.scaleSide == Side.RIGHT) {
						AutonCommand = new RightScaleMode();
				} //else if (Robot.gameState.mySwitchSide == Side.RIGHT) {
				//	AutonCommand = new RightSW();
				 else {
					AutonCommand = new FollowTrajectory(new CrossTheLine());
				}
				break;
			}
			
			case (22):{
				AutoName = "Left Sneaky Scale or RightSW or straight";
				if(Robot.gameState.scaleSide == Side.LEFT) {
						AutonCommand = new LeftSneakyScaleMode();
				} //else if (Robot.gameState.mySwitchSide == Side.LEFT) {
					//AutonCommand = new LeftSW();
				 else {
					 if(Robot.gameState.mySwitchSide == Side.LEFT) {
							AutonCommand = new LeftSW();
						} else {
							AutonCommand = new FollowTrajectory(new CrossTheLine());
						}
				}
				break;
			}			
			
			case (23):{
				AutoName = "Right Sneaky Scale or LeftSW or straight";
				if(Robot.gameState.scaleSide == Side.RIGHT) {
						AutonCommand = new RightSneakyScaleMode();
				} //else if (Robot.gameState.mySwitchSide == Side.LEFT) {
					//AutonCommand = new LeftSW();
				 else {
					 if(Robot.gameState.mySwitchSide == Side.RIGHT) {
							AutonCommand = new RightSW();
						} else {
							AutonCommand = new FollowTrajectory(new CrossTheLine());
						}
				}
				break;
			}	
			
			
			
			case (31):{
				AutoName = "Center SW Spline + Arc Scale";
				if(Robot.gameState.mySwitchSide == Side.LEFT) {
					AutonCommand = new LeftSWOneAndHalfPlusArc();
				} else {
					AutonCommand = new RightSWOneAndHalfPlusArc();
				}
				break;
			}
			
			case (88):{
				AutoName = "Arc to scale left";
				AutonCommand = new FollowTrajectory(new ArcLeft());
				break;
			}		
			case (89):{
				AutoName = "Left Scale 2";
				AutonCommand = new LeftScale2Cube();
				break;
			}
			case (90):{
				AutoName = "Left Multi Cube Auto";
				AutonCommand = new LeftSWOneAndHalf();
				break;
			}
			case (94):{
				AutoName = "-90 Test IPT Turn Mode";
				AutonCommand = new InPlaceTurn(-90);
				break;
			}
			case (95):{
				AutoName = "45 Test IPT Turn Mode";
				AutonCommand = new InPlaceTurn(45);
				break;
			}
			case (96):{
				AutoName = "Five Feet and Turn";
				AutonCommand = new FollowTrajectory(new FiveFeetAndTurn());
				break;
			}
			case (97):{
				AutoName = "Five Feet Straight";
				AutonCommand = new FollowTrajectory(new FiveFeet());
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
