package com.frc.team5430.motors;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.controller.PIDController;


public class RoboTires extends WPI_TalonFX{

//constants
private double ratio;
private double circumferenceInInches;
private double inches = 12;
private double totalInches;
private double motorRotations;
private double encoderTicks = 2048;

    public RoboTires(int CANid){
        super(CANid);
    }

    //individually control motors for distance.
public void driveInDistance(RoboTires motor, double feet){

totalInches = feet * inches;

motorRotations = (totalInches/circumferenceInInches) * ratio;

motor.set(ControlMode.Position, motorRotations * encoderTicks);

}

public void driveInDistance(WPI_TalonFX motor, double feet, PIDController pid){

   
totalInches = feet * inches;

motorRotations = (totalInches/circumferenceInInches) * ratio;

pid.setSetpoint(motorRotations * encoderTicks);

    while(motor.getSelectedSensorPosition() < motorRotations * encoderTicks){
motor.set(ControlMode.PercentOutput, pid.calculate(motor.getSelectedSensorPosition()));

}
    }


public void setCircumference(double diameter){
 circumferenceInInches = diameter * Math.PI;
 }

public double getCircumference(){
    return circumferenceInInches;
}

public void setRatio(double Gratio){
    ratio = Gratio;
}

public double getRatio(){
    return ratio;
}

}