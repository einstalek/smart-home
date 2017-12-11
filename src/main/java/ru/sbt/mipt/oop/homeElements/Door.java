package ru.sbt.mipt.oop.homeElements;

import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;

public class Door implements Actionable {
    private Room room;
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    @Override
    public String toString() {
        String s = "door-" + getId();
        s += isOpen ? "_opened" : "_closed";
        return s;
    }
}
