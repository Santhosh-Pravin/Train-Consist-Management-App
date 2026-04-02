package main;

import service.TrainService;

/**
 * Main application entry point for the Train Consist Management App.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        TrainService trainService = new TrainService();

        // --- UC1 OUTPUT ---
        System.out.println("\n--- UC1 OUTPUT ---");
        System.out.println("Initial bogie count: " + trainService.getInitialBogieCount());

        // --- UC2 OUTPUT ---
        System.out.println("\n--- UC2 OUTPUT ---");
        // Add passenger bogies
        trainService.addBogies();
        
        // Display list
        trainService.displayConsist();
        
        // Remove AC Chair
        trainService.removeBogie("AC Chair");
        
        // Check contains
        trainService.displayContainsBogie("Sleeper");
        
        // Print final list
        System.out.print("Final ");
        trainService.displayConsist();
    }
}
