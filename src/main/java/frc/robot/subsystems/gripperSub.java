package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class gripperSub extends SubsystemBase{

    private static TalonSRX gripperSRX = new TalonSRX(Constants.CANid.kGripperSRX);
    static TalonSRXConfiguration G_configSRX = new TalonSRXConfiguration();
    static Timer gTimer = new Timer();

    public static void GripperSRXsettings(){
    //SRX Settings
        G_configSRX.peakCurrentLimit = 40; //Peak amps before it reduces it
        G_configSRX.peakCurrentDuration = 1300; //Amount of time it allows for the Talon's to stay at peak amps(in miliseconds)
        //Sets settings
    gripperSRX.configAllSettings(G_configSRX);
    }
    //move arm
    public void gripping(double axis){
        gripperSRX.set(ControlMode.PercentOutput, axis * .35);
    }

    public static void gripinPower(double power){
        gripperSRX.set(ControlMode.PercentOutput, power);
    }

    public static void gripinTime(double time, double power){
        
        if(gTimer.get() < time){
            gripperSRX.set(ControlMode.PercentOutput, power);}
        else 
    {gTimer.reset();
        gTimer.stop();}

    }
//Same thing for gripinTime, but reverse poleraity
    public static void releasingTime(double time, double power){
        
        if(gTimer.get() < time){
            gripperSRX.set(ControlMode.PercentOutput, -power);}
        else 
    {gTimer.reset();
        gTimer.stop();}

    }

}