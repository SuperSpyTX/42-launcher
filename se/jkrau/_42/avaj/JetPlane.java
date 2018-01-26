package se.jkrau._42.avaj;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    /**
     * Package-visible constructor.
     */
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);

        switch (currentWeather) {
            case "SUN":
                this.coordinates.changeLatitude(10).changeHeight(2);
                this.log("This is nice.  Nice and shiny to take Instragram pictures.");
                break;
            case "RAIN":
                this.coordinates.changeLatitude(5);
                this.log("Oh man it's pouring, not digging this too much.");
                break;
            case "FOG":
                this.coordinates.changeLatitude(1);
                this.log("Kind of hard to see outside, I better be careful.");
                break;
            case "SNOW":
                this.coordinates.changeHeight(-7);
                this.log("Oh boy this is bad.  This is very bad. I'm heading down!");
                break;
        }

        if (this.coordinates.getHeight() == 0) {
            Logger.getInstance().log(this.getFullName() + " landing.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
