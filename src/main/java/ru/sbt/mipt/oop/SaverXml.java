package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.homeElements.SmartHome;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaverXml implements Saver {
    @Override
    public void save(SmartHome smartHome) throws IOException {
        String result = "";
        ArrayList<String> strings = new ArrayList<>();
        smartHome.executeAction(o -> strings.add(o.toString()));
        for (String s: strings) {
            switch (s.split("-")[0]) {
                case "room": {
                    result += "\t <room>" + s.split("-")[1] + "</room>\n";
                    break;
                }
                case "light":
                    result += "\t\t <light>" + s.split("-")[1] + "</light>\n";
                    break;
                case "door":
                    result += "\t\t <door>" + s.split("-")[1] + "</door>\n";
                    break;
                default:
                    result += "<" + s + "> \n";
                    break;
            }
        }
        result += "</home>";
        FileWriter fileWriter = new FileWriter("smart-home.xml");
        fileWriter.write(result);
        fileWriter.close();
    }
}
