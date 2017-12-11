package ru.sbt.mipt.oop.readers;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.homeElements.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class HomeJsonFileReader implements FileReader{

    @Override
    public SmartHome read() throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        return gson.fromJson(json, SmartHome.class);
    }
}
