// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
 
public static double multiplier = 0;

  public static class CANid{

    public static final int kRotateSRX = 6;
    public static final int kGripperSRX = 7;
    public static final int kExtendSRX = 8;
    public static final int kSpareSRX = 9;
    //drivetrain
    public static final int kBackRightFX = 1;
    public static final int kBackLeftFX = 2;
    public static final int kFrontRightFX = 3;
    public static final int kFrontLeftFX = 4;

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
public static MotorControllerGroup leftGroup;
public static MotorControllerGroup rightGroup;
public enum _driveTrain {
}
}
