package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;



public class GripCommand extends CommandBase {
  private TalonSRX gripperSRX = new TalonSRX(Constants.CANid.kGripperSRX);

    // --- { autoArmGripper - auton; checks if you want to GRIP/LETGO of a CUBE/CONE }
    public autoArmGripper(boolean isGripping, String cubeOrCone){
    double motorStrength; // local gripper strength of method
    
    switch (cubeOrCone){ // first checks if you're using cone or cube and adjusts stregth
      case "cube":
        System.out.println("Cube Selected");
        motorStrength = Constants.gripperStrengthCube; // changes localStrength to strength for cube
        break;
        case "cone":
          System.out.println("Cone Selected");
          motorStrength = Constants.gripperStrengthCone; // changes localStrength to strength for cone
          break;
        default:
          System.out.println("Cube Selected");
          motorStrength = Constants.gripperStrengthCube; // if stated improperly, defaults to strength for cube
          break;
      }
      switch (isGripping){ // then checks if you want to grip or not
        case true: // if you want to grip:
          while(s_timer.get() < 1){ // to edit for encoder stuff
            gripperSRX.set(ControlMode.PercentOutput, motorStrength); //increases gripper output by local strength until a second passes
            }
            gripperSRX.set(ControlMode.PercentOutput, 0);
        case false: // if you want to let go of a peice:
          while(s_timer.get() < 1){ // to edit for encoder stuff
            gripperSRX.set(ControlMode.PercentOutput, -motorStrength); //decreases gripper output by local strength until a second passes
            }
            gripperSRX.set(ControlMode.PercentOutput, 0);
        default:// lets go by default
          while(s_timer.get() < 1){ // to edit for encoder stuff
            gripperSRX.set(ControlMode.PercentOutput, -motorStrength); //increases gripper output by local strength until a second passes
            }
            gripperSRX.set(ControlMode.PercentOutput, 0);
     }
    } 
}
