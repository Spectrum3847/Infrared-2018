package org.spectrum3847.robot.commands.auto.modes;

import org.spectrum3847.paths.*;
import org.spectrum3847.robot.Robot;
import org.spectrum3847.robot.commands.FollowTrajectory;
import org.spectrum3847.robot.commands.arm.ArmFwdHome;
import org.spectrum3847.robot.commands.arm.ArmMotionMagicHold;
import org.spectrum3847.robot.commands.arm.ArmMotionMagicPos;
import org.spectrum3847.robot.commands.arm.ArmRevHome;
import org.spectrum3847.robot.commands.arm.SetArmPos;
import org.spectrum3847.robot.commands.auto.DriveToScale;
import org.spectrum3847.robot.commands.auto.DriveForTime;
import org.spectrum3847.robot.commands.auto.DriveUntilWall;
import org.spectrum3847.robot.commands.intake.EjectCube;
import org.spectrum3847.robot.commands.intake.IntakeOn;
import org.spectrum3847.robot.commands.intake.IntakeStop;
import org.spectrum3847.robot.commands.intake.IntakeUntilCurrent;
import org.spectrum3847.robot.commands.intake.OpenIntakeOn;
import org.spectrum3847.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSWOneAndHalfPlusArc extends CommandGroup {
	
	double ejectCubeTime = 0.5;

	public LeftSWOneAndHalfPlusArc() {
		super("CeneterSWpigeon");
		//If the switch is on the left make sure we turn before driving
		this.addParallel(new SetArmPos(Arm.Position.FwdPortal)); //Arm to 2nd Cube Position
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter()),4);
		//this.addSequential(new DriveUntilWall());
		this.addParallel(new EjectCube(), ejectCubeTime);
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter2()),6);
		this.addSequential(new ArmFwdHome());
		this.addParallel(new OpenIntakeOn(1));
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter3()),4);
		this.addParallel(new IntakeOn(1),1);
		this.addSequential(new DriveToScale());//Only used to end with a cube in hand
		/*this.addParallel(new IntakeOn(1));
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter3()),5); //Drive Forward
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter4()),5); //Backup
		this.addParallel(new SetArmPos(Arm.Position.FwdPortal)); //Raise Arm
		this.addParallel(new IntakeStop());
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter5()),5); //Drive to switch
		this.addSequential(new EjectCube(), ejectCubeTime);
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter6()),5);//Back to Center
		this.addSequential(new ArmMotionMagicPos(Robot.arm.pos2ndRowCube),5); //Arm to 2nd Cube Position
		this.addParallel(new ArmMotionMagicHold());//Hold Arm Position
		this.addParallel(new IntakeOn(1)); // Turn intake on
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter7()),5); //Drive Fwd and Intake
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter8()),5); //Backup
		this.addParallel(new IntakeStop()); // Turn intake off
		this.addParallel(new SetArmPos(Arm.Position.FwdPortal)); //Raise Arm
		this.addSequential(new FollowTrajectory(new LeftSwitchCenter9()),5); //Drive Back to Switch
		this.addSequential(new EjectCube(), ejectCubeTime);
		*/
		
	}


}
