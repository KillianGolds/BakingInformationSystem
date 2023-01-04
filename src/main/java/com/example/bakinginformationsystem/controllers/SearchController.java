package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.GenList;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;
import static com.example.bakinginformationsystem.controllers.MainController.mainControl;
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
    @FXML
    public TextField searchBox;

    String searchTerm;


    public void Search(String searchTerm){
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }


    public ListView<String> getSearchListView() {
        return searchListView;
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        searchControl = this;
    }

    public void onStartSearch() {
        searchBox.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            searchListView.getItems().clear();



        });
    }

    //deletes the search listview and repopulates it from the generic linked list
    public void refreshSearchListView(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        searchListView.getItems().add("Bakery Goods:\n=======================================================");
        bakeryGoodControl.bakeryGoodList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        searchListView.getItems().add( "\nIngredients:\n=======================================================");
        ingredientControl.ingredientList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        searchListView.getItems().add("\nRecipes:\n=======================================================");
        recipeControl.recipeList.iterateObjecttoString(getSearchListView());
    }

//    public void search(String searchQuery) {
//        //TODO I don't know how to get the input text for 'searchTerm' to compare it to any of the lists.
//        mainControl.searchLists.search(searchQuery, searchControl.getSearchListView());
//    }

//    public GenList<String> getAllItems() {
//        bakeryGoodControl.bakeryGoodList.iterateObjecttoString(getSearchListView());
//        ingredientControl.ingredientList.iterateObjecttoString(getSearchListView());
//        recipeControl.recipeList.iterateObjecttoString(getSearchListView());
//        return null;
//    }

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
