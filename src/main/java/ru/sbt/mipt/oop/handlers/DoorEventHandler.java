package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.homeElements.Door;
import ru.sbt.mipt.oop.homeElements.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_OPEN;

public class DoorEventHandler implements EventHandler {

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() != DOOR_OPEN && event.getType() != DOOR_CLOSED) return;
        DoorIterator doorIterator = new DoorIterator(home);
        while (doorIterator.hasNext()) {
            Door door = doorIterator.next();
            if (door.getId().equals(event.getObjectId())) {
                if (event.getType() == DOOR_OPEN) {
                    door.setOpen(true);
                    System.out.println("Door " + door.getId() + " is opened now");
                }
                else if (event.getType() == DOOR_CLOSED){
                    door.setOpen(false);
                    System.out.println("Door " + door.getId() + " is closed now");
                }
            }
        }
    }
}
