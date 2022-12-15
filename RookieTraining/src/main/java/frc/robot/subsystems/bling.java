package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;

import edu.wpi.first.wpilibj.AddressableLEDBuffer;

import edu.wpi.first.wpilibj.command.SubsystemBase;


public class Bling extends Subsytems{
    public AddressableLED m_LED;
    public AddressableLEDBugger m_LedBuffer;

    public int ledR = 0;
    public int ledG = 0;
    public int ledB = 0;

    public Bling(){
        m_LED = new AddressableLED(0);
        m_LedBuffer = new AddressableLEDBuffer(8);
        m_LED.setLength(m_LEDBuffer.getLength());
        m_LED.setData(m_LEDBuffer);
        m_LED.start();
    }

    @Override
    public void periodic(){
        m_LED.setData(m_LedBuffer);
    }

    public void setRGB(int i, int r, int g, int b){
        m_LEDBuffer.setRGB(i , r, g, b);
    }

    public void setRGBALL(int r, int g, int b){
        LedB = r;
        LedG = g;
        LedB = b;
        for(int i = 0; i<m_LEDBuffer.getLength(); i++){
            m_LEDBuffer.setRGB(i ,r ,g , b);
        }
    }
}