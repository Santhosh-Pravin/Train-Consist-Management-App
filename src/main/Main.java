package main;

import service.TrainService;
import core.ConsistManager;

/**
 * Main application entry point for the Train Consist Management App.
 * Sequentially executes Use Cases 1 through 5.
 */
public class Main {

    public static void main(String[] args) {
        
        System.out.println("=== Train Consist Management App ===");

        // --- UC1 OUTPUT ---
        System.out.println("\n--- UC1 OUTPUT ---");
        // Initialize service, which in turn initializes the Train model and its empty ArrayList
        TrainService trainService = new TrainService();
        System.out.println("Initial bogie count: " + trainService.getInitialBogieCount());


        // --- UC2 OUTPUT ---
        System.out.println("\n--- UC2 OUTPUT ---");
        System.out.println("Demonstrating Passenger Bogies (ArrayList):");
        
        // Add bogies: Sleeper, AC Chair, First Class
        trainService.addBogies();
        
        // Display list
        trainService.displayConsist();
        
        // Remove "AC Chair"
        trainService.removeBogie("AC Chair");
        
        // Check contains("Sleeper")
        trainService.displayContainsBogie("Sleeper");
        
        // Print final list
        System.out.print("Final ");
        trainService.displayConsist();


        // Initialize Core Manager for UC3, UC4, UC5
        ConsistManager consistManager = new ConsistManager();

        // --- UC3 OUTPUT ---
        // HashSet - Unique Bogie IDs
        consistManager.demonstrateUniqueIds();

        // --- UC4 OUTPUT ---
        // LinkedList - Ordered Train Consist
        consistManager.demonstrateOrderedConsist();

        // --- UC5 OUTPUT ---
        // LinkedHashSet - Preserve Order + Uniqueness
        consistManager.demonstrateOrderAndUniqueness();

        // --- UC6 OUTPUT ---
        // HashMap - Bogie Capacity Mapping
        consistManager.demonstrateBogieCapacityMapping();
    }
}
