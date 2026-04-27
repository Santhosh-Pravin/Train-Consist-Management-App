package core;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import model.Bogie;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import model.GoodsBogie;
import model.InvalidCapacityException;
import model. CargoSafetyException;

/**
 * Core component for managing different consist formations.
 * Demonstrates HashSet, LinkedList, and LinkedHashSet.
 */
public class ConsistManager {

    /**
     * UC3 - Maintains a collection of Unique Bogie IDs.
     * Uses HashSet to automatically ignore duplicate entries.
     */
    public void demonstrateUniqueIds() {
        System.out.println("\n--- UC3 OUTPUT ---");
        System.out.println("Demonstrating Unique Bogie IDs (HashSet):");
        
        // Use HashSet to automatically filter out duplicates
        Set<String> uniqueIds = new HashSet<>();
        
        System.out.println("Adding: B1, B2, B3, B1 (duplicate)");
        // Add bogie IDs
        uniqueIds.add("B1");
        uniqueIds.add("B2");
        uniqueIds.add("B3");
        // Attempting to add a duplicate - HashSet will ignore this
        uniqueIds.add("B1"); 
        
        System.out.println("Notice how duplicate 'B1' is ignored automatically.");
        System.out.println("Unique IDs: " + uniqueIds);
    }

    /**
     * UC4 - Manages Ordered Train Consist.
     * Uses LinkedList for efficient insertions and deletions at specific positions.
     */
    public void demonstrateOrderedConsist() {
        System.out.println("\n--- UC4 OUTPUT ---");
        System.out.println("Demonstrating Ordered Train Consist (LinkedList):");
        
        // LinkedList is ideal for frequently adding/removing elements from ends or middle
        LinkedList<String> orderedConsist = new LinkedList<>();
        
        System.out.println("Adding initial consist...");
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");
        
        System.out.println("Inserting 'Pantry Car' at index 2 (between Sleeper and AC)...");
        orderedConsist.add(2, "Pantry Car");
        
        System.out.println("Removing the first bogie (Engine)...");
        orderedConsist.removeFirst(); // Removes element at index 0
        
        System.out.println("Removing the last bogie (Guard)...");
        orderedConsist.removeLast();  // Removes the last element
        
        System.out.println("Final train order: " + orderedConsist);
    }

    /**
     * UC5 - Preserves Order + Uniqueness.
     * Uses LinkedHashSet to maintain insertion order while preventing duplicates.
     */
    public void demonstrateOrderAndUniqueness() {
        System.out.println("\n--- UC5 OUTPUT ---");
        System.out.println("Demonstrating Preserve Order + Uniqueness (LinkedHashSet):");
        
        // LinkedHashSet combines HashSet's uniqueness with LinkedList's order preservation
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        
        System.out.println("Adding: Engine, Sleeper, Cargo, Guard");
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        
        System.out.println("Trying to add duplicate: Sleeper");
        boolean isAdded = formation.add("Sleeper"); // This will return false
        
        if (!isAdded) {
            System.out.println("Duplicate 'Sleeper' was not added.");
        }
        
        System.out.println("Final Formation (Order preserved, no duplicates): " + formation);


    }

    /**
     * UC6 - Maps Bogie Type to Capacity.
     * Uses HashMap to associate each bogie with its seating/load capacity.
     */
    public void demonstrateBogieCapacityMapping() {
        System.out.println("\n--- UC6 OUTPUT ---");
        System.out.println("Demonstrating Bogie-Capacity Mapping (HashMap):");

        // Create HashMap
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        System.out.println("Adding bogie capacities...");

        // Insert values using put()
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 78);
        bogieCapacityMap.put("First Class", 24);

