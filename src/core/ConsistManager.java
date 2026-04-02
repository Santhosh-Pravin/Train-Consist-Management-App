package core;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Core component for managing different consist formations.
 */
public class ConsistManager {

    /**
     * UC3 - Maintains a collection of Unique Bogie IDs.
     * Uses HashSet to automatically ignore duplicate entries.
     */
    public void demonstrateUniqueIds() {
        System.out.println("Demonstrating Unique Bogie IDs (HashSet):");
        Set<String> uniqueIds = new HashSet<>();
        
        uniqueIds.add("B1");
        uniqueIds.add("B2");
        uniqueIds.add("B3");
        uniqueIds.add("B1"); // Attempting to add a duplicate
        
        System.out.println("Notice how duplicate 'B1' is ignored automatically.");
        System.out.println("Unique IDs: " + uniqueIds);
    }

    /**
     * UC4 - Manages Ordered Train Consist.
     * Uses LinkedList for efficient insertions and deletions at specific positions.
     */
    public void demonstrateOrderedConsist() {
        System.out.println("Demonstrating Ordered Train Consist (LinkedList):");
        LinkedList<String> orderedConsist = new LinkedList<>();
        
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");
        
        // Insert Pantry Car at index 2
        orderedConsist.add(2, "Pantry Car");
        
        // Remove First and Last bogie
        orderedConsist.removeFirst();
        orderedConsist.removeLast();
        
        System.out.println("Final train order: " + orderedConsist);
    }
}
