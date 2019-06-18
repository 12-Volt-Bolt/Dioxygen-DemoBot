/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.ball_launcher;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap.Pnumatics;

/**
 * Add your docs here.
 */
public class SolenoidControl extends Subsystem {
  
  public static Solenoid topSolenoid = new Solenoid(Pnumatics.topSolenoid.getID());
  public static Solenoid bottomSolenoid = new Solenoid(Pnumatics.bottomSolenoid.getID());

  public static Solenoid[] solenoids = new Solenoid[]{ topSolenoid,bottomSolenoid };

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void solenoidOn(Pnumatics solenoid)
  {
    solenoids[solenoid.getID()].set(true);
  }

  public static void solenoidOff(Pnumatics solenoid)
  {
    solenoids[solenoid.getID()].set(false);
  }

  public static void alternateSolenoid(Pnumatics solenoid)
  {
    Solenoid temp = solenoids[solenoid.getID()];
    temp.set(!temp.get());
  }
}
