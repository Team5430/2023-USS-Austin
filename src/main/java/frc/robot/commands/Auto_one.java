package frc.robot.commands;

import frc.robot.subsystems.driveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


//sequential command groups go by steps. 
//ex. step one first *then* step two and so on.
public class Auto_one extends SequentialCommandGroup {
  /** 
   *   * @param drive The drive subsystem this command will run on
   * @return 
   */
  public void Auto_example(driveTrain drive) {
    addCommands(
    );
  }

}