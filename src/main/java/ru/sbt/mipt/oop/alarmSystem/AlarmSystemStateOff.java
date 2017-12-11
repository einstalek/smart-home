package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmSystemStateOff implements AlarmSystemState {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOff(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.OFF;
    }

    @Override
    public void enterPassword(String s) {}

    @Override
    public void turnOff() {}

    @Override
    public void turnOn() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {}
}
