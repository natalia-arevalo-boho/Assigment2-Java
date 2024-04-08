module com.example.dogsapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.dogsapi to javafx.fxml;
    exports com.example.dogsapi;
}