package ru.sbt.mipt.oop;

public interface EventHandler {
    SensorEventType getEventType();
    void handle(SensorEvent event);
}
