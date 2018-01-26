package se.jkrau._42.avaj;

/**
 * Derived Tower class designated for weather reporting.
 * @see se.jkrau._42.avaj.Tower
 */
public class WeatherTower extends Tower {

    /**
     * Calls singleton to provide current weather information for given coordinates.
     * @param coordinates The given Aircraft's coordinates.
     * @see se.jkrau._42.avaj.WeatherProvider
     */
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    /**
     * Override to log register messages from weather tower (if Flyable is an Aircraft).
     * @param flyable The flyable object.
     */
    @Override
    public void register(Flyable flyable) {
        super.register(flyable);

        if (flyable instanceof Aircraft) {
            this.log(((Aircraft)flyable).getFullName() + " registered to weather tower.");
        }
    }

    /**
     * Override to log unregister messages from weather tower (if Flyable is an Aircraft).
     * @param flyable The flyable object
     */
    @Override
    public void unregister(Flyable flyable) {
        super.unregister(flyable);

        if (flyable instanceof Aircraft) {
            this.log(((Aircraft)flyable).getFullName() + " unregistered from weather tower.");
        }
    }

    /**
     * Package-visible method called on each simulation tick.
     */
    void changeWeather() {
        this.conditionsChanged();
    }
}