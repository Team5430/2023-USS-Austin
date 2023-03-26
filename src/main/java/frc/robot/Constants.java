// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class CANid{
    public static WPI_TalonFX backRightMotor = new WPI_TalonFX(2);
    public static WPI_TalonFX backLeftMotor = new WPI_TalonFX(3);
    public static WPI_TalonFX frontRightMotor = new WPI_TalonFX(4);
    public static WPI_TalonFX frontLeftMotor = new WPI_TalonFX(5);
    //organizes motor conrollers into groups, left and right respectively
    static MotorControllerGroup leftGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
    static MotorControllerGroup rightGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
    //creates a differential (tank) drive out of the two motor controller groups
    public static DifferentialDrive driveTrain = new DifferentialDrive(leftGroup, rightGroup);
    public static final int kRotateSRX = 6;
    public static final int kGripperSRX = 7;
    public static final int kExtendSRX = 8;
    public static final int kSpareSRX = 9;

  }
  public static class OperatorConstants {
    public static final int kCoPilotPort = 0;
      
    public static final int kLeftJoystickPort = 1;
    public static final int kRightJoystickPort = 2;
  }
public static TalonFX backRightMotor;
public static TalonFX frontLeftMotor;
public static TalonFX backLeftMotor;
public static TalonFX frontRightMotor;
public static Object leftGroup;
public static Object rightGroup;
}
