package se.jkrau._42.avaj;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
