package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a Train.
 * This class encapsulates the data related to a train, primarily its bogies.
 */
public class Train {

    // Using ArrayList to store the list of bogies as per UC1 requirement
    private List<String> bogies;

    /**
     * Constructor to initialize an empty Train.
     */
    public Train() {
        // Initialize empty ArrayList for bogies
        this.bogies = new ArrayList<>();
    }

    /**
     * Retrieves the list of bogies.
     * @return List of passenger bogies
     */
    public List<String> getBogies() {
        return bogies;
    }

    /**
     * Sets the list of bogies.
     * @param bogies The new list of bogies
     */
    public void setBogies(List<String> bogies) {
        this.bogies = bogies;
    }
}
