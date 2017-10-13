package ru.sbt.mipt.oop;
import java.io.IOException;
import java.util.ArrayList;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {

        FileReader reader = new HomeInternetFileReader();
        SmartHome smartHome = reader.read();
        ArrayList<EventHandler> handlers = new ArrayList<>();
        handlers.add(new LightEventHandler());
        handlers.add(new DoorEventHandler());

        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler: handlers) {
                handler.handle(smartHome, event);
            }
            event = getNextSensorEvent();
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
