// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoSelection;
import frc.robot.commands.Auto_one;
import frc.robot.subsystems.rotationSub;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.extendSub;
import frc.robot.subsystems.gripperSub;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final driveTrain m_DriveTrain = new driveTrain();
  private final rotationSub m_armSub = new rotationSub();
  private final gripperSub m_gripperSub = new gripperSub();
  private final extendSub m_extendSub = new extendSub();


//Joysticks for driver
public final static CommandJoystick m_JoystickLeft = new CommandJoystick(OperatorConstants.kLeftJoystickPort);
public final static CommandJoystick m_JoystickRight = new CommandJoystick(OperatorConstants.kRightJoystickPort);
// co-pilot controller
public final static CommandJoystick m_Controller0 = new CommandJoystick(OperatorConstants.kCoPilotPort);
 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

      //drive
    m_DriveTrain.setDefaultCommand(
      new RunCommand(() -> m_DriveTrain.Drive(m_JoystickLeft.getY(), m_JoystickRight.getY()),m_DriveTrain));
      //rotate arm
    m_armSub.setDefaultCommand(
      new RunCommand(() -> m_armSub.rotating(m_Controller0.getRawAxis(0)), m_armSub));
      //gripper control
    m_gripperSub.setDefaultCommand(
      new RunCommand(() -> m_gripperSub.gripping(RobotContainer.m_Controller0.getRawAxis(2) - RobotContainer.m_Controller0.getRawAxis(3)), m_gripperSub));
      //extending control
    m_extendSub.setDefaultCommand(
      new RunCommand(() -> m_extendSub.extending(RobotContainer.m_Controller0.getRawAxis(5)), m_extendSub));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings(){
//Co-Pilot controls
    Trigger joyButtonLeft = m_JoystickLeft.button(3);
    Trigger joyButtonRight = m_JoystickRight.button(3);
    Trigger calibButton = m_Controller0.button(2);
    Trigger zeroYaw = m_Controller0.button(3);
    
    joyButtonLeft.onTrue(new InstantCommand(m_DriveTrain:: VariableSpeedIncrease, m_DriveTrain));
    joyButtonRight.onTrue(new InstantCommand(m_DriveTrain:: VariableSpeedDecrease, m_DriveTrain));
    calibButton.onTrue(new InstantCommand(m_DriveTrain:: calibrateGyro));
    zeroYaw.onTrue(new InstantCommand(m_DriveTrain:: gyro0Yaw));
  }


}
  
 
