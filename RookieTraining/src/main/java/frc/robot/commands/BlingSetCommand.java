package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Bling;
import frc.robot.subsystems.OI;

public class BlingSetCommand extends CommandBase {
    Bling bling;
    OI oi;

    public BlingSetCommand(Bling bling_, OI oi_){
        bling = bling_;
        oi = oi_;
        addRequirements(bling);
    }

    @Override
    public void initialize() {
        bling.setRGBAll(31, 166, 75);
    }

    @Override
    public void execute(){
        if(oi.getRawButton(1)){
            bling.setRGBAll(255, 0, 0);
        }
        else if(oi.getRawButton(2)){
            bling.setRGBAll(0, 255, 0);
        }
        else if(oi.getRawButton(3)){
            bling.setRGBAll(100, 20, 60);
        }
        else if(oi.getRawButton(4)){
            bling.setRGBAll(10, 200, 80);
        }
        else{
            bling.setRGBAll(0, 0, 255);        }
    }

    @Override
    public void end(boolean interrupted){
        bling.setRGBAll(0,0,0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
 }