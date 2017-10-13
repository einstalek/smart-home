package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class LightEventHandlerTest {
    @Test
    public void testHandle() {
        LightEventHandler handler = new LightEventHandler();
        SmartHome smartHome = new SmartHome();
        Light light = new Light("1", false);
        smartHome.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(),
                "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, light.getId());

        assertFalse(light.isOn());
        handler.handle(smartHome, event);
        assertTrue(light.isOn());
    }
}