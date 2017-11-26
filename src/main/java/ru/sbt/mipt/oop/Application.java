package ru.sbt.mipt.oop;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String... args) throws IOException {

        SmartHome smartHome = new SmartHome();
        Door door = new Door(true, "2");
        Light light1 = new Light("0", true);
        Light light2 = new Light("1", true);
        smartHome.addRoom(new Room(Arrays.asList(light1, light2), Arrays.asList(door), "room"));

        SensorEventObserver observer = new SensorEventObserver();
        observer.addHandlers();
        observer.observe(smartHome);

    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}
