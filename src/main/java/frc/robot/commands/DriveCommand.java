// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.driveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;


/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {

  public final driveTrain m_driveTrain;
  

  //Replace with actual numbers later -------------------------- !!!!!!
  private static double[] variableSpeed = {4, 2, 0, 6, 9};

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(driveTrain subsystem) {
    m_driveTrain = subsystem;
    
    // Use addRequirements() here to declare subsystem dependencies
    
    addRequirements(subsystem);
  }
  public double getLeftYaxis(Joystick joy){
    return joy.getY();
  }
  public double getRightYaxis(Joystick joy){
    return joy.getY();
  }
  public double getVariableSpeed(int speedVarIndex){
   return variableSpeed[speedVarIndex];
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }

}

