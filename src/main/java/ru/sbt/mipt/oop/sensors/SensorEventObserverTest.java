package ru.sbt.mipt.oop.sensors;

import org.junit.Test;
import ru.sbt.mipt.oop.handlers.DoorEventHandler;
import ru.sbt.mipt.oop.handlers.LightEventHandler;
import ru.sbt.mipt.oop.handlers.SimpleScenarioHandler;
import ru.sbt.mipt.oop.homeElements.SmartHome;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SensorEventObserverTest {
    @Test
    public void test() {
        SmartHome smartHome = mock(SmartHome.class);
        LightEventHandler lightEventHandler = mock(LightEventHandler.class);
        DoorEventHandler doorEventHandler = mock(DoorEventHandler.class);
        SimpleScenarioHandler simpleScenarioHandler = mock(SimpleScenarioHandler.class);

        SensorEventObserver sensorEventObserver = new SensorEventObserver(asList(lightEventHandler, doorEventHandler, simpleScenarioHandler));
        SensorEvent sensorEvent = mock(SensorEvent.class);
        sensorEventObserver.onEvent(smartHome, sensorEvent);

        verify(lightEventHandler).handle(smartHome, sensorEvent);
        verify(doorEventHandler).handle(smartHome, sensorEvent);
        verify(simpleScenarioHandler).handle(smartHome, sensorEvent);
    }
}