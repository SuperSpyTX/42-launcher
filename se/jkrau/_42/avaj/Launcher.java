package se.jkrau._42.avaj;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main entry point in the program.
 */
public class Launcher {

    /**
     * Few hardcoded variables for debugging/easy changes.
     */
    private static final String OUTPUT_FILE = "simulation.txt";

    private static final boolean DEBUG_OUTPUT = false;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: se.jkrau._42.avaj.Launcher [scenario-file]");
            return;
        }

        try {
            Simulator simulator = new Simulator(args[0], OUTPUT_FILE, DEBUG_OUTPUT);
            if (!simulator.parse()) {
                return;
            }

            simulator.run();

            Logger.getInstance().close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File could not be opened or found.");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
