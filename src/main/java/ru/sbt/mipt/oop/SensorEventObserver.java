package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.List;

public class SensorEventObserver {
    public List<EventHandler> handlers = new ArrayList<>();

    public void addHandlers() {
        handlers.add(new LightEventHandler());
        handlers.add(new SimpleHandlerDecorator(new DoorEventHandler()));
        handlers.add(new SimpleHandlerDecorator(new SimpleScenarioHandler()));
        handlers.add(new SimpleScenarioHandler());
    }


    public void observe(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler: handlers) {
                handler.handle(smartHome, event);
            }
            event = getNextSensorEvent();
        }
    }

    public static SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
