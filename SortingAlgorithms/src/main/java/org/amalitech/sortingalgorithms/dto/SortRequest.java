package org.amalitech.sortingalgorithms.dto;

/**
 * This class is a Data Transfer Object (DTO) used to encapsulate the array data in the request body.
 * It provides a structure for the request payload when invoking the sorting endpoints.
 */
public class SortRequest {

    // Array to be sorted
    private int[] array;

    /**
     * Gets the array to be sorted.
     *
     * @return the array to be sorted
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Sets the array to be sorted.
     *
     * @param array the array to be sorted
     */
    public void setArray(int[] array) {
        this.array = array;
    }
}