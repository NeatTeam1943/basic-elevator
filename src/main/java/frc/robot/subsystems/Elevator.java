package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants.ElevatorConstants;

public class Elevator extends SubsystemBase {
  private CANSparkMax m_motor;

  public Elevator() {
    m_motor = new CANSparkMax(ElevatorConstants.kDeviceID, MotorType.kBrushless);

    /*Convert rotations output to meters */
    m_motor.getEncoder().setPositionConversionFactor(ElevatorConstants.kCircumferenceOfWheelInMeters * ElevatorConstants.kGearRatio);
  }

  public RelativeEncoder getEncoder(){
    return m_motor.getEncoder();
  }

  public void set(double speed){
    m_motor.set(speed);
  }
}
