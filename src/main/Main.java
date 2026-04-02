package main;

import service.TrainService;

/**
 * Main application entry point for the Train Consist Management App.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // --- UC1 OUTPUT ---
        System.out.println("\n--- UC1 OUTPUT ---");
        TrainService trainService = new TrainService();
        System.out.println("Initial bogie count: " + trainService.getInitialBogieCount());
    }
}
