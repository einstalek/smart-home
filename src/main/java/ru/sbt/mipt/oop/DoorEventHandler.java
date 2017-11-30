package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.*;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHandler implements EventHandler {

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() != DOOR_OPEN || event.getType() != DOOR_CLOSED) return;
            DoorIterator doorIterator = new DoorIterator(home);
            while (doorIterator.hasNext()) {
                Door door = doorIterator.next();
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) door.setOpen(true);
                    else door.setOpen(false);
                }
            }
    }

    private void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
