package se.jkrau._42.avaj;

import java.io.PrintStream;

public class Simulator {

    private WeatherTower weatherTower;
    private int iterations;

    public Simulator(WeatherTower tower, int iterations, String outputFile) {
        this.weatherTower = tower;
        this.iterations = iterations;
        Logger.getInstance().setOutputFile(outputFile);
    }

    public void run() {
        for (int i = 0; i < this.iterations; i++) {
            this.weatherTower.changeWeather();
        }
    }
}
