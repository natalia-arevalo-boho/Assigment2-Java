package com.example.dogsapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {
    public static Scene dogsView;
    public static Scene dogResult;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load dogs-view.fxml
            FXMLLoader fxmlLoaderDogs = new FXMLLoader();
            URL dogsViewUrl = getClass().getResource("/com/example/dogsapi/dogs-view.fxml");
            if (dogsViewUrl == null) {
                throw new IOException("FXML file not found: dogs-view.fxml");
            }
            Parent fxmlDogs = fxmlLoaderDogs.load(dogsViewUrl.openStream());
            dogsView = new Scene(fxmlDogs, 400, 400);

            // Load detailsview.fxml (previously dog-result.fxml)
            FXMLLoader fxmlLoaderDogResult = new FXMLLoader();
            URL dogResultUrl = getClass().getResource("/com/example/dogsapi/detailsview.fxml");
            if (dogResultUrl == null) throw new IOException("FXML file not found: detailsview.fxml");
            Parent fxmlDogResult = fxmlLoaderDogResult.load(dogResultUrl.openStream());
            dogResult = new Scene(fxmlDogResult, 300, 400);

            // Configure primaryStage
            primaryStage.setTitle("Choose a Dog");
            primaryStage.setScene(dogsView); // Set the initial scene

            // Add image to the stage
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/dogsapi/images/icon1.png")));
            primaryStage.getIcons().add(icon);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to change the screen
    public static void changeScreen(String src) {
        Stage stage = (Stage) dogsView.getWindow();
        switch (src) {
            case "dogsview":
                stage.setScene(dogsView);
                break;
            case "dogresult":
            default:
                stage.setScene(dogResult);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
