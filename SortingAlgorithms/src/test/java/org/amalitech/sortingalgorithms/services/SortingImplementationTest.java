package org.amalitech.sortingalgorithms.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingImplementationTest {

    private SortingImplementation sortingImplementation = new SortingImplementation();

    @Test
    public void testHeapSort() {
        int[] inputArray = {12, 11, 13, 5, 6, 7};
        int[] expectedSortedArray = {5, 6, 7, 11, 12, 13};
        assertSortingAlgorithm(inputArray, expectedSortedArray, SortingAlgorithm.HEAP);
    }

    @Test
    public void testQuickSort() {
        int[] inputArray = {10, 7, 8, 9, 1, 5};
        int[] expectedSortedArray = {1, 5, 7, 8, 9, 10};
        assertSortingAlgorithm(inputArray, expectedSortedArray, SortingAlgorithm.QUICK);
    }

    @Test
    public void testMergeSort() {
        int[] inputArray = {38, 27, 43, 3, 9, 82, 10};
        int[] expectedSortedArray = {3, 9, 10, 27, 38, 43, 82};
        assertSortingAlgorithm(inputArray, expectedSortedArray, SortingAlgorithm.MERGE);
    }

    @Test
    public void testRadixSort() {
        int[] inputArray = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expectedSortedArray = {2, 24, 45, 66, 75, 90, 170, 802};
        assertSortingAlgorithm(inputArray, expectedSortedArray, SortingAlgorithm.RADIX);
    }

    @Test
    public void testBucketSort() {
        int[] inputArray = {8, 2, 5, 3, 7, 1, 4, 6};
        int[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
        assertSortingAlgorithm(inputArray, expectedSortedArray, SortingAlgorithm.BUCKET);
    }

    private void assertSortingAlgorithm(int[] inputArray, int[] expectedSortedArray, SortingAlgorithm algorithm) {
        int[] sortedArray = sortingImplementation.sort(inputArray, algorithm);
        assertArrayEquals(expectedSortedArray, sortedArray, "Sorting algorithm " + algorithm + " failed");
    }
}
