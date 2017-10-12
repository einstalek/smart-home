package ru.sbt.mipt.oop;

public class DoorOpenEventHandler implements EventHandler {
    private SensorEventType eventType;

    public DoorOpenEventHandler() {
        eventType = SensorEventType.DOOR_OPEN;
    }

    @Override
    public SensorEventType getEventType() {
        return eventType;
    }

    @Override
    public void handle(SensorEvent event) {

    }
}
