package se.jkrau._42.avaj;

/**
 * Factory pattern for creating Aircraft classes.
 * @see se.jkrau._42.avaj.Aircraft
 */
public class AircraftFactory {

    /**
     * Custom exception if invalid Aircraft has been selected.
     */
    public static class InvalidAircraftException extends Throwable {
        InvalidAircraftException(String type) {
            super("'" + type + "' is not a valid Aircraft Type.");
        }
    }

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
            throws InvalidAircraftException {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Flyable fly;

        switch (type) {
            case "Baloon":
                fly = new Baloon(name, coordinates);
                break;
            case "JetPlane":
                fly = new JetPlane(name, coordinates);
                break;
            case "Helicopter":
                fly = new Helicopter(name, coordinates);
                break;
            default:
                throw new InvalidAircraftException(type);
        }

        return fly;
    }
}
