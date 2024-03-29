package se.jkrau._42.avaj;

import java.io.*;

/**
 * Simulator Class to structure all Simulation code.
 * Designed to parse a scenario.txt file and output to a simulation file with a Logger.
 * @see se.jkrau._42.avaj.Logger
 */
public class Simulator {

    private WeatherTower weatherTower;
    private BufferedReader bufferedReader;
    private int iterations;
    private boolean debug;

    public Simulator(String inputFile, String outputFile, boolean debug) throws FileNotFoundException {
        this.weatherTower = new WeatherTower();
        this.iterations = 0;
        this.bufferedReader = new BufferedReader(new FileReader(inputFile));
        this.debug = debug;
        Logger.getInstance().setOutputFile(outputFile);
    }

    public boolean parse() {
        try {
            this.iterations = Integer.parseInt(bufferedReader.readLine());

            String line;
            int linecount = 1;
            while ((line = this.bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isWhitespace(line.charAt(i)) && line.charAt(i) != ' ') {
                        System.out.println("Error: Unexpected whitespace found at line " + linecount);
                        this.bufferedReader.close();
                        return false;
                    }
                }
                String[] fantasy = line.split(" ");
                if (fantasy.length != 5) {
                    System.out.println("Error: Incorrect amount of spaces at line " + linecount);
                    this.bufferedReader.close();
                    return false;
                }

                int nums[] = new int[3];

                for (int i = 2; i < fantasy.length; i++) {
                    try {
                        nums[i - 2] = Integer.parseInt(fantasy[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid parameters (no valid numbers) at line " + linecount);
                        this.bufferedReader.close();
                        return false;
                    }
                }

                try {
                    Flyable newAircraft = AircraftFactory.newAircraft(fantasy[0], fantasy[1], nums[0], nums[1], nums[2]);
                    newAircraft.registerTower(this.weatherTower);
                } catch (AircraftFactory.InvalidAircraftException e) {
                    System.out.println("Error: Invalid aircraft type '" + fantasy[0] + "' at line " + linecount);
                    this.bufferedReader.close();
                    return false;
                }

                linecount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Error: No number listed at the top of the file.");
            return false;
        }

        return true;
    }

    public void run() {
        for (int i = 0; i < this.iterations; i++) {
            if (this.debug)
                Logger.getInstance().log(" ---------------- ITERATION " + i + " ---------------------");
            this.weatherTower.changeWeather();
        }
    }

}
