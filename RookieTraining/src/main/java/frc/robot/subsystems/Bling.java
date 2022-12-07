// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Bling extends SubsystemBase {
  public AddressableLED m_led;
  public AddressableLEDBuffer m_ledBuffer;

  public int ledR = 0;
  public int ledG = 0;
  public int ledB = 0;

  public Bling() {
    m_led = new AddressableLED(0);
    m_ledBuffer = new AddressableLEDBuffer(8);
    m_led.setLength(m_ledBuffer.getLength());
    m_led.setData(m_ledBuffer);
    m_led.start();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      m_led.setData(m_ledBuffer);
   }

  public void setRGB(int i,int r, int g, int b) {
    m_ledBuffer.setRGB(i, r, g, b);
  }

  public void setRGBAll(int r, int g, int b) {
    ledR = r;
    ledG = g;
    ledB = b;
    for (var i = 0; i < (m_ledBuffer.getLength()); i++) {
      m_ledBuffer.setRGB(i, r, g, b);
    }
  }

}