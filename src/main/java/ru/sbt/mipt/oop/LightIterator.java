package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LightIterator implements Iterator<Light> {

    private final SmartHome smartHome;
    private int currentRoom;
    private int currentLight;
    private List<Room> rooms;

    public LightIterator(SmartHome smartHome) {
        this.smartHome = smartHome;
        this.currentRoom = 0;
        this.currentLight = 0;
        this.rooms = new ArrayList<>(smartHome.getRooms());
    }

    @Override
    public boolean hasNext() {
        if (currentRoom > rooms.size() - 1) return false;
        if (currentRoom == rooms.size() - 1) {
            Room room  = rooms.get(currentRoom);
            if (currentLight > new ArrayList<>(room.getLights()).size() - 1) return false;
        }
        return true;
    }

    @Override
    public Light next() {
        List<Light> currentRoomLights = new ArrayList<>(rooms.get(currentRoom).getLights());
        Light light;
        if (currentRoomLights.size() == 1) {
            if (currentLight == 0) {
                light = currentRoomLights.get(currentLight);
                currentRoom++;
                currentLight = 0;
            }
            else throw new IllegalStateException();
        }
        else {
            if (currentLight < currentRoomLights.size() - 1) {
                light = currentRoomLights.get(currentLight);
                currentLight++;
            }
            else if (currentLight == currentRoomLights.size() - 1) {
                light = currentRoomLights.get(currentLight);
                currentRoom++;
                currentLight = 0;
            }
            else throw new IllegalStateException();
        }
        return light;
    }
}
