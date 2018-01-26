package se.jkrau._42.avaj;

import java.util.ArrayList;
import java.util.List;

/**
 * Base level class for all Tower objects.
 */
public class Tower {

    private List<Flyable> observers;

    private List<Flyable> remove;

    /**
     * Package-visible constructor.
     */
    Tower() {
        this.observers = new ArrayList<>();
        this.remove = new ArrayList<>();
    }

    protected void log(String message) {
        Logger.getInstance().log("Tower says: " + message);
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        remove.add(flyable);
    }

    protected void conditionsChanged() {
        // Update all Flyables with updateConditions()
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }

        observers.removeAll(this.remove);
        this.remove.clear();
    }
}
