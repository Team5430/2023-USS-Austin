package com.frc.robot.commands;

import com.frc.robot.subsystems.driveTrain;
import com.frc.robot.subsystems.extendSub;
import com.frc.robot.subsystems.gripperSub;
import com.frc.robot.subsystems.rotationSub;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public class Autos {

  public static CommandBase defaultAutonomous(driveTrain drive){
    return Commands.sequence(rotationSub.C_rotateinTime(5,.3), extendSub.C_extendTime(2.5,.3), gripperSub.C_gripinTime(1,.3),
    extendSub.C_extendTime(5, -.3), gripperSub.C_gripinTime(1, -.3), rotationSub.C_rotateinTime(5, -.3)); 
}
  private Autos(){
    throw new UnsupportedOperationException("This is where we contain our autos!");
  }
}

