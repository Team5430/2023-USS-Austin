package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.extendSub;
import frc.robot.subsystems.gripperSub;
import frc.robot.subsystems.rotationSub;

public class Autos {

  public static CommandBase defaultAutonomous(driveTrain drive){
    return Commands.sequence(rotationSub.C_rotateinTime(5,.3), extendSub.C_extendTime(2.5,.3), gripperSub.C_gripinTime(1,.3),
    extendSub.C_extendTime(5, -.3), gripperSub.C_gripinTime(1, -.3), rotationSub.C_rotateinTime(5, -.3)); 
}
  private Autos(){
    throw new UnsupportedOperationException("This is where we contain our autos!");
  }
}

