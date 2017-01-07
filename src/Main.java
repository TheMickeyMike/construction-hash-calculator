import java.security.MessageDigest;
import java.util.*;

public class Main {

    private static final HashMap<String, String> PORTS_CONFIGS = new HashMap<>();

    private static final List<String> GYRO_INDEXES = Arrays.asList("A", "B", "C", "D");

    private static final String[] MOTOR_PORTS = {"big_motor", "middle_motor"};
    private static final String[] SENSOR_PORTS = {
            "color_sensor",
            "infrared_sensor",
            "ultrasonic_sensor",
            "touch_sensor",
            "gyro_sensor",
            "touch_sensor"
    };


    public static void main(String[] args) {
        generateExampleConfig(); // Generates HashMap with dummy configs

        String hash = null;
        try {
            hash = ConstructionHashCalculator.calculate(PORTS_CONFIGS); // Calculates Robot Construction MD5 Hash
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hash: " + hash);
    }

    private static String getMotor() {
        int idx = new Random().nextInt(MOTOR_PORTS.length);
        return (MOTOR_PORTS[idx]);
    }

    private static String getSensor() {
        int idx = new Random().nextInt(SENSOR_PORTS.length);
        return (SENSOR_PORTS[idx]);
    }

    private static void generateExampleConfig() {
        GYRO_INDEXES.forEach(indx -> PORTS_CONFIGS.put(indx, getMotor()));
        for (int i = 1; i < 5; i++) {
            PORTS_CONFIGS.put(Integer.toString(i), getSensor());
        }
    }
}
