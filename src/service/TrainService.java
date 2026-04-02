package service;

import model.Train;
import java.util.List;

/**
 * Service class handling operations related to Train consists.
 * Encapsulates the business logic, keeping it separate from Main.
 */
public class TrainService {

    private Train train;

    /**
     * Constructor initializes a new Train instance.
     * Fulfills UC1: Initialize empty ArrayList for bogies.
     */
    public TrainService() {
        this.train = new Train();
    }

    /**
     * Gets the initial bogie count.
     * Features: Display initial bogie count using .size().
     * @return The count of bogies (initially 0).
     */
    public int getInitialBogieCount() {
        return train.getBogies().size();
    }

    /**
     * UC2 - Adds standard passenger bogies to the train's ArrayList.
     */
    public void addBogies() {
        System.out.println("Adding standard bogies...");
        List<String> currentBogies = train.getBogies();
        
        currentBogies.add("Sleeper");
        currentBogies.add("AC Chair");
        currentBogies.add("First Class");
    }

    /**
     * UC2 - Removes a specific bogie from the list.
     * @param type The type of bogie to remove (e.g., "AC Chair").
     */
    public void removeBogie(String type) {
        System.out.println("Removing: " + type);
        train.getBogies().remove(type);
    }

    /**
     * UC2 - Checks if a specific bogie type exists in the consist.
     * @param type The type to check for.
     */
    public void displayContainsBogie(String type) {
        boolean hasBogie = train.getBogies().contains(type);
        System.out.println("Check: contains(\"" + type + "\") -> " + hasBogie);
    }

    /**
     * Utility method to display the current consist.
     */
    public void displayConsist() {
        System.out.println("Current list: " + train.getBogies());
    }
}
