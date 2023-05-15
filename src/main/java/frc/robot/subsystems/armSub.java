package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class armSub extends SubsystemBase{
    private TalonSRX extendSRX = new TalonSRX(Constants.CANid.kExtendSRX);
    

}