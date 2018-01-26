package se.jkrau._42.avaj;

/**
 * Base level class for all currently defined Aircraft.
 */
public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    /**
     * Returns and increments the id count, used to give unique IDs for each Aircraft.
     * @return the next ID to assign to an aircraft.
     */
    private long nextId() {
        return ++idCounter;
    }

    protected void log(String message) {
        Logger.getInstance().log(this.getFullName() + ": " + message);
    }

    public String getFullName() {
        return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
    }
}