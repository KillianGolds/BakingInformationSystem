package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.BakeryGood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;

public class SearchController {
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

    //deletes the search listview and repopulates it from the generic linked list
    public void refreshSearchListView(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        bakeryGoodControl.bakeryGoodList.iterate(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        ingredientControl.ingredientList.iterate(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        //.iterate(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.


    }
}
