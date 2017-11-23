package ru.sbt.mipt.oop;

public class AlarmSystem {

    private  AlarmSystemState alarmSystemState;


    public AlarmSystem() {
        this.alarmSystemState = new AlarmSystemStateOff(this);
    }


    public void turnOn() {
        alarmSystemState.turnOn();
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
}
