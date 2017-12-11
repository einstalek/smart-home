package ru.sbt.mipt.oop;
import ru.sbt.mipt.oop.handlers.DoorEventHandler;
import ru.sbt.mipt.oop.handlers.LightEventHandler;
import ru.sbt.mipt.oop.handlers.SimpleScenarioHandler;
import ru.sbt.mipt.oop.homeElements.Door;
import ru.sbt.mipt.oop.homeElements.Light;
import ru.sbt.mipt.oop.homeElements.Room;
import ru.sbt.mipt.oop.homeElements.SmartHome;
import ru.sbt.mipt.oop.sensors.SensorEventObserver;

import java.io.IOException;
import java.util.Collections;

import static java.util.Arrays.asList;

public class Application {

    public static void main(String... args) throws IOException {

        SmartHome smartHome = new SmartHome();
        Door door1 = new Door(false, "4");
        Light light1 = new Light("0", false);
        Light light2 = new Light("1", true);
        Light light3 = new Light("3", true);
        smartHome.addRoom(new Room(Collections.singletonList(light1), asList(door1, new Door(false, "3")), "bathroom"));
        smartHome.addRoom(new Room(Collections.singletonList(light2), Collections.singletonList(new Door(true, "8")), "hall"));
        smartHome.addRoom(new Room(Collections.singletonList(light3), Collections.singletonList(new Door(true, "7")), "kitchen"));

        SensorEventObserver observer = new SensorEventObserver(asList(new LightEventHandler(), new DoorEventHandler(), new SimpleScenarioHandler()));
        observer.observe(smartHome);

        new SaverXml().save(smartHome);

    }
}
