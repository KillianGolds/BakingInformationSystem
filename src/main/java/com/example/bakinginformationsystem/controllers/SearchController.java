package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.GenList;
import com.example.bakinginformationsystem.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchController {
    public static RecipeController searchControl;
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
    public GenList<String> searchList;
    @FXML
    public Button refreshSearchListView;

    public void setViewBakedGoods(ActionEvent actionEvent) {
    }




    //deletes the search listview and repopulates it from the generic linked list
    public void refreshRecipeListView(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        searchList.iterate(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
    }
}
