package se.jkrau._42.avaj;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    @Override
    public void register(Flyable flyable) {
        super.register(flyable);

        if (flyable instanceof Aircraft) {
            this.log(((Aircraft)flyable).getFullName() + " registered to weather tower.");
        }
    }

    @Override
    public void unregister(Flyable flyable) {
        super.unregister(flyable);


        if (flyable instanceof Aircraft) {
            this.log(((Aircraft)flyable).getFullName() + " unregistered from weather tower.");
        }
    }

    void changeWeather() {
        // Change weather here?
        this.conditionsChanged();
    }
}