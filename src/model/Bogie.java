package model;

/**
 * Represents a Bogie with name and seating capacity.
 */
public class Bogie {

    private String name;
    private int capacity;

    public Bogie(String name, int capacity) throws InvalidCapacityException {

        if (capacity <= 0) {
            throw new InvalidCapacityException(
                    "Invalid capacity for bogie '" + name + "'. Capacity must be greater than 0."
            );
        }

        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}
