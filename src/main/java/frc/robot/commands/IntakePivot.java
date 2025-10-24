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
    private TalonFX pivotMotor = new TalonFX(50);
    CurrentLimitsConfigs supplyLimit = new CurrentLimitsConfigs();

    private SparkMax intakeMotor = new SparkMax(2, MotorType.kBrushless);

    private SparkMax reverseIntakeMotor = new SparkMax(3, MotorType.kBrushless);

    private double shooterSpeedLimiter = 0.7;

    private int pivotStage;
    
    public IntakePivot(double shooterSpeed, int pivotStage) {
        this.pivotStage = pivotStage;
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

    public void shoot(double inputSpeed) {
        intakeMotor.set(-shooterSpeedLimiter*inputSpeed);
        reverseIntakeMotor.set(shooterSpeedLimiter*inputSpeed);
    }

    public void increasePosition() {
        setPivotStage(pivotStage+1);
    }

    public void decreasePosition() {
        setPivotStage(pivotStage-1);
    }

    public void setPivotStage(int stage) {
        double desiredPosition = 0.5;
        switch (stage) {
            case 1:
            pivotStage = 1;
            stage = 1;
            desiredPosition = 0.3;
            pivotMotor.setControl(new PositionDutyCycle(desiredPosition));
                break;
            case 2:
            pivotStage = 2;
            stage = 2;
            desiredPosition = 1;
            pivotMotor.setControl(new PositionDutyCycle(desiredPosition));
                break;
            case 3:
            pivotStage = 3;
            stage = 3;
            desiredPosition = 2;
            pivotMotor.setControl(new PositionDutyCycle(desiredPosition));
            case 4:
            pivotStage = 4;
            stage = 4;
            desiredPosition = 3;
            pivotMotor.setControl(new PositionDutyCycle(desiredPosition));
                break;
            default:
                pivotStage = 4;
                stage = 4;
                desiredPosition = 0.9;
                pivotMotor.setControl(new PositionDutyCycle(desiredPosition));
                break;
        }
    }
}
