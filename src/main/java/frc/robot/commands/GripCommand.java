package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;



public class GripCommand extends CommandBase {
    private final TalonSRX gTalonSRX = new TalonSRX(7);
    public class GripperAuto{
        //private static double gripperStrengthCube = 1;
        //private static double gripperStrengthCone = 2;
        public GripperAuto(String openGrip, String cubeOrCone){
            switch (cubeOrCone){
                case "cone":
                    System.out.println("Cone Selected");
                    // change values of motor strength to gripper strength cone
                    break;
                case "cube":
                default:
                    System.out.println("Cube Selected");
                    // change values of motor strength to gripper strength cube
                    break;
            }
            switch (openGrip){
                case "close":
                    System.out.println("Closing Grip");
                    // closes grip    
                    break;
                case "open":
                default:
                    System.out.println("Opening Grip");
                    break;
                    // opens grip
            }
        }
    }
}