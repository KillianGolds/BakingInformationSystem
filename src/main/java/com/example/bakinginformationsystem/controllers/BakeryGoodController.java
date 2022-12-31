package com.example.bakinginformationsystem.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

//to be done
public class BakeryGoodController implements Initializable {

    public static BakeryGoodController bakeryGoodControl;
    public TextField goodType;

    public void initialize(URL url, ResourceBundle resourceBundle){
        bakeryGoodControl = this;
    }
}
