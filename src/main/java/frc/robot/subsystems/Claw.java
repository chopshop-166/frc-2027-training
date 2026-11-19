package frc.robot.subsystems;

import com.chopshop166.chopshoplib.commands.SmartSubsystemBase;
import com.chopshop166.chopshoplib.pneumatics.IDSolenoid;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.maps.subsystems.Clawmap;

public class Claw extends SmartSubsystemBase {

    IDSolenoid solenoid;

    public Claw(Clawmap map) {
        this.solenoid = map.solenoid;
    }

    public Command open() {
        return runOnce(() -> {
            this.solenoid.set(Value.kForward);
        });
    }

    public Command close() {
        return runOnce(() -> {
            this.solenoid.set(Value.kReverse);
        });
    }

    @Override
    public void safeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'safeState'");
    }

}