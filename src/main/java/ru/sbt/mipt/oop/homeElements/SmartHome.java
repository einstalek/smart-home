package ru.sbt.mipt.oop.homeElements;

import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {

    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Room room: rooms)
            room.executeAction(action);
    }

    @Override
    public String toString() {
        return "home";
    }
}
