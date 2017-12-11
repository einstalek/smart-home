package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.homeElements.SmartHome;

public interface EventHandler {
    void handle(SmartHome home, SensorEvent event);
}
