package frc.robot.subsytems;


public class Bling extends SubsytemsBase{
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
    }

    @Overide
    public void periodic(){
        m_Led.setData(m_LedBuffer);
    }

    public void setRGB(int i, int r, int g, int b) {
        m_LedBuffer.setRGB(i, r, g, b);
    }

    public void RGBAll(int r, int g, int b) {
        ledB = r;
        ledG = g;
        ledB = b;
        for(int i = 0; i < m_LedBuffer.getLength(); i++) {
            m_LedBuffer.setRGB(i, r, g, b);
        }
    }
}