package se.jkrau._42.avaj;

import java.io.*;

public class Simulator {

    private WeatherTower weatherTower;
    private BufferedReader bufferedReader;
    private int iterations;

    public Simulator(WeatherTower tower, int iterations, String inputFile, String outputFile) throws FileNotFoundException {
        this.weatherTower = tower;
        this.iterations = iterations;
        this.bufferedReader = new BufferedReader(new FileReader(inputFile));
        Logger.getInstance().setOutputFile(outputFile);
    }

    public boolean parseFile() {
        try {
            this.iterations = Integer.parseInt(bufferedReader.readLine());

            String line;
            while ((line = this.bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void run() {
        for (int i = 0; i < this.iterations; i++) {
            this.weatherTower.changeWeather();
        }
    }
}
