package org.amalitech.sortingalgorithms.controllers;

import org.amalitech.sortingalgorithms.dto.SortRequest;
import org.amalitech.sortingalgorithms.services.SortingService;
import org.amalitech.sortingalgorithms.services.SortingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class SortingWebController {

    @Autowired
    private SortingService sortingService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("sortRequest", new SortRequest());
        model.addAttribute("algorithms", SortingAlgorithm.values());
        return "index";
    }

    @PostMapping("/sort")
    public String sort(@ModelAttribute SortRequest sortRequest, Model model) {
        SortingAlgorithm algorithm = SortingAlgorithm.valueOf(sortRequest.getAlgorithm().toUpperCase());

        // Validate and convert the input string to an array of integers
        try {
            String arrayInput = sortRequest.getArray();
            if (arrayInput != null && !arrayInput.isEmpty()) {
                String[] stringArray = arrayInput.split(",");
                int[] array = Arrays.stream(stringArray)
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();

                // Create a copy of the original array to keep its original state
                int[] originalArray = Arrays.copyOf(array, array.length);

                // Sort the array using the selected algorithm
                int[] sortedArray = sortingService.sort(array, algorithm);

                // Convert arrays to strings for display
                String originalArrayString = Arrays.toString(originalArray);
                String sortedArrayString = Arrays.toString(sortedArray);

                // Add arrays to model attributes
                model.addAttribute("originalArray", originalArrayString);
                model.addAttribute("sortedArray", sortedArrayString);

                // Add sort request and algorithms to model
                model.addAttribute("sortRequest", sortRequest);
                model.addAttribute("algorithms", SortingAlgorithm.values());

                return "index";
            } else {
                model.addAttribute("error", "Input array cannot be empty.");
            }
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid input: Please enter a comma-separated list of integers.");
        }

        model.addAttribute("sortRequest", sortRequest);
        model.addAttribute("algorithms", SortingAlgorithm.values());
        return "index";
    }

}
