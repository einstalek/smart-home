package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.*;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHandler implements EventHandler {

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            DoorIterator doorIterator = new DoorIterator(home);
            while (doorIterator.hasNext()) {
                Door door = doorIterator.next();
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
//                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
//                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
//                        if (room.getName().equals("hall")) {
//                            for (Room homeRoom : home.getRooms()) {
//                                for (Light light : homeRoom.getLights()) {
//                                    light.setOn(false);
//                                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
//                                    sendCommand(command);
//                                }
//                            }
//                        }
                    }
                }
            }
        }
    }

    private void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
