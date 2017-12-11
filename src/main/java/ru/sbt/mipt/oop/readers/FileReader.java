package ru.sbt.mipt.oop.readers;

import ru.sbt.mipt.oop.homeElements.SmartHome;

import java.io.IOException;

public interface FileReader {
    public SmartHome read() throws IOException;
}
