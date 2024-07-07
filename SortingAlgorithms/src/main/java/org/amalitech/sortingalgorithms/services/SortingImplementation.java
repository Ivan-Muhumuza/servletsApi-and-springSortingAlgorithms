package org.amalitech.sortingalgorithms.services;

import org.springframework.stereotype.Service;

/**
 * This class implements the SortingService interface and provides concrete implementations
 * of various sorting algorithms.
 */
@Service
public class SortingImplementation implements SortingService {

    /**
     * Default sort method that uses Quick Sort.
     * This method overrides the sort method in the SortingService interface.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] array) {
        return quickSort(array); // Default sorting method
    }

    /**
     * Performs Heap Sort on the given array.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public int[] heapSort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
        return array;
    }

    /**
     * Helper method to heapify a subtree rooted with node i which is an index in the array.
     *
     * @param array the array representation of the heap
     * @param n the size of the heap
     * @param i the index of the subtree root
     */
    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    /**
     * Performs Quick Sort on the given array.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Helper method to recursively sort subarrays.
     *
     * @param array the array to be sorted
     * @param low the starting index
     * @param high the ending index
     */
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // pi is partitioning index, array[pi] is now at right place
            int pi = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * Helper method to partition the array and return the partition index.
     *
     * @param array the array to be partitioned
     * @param low the starting index
     * @param high the ending index
     * @return the partition index
     */
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     * Performs Merge Sort on the given array.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public int[] mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            // Copy data to temporary arrays left[] and right[]
            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            // Recursively sort two halves
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted halves into original array
            merge(array, left, right);
        }
        return array;
    }

    /**
     * Helper method to merge two sorted subarrays into a single sorted array.
     *
     * @param array the array to store the merged result
     * @param left the left sorted subarray
     * @param right the right sorted subarray
     */
    private void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge left and right arrays into array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    /**
     * Performs Radix Sort on the given array.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public int[] radixSort(int[] array) {
        int max = getMax(array);

        // Perform counting sort for every digit. Instead of passing digit number,
        // exp is passed. exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
        return array;
    }

    /**
     * Helper method to perform counting sort on the array according to the digit represented by exp.
     *
     * @param array the array to be sorted
     * @param exp the exponent representing the digit position
     */
    private void countSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Count array to store count of digits 0-9

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to array[], so that array[] contains sorted numbers according to current digit
        System.arraycopy(output, 0, array, 0, n);
    }

    /**
     * Helper method to get the maximum value in the array.
     *
     * @param array the array to be examined
     * @return the maximum value in the array
     */
    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Performs Bucket Sort on the given array.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public int[] bucketSort(int[] array) {
        int max = getMax(array);
        int[] bucket = new int[max + 1];

        // Count the occurrences of each element
        for (int value : array) {
            bucket[value]++;
        }

        // Generate the sorted array
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                array[outPos++] = i;
            }
        }
        return array;
    }
}
