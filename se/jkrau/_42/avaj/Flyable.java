package se.jkrau._42.avaj;

/**
 * Function level interface for all flying objects that can be registered to a Tower.
 * @see se.jkrau._42.avaj.Tower
 */
public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}