package com.servlet.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataService {
    private Map<Integer, String> dataset = new HashMap<>(); // create dataset object for Internal storage for items

    /**
     * Retrieve an item from the dataset by ID.
     * @param id The ID of the item to retrieve.
     * @return Optional containing the item value if found, otherwise empty.
     */
    public Optional<String> getItem(int id) {
        return Optional.ofNullable(dataset.get(id));  // Return item value wrapped in Optional
    }

    /**
     * Retrieve all items in the dataset.
     * @return Map representing all items, where key is ID and value is item value.
     */
    public Map<Integer, String> getAllItems() {
        return dataset;  // Return the entire dataset
    }

    /**
     * Add a new item to the dataset.
     * @param value The value of the new item to add.
     * @return The ID assigned to the newly added item.
     */
    public int addItem(String value) {
        int id = dataset.size() + 1; // Generate new ID (incremental)
        dataset.put(id, value); // Add item to the dataset
        return id; // Return the ID of the newly added item
    }

    /**
     * Update an existing item in the dataset.
     * @param id The ID of the item to update.
     * @param newValue The new value to set for the item.
     * @return true if update successful (item exists), false otherwise.
     */
    public boolean updateItem(int id, String newValue) {
        if (dataset.containsKey(id)) { // Check if item with given ID exists
            dataset.put(id, newValue); // Update item value
            return true; // Return true indicating successful update
        }
        return false; // Return false indicating item not found for update
    }

    /**
     * Delete an item from the dataset.
     * @param id The ID of the item to delete.
     * @return true if deletion successful (item exists), false otherwise.
     */
    public boolean deleteItem(int id) {
        return dataset.remove(id) != null; // Remove item by ID and return true if removed successfully
    }
}
