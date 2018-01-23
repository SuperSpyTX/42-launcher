package se.jkrau._42.avaj;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {

    }
}
