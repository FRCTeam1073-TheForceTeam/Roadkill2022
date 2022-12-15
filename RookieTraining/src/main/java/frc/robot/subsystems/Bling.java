// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Bling extends SubsystemBase {
  /** Creates a new Bling. */
  public AddressableLED m_Led;
  public AddressableLEDBuffer m_LedBuffer;

  public int ledR = 0;
  public int ledG = 0;
  public int ledB = 0;

  public Bling() {
    m_Led = new AddressableLED(0);
    m_LedBuffer = new AddressableLEDBuffer(8);
    m_Led.setLength(m_LedBuffer.getLength());
    m_Led.setData(m_LedBuffer);
    m_Led.start();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_Led.setData(m_LedBuffer);
  }

  public void setRGB(int i, int r, int g, int b){
    m_LedBuffer.setRGB(i, r, g, b);
  }

  public void setRGBAll(int r, int g, int b){
    ledB = r;
    ledG = g;
    ledB = b;
    for(int i = 0; i < m_LedBuffer.getLength(); i++){
      m_LedBuffer.setRGB(i, r, g, b);
    }
  }
}
