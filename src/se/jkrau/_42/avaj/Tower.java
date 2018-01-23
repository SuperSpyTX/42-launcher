package se.jkrau._42.avaj;

import java.util.List;

public class Tower {

    private List<Flyable> observers;
    private List<Flyable> remove;

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

        for (Flyable deadfly : remove) {
            if (observers.contains(deadfly)) {
                observers.remove(deadfly);
            }
        }
    }
}
