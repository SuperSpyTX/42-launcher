package se.jkrau._42.avaj;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    /**
     * Package-visible constructor.
     */
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);

        switch (currentWeather) {
            case "SUN":
                this.coordinates.changeLongitude(10).changeHeight(2);
                this.log("Nice outside, I think I'm gonna go check things down there from up here!");
                break;
            case "RAIN":
                this.coordinates.changeLongitude(5);
                this.log("Rainy outside, I better be steady.");
                break;
            case "FOG":
                this.coordinates.changeLongitude(1);
                this.log("I can barely see anything in these dense vapors!  I better not get struck by Zeus.");
                break;
            case "SNOW":
                this.coordinates.changeHeight(-12);
                this.log("Oh man, Snowflakes.  Snowflakes everywhere!");
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
