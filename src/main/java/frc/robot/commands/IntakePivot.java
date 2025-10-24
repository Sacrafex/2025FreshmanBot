package frc.robot.commands;

//import com.ctre.phoenix.*;
//import com.ctre.phoenix6.*;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakePivot extends Command {
    private static final int MIN_PIVOT_STAGE = 1;
    private static final int MAX_PIVOT_STAGE = 4;

    private TalonFX pivotMotor = new TalonFX(50);
    CurrentLimitsConfigs supplyLimit = new CurrentLimitsConfigs();

    private SparkMax intakeMotor = new SparkMax(2, MotorType.kBrushless);

    private SparkMax reverseIntakeMotor = new SparkMax(3, MotorType.kBrushless);

    private double shooterSpeedLimiter = 0.5;

    private int pivotStage;
    
    public IntakePivot(double shooterSpeed) {
        shooterSpeedLimiter = shooterSpeed;
        addRequirements();
    }

    @Override
    public void initialize() {
        pivotStage = 0;
    }

    @Override
    public void execute() {
    }

    public void intake(double inputSpeed) {
        intakeMotor.set(shooterSpeedLimiter*inputSpeed);
        reverseIntakeMotor.set(-shooterSpeedLimiter*inputSpeed);
    }

    public void zeroIntake() {
    }

    public void shoot(double inputSpeed) {
        intakeMotor.set(-shooterSpeedLimiter*inputSpeed);
        reverseIntakeMotor.set(shooterSpeedLimiter*inputSpeed);
    }

    public void increasePivotStage() {
        if (pivotStage < MAX_PIVOT_STAGE) {
            setPivotStage(pivotStage + 1);
        } else {
            System.err.println("Cannot increase pivot stage beyond MAX_PIVOT_STAGE.");
        }
    }

    public void decreasePivotStage() {
        if (pivotStage > MIN_PIVOT_STAGE) {
            setPivotStage(pivotStage - 1);
        } else {
            System.err.println("Cannot decrease pivot stage below MIN_PIVOT_STAGE.");
        }
    }

    public void setPivotStage(int stage) {
        if (stage < MIN_PIVOT_STAGE) {
            System.err.println("Invalid pivot stage: " + stage + " Fixing Position...");
            stage = MIN_PIVOT_STAGE;
            System.err.println("Fixed Variable Position to: " + stage);
        } else if (stage > MAX_PIVOT_STAGE) {
            System.err.println("Invalid pivot stage: " + stage + " Fixing Position...");
            stage = MAX_PIVOT_STAGE;
            System.err.println("Fixed Variable Position to: " + stage);
        }
        double desiredPosition = 0;
        switch (stage) {
            case 1:
                pivotStage = 1;
                desiredPosition = -0.2;
                break;
            case 2:
                pivotStage = 2;
                desiredPosition = 0;
                break;
            case 3:
                pivotStage = 3;
                desiredPosition = 0.2;
                break;
            case 4:
                pivotStage = 4;
                desiredPosition = 0.4;
                break;
        }
        pivotMotor.setControl(new PositionDutyCycle(desiredPosition));
        System.err.println("Set Physical Position to stage: " + stage);
    }
}
