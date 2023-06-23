package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class rotationSub extends SubsystemBase{
    private static TalonSRX rotateSRX = new TalonSRX(Constants.CANid.kRotateSRX);
    static TalonSRXConfiguration R_configSRX = new TalonSRXConfiguration();

public static void RotaterSRXsettings(){
    //SRX Settings
        R_configSRX.peakCurrentLimit = 40; //Peak amps before it reduces it
        R_configSRX.peakCurrentDuration = 1300; //Amount of time it allows for the Talon's to stay at peak amps(in miliseconds)
    //sets settings to the Talons
    rotateSRX.configAllSettings(R_configSRX);
    }
//method for rotating arm using CoPilot
    public void rotating(double axis){
        rotateSRX.set(ControlMode.PercentOutput, axis);
    }    
}
