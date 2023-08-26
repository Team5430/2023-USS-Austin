package frc.robot.commands;

import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.rotationSub;
import frc.robot.subsystems.gripperSub;
import frc.robot.subsystems.extendSub;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


//sequential command groups go by steps. 
//ex. step one first *then* step two and so on.
public class Auto_one extends SequentialCommandGroup {
  /** 
   *   * @param drive The drive subsystem this command will run on
   * 
   */
  public Auto_one(driveTrain drive){
    
    drive.driveInDistance(3, 0.3);
  }

}