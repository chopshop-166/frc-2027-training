package frc.robot.subsystems;

import com.chopshop166.chopshoplib.commands.SmartSubsystemBase;
import com.chopshop166.chopshoplib.pneumatics.IDSolenoid;
import com.chopshop166.chopshoplib.pneumatics.RevDSolenoid;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;

public class Claw extends SmartSubsystemBase {

    IDSolenoid solenoid;

    public Claw(int fwdChannel, int revChannel) {
        solenoid = new RevDSolenoid(fwdChannel, revChannel);
    }

    public Command open() {
        return runOnce(() -> {
            solenoid.set(Value.kForward);
        });
    }

    public Command close() {
        return runOnce(() -> {
            solenoid.set(Value.kReverse);
        });
    }

    @Override
    public void safeState() {
        throw new UnsupportedOperationException("Unimplemented method 'safeState'");
    }

}
