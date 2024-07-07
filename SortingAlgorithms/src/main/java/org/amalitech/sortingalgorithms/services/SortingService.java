package org.amalitech.sortingalgorithms.services;

/**
 * Interface SortingService defines the contract for classes that implement sorting algorithms.
 */
public interface SortingService {

    /**
     * Sorts the given array of integers in ascending order.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    int[] sort(int[] array);
}
