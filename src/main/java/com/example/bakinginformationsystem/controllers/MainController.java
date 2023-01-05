package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;


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





    public void save(ActionEvent actionEvent) {
        try{
            bakeryGoodControl.saveAllData();
            ingredientControl.saveAllData();
            recipeControl.saveAllData();
            Main.saveAllData();
        }catch(Exception e){
            System.err.println("Error writing to file: " + e);
        }
    }



    public void load(ActionEvent actionEvent) {
        try{
            bakeryGoodControl.loadAllData();
            ingredientControl.loadAllData();
            recipeControl.loadAllData();
            Main.loadAllData();
        }catch(Exception e){
            System.err.println("Error reading from file: " + e);
        }

    }

    public void clear(ActionEvent actionEvent) {
    }
}
