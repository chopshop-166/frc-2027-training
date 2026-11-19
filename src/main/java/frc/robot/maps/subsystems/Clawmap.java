package frc.robot.maps.subsystems;

import com.chopshop166.chopshoplib.logging.DataWrapper;
import com.chopshop166.chopshoplib.logging.LoggableMap;
import com.chopshop166.chopshoplib.pneumatics.IDSolenoid;
import com.chopshop166.chopshoplib.pneumatics.MockDSolenoid;

public class Clawmap implements LoggableMap<Clawmap.Data> {

    public IDSolenoid solenoid;

    public Clawmap(IDSolenoid solenoid) {
        this.solenoid = solenoid;
    }

    public Clawmap() {
        this.solenoid = new MockDSolenoid();
    }

    @Override
    public void updateData(Data data) {

    }

    public static class Data extends DataWrapper {

    }
}
