package ru.sbt.mipt.oop.handlers;

import org.junit.Test;
import ru.sbt.mipt.oop.homeElements.Light;
import ru.sbt.mipt.oop.homeElements.Room;
import ru.sbt.mipt.oop.homeElements.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class LightEventHandlerTest {
    @Test
    public void testHandleLightOn() {
        LightEventHandler handler = new LightEventHandler();
        SmartHome smartHome = new SmartHome();
        Light light = new Light("1", false);
        smartHome.addRoom(new Room(Arrays.asList(light), Collections.emptyList(), "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, light.getId());

        assertFalse(light.isOn());
        handler.handle(smartHome, event);
        assertTrue(light.isOn());
    }

    @Test
    public void testHandleLightOff() {
        LightEventHandler handler = new LightEventHandler();
        SmartHome smartHome = new SmartHome();
        Light light = new Light("1", true);
        smartHome.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(),
                "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, light.getId());

        assertTrue(light.isOn());
        handler.handle(smartHome, event);
        assertFalse(light.isOn());
    }
}