package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrain extends SubsystemBase {
    
    
    static WPI_TalonFX backRightMotor = new WPI_TalonFX(2);
    static WPI_TalonFX backLeftMotor = new WPI_TalonFX(3);
    static WPI_TalonFX frontRightMotor = new WPI_TalonFX(4);
    static WPI_TalonFX frontLeftMotor = new WPI_TalonFX(5);
    //organizes motor conrollers into groups, left and right respectively
    static MotorControllerGroup leftGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
    static MotorControllerGroup rightGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
    //creates a differential (tank) drive out of the two motor controller groups
    public static DifferentialDrive driveTrain = new DifferentialDrive(leftGroup, rightGroup);
    static TalonFXConfiguration configs = new TalonFXConfiguration();
    //Joysticks
    public static Joystick joystickLeft = new Joystick(1);
    public static Joystick joystickRight = new Joystick(2);

  public void Drive() {
        SupplyCurrentLimitConfiguration configTalonCurrent = new SupplyCurrentLimitConfiguration(true,55,0,0);
      backRightMotor.configSupplyCurrentLimit(configTalonCurrent);
      frontLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
      backLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
      backLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
//made negative so they don't run in opposite directions
      leftGroup.set(-joystickLeft.getY());

      rightGroup.set(joystickRight.getY());
    }
  
}
