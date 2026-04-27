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

        // --- UC7 OUTPUT ---
// Comparator - Sort Bogies by Capacity
        consistManager.demonstrateBogieSorting();

        // --- UC8 OUTPUT ---
// Stream API - Filter Bogies by Capacity
        consistManager.demonstrateBogieFiltering();

        // --- UC9 OUTPUT ---
// Stream API - Group Bogies by Category
        consistManager.demonstrateBogieGrouping();

        // --- UC10 OUTPUT ---
// Stream API - Aggregate total seating capacity
        consistManager.demonstrateTotalSeatingCapacity();

        // --- UC11 OUTPUT ---
// Regex validation for Train ID and Cargo Code
        consistManager.demonstrateTrainCargoValidation();

        // --- UC12 OUTPUT ---
// Goods Bogie safety validation
        consistManager.demonstrateGoodsBogieSafety();
        // --- UC13 OUTPUT ---
// Performance comparison (Loop vs Stream)
        consistManager.demonstratePerformanceComparison();
        // --- UC14 OUTPUT ---
// Custom Exception handling
        consistManager.demonstrateInvalidCapacityHandling();
        // --- UC15 OUTPUT ---
// Runtime exception handling for cargo safety
        consistManager.demonstrateCargoSafetyHandling();
        // --- UC16 OUTPUT ---
// Bubble Sort implementation
        consistManager.demonstrateBubbleSort();
        // --- UC18 OUTPUT ---
// Linear search on bogie IDs
        consistManager.demonstrateLinearSearch();
        // --- UC19 OUTPUT ---
// Binary search on sorted bogie IDs
        consistManager.demonstrateBinarySearch();

    }

}
