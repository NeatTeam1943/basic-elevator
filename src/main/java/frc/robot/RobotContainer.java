package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Elevate;
import frc.robot.subsystems.Elevator;

public class RobotContainer {
  private final Elevator m_elevator;
  private final Elevate m_elevate;

  public RobotContainer() {
    m_elevator = new Elevator();
    m_elevate = new Elevate(m_elevator);
   
    m_elevator.setDefaultCommand(m_elevate);
  }
  
  public Command getAutonomousCommand() {
    return null;
  }
}
