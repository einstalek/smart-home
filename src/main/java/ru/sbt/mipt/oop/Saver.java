package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.homeElements.SmartHome;

import java.io.IOException;

public interface Saver {
    public void save(SmartHome smartHome) throws IOException;
}
