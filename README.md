# construction-hash-calculator
Robot constructuon hash calculator.
## Config file snippet
```json
"game_requirements": {
      "system_version": "0.9.1",
      "sensor_ports": {
        "1": "infrared_sensor",
        "2": "touch_sensor",
        "3": "touch_sensor",
        "4": "gyro_sensor"
      },
      "motor_ports": {
        "A": "big_motor",
        "B": "big_motor",
        "C": "big_motor",
        "D": "middle_motor"
      }
    }
```
All possibles value in fields _motor_ports, sensor_ports_

| 1 - 4             | A - D        |
|-------------------|--------------|
| color_sensor      | big_motor    |
| gyro_sensor       | middle_motor |
| infrared_sensor   |              |
| ultrasonic_sensor |              |
| touch_sensor      |              |

## Example usage
As input we pass HashMap (**PORTS_CONFIGS**) with ports config.
```
Key : 1 Value : ultrasonic_sensor
Key : 2 Value : ultrasonic_sensor
Key : 3 Value : touch_sensor
Key : 4 Value : touch_sensor
Key : A Value : middle_motor
Key : B Value : big_motor
Key : C Value : big_motor
Key : D Value : middle_motor
```
Exammple usage:
```java
 String hash = ConstructionHashCalculator.calculate(PORTS_CONFIGS);
 ```
