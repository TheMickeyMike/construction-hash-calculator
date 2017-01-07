import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructionHashCalculator {

    private static final int SENSOR_MAX_INDEX = 5;
    private static final List<String> MOTOR_INDEXES = Arrays.asList("A", "B", "C", "D");

    public static String calculate(HashMap<String, String> portsMap) throws Exception {
        printPortsConfig(portsMap); // Printing sorted config
        String stringToHash = convertToHashingReadyString(portsMap);
        System.out.println(stringToHash); // Printing hashing string
        return createMD5Hash(stringToHash);
    }

    private static String createMD5Hash(String stringToHash) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(stringToHash.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    private static String convertToHashingReadyString(HashMap<String, String> portsMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < SENSOR_MAX_INDEX; i++) {
            stringBuilder.append(portsMap.get(Integer.toString(i)));
        }
        MOTOR_INDEXES.forEach(value -> stringBuilder.append(portsMap.get(value)));
        return stringBuilder.toString();
    }

    private static void printPortsConfig(HashMap<String, String> portsConfig) {
        portsConfig.entrySet().stream()
                .sorted((Map.Entry.comparingByKey()))
                .forEachOrdered(k -> System.out.println("Key : " + k.getKey() + " Value : " + k.getValue()));
    }
}
