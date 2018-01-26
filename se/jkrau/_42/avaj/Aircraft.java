package se.jkrau._42.avaj;

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