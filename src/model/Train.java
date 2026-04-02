package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a Train.
 */
public class Train {

    private List<String> bogies;

    public Train() {
        // UC1: Initialize empty ArrayList for bogies
        this.bogies = new ArrayList<>();
    }

    public List<String> getBogies() {
        return bogies;
    }

    public void setBogies(List<String> bogies) {
        this.bogies = bogies;
    }
}
