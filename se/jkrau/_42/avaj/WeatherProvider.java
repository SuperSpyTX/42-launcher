package se.jkrau._42.avaj;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private static SecureRandom secureRandom;

    private WeatherProvider() {
        weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
        secureRandom = new SecureRandom();
    }

    /**
     * Returns the singleton instance of WeatherProvider.
     */
    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }

        return weatherProvider;
    }

    /**
     * Generates 6 random integers from SecureRandom, and multiplies coordinates with first 3 random
     * integers, same calculation is done for last 3 integers.  These two values are then compared to
     * as "temperature" and "humidity", and returns an appropriate value for weather.
     *
     * @param coordinates Coordinates of the current aircraft.
     * @return "RAIN", "FOG", "SUN", "SNOW"
     */
    public String getCurrentWeather(Coordinates coordinates) {
        byte[] randomBytes = new byte[36]; // sizeof(int) * 6
        secureRandom.nextBytes(randomBytes);
        int[] randomInts = new int[6];
        ByteBuffer buffer = ByteBuffer.wrap(randomBytes);
        for (int i = 0; i < 6; i++) {
            randomInts[i] = buffer.getInt(i);
        }

        int temperature = (coordinates.getLongitude() * randomInts[0])
                * (coordinates.getLatitude() * randomInts[1])
                * (coordinates.getHeight() * randomInts[2]) % 100;
        int humidity = (coordinates.getLongitude() * randomInts[3])
                * (coordinates.getLatitude() * randomInts[4])
                * (coordinates.getHeight() * randomInts[5]) % 100;

        if (temperature < 0)
            temperature *= -1;
        if (humidity < 0)
            humidity *= -1;

        // Not a meteorologist..

        if (humidity >= 60) {
            if (temperature >= 75) {
                return weather[0];
            } else if (temperature >= 40) {
                return weather[1];
            } else {
                return weather[3];
            }
        } else if (humidity >= 40) {
            if (temperature >= 70) {
                return weather[0];
            } else if (temperature >= 40) {
                return weather[1];
            } else {
                return weather[3];
            }
        }

        return weather[2];
    }
}
