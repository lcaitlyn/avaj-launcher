package main.java.edu.lcaitlyn.avaj_launcher.utils;

import main.java.edu.lcaitlyn.avaj_launcher.exceptions.IllegalScenarioArgument;
import main.java.edu.lcaitlyn.avaj_launcher.exceptions.ScenarioNotFound;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReader {
    public static List<String> getScenario(File file) throws IOException {
        List<String> scenarios;

        try {
            scenarios = Files.readAllLines(file.toPath());
            if (scenarios.isEmpty()) {
                throw new ScenarioNotFound();
            }
            if (scenarios.size() < 2) {
                throw new IllegalScenarioArgument("Scenario should have at least 2 lines");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return scenarios;
    };
}
