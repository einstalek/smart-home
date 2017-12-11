package ru.sbt.mipt.oop.alarmSystem;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import static org.junit.Assert.assertEquals;
import static ru.sbt.mipt.oop.sensors.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.alarmSystem.AlarmSystemStateEnum.*;

public class AlarmSystemTest {

    @Test
    public void testNewSystemIfOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        Assert.assertEquals(OFF, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void turnOnSetsTurnedOnState() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(ON, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void testSensorEventSetsWaitsForPasswordState() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent sensorEvent = createSensorEvent();
        alarmSystem.onEvent(sensorEvent);
        assertEquals(WAIT_FOR_PASSWORD , alarmSystem.getSystemStateEnum());
    }

    private SensorEvent createSensorEvent() {
        return new SensorEvent(LIGHT_ON, "a");
    }


    @Test
    public void testEventDoesNothingWhenTurnedOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        SensorEvent sensorEvent = createSensorEvent();
        alarmSystem.onEvent(sensorEvent);
        assertEquals(OFF, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void testRightPasswordEnter() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.onEvent(createSensorEvent());
        alarmSystem.enterPassword("qwerty");
        assertEquals(OFF, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void testWrongPasswordEnter() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.onEvent(createSensorEvent());
        alarmSystem.enterPassword("12345");
        assertEquals(ALARM, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void testCantTurnOffWhenAlarmState() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.onEvent(createSensorEvent());
        alarmSystem.turnOff();
        assertEquals(ALARM, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void testTurnOffAlarmStateWithRightPassord() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.onEvent(createSensorEvent());
        alarmSystem.enterPassword("12345");
        assertEquals(ALARM, alarmSystem.getSystemStateEnum());
        alarmSystem.enterPassword("qwerty");
        assertEquals(OFF, alarmSystem.getSystemStateEnum());
    }
}
