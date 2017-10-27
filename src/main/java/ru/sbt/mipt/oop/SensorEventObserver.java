package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.List;

import static ru.sbt.mipt.oop.Application.getNextSensorEvent;

public class SensorEventObserver {
    public List<EventHandler> handlers = new ArrayList<>();

    public void addHandlers() {
        handlers.add(new LightEventHandler());
        handlers.add(new DoorEventHandler());
        handlers.add(new SimpleHandlerDecorator(new SimpleScenarioHandler()));
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
}
