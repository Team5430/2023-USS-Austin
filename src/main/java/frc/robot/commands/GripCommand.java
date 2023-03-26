package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GripperSubsystem;

public class GripCommand extends CommandBase {
    private final TalonSRX gTalonSRX = new TalonSRX(7);

}
