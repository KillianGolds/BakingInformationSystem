package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.GenList;
import com.example.bakinginformationsystem.Ingredient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class IngredientController {

    public static IngredientController ingredientControl;
    @FXML
    public TextField ingredientName;
    @FXML
    public TextArea ingredientTextDesc;
    @FXML
    public TextField calories;
    @FXML
    public Button addIngredient;
    @FXML
    public ListView<Ingredient> ingredientsListView;
    public ListView<Ingredient> getIngredientsListView() {
        return ingredientsListView;
    }
    @FXML
    public Button delIngredient;
    @FXML
    public Button clearIngredients;
    @FXML
    public Button refreshIngredientsListView;

    GenList<Ingredient> ingredientList = new GenList();

    public void addIngredient(ActionEvent actionEvent) {
        if (ingredientName != null && ingredientTextDesc != null && calories != null) {
            Ingredient I = new Ingredient(ingredientName.getText(), ingredientTextDesc.getText(), Integer.parseInt(calories.getText()));
            //Need to convert from int to String. Can't wrap for some reason
            ingredientsListView.getItems().add(I); //adds the ingredient to the list view
            ingredientList.addLast(I); //adds the ingredient to the ingredientList linkedlist
            ingredientName.clear();
            ingredientTextDesc.clear();
            calories.clear();
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        ingredientControl = this;
    }

    public void deleteIngredient(ActionEvent actionEvent) {
        Ingredient ItoDelete = ingredientsListView.getSelectionModel().getSelectedItem();
        //Not sure why it's telling me "Ingredient" isn't an object
        ingredientsListView.getItems().remove(ItoDelete); //deletes the selected Ingredient object from the list view
        ingredientList.delete(ItoDelete);
    }

    public void deleteAllIngredients(ActionEvent actionEvent) {
        ingredientList.clear(); //clears all elements from generic list.
        ingredientsListView.getItems().clear(); //^^ ^^ ^^ from list view.
    }

    public void refreshIngredientListView(ActionEvent actionEvent) {
        ingredientsListView.getItems().clear(); //deletes listview content
        ingredientList.iterate(getIngredientsListView()); //iterates over each element in the bakeygoods list and adds each element to the listview.
    }
}
