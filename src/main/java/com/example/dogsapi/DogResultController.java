package com.example.dogsapi;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DogResultController {

    @FXML
    private ImageView dogImageView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label coatLengthLabel;

    @FXML
    private Label trainabilityLabel;

    @FXML
    private Label energyLabel;

    @FXML
    private Label minLifeExpectancyLabel;

    @FXML
    private Label maxLifeExpectancyLabel;

    @FXML
    private Button backButton;

    private Dog dog;

    public void initialize() {
        if (dog != null) {
            nameLabel.setText("Dog breed: " + dog.getName());
            coatLengthLabel.setText("Coat length: " + dog.getCoatLength());
            trainabilityLabel.setText("Trainability: " + dog.getTrainability());
            energyLabel.setText("Energy: " + dog.getEnergy());
            minLifeExpectancyLabel.setText("Min. Life Expectancy: " + dog.getMinLifeExpectancy() + " years");
            maxLifeExpectancyLabel.setText("Max. Life Expectancy: " + dog.getMaxLifeExpectancy() + " years");

            // Load the dog image if the URL is not null or empty
            if (dog.getImageUrl() != null && !dog.getImageUrl().isEmpty()) {
                Image image = new Image(dog.getImageUrl());
                dogImageView.setImage(image);
            }
        }
    }

    public void setDog(Dog dog) {
        this.dog = dog;
        initialize(); // calls initialize to display dog details
    }

    @FXML
    private void handleBackButtonClick() {
        // Close the current window
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
