package ru.sbt.mipt.oop;

public class AlarmSystemStateWaitingForPassword implements AlarmSystemState {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateWaitingForPassword(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {

    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
    }
}
