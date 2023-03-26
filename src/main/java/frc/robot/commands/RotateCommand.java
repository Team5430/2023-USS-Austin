// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RotateSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;


/** An example command that uses an example subsystem. */
public class RotateCommand extends CommandBase {

  private final RotateSubsystem m_rotateSubsystem;
  
  private final TalonSRX rTalonSRX = new TalonSRX(6);

  public Joystick controller0Joystick = new Joystick(0);
  public double getYaxisRight(Joystick controller0Joystick)
  {
    return controller0Joystick.getRawAxis(1) * 0.9;
  }
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RotateCommand(RotateSubsystem subsystem) {
    m_rotateSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    rTalonSRX.set(ControlMode.PercentOutput, getYaxisRight(controller0Joystick));
    addRequirements(subsystem);
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
    return false;
  }
}
