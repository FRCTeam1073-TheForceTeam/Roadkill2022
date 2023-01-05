// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  // Define devices here:
  public WPI_TalonFX testMotor;
  public int ticksPerRevolution = 2048;

  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    // Initialize devices here:
    testMotor = new WPI_TalonFX(46);
    testMotor.configFactoryDefault();
    testMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    testMotor.setSelectedSensorPosition(0);
    SmartDashboard.putNumber("Motor percent Output", getVelocity());
  }

  public double getPosition() {
    return testMotor.getSelectedSensorPosition() * (2 * Math.PI) / ticksPerRevolution;
  }

  public double getVelocity() {
    return testMotor.getSelectedSensorVelocity() * (2 * Math.PI) * 10.0 / ticksPerRevolution;
  }

  public double getMotorTemperature() {
    return testMotor.getTemperature();
  }

  public void setPower(double power) {
    testMotor.set(ControlMode.PercentOutput, power*.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Motor Velocity", getVelocity());
    SmartDashboard.putNumber("Motor Position", getPosition());
    SmartDashboard.putNumber("Motor Temperatur", getMotorTemperature());
   // power = SmartDashboard.getNumber("Motor percent Output", power);
  }
}
