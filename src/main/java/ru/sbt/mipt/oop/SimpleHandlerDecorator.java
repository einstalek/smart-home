package ru.sbt.mipt.oop;

public class SimpleHandlerDecorator implements EventHandler{
    private final EventHandler handler;

    public SimpleHandlerDecorator(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        System.out.println("Here's a decorator " + System.currentTimeMillis() / 1000);
        handler.handle(home, event);
    }
}
