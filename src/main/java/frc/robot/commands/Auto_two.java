package frc.robot.commands;

import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.rotationSub;
import frc.robot.subsystems.gripperSub;
import frc.robot.subsystems.extendSub;
import frc.robot.Constants;

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
    System.out.println("rotating..");
    rotationSub.rotateinTime(1, 0.6);

    System.out.println("Raising my arm!!!! RRAAAAHHHH!!!");
    extendSub.extendTime(0.5, 0.6);

    System.out.println("Oh lord, get a grip you're coming apart!!!");
    gripperSub.gripinTime(0.8, 0.7);

    System.out.println("Get this thing off my hand >:(");
    gripperSub.releasingTime(0.8, 0.7);

    System.out.println("Retracting..");
    extendSub.retractTime(2, 0.6);

    System.out.println("Reseting the grabbing point");
    gripperSub.gripinTime(0.8, 0.7);

  }
}