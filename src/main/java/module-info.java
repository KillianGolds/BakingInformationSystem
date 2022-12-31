module BakingInformationSystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens com.example.bakinginformationsystem to javafx.fxml;
    exports com.example.bakinginformationsystem;

    opens com.example.bakinginformationsystem.controllers to javafx.fxml;
    exports com.example.bakinginformationsystem.controllers;
}