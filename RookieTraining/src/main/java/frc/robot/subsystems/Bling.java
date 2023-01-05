package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Bling extends SubsystemBase{
    public AddressableLED m_Led;
    public AddressableLEDBuffer m_LedBuffer;

    public int ledR = 0;
    public int ledG = 0;
    public int ledB = 0;

    public Bling(){
        m_Led = new AddressableLED(0);
        m_LedBuffer = new AddressableLEDBuffer(8);
        m_Led.setLength(m_LedBuffer.getLength());
        m_Led.setData(m_LedBuffer);
        m_Led.start();
        SmartDashboard.putNumber("R Value", ledR);
        SmartDashboard.putNumber("G Value", ledG);
        SmartDashboard.putNumber("B Value", ledB);
    }

    @Override
    public void periodic(){
        //Ths method will be called once per scheduler run
        m_Led.setData(m_LedBuffer);
        //SmartDashboard.putBoolean("Update", false);
        //if(SmartDashboard.getBoolean("Update", false)){
            ledR = (int)SmartDashboard.getNumber("R Value", ledR);
            ledG = (int)SmartDashboard.getNumber("G Value", ledG);
            ledB = (int)SmartDashboard.getNumber("B Value", ledB);
            setRGBAll(ledR, ledG, ledB);
    //}
    }

    public void setRGB(int i, int r, int g, int b) {
        m_LedBuffer.setRGB(i, r, g, b);
    }

    public void setRGBAll(int r, int g, int b) {
        ledB = r;
        ledG = g;
        ledB = b;
        for(int i = 0; i < m_LedBuffer.getLength(); i++) {
            m_LedBuffer.setRGB(i, r, g, b);
        }
    }
}