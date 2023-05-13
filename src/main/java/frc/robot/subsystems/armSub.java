package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

import frc.robot.Constants;
import frc.robot.Constants.CANid;;

public class armSub extends SubsystemBase{
    private TalonSRX rotateSRX = new TalonSRX(Constants.CANid.kRotateSRX);
    private TalonSRX extendSRX = new TalonSRX(Constants.CANid.kExtendSRX);
    TalonSRXConfiguration configSRX = new TalonSRXConfiguration();

public void SRXsettings(){
//Settings
configSRX.peakCurrentLimit = 40; //Peak amps before it reduces it
configSRX.peakCurrentDuration = 1300; //Amount of time it allows for the Talon's to stay at peak amps(in miliseconds)
    //sets settings to the Talons
    rotateSRX.configAllSettings(configSRX);
    extendSRX.configAllSettings(configSRX);

}

    public void rotating(double axis){
        rotateSRX.set(ControlMode.PercentOutput, axis);
    }

    public void extending(double axis){
        extendSRX.set(ControlMode.PercentOutput, axis);
    }
        
     
    

}
