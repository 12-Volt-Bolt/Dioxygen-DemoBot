/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.driveCommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.TankDrive;
import frc.robot.subsystems.Drivebase.driveSubsystemKeys;

public class BasicTankDrive extends Command {

  private Drivebase drivebase = Robot.drivebase;
  private XboxController driveCon = Robot.driveController;

  public BasicTankDrive() {
    requires(drivebase);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivebase.setKey(driveSubsystemKeys.tankSub);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    TankDrive.arcadeDrive(driveCon.getY(Hand.kLeft), -driveCon.getX(Hand.kRight));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivebase.Stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Drivebase.Stop();
  }
}
