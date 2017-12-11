package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmSystem {

    private AlarmSystemState alarmSystemState;


    public AlarmSystem() {
        this.alarmSystemState = new AlarmSystemStateOff(this);
    }


    public void turnOn() {
        alarmSystemState.turnOn();
    }

    public void turnOff() {
        alarmSystemState.turnOff();
    }

    public void onEvent(SensorEvent sensorEvent) {
        alarmSystemState.onEvent(sensorEvent);
    }

    public void setAlarmSystemState(AlarmSystemState alarmSystemState) {
        this.alarmSystemState = alarmSystemState;
    }

    public AlarmSystemStateEnum getSystemStateEnum() {
        return alarmSystemState.getState();
    }

    public void enterPassword(String password) {
        alarmSystemState.enterPassword(password);
    }
}
