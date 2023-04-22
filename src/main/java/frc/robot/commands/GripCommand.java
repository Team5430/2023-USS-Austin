package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GripperSubsystem;

public class GripCommand extends CommandBase {
    private final TalonSRX gTalonSRX = new TalonSRX(7);
    public class Gripper{
        private static gripperStrengthCube;
        private static gripperStrengthCone;
        public Gripper(boolean isGripping, String cubeOrCone){
            switch (cubeOrCone){
                case "Cube":
                case "CUBE":
                case "cube":
                    System.out.println("Cube Selected");
                    // change values to gripper strength cube
                    break;
                case "Cone":
                case "CONE":
                case "cone":
                    System.out.println("Cone Selected");
                    // change values of motor to gripper strength cone
                    break;
                default:
                    System.out.println("Cube Selected");
                    // change values to gripper strength cube
                    break;
            }
            switch (isGripping){
                
            }
        }
    }
}
