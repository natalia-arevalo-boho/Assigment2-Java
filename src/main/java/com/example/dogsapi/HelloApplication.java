package com.example.dogsapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dogs-view.fxml"));

        // Create a scene with the loaded FXML content
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Set the title of the window
        stage.setTitle("Hello!");

        // Set the scene to the stage
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}
