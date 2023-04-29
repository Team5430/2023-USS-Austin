package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrain extends SubsystemBase  {


   final   WPI_TalonFX backRightMotor = new WPI_TalonFX(1);
   final   WPI_TalonFX backLeftMotor = new WPI_TalonFX(2);
  final  WPI_TalonFX frontRightMotor = new WPI_TalonFX(3);
  final     WPI_TalonFX frontLeftMotor = new WPI_TalonFX(4);
      //organizes motor conrollers into groups, left and right respectively
     final MotorControllerGroup leftGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
   final   MotorControllerGroup rightGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
//Motor settings
public void driveSettings(){
      SupplyCurrentLimitConfiguration configTalonCurrent = new SupplyCurrentLimitConfiguration(true,55,0,0);
          frontRightMotor.configSupplyCurrentLimit(configTalonCurrent);
          frontLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
          backLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
          backRightMotor.configSupplyCurrentLimit(configTalonCurrent); 
          
}
      //drive with input 
    
    public void Drive(double left, double right){
      leftGroup.set(leftPower());
      rightGroup.set(rightPower());
    }
    Joystick joystickLeft = new Joystick(1);
    Joystick joystickRight = new Joystick(2);

    public double leftPower(){
      return joystickLeft.getY() ;
    } 
    public double rightPower(){
      return joystickRight.getY();
    }
    
  }



