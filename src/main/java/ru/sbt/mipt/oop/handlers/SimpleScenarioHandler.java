package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.homeElements.Door;
import ru.sbt.mipt.oop.homeElements.Light;
import ru.sbt.mipt.oop.homeElements.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

public class SimpleScenarioHandler implements EventHandler {
    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() != SensorEventType.DOOR_CLOSED && event.getType() != SensorEventType.DOOR_OPEN)  return;
        DoorIterator doorIterator = new DoorIterator(home);
        while (doorIterator.hasNext()) {
            Door door = doorIterator.next();
            if (door.getId().equals(event.getObjectId()) && door.getRoom().getName().equals("hall")) {
                if (event.getType() == SensorEventType.DOOR_CLOSED) {
                    applyToAllDoors(home, false);
                    applyToAllLights(home, false);
                }
                else {
                    applyToAllDoors(home, true);
                    applyToAllLights(home, true);
                }
            }
        }
    }

    private void applyToAllLights(SmartHome home, boolean operation) {
        LightIterator lightIterator = new LightIterator(home);
        while (lightIterator.hasNext()) {
            Light light = lightIterator.next();
            light.setOn(operation);
        }
    }

    private void applyToAllDoors(SmartHome home, boolean operation) {
        DoorIterator doorIterator = new DoorIterator(home);
        while (doorIterator.hasNext()) {
            Door door = doorIterator.next();
            door.setOpen(operation);
        }
    }
}
