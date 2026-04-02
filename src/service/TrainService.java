package service;

import model.Train;
import java.util.List;

/**
 * Service class handling operations related to Train consists.
 */
public class TrainService {

    private Train train;

    public TrainService() {
        this.train = new Train();
    }

    public int getInitialBogieCount() {
        return train.getBogies().size();
    }

    // --- UC2 Methods ---

    /**
     * Add Passenger Bogies (ArrayList)
     */
    public void addBogies() {
        System.out.println("Adding standard passenger bogies...");
        List<String> bogies = train.getBogies();
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");
    }

    /**
     * Remove a specific bogie
     */
    public void removeBogie(String type) {
        System.out.println("Removing '" + type + "'...");
        train.getBogies().remove(type);
    }

    /**
     * Check if the train contains a specific bogie model
     */
    public void displayContainsBogie(String type) {
        boolean hasBogie = train.getBogies().contains(type);
        System.out.println("Check: contains(\"" + type + "\") -> " + hasBogie);
    }

    /**
     * Display current list of bogies
     */
    public void displayConsist() {
        System.out.println("Current list: " + train.getBogies());
    }
}
