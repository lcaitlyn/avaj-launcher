package main.java.edu.lcaitlyn.avaj_launcher.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private final String FILENAME = "simulation.txt";
    private static Logger instance;
    private PrintWriter printWriter;

    private Logger() {
        File file = new File(FILENAME);

        if (file.exists()) {
            file.delete();
            file = new File(FILENAME);
        }

        try {
            printWriter = new PrintWriter(new FileWriter(file, true), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        printWriter.println(message);
    }

    public void close() {
        printWriter.close();
    }
}
