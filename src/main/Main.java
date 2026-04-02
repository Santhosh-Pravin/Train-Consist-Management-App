package main;

import service.TrainService;
import core.ConsistManager;

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
        trainService.addBogies();
        trainService.displayConsist();
        trainService.removeBogie("AC Chair");
        trainService.displayContainsBogie("Sleeper");
        System.out.print("Final ");
        trainService.displayConsist();

        // --- UC3 OUTPUT ---
        System.out.println("\n--- UC3 OUTPUT ---");
        ConsistManager consistManager = new ConsistManager();
        consistManager.demonstrateUniqueIds();

        // --- UC4 OUTPUT ---
        System.out.println("\n--- UC4 OUTPUT ---");
        consistManager.demonstrateOrderedConsist();
    }
}
