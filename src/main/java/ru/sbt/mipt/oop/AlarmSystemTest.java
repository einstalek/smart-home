package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlarmSystemTest {

    @Test
    public void testNewSystemIfOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void turnOnSetsState() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void testSensorEventSetsWaitsForPassowrdState() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent sensorEvent = createSensorEvent();
        alarmSystem.onEvent(sensorEvent);
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD , alarmSystem.getSystemStateEnum());
    }

    public SensorEvent createSensorEvent() {
        return new SensorEvent(SensorEventType.LIGHT_ON, "a");
    }


    @Test
    public void testSystemIsOffWithoutTurningOn() {
        AlarmSystem alarmSystem = new AlarmSystem();
        SensorEvent sensorEvent = createSensorEvent();
        alarmSystem.onEvent(sensorEvent);
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getSystemStateEnum());
    }

    @Test
    public void testTurnOnDoesNothingWhenWatingForPassowrd() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.onEvent(createSensorEvent());
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getSystemStateEnum());
    }
}
