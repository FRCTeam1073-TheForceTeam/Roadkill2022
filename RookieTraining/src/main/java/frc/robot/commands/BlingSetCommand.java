// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Bling;
import frc.robot.subsystems.OI;

public class BlingSetCommand extends CommandBase {
  Bling bling;
  OI oi;
  
  /** Creates a new BlingSetCommand. */
  public BlingSetCommand(Bling bling_, OI oi_) {
    // Use addRequirements() here to declare subsystem dependencies.
    bling = bling_;
    oi = oi_;
    addRequirements(bling);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    bling.setRGBAll(204,0,204); // Set to PINK
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (oi.getRawButton(1)) {
      bling.setRGBAll(255,0,0); // RED
    } else if (oi.getRawButton(2)) {
      bling.setRGBAll(0,255,0); // GREEN
    } else if (oi.getRawButton(3)) {
      bling.setRGBAll(0,0,255); // BLUE
    } else if (oi.getRawButton(4)) {
      bling.setRGBAll(102,0,204); // PURPLE
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    bling.setRGBAll(0,0,0); // Set to BLACK (OFF)
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}