package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BlingSubsystem extends SubsystemBase
{
    public AddressableLED led;
    public AddressableLEDBuffer led_buffer;

    public BlingSubsystem()
    {
        led = new AddressableLED(0);
        led_buffer = new AddressableLEDBuffer(60);
        
        led.setData(led_buffer);
        led.start();
    }

    public void setRGB(int i, int r, int g, int b)
    {  
        led_buffer.setRGB(i, r, g, b);
         
        led.setData(led_buffer);
    }

    public void setHSV(int i, int h, int s, int v)
    {
        led_buffer.setHSV(i, h, s, v);

        led.setData(led_buffer);
    }

    public void setAllRGB(int r, int g, int b)
    {
        for (var i = 0; i < led_buffer.getLength(); i++) 
        {
            led_buffer.setRGB(i, r, g, b);
        }
         
        led.setData(led_buffer);
    }

    public void setAllHSV(int h, int s, int v)
    {
        for (var i = 0; i < led_buffer.getLength(); i++) 
        {
            led_buffer.setHSV(i, h, s, v);
        }
         
        led.setData(led_buffer);
    }

    @Override
    public void periodic()
    {

    }
}
