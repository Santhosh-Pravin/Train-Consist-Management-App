package core;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.Set;

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
}
