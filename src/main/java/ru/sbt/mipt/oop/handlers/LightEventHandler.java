package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.homeElements.Light;
import ru.sbt.mipt.oop.homeElements.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import static ru.sbt.mipt.oop.sensors.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.sensors.SensorEventType.LIGHT_ON;

public class LightEventHandler implements EventHandler{

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() != LIGHT_ON && event.getType() != LIGHT_OFF) return;
        LightIterator iterator = new LightIterator(home);
        while (iterator.hasNext()) {
            Light light = iterator.next();
            if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " is turned on now");
                    }
                    else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " is turned off now");
                    }
                }
        }
    }
}
