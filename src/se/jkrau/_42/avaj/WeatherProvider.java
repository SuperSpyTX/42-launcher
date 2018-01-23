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

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }

        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        byte[] randomBytes = new byte[36]; // sizeof(int) * 6
        secureRandom.nextBytes(randomBytes);
        int[] randomInts = new int[6];
        ByteBuffer buffer = ByteBuffer.wrap(randomBytes);
        for (int i = 0; i < 6; i++) {
            randomInts[i] = buffer.getInt(i);
        }

        // Temperature is assumed to be in farenheit.
        // Humidity is assumed to be relative humidity.

        int temperature = (coordinates.getLongitude() * randomInts[0])
                * (coordinates.getLatitude() * randomInts[1])
                * (coordinates.getHeight() * randomInts[2]) % 100;
        int humidity = (coordinates.getLongitude() * randomInts[3])
                * (coordinates.getLatitude() * randomInts[4])
                * (coordinates.getHeight() * randomInts[5]) % 100;

        // Not a meteorologist..

        if ((humidity >= 80 && temperature <= 75) || (humidity <= 20 && temperature >= 70)) {
            return weather[1];
        }

        if (humidity >= 50) {
            if (temperature <= 40 && temperature >= 20) {
                return weather[3];
            } else if (temperature >= 40) {
                return weather[0];
            }
        }

        return weather[2];
    }
}
