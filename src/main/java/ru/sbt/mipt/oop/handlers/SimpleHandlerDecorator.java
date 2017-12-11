package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.homeElements.SmartHome;

public class SimpleHandlerDecorator implements EventHandler {
    private final EventHandler handler;

    public SimpleHandlerDecorator(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        System.out.println("This is a decorator " + System.currentTimeMillis() / 1000);
        handler.handle(home, event);
    }
}
