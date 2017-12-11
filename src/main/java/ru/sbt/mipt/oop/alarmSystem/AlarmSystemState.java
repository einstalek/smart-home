package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public interface AlarmSystemState {
    public void turnOn();
    public void onEvent(SensorEvent sensorEvent);
    public AlarmSystemStateEnum getState();
    public void enterPassword(String s);
    public void turnOff();
}
