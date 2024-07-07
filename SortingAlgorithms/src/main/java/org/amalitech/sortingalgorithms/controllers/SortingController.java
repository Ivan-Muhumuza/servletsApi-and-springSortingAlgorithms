package org.amalitech.sortingalgorithms.controllers;

import org.amalitech.sortingalgorithms.services.SortingService;
import org.amalitech.sortingalgorithms.services.SortingImplementation;
import org.amalitech.sortingalgorithms.dto.SortRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class defines a REST controller for sorting operations.
 * It is marked with @RestController to indicate that it is a controller and to enable RESTful web services.
 */
@RestController
@RequestMapping("/api/sorting")
public class SortingController {

    // Automatically injects the SortingService bean defined in the configuration class.
    @Autowired
    private SortingService sortingService;

    /**
     * Endpoint for performing Heap Sort.
     * The @PostMapping annotation maps HTTP POST requests to this method.
     * The @RequestBody annotation binds the request body to the method parameter.
     *
     * @param request the request containing the array to be sorted
     * @return the sorted array
     */
    @PostMapping("/heapSort")
    public int[] heapSort(@RequestBody SortRequest request) {
        return ((SortingImplementation) sortingService).heapSort(request.getArray());
    }

    /**
     * Endpoint for performing Quick Sort.
     *
     * @param request the request containing the array to be sorted
     * @return the sorted array
     */
    @PostMapping("/quickSort")
    public int[] quickSort(@RequestBody SortRequest request) {
        return ((SortingImplementation) sortingService).quickSort(request.getArray());
    }

    /**
     * Endpoint for performing Merge Sort.
     *
     * @param request the request containing the array to be sorted
     * @return the sorted array
     */
    @PostMapping("/mergeSort")
    public int[] mergeSort(@RequestBody SortRequest request) {
        return ((SortingImplementation) sortingService).mergeSort(request.getArray());
    }

    /**
     * Endpoint for performing Radix Sort.
     *
     * @param request the request containing the array to be sorted
     * @return the sorted array
     */
    @PostMapping("/radixSort")
    public int[] radixSort(@RequestBody SortRequest request) {
        return ((SortingImplementation) sortingService).radixSort(request.getArray());
    }

    /**
     * Endpoint for performing Bucket Sort.
     *
     * @param request the request containing the array to be sorted
     * @return the sorted array
     */
    @PostMapping("/bucketSort")
    public int[] bucketSort(@RequestBody SortRequest request) {
        return ((SortingImplementation) sortingService).bucketSort(request.getArray());
    }
}