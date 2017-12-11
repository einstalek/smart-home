package ru.sbt.mipt.oop.homeElements;

import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;

public class Light implements Actionable {
    private Room room;
    private boolean isOn;
    private final String id;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    @Override
    public String toString() {
        String s = "light-" + getId();
        s += isOn ? "_on" : "_off";
        return s;
    }
}
