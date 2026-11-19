package frc.robot.maps.subsystems;

import com.chopshop166.chopshoplib.logging.DataWrapper;
import com.chopshop166.chopshoplib.logging.LoggableMap;
import com.chopshop166.chopshoplib.logging.data.MotorControllerData;
import com.chopshop166.chopshoplib.motors.SmartMotorController;

public class RollerMap implements LoggableMap<RollerMap.Data> {

    public SmartMotorController motor;

    public RollerMap(SmartMotorController motor) {
        this.motor = motor;
    }

    public RollerMap() {
        this.motor = new SmartMotorController();
    }

    @Override
    public void updateData(Data data) {
        data.roller.updateData(this.motor);
    }

    public static class Data extends DataWrapper {
        public MotorControllerData roller = new MotorControllerData();
    }
}
