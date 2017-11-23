package ru.sbt.mipt.oop;

public class AlarmSystemStatePassword implements AlarmSystemState {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStatePassword(AlarmSystem alarmSystem) {
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
