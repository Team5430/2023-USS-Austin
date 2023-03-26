package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;;

public class driveTrain extends SubsystemBase {
    
    
   
    //Joysticks
    public static Joystick joystickLeft = new Joystick(1);
    public static Joystick joystickRight = new Joystick(2);

  public void Drive() {
        SupplyCurrentLimitConfiguration configTalonCurrent = new SupplyCurrentLimitConfiguration(true,55,0,0);
          ((TalonFX) Constants.frontRightMotor).configSupplyCurrentLimit(configTalonCurrent);
          ((TalonFX) Constants.frontLeftMotor).configSupplyCurrentLimit(configTalonCurrent);
          ((TalonFX) Constants.backLeftMotor).configSupplyCurrentLimit(configTalonCurrent);
          ((TalonFX) Constants.backLeftMotor).configSupplyCurrentLimit(configTalonCurrent);

//made negative so they don't run in opposite directions
      ((WPI_TalonFX) Constants.leftGroup).set(getLeftYaxis(joystickLeft));

      ((WPI_TalonFX) Constants.rightGroup).set(getRightYaxis(joystickRight));
    }
    public double getLeftYaxis(Joystick Port){
      return Port.getY();
    }
    public double getRightYaxis(Joystick Port){
      return Port.getY();
    }
    
    
  
}
