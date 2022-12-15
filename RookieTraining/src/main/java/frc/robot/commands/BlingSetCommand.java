package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;

public class BlingSetCommand extends CommandBase{


    public class BlingSetCommand(){
        addRequirments(Bling);
    }

    @Override
    public void intialize(){
        bling.setRGBALL(31, 166,76);
    }

    @Override
    public void execute(){
        bling.setRawButton(1);
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}