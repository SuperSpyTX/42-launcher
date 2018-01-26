package se.jkrau._42.avaj;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    /**
     * Package-visible constructor.
     */
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);

        switch (currentWeather) {
            case "SUN":
                this.coordinates.changeLongitude(2).changeHeight(4);
                this.log("Nice view from here! I can't believe it's not Civilization 5.");
                break;
            case "RAIN":
                this.coordinates.changeHeight(-5);
                this.log("Aww I'm getting rained on, going down!");
                break;
            case "FOG":
                this.coordinates.changeHeight(-3);
                this.log("I feel too much vapor, I can't stay up!");
                break;
            case "SNOW":
                this.coordinates.changeHeight(-15);
                this.log("Sigh.  I guess I'm not a Baloon anymore.");
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
