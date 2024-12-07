package main.java.edu.lcaitlyn.avaj_launcher;

import main.java.edu.lcaitlyn.avaj_launcher.dto.Flyable;
import main.java.edu.lcaitlyn.avaj_launcher.exceptions.BrokenScenarioFile;
import main.java.edu.lcaitlyn.avaj_launcher.exceptions.ScenarioNotFound;
import main.java.edu.lcaitlyn.avaj_launcher.exceptions.WrongArgumentException;
import main.java.edu.lcaitlyn.avaj_launcher.utils.FileReader;
import main.java.edu.lcaitlyn.avaj_launcher.utils.ScenarioReader;

import java.io.File;
import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new WrongArgumentException();
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            throw new ScenarioNotFound();
        }
        if (!file.isFile() || !file.canRead()) {
            throw new BrokenScenarioFile();
        }

        List<String> scenario = FileReader.getScenario(file);

        int simulationNumber = ScenarioReader.getSimulationNumber(scenario);
        List<Flyable> aircrafts = ScenarioReader.getAircrafts(scenario);

        Simulation.launch(simulationNumber, aircrafts);
    }
}
