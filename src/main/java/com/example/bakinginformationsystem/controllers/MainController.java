package com.example.bakinginformationsystem.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


//to be done
public class MainController implements Initializable {

    public static MainController mainControl;
    @FXML
    public Button save;
    @FXML
    public Button load;
    @FXML
    public Button clear;

    public void initialize(URL url, ResourceBundle resourceBundle){
        mainControl = this;
    }


}
