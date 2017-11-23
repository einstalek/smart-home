package ru.sbt.mipt.oop;

public interface AlarmSystemState {
    public void turnOn();
    public void onEvent(SensorEvent sensorEvent);
    public AlarmSystemStateEnum getState();
}
