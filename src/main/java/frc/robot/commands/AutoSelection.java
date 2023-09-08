// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.Map;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SelectCommand;
import frc.robot.subsystems.driveTrain;

//WIP autoselector
public final class AutoSelection extends CommandBase {

  private final driveTrain m_dTrain = new driveTrain();

  /** Example static factory for an autonomous command. */
 private enum AutoChoice{
  AUTO_ONE,
  AUTO_TWO,
  AUTO_THREE
 }

 private AutoChoice select() {
//selection to be passed down below
  return AutoChoice.AUTO_ONE;

 }
 private final Command m_autonomousCommand =
      new SelectCommand(
          // Maps selector values to commands
          Map.ofEntries(
                //example of auto being chosen right here!
              Map.entry(AutoChoice.AUTO_ONE, new Auto_one(m_dTrain)),

              Map.entry(AutoChoice.AUTO_TWO, new PrintCommand("Woah, there's errors")),

              Map.entry(AutoChoice.AUTO_THREE, new PrintCommand("What do I put here?"))),
  //select is chosen from above
          this::select);

  
}
