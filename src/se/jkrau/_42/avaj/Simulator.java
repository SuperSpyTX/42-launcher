package se.jkrau._42.avaj;

import java.io.PrintStream;

public class Simulator {

    private WeatherTower weatherTower;
    private PrintStream printStream;
    private int iterations;

    public Simulator(WeatherTower tower, PrintStream output, int iterations) {
        this.weatherTower = tower;
        this.printStream = output;
        this.iterations = iterations;
    }

    public void run() {
        for (int i = 0; i < this.iterations; i++) {
            this.weatherTower.changeWeather();
        }
    }
}
