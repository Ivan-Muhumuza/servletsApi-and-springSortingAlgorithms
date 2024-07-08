package org.amalitech.sortingalgorithms.dto;

/**
 * This class is a Data Transfer Object (DTO) used to encapsulate the array data in the request body.
 * It provides a structure for the request payload when invoking the sorting endpoints.
 */
public class SortRequest {
    private String array;
    private String algorithm;

    // Getters
    public String getArray() {
        return array;
    }

    public String getAlgorithm() {
        return algorithm;
    }

}