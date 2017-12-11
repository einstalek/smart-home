package ru.sbt.mipt.oop.handlers;

import org.junit.Test;
import ru.sbt.mipt.oop.homeElements.Door;
import ru.sbt.mipt.oop.homeElements.Light;
import ru.sbt.mipt.oop.homeElements.Room;
import ru.sbt.mipt.oop.homeElements.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SimpleScenarioHandlerTest {
    @Test
    public void testHallDoorClosed() {
        SmartHome smartHome = new SmartHome();
        Door door = new Door(true, "1");
        Light light = new Light("1", true);
        Door hall_door = new Door(true, "2");
        Light hall_light = new Light("2", true);
        smartHome.addRoom(new Room(Arrays.asList(light), Arrays.asList(door), "room"));
        smartHome.addRoom(new Room(Arrays.asList(hall_light), Arrays.asList(hall_door), "hall"));

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, hall_door.getId());
        SimpleScenarioHandler handler = new SimpleScenarioHandler();
        handler.handle(smartHome, event);

        DoorIterator doorIterator = new DoorIterator(smartHome);
        LightIterator lightIterator = new LightIterator(smartHome);

        while (doorIterator.hasNext())
            assertFalse(doorIterator.next().isOpen());
        while (lightIterator.hasNext())
            assertFalse(lightIterator.next().isOn());
    }

    @Test
    public void testHallDoorOpened() {
        SmartHome smartHome = new SmartHome();
        Door door = new Door(false, "1");
        Light light = new Light("1", false);
        Door hall_door = new Door(false, "2");
        Light hall_light = new Light("2", false);
        smartHome.addRoom(new Room(Arrays.asList(light), Arrays.asList(door), "room"));
        smartHome.addRoom(new Room(Arrays.asList(hall_light), Arrays.asList(hall_door), "hall"));

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, hall_door.getId());
        SimpleScenarioHandler handler = new SimpleScenarioHandler();
        handler.handle(smartHome, event);

        DoorIterator doorIterator = new DoorIterator(smartHome);
        LightIterator lightIterator = new LightIterator(smartHome);

        while (doorIterator.hasNext())
            assertTrue(doorIterator.next().isOpen());
        while (lightIterator.hasNext())
            assertTrue(lightIterator.next().isOn());
    }
}