package se.jkrau._42.avaj;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider() {
        weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};

    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }

        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

    }
}
