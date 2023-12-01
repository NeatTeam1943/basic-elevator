package frc.robot.commands;

import java.util.Map;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.subsystems.Elevator;

public class Elevate extends CommandBase {
  private Elevator m_elevator;
  private PIDController m_controller;

  private ShuffleboardTab tab = Shuffleboard.getTab(ElevatorConstants.kElevatorTabTitle);
  private double m_range;

  public Elevate(Elevator elevator) {
    m_elevator = elevator;
    m_controller = new PIDController(ElevatorConstants.kP, ElevatorConstants.kI, ElevatorConstants.kD);

    m_range = tab.add(ElevatorConstants.kElevatorRangeWidget, 0) // May not work. We have no previous knowledge with Shuffleboard D:  
        .withWidget(BuiltInWidgets.kNumberSlider)
        .withProperties(Map.of("min", ElevatorConstants.kBottomDistance, "max", ElevatorConstants.kTopDistance))
        .getEntry()
        .getDouble(0);

    addRequirements(m_elevator);
  }

  @Override
  public void initialize() {
    m_controller.setSetpoint(m_range);
  }

  @Override
  public void execute() {
    double speed = m_controller.calculate(m_elevator.getEncoder().getPosition()); 
    m_elevator.set(speed);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false; // Should never finish thanks to gravity
  }
}
