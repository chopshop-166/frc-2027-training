package frc.robot.maps;

import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.NT4Publisher;
import org.littletonrobotics.junction.wpilog.WPILOGWriter;

import com.chopshop166.chopshoplib.maps.RobotMapFor;
import com.chopshop166.chopshoplib.motors.CSSparkFlex;
import com.chopshop166.chopshoplib.motors.SmartMotorControllerGroup;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import frc.robot.maps.subsystems.RollerMap;

@RobotMapFor("00:80:2F:40:A6:13")
public class ThunderBird extends RobotMap {

    @Override
    public RollerMap getRollerMap() {
        CSSparkFlex motor1 = new CSSparkFlex(13);
        CSSparkFlex motor2 = new CSSparkFlex(19);
        SparkFlexConfig motor1Config = new SparkFlexConfig();
        SparkFlexConfig motor2Config = new SparkFlexConfig();
        motor1Config.smartCurrentLimit(40);
        motor2Config.smartCurrentLimit(40);
        motor2Config.inverted(false);
        motor1Config.follow(19, true);
        motor1.getMotorController().configure(motor1Config, ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters);
        motor2.getMotorController().configure(motor2Config, ResetMode.kResetSafeParameters,
                PersistMode.kPersistParameters);
        SmartMotorControllerGroup smcg = new SmartMotorControllerGroup(motor2, motor1);
        return new RollerMap(smcg);
    }

    @Override
    public void setupLogging() {
        Logger.addDataReceiver(new WPILOGWriter("/media/sda1/")); // Log to a USB stick
        Logger.addDataReceiver(new NT4Publisher()); // Publish data to NetworkTables
        Logger.recordMetadata("RobotMap", this.getClass().getSimpleName());
        new PowerDistribution(1, ModuleType.kRev); // Enables power distribution logging
    }

}
