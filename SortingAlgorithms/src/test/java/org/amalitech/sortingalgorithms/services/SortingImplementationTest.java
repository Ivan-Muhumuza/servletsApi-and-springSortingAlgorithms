package org.amalitech.sortingalgorithms.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Unit tests for SortingImplementation class.
 */
public class SortingImplementationTest {

    // Create an instance of SortingImplementation to test its methods
    private final SortingImplementation sortingService = new SortingImplementation();

    @Test
    public void testHeapSort() {
        // Test data
        int[] array = {4, 10, 3, 5, 1};
        int[] sortedArray = {1, 3, 4, 5, 10};

        // Call heapSort method and assert the result matches the expected sortedArray
        assertArrayEquals(sortedArray, sortingService.heapSort(array));
    }

    @Test
    public void testQuickSort() {
        // Test data
        int[] array = {4, 10, 3, 5, 1};
        int[] sortedArray = {1, 3, 4, 5, 10};

        // Call quickSort method and assert the result matches the expected sortedArray
        assertArrayEquals(sortedArray, sortingService.quickSort(array));
    }

    @Test
    public void testMergeSort() {
        // Test data
        int[] array = {4, 10, 3, 5, 1};
        int[] sortedArray = {1, 3, 4, 5, 10};

        // Call mergeSort method and assert the result matches the expected sortedArray
        assertArrayEquals(sortedArray, sortingService.mergeSort(array));
    }

    @Test
    public void testRadixSort() {
        // Test data
        int[] array = {4, 10, 3, 5, 1};
        int[] sortedArray = {1, 3, 4, 5, 10};

        // Call radixSort method and assert the result matches the expected sortedArray
        assertArrayEquals(sortedArray, sortingService.radixSort(array));
    }

    @Test
    public void testBucketSort() {
        // Test data
        int[] array = {4, 10, 3, 5, 1};
        int[] sortedArray = {1, 3, 4, 5, 10};

        // Call bucketSort method and assert the result matches the expected sortedArray
        assertArrayEquals(sortedArray, sortingService.bucketSort(array));
    }
}
