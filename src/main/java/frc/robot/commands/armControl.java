package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.armSub;
import edu.wpi.first.wpilibj2.command.CommandBase;


/**

 * A simple command that grabs a hatch with the {@link armSub}. {@link

 * edu.wpi.first.wpilibj2.command.InstantCommand}.

 */

public class armControl extends CommandBase {

  // The subsystem the command runs on
  private armSub m_armSub;

  public void rotate_arm(armSub subsystem) {

    m_armSub = subsystem;
    addRequirements(m_armSub);
  }

  @Override
  public void initialize() { 
    m_armSub.rotating(RobotContainer.m_Controller0.getRawAxis(0));
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}