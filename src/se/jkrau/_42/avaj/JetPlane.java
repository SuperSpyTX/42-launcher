package se.jkrau._42.avaj;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected JetPlane(String name, Coordinates coordinates) {
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
