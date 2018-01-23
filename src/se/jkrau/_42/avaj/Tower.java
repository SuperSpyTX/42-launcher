package se.jkrau._42.avaj;

import java.util.List;

public class Tower {

    private List<Flyable> observers;
    private List<Flyable> removal;

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        removal.add(flyable);
    }

    protected void conditionsChanged() {

    }
}
