package ru.sbt.mipt.oop.readers;

import ru.sbt.mipt.oop.homeElements.SmartHome;

import java.io.IOException;

public class HomeInternetFileReader implements FileReader{
    @Override
    public SmartHome read() throws IOException {
        return new SmartHome();
    }
}
