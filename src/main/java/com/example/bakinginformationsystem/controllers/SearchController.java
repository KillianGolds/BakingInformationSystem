package com.example.bakinginformationsystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;

public class SearchController implements Initializable {
    public static SearchController searchControl;
    @FXML
    public Button viewAll;
    @FXML
    public Button viewBakedGoods;
    @FXML
    public Button viewIngredients;
    @FXML
    public Button viewRecipes;
    @FXML
    public ListView<String> searchListView;
    @FXML
    public Button refreshSearchListView;

    public ListView<String> getSearchListView() {
        return searchListView;
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        searchControl = this;
    }

    //deletes the search listview and repopulates it from the generic linked list
    public void refreshSearchListView(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        searchListView.getItems().add("Bakery Goods:\n=======================================================");
        bakeryGoodControl.bakeryGoodList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        searchListView.getItems().add( "\nIngredients:\n=======================================================");
        ingredientControl.ingredientList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        searchListView.getItems().add("\nRecipes:\n=======================================================");
    }

    public void search(ActionEvent actionEvent) {
        //TODO
    }



    public void viewAll(ActionEvent actionEvent) {
        //TODO implement dividers being non selectable.
        searchListView.getItems().clear(); //deletes listview content
        searchListView.getItems().add("Bakery Goods:\n=======================================================");
        bakeryGoodControl.bakeryGoodList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        searchListView.getItems().add( "\nIngredients:\n=======================================================");
        ingredientControl.ingredientList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        searchListView.getItems().add("\nRecipes:\n=======================================================");
        recipeControl.recipeList.iterateObjecttoString(getSearchListView());

    }

    public void viewBakedGoods(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        bakeryGoodControl.bakeryGoodList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.

    }

    public void viewIngredients(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        ingredientControl.ingredientList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.

    }

    public void viewRecipes(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        recipeControl.recipeList.iterateObjecttoString(getSearchListView());
    }
}
