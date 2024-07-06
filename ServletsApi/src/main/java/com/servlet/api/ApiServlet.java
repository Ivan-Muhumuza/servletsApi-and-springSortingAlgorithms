package com.servlet.api;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import org.json.JSONObject;

@WebServlet()
public class ApiServlet extends HttpServlet {
    private DataService dataService = new DataService();  // Initialize the data service to handle data operations

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json"); // Set response content type to JSON

        String pathInfo = req.getPathInfo(); // Get the path info from the request

        if (pathInfo == null || pathInfo.equals("/")) {
            // Return all items
            String allItemsJson = dataService.getAllItems()
                    .entrySet()
                    .stream()
                    .map(entry -> "{\"id\":" + entry.getKey() + ", \"value\":\"" + entry.getValue() + "\", \"links\":[{\"rel\":\"self\", \"href\":\"/api/" + entry.getKey() + "\"}]}")
                    .collect(Collectors.joining(", ", "[", "]"));  // Convert all items to JSON format

            out.write(allItemsJson); // Write the JSON response
        } else {
            // Return specific item by ID
            String idStr = pathInfo.substring(1); // Get the ID from the path
            if (idStr.isEmpty()) {
                out.write("{\"error\":\"No ID provided\"}");
                return;
            }

            int id = Integer.parseInt(idStr); // Parse the ID to an integer
            Optional<String> item = dataService.getItem(id); // Retrieve the item from the data service
            if (item.isPresent()) {
                String value = item.get();
                out.write("{\"id\":" + id + ", \"value\":\"" + value + "\", \"links\":[{\"rel\":\"self\", \"href\":\"/api/" + id + "\"}]}");
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // Set response status to 404 if item not found
                out.write("{\"error\":\"Item not found\"}");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String value = req.getParameter("value"); // Get the value from the request parameters
        int id = dataService.addItem(value);  // Add the item to the data service and get the new ID

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json"); // Set response content type to JSON
        resp.setStatus(HttpServletResponse.SC_CREATED);  // Set response status to 201 Created
        out.write("{\"id\":" + id + ", \"value\":\"" + value + "\", \"links\":[{\"rel\":\"self\", \"href\":\"/api/" + id + "\"}]}");  // Write the created item as JSON
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getPathInfo().substring(1)); // Get the ID from the path and parse it to an integer

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);  // Read the request body into a StringBuilder
            }
        }

        String jsonString = sb.toString(); // Convert the StringBuilder to a string
        JSONObject jsonObject = new JSONObject(jsonString);  // Parse the string to a JSON object
        String newValue = jsonObject.getString("value"); // Get the new value from the JSON object

        if (dataService.updateItem(id, newValue)) {
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json"); // Set response content type to JSON
            resp.setStatus(HttpServletResponse.SC_OK); // Set response status to 200 OK
            out.write("{\"id\":" + id + ", \"value\":\"" + newValue + "\", \"links\":[{\"rel\":\"self\", \"href\":\"/api/" + id + "\"}]}");  // Write the updated item as JSON
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);  // Set response status to 404 if item not found
            PrintWriter out = resp.getWriter();
            out.write("{\"error\":\"Item not found\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json"); // Set response content type to JSON

        String idStr = req.getPathInfo().substring(1);  // Get the ID from the path
        if (idStr.isEmpty()) {
            out.write("{\"error\":\"No ID provided\"}");
            return;
        }

        int id = Integer.parseInt(idStr); // Parse the ID to an integer
        if (dataService.deleteItem(id)) {
            resp.setStatus(HttpServletResponse.SC_OK); // 200 OK
            out.write("{\"message\":\"Item deleted successfully\"}");
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);  // Set response status to 404 if item not found
            out.write("{\"error\":\"Item not found\"}");
        }
    }
}
