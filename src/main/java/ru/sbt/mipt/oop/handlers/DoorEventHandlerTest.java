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

public class DoorEventHandlerTest {

    @Test
    public void testHandle() {
        DoorEventHandler handler = new DoorEventHandler();
        SmartHome smartHome = new SmartHome();

        Door door = new Door(true, "2");
        Light light = new Light("2", true);
        smartHome.addRoom(new Room(Arrays.asList(light), Arrays.asList(door), "room"));
        System.out.println(door.isOpen());
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, door.getId());

        handler.handle(smartHome, event);
        assertFalse(door.isOpen());
    }


    @Test
    public void testEventWithHallDoorClosed() {
        DoorEventHandler handler = new DoorEventHandler();
        SmartHome smartHome = new SmartHome();

        Door hall_door = new Door(true, "1");
        Light hall_light = new Light("1", true);
        Door door = new Door(true, "2");
        Light light = new Light("2", true);
        smartHome.addRoom(new Room(Arrays.asList(hall_light), Arrays.asList(hall_door), "hall"));
        smartHome.addRoom(new Room(Arrays.asList(light), Arrays.asList(door), "room"));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, hall_door.getId());

//        assertTrue(hall_light.isOn());
//        assertTrue(light.isOn());

        handler.handle(smartHome, event);
//
//        assertFalse(hall_door.isOpen());
//        assertFalse(hall_light.isOn());
//        assertFalse(light.isOn());
    }
}