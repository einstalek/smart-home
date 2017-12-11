package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmSystemStateOn implements AlarmSystemState {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ON;
    }

    @Override
    public void enterPassword(String s) {}

    @Override
    public void turnOff() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitingForPassword(alarmSystem));
    }

    @Override
    public void turnOn() { }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitingForPassword(alarmSystem));
    }
}
