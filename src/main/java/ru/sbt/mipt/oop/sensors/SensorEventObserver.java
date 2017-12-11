package ru.sbt.mipt.oop.sensors;

import ru.sbt.mipt.oop.handlers.*;
import ru.sbt.mipt.oop.homeElements.SmartHome;

import java.util.ArrayList;
import java.util.List;

public class SensorEventObserver {
    public List<EventHandler> handlers = new ArrayList<>();

    public SensorEventObserver(List<EventHandler> handlers) {
        this.handlers = handlers;
    }


    public void observe(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            onEvent(smartHome, event);
            event = getNextSensorEvent();
        }
    }

    public void onEvent(SmartHome smartHome, SensorEvent event) {
        System.out.println("Got event: " + event.getType());
        for (EventHandler handler: handlers) {
            handler.handle(smartHome, event);
        }
    }

    public static SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
