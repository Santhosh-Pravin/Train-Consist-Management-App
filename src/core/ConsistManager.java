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
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));
        bogies.add(new Bogie("First Class", 24));

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
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));
        bogies.add(new Bogie("First Class", 24));

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
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));

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
}
