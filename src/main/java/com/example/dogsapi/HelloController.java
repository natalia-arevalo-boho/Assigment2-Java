package com.example.dogsapi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloController {

    @FXML
    private ListView<Dog> resultListView;

    @FXML
    private TextField searchField;

    private final String apiKey = "Uw2rSNgY/8muWJZepCTc1g==FlqNwMTc0wmc50Qv";

    // Initialize method to set event handlers
    public void initialize() {
        resultListView.setOnMouseClicked(this::handleListItemClicked);
    }

    // Event handler for when an item in the resultListView is clicked
    @FXML
    private void handleListItemClicked(MouseEvent event) {
        Dog selectedDog = resultListView.getSelectionModel().getSelectedItem();
        if (selectedDog != null) {
            displayDogDetail(selectedDog);
        }
    }

    // Event handler for when the search button is clicked
    @FXML
    private void searchButtonClicked() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (!searchTerm.isEmpty()) {
            ObservableList<Dog> dogs = searchDogs(searchTerm);
            resultListView.setItems(dogs);
        }
    }

    // Method to search for dogs based on a search term
    private ObservableList<Dog> searchDogs(String searchTerm) {
        ObservableList<Dog> dogs = FXCollections.observableArrayList();
        try {
            String urlString = "https://api.api-ninjas.com/v1/dogs?name=" + searchTerm;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", apiKey);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Use Gson to parse the JSON response
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(response.toString(), JsonArray.class);
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : "";
                int coatLength = jsonObject.has("coat_length") ? jsonObject.get("coat_length").getAsInt() : 0; // Corrected field name and type
                int trainability = jsonObject.has("trainability") ? jsonObject.get("trainability").getAsInt() : 0;
                int energy = jsonObject.has("energy") ? jsonObject.get("energy").getAsInt() : 0;
                int minLifeExpectancy = jsonObject.has("min_life_expectancy") ? jsonObject.get("min_life_expectancy").getAsInt() : 0; // Corrected field name
                int maxLifeExpectancy = jsonObject.has("max_life_expectancy") ? jsonObject.get("max_life_expectancy").getAsInt() : 0; // Corrected field name
                String imageUrl = jsonObject.has("image_link") ? jsonObject.get("image_link").getAsString() : ""; // Corrected field name
                dogs.add(new Dog(name, coatLength, trainability, energy, minLifeExpectancy, maxLifeExpectancy, imageUrl));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dogs;
    }

    // Method to display detailed information about a selected dog
    private void displayDogDetail(Dog dog) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsview.fxml"));
            AnchorPane root = loader.load();

            // Send data to the second scene
            DogResultController controller = loader.getController();
            controller.setDog(dog);

            // Show the second scene
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Dog Details");
            popupStage.setScene(new Scene(root, 400, 600));
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
