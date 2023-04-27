package frc.robot.subsystems;

import java.lang.module.ResolutionException;
import java.util.Set;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveCommand;

public class driveTrain extends SubsystemBase implements Command {


    public void Drive(){   
      WPI_TalonFX backRightMotor = new WPI_TalonFX(1);
      WPI_TalonFX backLeftMotor = new WPI_TalonFX(2);
      WPI_TalonFX frontRightMotor = new WPI_TalonFX(3);
      WPI_TalonFX frontLeftMotor = new WPI_TalonFX(4);
      //organizes motor conrollers into groups, left and right respectively
      MotorControllerGroup leftGroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
      MotorControllerGroup rightGroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
      //creates a differential (tank) drive out of the two motor controller groups
      DifferentialDrive _driveTrain = new DifferentialDrive(leftGroup, rightGroup);

      SupplyCurrentLimitConfiguration configTalonCurrent = new SupplyCurrentLimitConfiguration(true,55,0,0);
          frontRightMotor.configSupplyCurrentLimit(configTalonCurrent);
          frontLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
          backLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
          backRightMotor.configSupplyCurrentLimit(configTalonCurrent); 

      
      _driveTrain.tankDrive(leftPower(), rightPower());
    }

    
   
    
    public void initDefaultCommand(driveTrain driveTrain) {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand(driveTrain));
        // we will never forget
    }

    @Override
    public Set<Subsystem> getRequirements() {
      // TODO Auto-generated method stub
      return null;
    }
    Joystick joystickLeft = new Joystick(1);
    Joystick joystickRight = new Joystick(2);

   
  
    public double leftPower(){
      return joystickLeft.getY();
    } 
    public double rightPower(){
      return joystickRight.getY();
    }
  }



