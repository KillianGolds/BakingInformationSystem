package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.GenList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;
import static com.example.bakinginformationsystem.controllers.SearchController.searchControl;


//to be done
public class MainController implements Initializable {

    public static MainController mainControl;
    @FXML
    public Button save;
    @FXML
    public Button load;
    @FXML
    public Button clear;

    public GenList<String> searchLists = new GenList<>();

    public void initialize(URL url, ResourceBundle resourceBundle){
        mainControl = this;
    }


    public GenList<String> getAllItems() {
        bakeryGoodControl.bakeryGoodList.addAllElementsToListFromListAsString(searchLists);
        ingredientControl.ingredientList.addAllElementsToListFromListAsString(searchLists);
        recipeControl.recipeList.addAllElementsToListFromListAsString(searchLists);
        return searchLists;
    }
    public void onApplicationStart() {

    }

}
