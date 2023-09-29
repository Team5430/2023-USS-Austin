package frc.robot.commands;

import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.rotationSub;
import frc.robot.subsystems.gripperSub;
import frc.robot.subsystems.extendSub;
import frc.robot.Constants;
import frc.robot.Robot;

import org.ejml.equation.IntegerSequence.Combined;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


//sequential command groups go by steps. 
//ex. step one first *then* step two and so on.
public class Auto_two extends CommandBase {
  /** 
   *   * @param drive The drive subsystem this command will run on
   * 
   */
  public Auto_two(driveTrain drive) {
    //bring arm upwards to postion for scoring
    rotationSub.rotateinTime(2.5, -0.9);
    ///extend out arm 
    extendSub.extendPower( 0.35);
    // let out cargo; bring claws out
    gripperSub.gripinTime(1, -0.5);   
    //bring in claws back in
    gripperSub.gripinTime(1, 0.5);
    //retracts arm back into position 
    extendSub.extendPower(-0.35);
    //rotates arm back into position
    rotationSub.rotateinTime(2.5, 0.9);
    
    drive.driveInDistance(24, 0.5);

    Robot.autoStatus = 2;


  }
}