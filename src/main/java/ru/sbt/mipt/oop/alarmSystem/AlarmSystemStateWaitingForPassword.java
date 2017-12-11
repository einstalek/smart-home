package ru.sbt.mipt.oop.alarmSystem;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmSystemStateWaitingForPassword implements AlarmSystemState {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateWaitingForPassword(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void turnOn() {}

    @Override
    public void onEvent(SensorEvent sensorEvent) {}

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
    }

    @Override
    public void enterPassword(String s) {
        if (s.equals("qwerty")) alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
        else alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
    }

    @Override
    public void turnOff() {}
}
