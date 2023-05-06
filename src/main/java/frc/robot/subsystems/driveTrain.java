package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase  {

   final static  WPI_TalonFX backRightMotor = new WPI_TalonFX(Constants.CANid.kBackRightFX);
   final static  WPI_TalonFX backLeftMotor = new WPI_TalonFX(Constants.CANid.kBackLeftFX);
   final static  WPI_TalonFX frontRightMotor = new WPI_TalonFX(Constants.CANid.kFrontRightFX);
   final static  WPI_TalonFX frontLeftMotor = new WPI_TalonFX(Constants.CANid.kBackLeftFX);
      //organizes motor conrollers into groups, left and right respectively
    final MotorControllerGroup leftGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
    final MotorControllerGroup rightGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
    //gyro
    final static AHRS ahrs = new AHRS(Port.kUSB1);
    
    

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
      leftGroup.set(left * Constants.multiplier);
      rightGroup.set(-right * Constants.multiplier);
  }
  //VariableSpeed
    public void VariableSpeedIncrease(){
      Constants.multiplier +=.1;
    }
    public void VariableSpeedDecrease(){
      Constants.multiplier -=.1;
    }
    public void calibrateGyro(){  
      // Calibrates the Gyro at beginning of lifetime. DO NOT TOUCH IT WHILE IT IS CALIBRATING!
      ahrs.calibrate();
    }
    public void gyro0Yaw(){
    //Sets Yaw (aka the z-axis)
    ahrs.zeroYaw();
   }  
   
     public static double getGyroAngle(){
      return ahrs.getAngle();
    }
    
    public static double getGyroPitch(){
      return ahrs.getPitch();
    }

    public static double getGyroYaw(){
      return ahrs.getYaw();
    }

    public static double getGyroroll(){
      return ahrs.getRoll();
    }

    public static double getAccelX(){
      return ahrs.getRawAccelX();
    }

    public static double getAccelY(){
    return ahrs.getWorldLinearAccelY();
    }

    public static double getAccelz(){
      return ahrs.getWorldLinearAccelZ();
    }
    public static double getX(){
      return ahrs.getRawGyroX();
    }
    public static double getY(){
      return ahrs.getRawGyroY();
    }
  
    
  //if you want to add anything, make other functions to use                                                                                                                                  

}

  



