package com.frc.team5430.motors;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
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

    RoboTires(int CANid){
        super(CANid);
    }

    //individually control motors for distance.
private void driveInDistance(RoboTires motor, double feet){

totalInches = feet * inches;

motorRotations = (totalInches/circumferenceInInches) * ratio;

motor.set(ContorlMode.Position, motorRotations * encoderTicks);

}

private void driveInDistance(RobotTires motor, double feet, PIDController pid){

   
totalInches = feet * inches;

motorRotations = (totalInches/circumferenceInInches) * ratio;

pid.setpoint(motorRotations * encoderTicks);

    while(motor.getSelectedSensorPosition() < motorRotations * encoderTicks){
motor.set(ControlMode.PercentOutput, pid.calculate(motor.getSelectedSensorPosition));

}
    }


private void setCircumference(double diameter){
 circumferenceInInches = diameter * Math.PI;
 }

private double getCircumference(){
    return diameter;
}

private void setRatio(double Gratio){
    ratio = Gratio;
}

private void getRatio(){
    return ratio;
}



}