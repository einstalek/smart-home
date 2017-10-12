package ru.sbt.mipt.oop;

public class LightOnEventHandler implements EventHandler{
    private SensorEventType eventType;

    public LightOnEventHandler() {
        this.eventType = SensorEventType.LIGHT_ON;
    }

    @Override
    public SensorEventType getEventType() {
        return this.eventType;
    }

    @Override
    public void handle(SensorEvent event) {

    }
}
