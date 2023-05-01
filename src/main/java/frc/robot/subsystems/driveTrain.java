package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrain extends SubsystemBase  {


   final static  WPI_TalonFX backRightMotor = new WPI_TalonFX(1);
   final static  WPI_TalonFX backLeftMotor = new WPI_TalonFX(2);
   final static  WPI_TalonFX frontRightMotor = new WPI_TalonFX(3);
   final static  WPI_TalonFX frontLeftMotor = new WPI_TalonFX(4);
      //organizes motor conrollers into groups, left and right respectively
     final MotorControllerGroup leftGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
   final   MotorControllerGroup rightGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
//Motor settings
public static void driveSettings(){
      SupplyCurrentLimitConfiguration configTalonCurrent = new SupplyCurrentLimitConfiguration(true,55,0,0);
          frontRightMotor.configSupplyCurrentLimit(configTalonCurrent);
          frontLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
          backLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
          backRightMotor.configSupplyCurrentLimit(configTalonCurrent); 
          
}
//drive with input     
    public void Drive(double left, double right){
      leftGroup.set(left);
      rightGroup.set(right);
    }
  }



