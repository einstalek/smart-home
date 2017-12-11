package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmSystemStateAlarm implements AlarmSystemState {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateAlarm(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() { }

    @Override
    public void onEvent(SensorEvent sensorEvent) {}

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ALARM;
    }

    @Override
    public void enterPassword(String s) {
        if (s.equals("qwerty")) alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
    }

    @Override
    public void turnOff() {

    }
}
