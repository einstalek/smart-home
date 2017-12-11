package ru.sbt.mipt.oop.homeElements;

import ru.sbt.mipt.oop.composite.Action;
import ru.sbt.mipt.oop.composite.Actionable;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
        for (Door door: doors) door.setRoom(this);
        for (Light light: lights) light.setRoom(this);
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Light light: lights)
            light.executeAction(action);
        for (Door door: doors)
            door.executeAction(action);
    }

    @Override
    public String toString() {
        return "room-" + getName();
    }
}
