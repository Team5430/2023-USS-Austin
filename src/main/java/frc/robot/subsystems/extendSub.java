package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class extendSub extends SubsystemBase {
    
    private static TalonSRX extendSRX = new TalonSRX(Constants.CANid.kExtendSRX);
   static TalonSRXConfiguration E_configSRX = new TalonSRXConfiguration();
   Timer eTimer = new Timer();

    public static void ExtenderSRXsettings(){
    //SRX Settings
         E_configSRX.peakCurrentLimit = 40; //Peak amps before it reduces it
         E_configSRX.peakCurrentDuration = 1300; //Amount of time it allows for the Talon's to stay at peak amps(in miliseconds)
         //Sets settings
     extendSRX.configAllSettings(E_configSRX);
    }
    //method for extending arm using CoPilot
    public void extending(double axis){
     extendSRX.set(ControlMode.PercentOutput, axis);
    }
    public void extendTime(double time, double power){
    
    if(eTimer.get() < time){
        extendSRX.set(ControlMode.PercentOutput, power);}
        else 
    {eTimer.reset(); 
        eTimer.stop();}

    }

    }
