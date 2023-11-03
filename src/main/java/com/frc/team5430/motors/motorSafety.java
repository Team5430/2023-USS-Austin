package com.frc.team5430.motors;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class motorSafety{

double inputing; 
//input should be conencted from you are using to control a motor
//middleman variable should be getting input and outputing input for this to work.
    public motorSafety(WPI_TalonFX motor, double input){
        if(Math.abs(motor.get()) > 0.7){
                inputing =  input * .7;
        }
    }
    //WIP
    public motorSafety(MotorControllerGroup leftGroup, MotorControllerGroup rightGroup, double rightI, double leftI){
        if(Math.abs(leftGroup.get()) > 0.7){
            leftGroup.set(leftI);
        }
        if(Math.abs(rightGroup.get()) > 0.7){
            rightGroup.set(rightI);
        }
    }
    }