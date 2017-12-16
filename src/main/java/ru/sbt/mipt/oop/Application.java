package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");

//        SmartHome smartHome = new HomeJsonFileReader().read();


//        new SaverXml().save(smartHome);
    }

    public static SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
