package ru.sbt.mipt.oop;

public class LightOffEventHandler implements EventHandler{
    private SensorEventType eventType;

    public LightOffEventHandler() {
        this.eventType = SensorEventType.LIGHT_OFF;
    }

    @Override
    public SensorEventType getEventType() {
        return this.eventType;
    }

    @Override
    public void handle(SensorEvent event) {

    }
}
