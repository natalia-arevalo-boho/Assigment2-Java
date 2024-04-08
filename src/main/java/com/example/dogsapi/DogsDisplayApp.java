package com.example.dogsapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DogsDisplayApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dogs-view.fxml"));
            Parent root = loader.load();

            // Create a scene with the loaded FXML content
            Scene scene = new Scene(root);

            // Set the scene to the primary stage (main window)
            primaryStage.setScene(scene);

            // Set the title of the window
            primaryStage.setTitle("Dogs Display App");

            // Show the primary stage
            primaryStage.show();
        } catch (IOException e) {
            // Print stack trace if an exception occurs during loading
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