        // Iterating using entrySet()
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    ", Capacity: " + entry.getValue());
        }

        System.out.println("Program continues...");
    }

    /**
     * UC7 - Sort Bogies by Capacity using Comparator.
     */
    public void demonstrateBogieSorting() {
        System.out.println("\n--- UC7 OUTPUT ---");
        System.out.println("Sorting Bogies by Capacity (Comparator):");

        // Create List of Bogie objects
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        try{
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 78));
            bogies.add(new Bogie("First Class", 24));
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Sort using Comparator + Lambda
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nAfter Sorting (Ascending Capacity):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("Program continues...");
    }

    /**
     * UC8 - Filter Bogies using Stream API.
     */
    public void demonstrateBogieFiltering() {
        System.out.println("\n--- UC8 OUTPUT ---");
        System.out.println("Filtering Bogies with Capacity > 60 (Stream API):");

        // Create Bogie list (reuse same as UC7)
        List<Bogie> bogies = new ArrayList<>();
        try{
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 78));
            bogies.add(new Bogie("First Class", 24));
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Original Bogies:");
        bogies.forEach(System.out::println);

        // Filter using Stream API
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList(); // Java 16+

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println("Program continues...");
    }

    /**
     * UC9 - Group Bogies into categories using Stream collectors.
     */
    public void demonstrateBogieGrouping() {
        System.out.println("\n--- UC9 OUTPUT ---");
        System.out.println("Grouping Bogies by Name (Stream API & Collectors):");

        // Reuse Bogie list (as in UC7/UC8)
        List<Bogie> bogies = new ArrayList<>();
        try {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 78));
            bogies.add(new Bogie("First Class", 24));
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 78));
        } catch (InvalidCapacityException e) {
        System.out.println(e.getMessage());
        }

        System.out.println("Original Bogies:");
        bogies.forEach(System.out::println);

        // Grouping using Collectors.groupingBy()
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        System.out.println("\nGrouped Bogies:");
        groupedBogies.forEach((name, group) -> {
            System.out.println(name + " -> " + group);
        });

        System.out.println("Program continues...");
    }

    /**
     * UC10 - Aggregate seating capacities using Stream reduction.
     */
    public void demonstrateTotalSeatingCapacity() {
        System.out.println("\n--- UC10 OUTPUT ---");
        System.out.println("Calculating total seating capacity using Stream reduction:");

        // Reuse Bogie list (same as UC7–UC9)
        List<Bogie> bogies = new ArrayList<>();
        try{
           bogies.add(new Bogie("Sleeper", 72));
           bogies.add(new Bogie("AC Chair", 78));
           bogies.add(new Bogie("First Class", 24));
           bogies.add(new Bogie("Sleeper", 72));
           bogies.add(new Bogie("AC Chair", 78));
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Bogies and their capacities:");
        bogies.forEach(System.out::println);

        // Aggregate total capacity using map() + reduce()
        int totalCapacity = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal seating capacity: " + totalCapacity);
        System.out.println("Program continues...");
    }

    /**
     * UC11 - Validate Train ID and Cargo Code formats using Regular Expressions.
     */
    public void demonstrateTrainCargoValidation() {
        System.out.println("\n--- UC11 OUTPUT ---");
        System.out.println("Validating Train ID and Cargo Code formats:");

        Scanner scanner = new Scanner(System.in);

        // Prompt user for Train ID
        System.out.print("Enter Train ID (format TRN-1234): ");
        String trainId = scanner.nextLine();

        // Prompt user for Cargo Code
        System.out.print("Enter Cargo Code (format PET-XX): ");
        String cargoCode = scanner.nextLine();

        // Define regex patterns
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        // Match patterns
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validate input
        if (trainMatcher.matches()) {
            System.out.println("Train ID is valid: " + trainId);
        } else {
            System.out.println("Train ID is INVALID!");
        }

        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is valid: " + cargoCode);
        } else {
            System.out.println("Cargo Code is INVALID!");
        }

        System.out.println("Program continues...");
    }
    /**
     * UC12 - Validate Goods Bogie safety rules using Streams and Lambda expressions.
     */
    public void demonstrateGoodsBogieSafety() {
        System.out.println("\n--- UC12 OUTPUT ---");
        System.out.println("Checking Goods Bogie Safety Compliance:");

        // Create a list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Box", "Coal"));
        goodsBogies.add(new GoodsBogie("Flat", "Steel"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum")); // safe
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // unsafe example

        // Display the bogies
        System.out.println("Goods Bogies:");
        goodsBogies.forEach(System.out::println);

        // Safety rule: Cylindrical bogies can carry only Petroleum
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !b.getType().equalsIgnoreCase("Cylindrical")
                        || b.getCargo().equalsIgnoreCase("Petroleum"));

        if (isSafe) {
            System.out.println("\nTrain is safety compliant!");
        } else {
            System.out.println("\nTrain is NOT safety compliant!");
        }

        System.out.println("Program continues...");
    }
    /**
     * UC13 - Performance Comparison (Loop vs Stream)
     */
    public void demonstratePerformanceComparison() {

        System.out.println("\n--- UC13 OUTPUT ---");
        System.out.println("Comparing Loop vs Stream Performance:");

        // Step 1: Prepare a large collection of bogies
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            try{
               bogies.add(new Bogie("Sleeper", 72));
               bogies.add(new Bogie("AC Chair", 78));
               bogies.add(new Bogie("First Class", 24));
            } catch (InvalidCapacityException e) {
                System.out.println(e.getMessage());
            }
        }

        // ---------------- LOOP BASED ----------------
        long startLoop = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ---------------- STREAM BASED ----------------
        long startStream = System.nanoTime();

        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ---------------- RESULTS ----------------
        System.out.println("Loop Time (nanoseconds): " + loopTime);
        System.out.println("Stream Time (nanoseconds): " + streamTime);

        if (loopTime < streamTime) {
            System.out.println("Loop is faster in this run.");
        } else if (streamTime < loopTime) {
            System.out.println("Stream is faster in this run.");
        } else {
            System.out.println("Both performed equally.");
        }

        System.out.println("Program continues...");
    }
    /**
     * UC14 - Custom Exception for Invalid Bogie Capacity
     */
    public void demonstrateInvalidCapacityHandling() {

        System.out.println("\n--- UC14 OUTPUT ---");
        System.out.println("Validating Bogie Capacity using Custom Exception:");

        try {
            // Valid bogie
            Bogie valid = new Bogie("Sleeper", 72);
            System.out.println("Created: " + valid);

            // Invalid bogie
            Bogie invalid = new Bogie("Faulty", 0);
            System.out.println("Created: " + invalid);

        } catch (InvalidCapacityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
    private void assignCargoSafely(GoodsBogie bogie) {

        try {
            // Rule: Petroleum should NOT go in rectangular/box bogie
            if (bogie.getCargo().equalsIgnoreCase("Petroleum") &&
                    bogie.getType().equalsIgnoreCase("Box")) {

                throw new CargoSafetyException(
                        "Unsafe cargo assignment: Petroleum cannot be loaded in Box bogie!"
                );
            }

            System.out.println("Safe assignment: " + bogie);

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            System.out.println("Logging: Cargo check completed for -> " + bogie);
        }
    }
    /**
     * UC15 - Handle unsafe cargo using try-catch-finally
     */
    public void demonstrateCargoSafetyHandling() {

        System.out.println("\n--- UC15 OUTPUT ---");
        System.out.println("Handling Unsafe Cargo Assignments:");

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum")); // safe
        goodsBogies.add(new GoodsBogie("Box", "Coal"));              // safe
        goodsBogies.add(new GoodsBogie("Box", "Petroleum"));         // unsafe

        for (GoodsBogie bogie : goodsBogies) {
            assignCargoSafely(bogie);
        }

        System.out.println("Program continues safely...");
    }
    /**
     * UC16 - Bubble Sort Passenger Bogie Capacities
     */
    public void demonstrateBubbleSort() {

        System.out.println("\n--- UC16 OUTPUT ---");
        System.out.println("Bubble Sort on Passenger Bogie Capacities:");

        // Step 1: Create array of capacities
        int[] capacities = {72, 78, 24, 90, 55, 60};

        System.out.println("Before Sorting:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Step 2: Bubble Sort logic
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {
                    // swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Step 3: Print sorted array
        System.out.println("After Sorting:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\nProgram continues...");
    }
    /**
     * UC18 - Linear Search for Bogie ID
     */
    public void demonstrateLinearSearch() {

        System.out.println("\n--- UC18 OUTPUT ---");
        System.out.println("Linear Search on Bogie IDs:");

        // Step 1: Unsorted array of bogie IDs
        String[] bogieIds = {
                "B102",
                "B205",
                "B309",
                "B111",
                "B450"
        };

        // Step 2: Search key
        String searchKey = "B111";

        System.out.println("Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }
        System.out.println();

        System.out.println("Searching for: " + searchKey);

        // Step 3: Linear search logic
        boolean found = false;

        for (int i = 0; i < bogieIds.length; i++) {

            if (bogieIds[i].equals(searchKey)) {
                System.out.println("Bogie found at index: " + i);
                found = true;
                break; // early termination
            }
        }

        // Step 4: Result
        if (!found) {
            System.out.println("Bogie NOT found in the list.");
        }

        System.out.println("Program continues...");
    }
    /**
     * UC19 - Binary Search for Bogie IDs
     */
    public void demonstrateBinarySearch() {

        System.out.println("\n--- UC19 OUTPUT ---");
        System.out.println("Binary Search on Sorted Bogie IDs:");

        // Step 1: Sorted array (IMPORTANT precondition)
        String[] bogieIds = {
                "B101",
                "B205",
                "B309",
                "B410",
                "B550",
                "B720"
        };

        String searchKey = "B410";

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }
        System.out.println();

        System.out.println("Searching for: " + searchKey);

        // Step 2: Binary search setup
        int low = 0;
        int high = bogieIds.length - 1;

        boolean found = false;

        // Step 3: Binary search loop
        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = bogieIds[mid].compareTo(searchKey);

            if (comparison == 0) {
                System.out.println("Bogie found at index: " + mid);
                found = true;
                break;
            }
            else if (comparison < 0) {
                // mid is smaller → search right half
                low = mid + 1;
            }
            else {
                // mid is larger → search left half
                high = mid - 1;
            }
        }

        // Step 4: Result
        if (!found) {
            System.out.println("Bogie NOT found in the list.");
        }

        System.out.println("Program continues...");
    }

    /**
     * UC20 - Prevent search on empty train (Defensive Programming)
     */
    public void demonstrateSafeSearch(List<String> bogieIds, String searchKey) {

        System.out.println("\n--- UC20 OUTPUT ---");
        System.out.println("Defensive Search Operation:");

        // Step 1: Validate state BEFORE searching
        if (bogieIds == null || bogieIds.isEmpty()) {
            throw new IllegalStateException("Search aborted: No bogies available in the train!");
        }

        System.out.println("Bogie list is available. Proceeding with search...");

        // Step 2: Linear search (can also reuse UC18 logic)
        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                found = true;
                break;
            }
        }

        // Step 3: Result
        if (found) {
            System.out.println("Bogie FOUND: " + searchKey);
        } else {
            System.out.println("Bogie NOT FOUND: " + searchKey);
        }

        System.out.println("Program continues safely...");
    }

}
