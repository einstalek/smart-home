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
        if (currentRoom < smartHome.rooms.size() - 1) return true;
        if (currentRoom == smartHome.rooms.size() - 1) {
            List<Light> currentRoomLights = new ArrayList<>(rooms.get(currentRoom).getLights());
            if (currentLight < currentRoomLights.size()) return true;
        }
        return false;
    }

    @Override
    public Light next() {
        List<Light> currentRoomLights = new ArrayList<>(rooms.get(currentRoom).getLights());
        Light light = currentRoomLights.get(currentLight);

        if (currentRoom < rooms.size() - 1) {
            if (currentLight < currentRoomLights.size()) {
//                light = currentRoomLights.get(currentLight);
                currentLight++;
            }
            else {
//                light = currentRoomLights.get(currentLight);
                currentRoom++;
                currentLight = 0;
            }
        }
        else if (currentRoom == rooms.size() - 1 && currentLight < currentRoomLights.size()) {
//            light = currentRoomLights.get(currentLight);
            currentLight++;
        }
        else
            throw new IllegalStateException();
        return light;
    }
}
