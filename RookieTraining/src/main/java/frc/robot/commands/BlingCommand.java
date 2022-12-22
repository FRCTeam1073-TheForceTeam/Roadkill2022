package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OI;
import frc.robot.subsystems.BlingSubsystem;

public class BlingCommand extends CommandBase
{
    BlingSubsystem bling;
    OI oi;

    public BlingCommand(BlingSubsystem bling_, OI oi_)
    {
        bling = bling_;
        oi = oi_;

        addRequirements(bling);
    }

    @Override
    public void initialize()
    {
        bling.setAllRGB(0, 255, 255);
    }

    @Override
    public void execute()
    {
        bling.setAllHSV((int) (OI.driverController.getRawAxis(0) * 180), (int) (OI.driverController.getRawAxis(1) * 255), 255);
    }

    @Override
    public void end(boolean interrupted)
    {
        bling.setAllRGB(0, 0, 0);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}
