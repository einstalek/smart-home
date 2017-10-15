package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class DoorEventHandlerTest {

    @Test
    public void testHandle() {
        DoorEventHandler handler = new DoorEventHandler();
        SmartHome smartHome = new SmartHome();
        Door door = new Door(false, "1");
        Light light = new Light("1", false);
        smartHome.addRoom(new Room(Arrays.asList(light), Arrays.asList(door), "hall"));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, door.getId());

        assertFalse(light.isOn());
        handler.handle(smartHome, event);
        /*
        Непонятно, что за метод sendCommand в классе DoorEventHAndler
         */
        assertTrue(light.isOn());
    }
}