// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;

public class RobotContainer {

  /* Subsystems */
  private final Swerve s_Swerve = new Swerve();
  private final Arm arm = new Arm();
  public final Shooter shooter = new Shooter();
  public final Intake intake = new Intake();
  public final IntakePivot intakePivot = new IntakePivot();
  public final Climber climber = new Climber();
  public final Limelight limelight = new Limelight();

  /* Pathplanner */
  private final SendableChooser<Command> autoChooser;

  /* Controllers */
  private final Joystick driver = new Joystick(0);

  /*
  Movement - Left Joystick
  Rotation - Right Joystick

  Zero Swerve Drive - Start Button
  Zero Gyro Arm - B Button

  ShootButton - A Button
  forceIntake - Y Button

  Left Align Button - Left Bumper
  Right Align Button - Right Bumper

   */

  private final double speedcontrol = 0.7;
  /* Driver Buttons */
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;
  private final JoystickButton zeroGyroSwerve = new JoystickButton(driver, XboxController.Button.kStart.value);
  private final JoystickButton zeroGyroArm = new JoystickButton(driver, XboxController.Button.kB.value);
  private final JoystickButton shootButton = new JoystickButton(driver, XboxController.Button.kA.value);
  private final JoystickButton alignLButton = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
  private final JoystickButton alignRButton = new JoystickButton(driver, XboxController.Button.kRightBumper.value);
  private final JoystickButton forceIntake = new JoystickButton(driver, XboxController.Button.kY.value);

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {

  }

  public Command getAutonomousCommand() {

  }
}
