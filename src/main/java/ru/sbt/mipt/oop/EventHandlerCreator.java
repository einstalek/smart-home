package ru.sbt.mipt.oop;

public class EventHandlerCreator {
    public static EventHandler createHandler(SensorEventType eventType) {
        if (eventType == SensorEventType.LIGHT_ON) return new LightOnEventHandler();
        else if (eventType == SensorEventType.LIGHT_OFF) return new LightOffEventHandler();
        else if (eventType == SensorEventType.DOOR_CLOSED) return new DoorClosedEventHandler();
        else if (eventType == SensorEventType.DOOR_OPEN) return  new DoorOpenEventHandler();
        else return null;
    }
}
