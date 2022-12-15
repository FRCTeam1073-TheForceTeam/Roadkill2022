// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Bling;
import frc.robot.subsystems.OI;

public class BlingSetCommand extends CommandBase {
  /** Creates a new BlingSetCommand. */
  Bling bling;
  OI oi;
  

  public BlingSetCommand(Bling bling_, OI oi_) {
    // Use addRequirements() here to declare subsystem dependencies.
    bling = bling_;
    oi = oi_;
    addRequirements(bling);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    bling.setRGBALL(2, 3, 132);  //pink/redish
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(oi.getRawButton(1)){
      bling.setRGBALL(52, 3, 173);
    } 
    else if(oi.getRawButton(2)){
      bling.setRGBALL(0, 255, 0);
    } 
    else{
      bling.setRGBALL(0, 0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    bling.setRGBALL(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
