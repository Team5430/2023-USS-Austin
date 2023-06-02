package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class armSub extends SubsystemBase{
    private TalonSRX extendSRX = new TalonSRX(Constants.CANid.kExtendSRX);
    private TalonSRX rotateSRX = new TalonSRX(Constants.CANid.kRotateSRX);
    private TalonSRX gripperSRX = new TalonSRX(Constants.CANid.kGripperSRX);
    TalonSRXConfiguration configSRX = new TalonSRXConfiguration();

public void SRXsettings(){
//Settings
configSRX.peakCurrentLimit = 40; //Peak amps before it reduces it
configSRX.peakCurrentDuration = 1300; //Amount of time it allows for the Talon's to stay at peak amps(in miliseconds)
    //sets settings to the Talons
    rotateSRX.configAllSettings(configSRX);
    extendSRX.configAllSettings(configSRX);
    gripperSRX.configAllSettings(configSRX);

}
//method for rotating arm using CoPilot
    public void rotating(double axis){
        rotateSRX.set(ControlMode.PercentOutput, axis);
    }
//method for extending arm using CoPilot
    public void extending(double axis){
        extendSRX.set(ControlMode.PercentOutput, axis);
    }
//Allows extending method to be run during the whole match
    {new RunCommand(() -> extending(RobotContainer.m_Controller0.getRawAxis(5)));}

//method for arm gripping using CoPilot
    public void gripping(double axis){
        gripperSRX.set(ControlMode.PercentOutput, axis * .35);
    }
//Allows gripping method to be run during the whole match
    {new RunCommand(() -> rotating(RobotContainer.m_Controller0.getRawAxis(2) - RobotContainer.m_Controller0.getRawAxis(3)));}
        
     
    

}