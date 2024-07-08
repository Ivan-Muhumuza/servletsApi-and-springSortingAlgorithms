package org.amalitech.sortingalgorithms.dto;

/**
 * This class is a Data Transfer Object (DTO) used to encapsulate the array data in the request body.
 * It provides a structure for the request payload when invoking the sorting endpoints.
 */
public class SortRequest {
    private String array;
    private String algorithm;

    // Getters and setters
    public String getArray() {
        return array;
    }

    public void setArray(String array) {
        this.array = array;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}