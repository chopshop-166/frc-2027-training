package frc.robot.subsystems;

import com.chopshop166.chopshoplib.logging.LoggedSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.maps.subsystems.RollerMap;
import frc.robot.maps.subsystems.RollerMap.Data;

public class Roller extends LoggedSubsystem<Data, RollerMap> {

    private final double INTAKE_SPEED = 0.5;
    private final double OUTTAKE_SPEED = -0.5;
    private final double IDLE_SPEED = 0.05;

    public Roller(RollerMap map) {
        super(new Data(), map);
    }

    public Command intake() {
        // spin the motor forward at some speed
        return runOnce(() -> {
            getData().roller.setpoint = INTAKE_SPEED;
        });
    }

    public Command outtake() {
        // spin the motor backward at some speed
        return runOnce(() -> {
            getData().roller.setpoint = OUTTAKE_SPEED;
        });
    }

    public Command idling() {
        // spin the motor backward at some speed
        return runOnce(() -> {
            getData().roller.setpoint = IDLE_SPEED;
        });
    }

    @Override
    public void safeState() {
        getData().roller.setpoint = 0;
    }

}
