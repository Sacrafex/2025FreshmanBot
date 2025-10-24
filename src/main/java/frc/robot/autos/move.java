package frc.robot.autos;

import frc.robot.subsystems.Swerve;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class move extends SequentialCommandGroup {
    public move(Swerve s_Swerve){
    s_Swerve.drive(new Translation2d(1, 0), 0, false, true);
    }
}