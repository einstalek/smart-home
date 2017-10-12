package ru.sbt.mipt.oop;

public class DoorClosedEventHandler implements EventHandler {
    private SensorEventType eventType;

    public DoorClosedEventHandler() {
        eventType = SensorEventType.DOOR_CLOSED;
    }

    @Override
    public SensorEventType getEventType() {
        return eventType;
    }

    @Override
    public void handle(SensorEvent event) {

    }
}
