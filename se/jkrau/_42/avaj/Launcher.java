package se.jkrau._42.avaj;

import java.io.FileNotFoundException;

public class Launcher {

    private static final String OUTPUT_FILE = "simulator.txt";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: se.jkrau._42.avaj.Launcher [scenario-file]");
            return;
        }

        try {
            Simulator simulator = new Simulator(args[0], "simulation.txt");
            if (!simulator.parseFile()) {
                return;
            }

            simulator.run();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File could not be opened or found.");
            e.printStackTrace();
        }
    }

}
