package frc.robot;

public final class Constants {
  public static class ElevatorConstants{
    public static final int kDeviceID = 1;

    public static final double kCircumferenceOfWheelInMeters = 1; // TODO: Change gear ration & circumference constants
    public static final double kGearRatio = 1 / 2;

    public static final int kTopDistance = 1;  // TODO: Adjust bottom & top distance values
    public static final int kBottomDistance = 0;

    public static final String kElevatorTabTitle = "Elevator";
    public static final String kElevatorRangeWidget = "Elevator Range";

    public static final double kP = 0.5;
    public static final double kI = 0;
    public static final double kD = 0;
  }
}
