package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.BakeryGood;
import com.example.bakinginformationsystem.GenList;
import com.example.bakinginformationsystem.HashTable;
import com.example.bakinginformationsystem.Ingredient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.HashTable.hashTableAccess;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;

public class IngredientController implements Initializable {

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
    @FXML
    public RadioButton inGrams;
    @FXML
    public RadioButton inMilliliters;
    @FXML
    public Button delIngredient;
    @FXML
    public Button clearIngredients;
    @FXML
    public Button refreshIngredientsListView;
    @FXML
    public TextField quantity;
    public GenList<Ingredient> ingredientList = new GenList();
    public GenList<Ingredient> getIngredientList() {
        return ingredientList;
    }
    public ListView<Ingredient> getIngredientsListView() {
        return ingredientsListView;
    }

    public void addIngredient(ActionEvent actionEvent) {
        if (ingredientName != null && ingredientTextDesc != null && calories != null) {
            ingredientsListView.setCellFactory(ingredientsAddedListView -> new ListCell<Ingredient>() {
                @Override
                protected void updateItem(Ingredient ingredient, boolean empty) {
                    super.updateItem(ingredient, empty);
                    if (empty || ingredient == null) {
                        setText(null);
                    } else {
                        // Call the desired toString() method of the Ingredient object
                        setText(ingredient.toString2());
                    }
                }
            });
            Ingredient I = new Ingredient(ingredientName.getText(), ingredientTextDesc.getText(), Integer.parseInt(calories.getText()), ingredientRadioButtonChoice(), Double.parseDouble(quantity.getText()));
            //Need to convert from int to String. Can't wrap for some reason
            ingredientsListView.getItems().add(I); //adds the ingredient to the list view
            ingredientList.addLast(I); //adds the ingredient to the ingredientList linkedlist
            hashTableAccess.hashAdd((Object) I);
            recipeControl.ingredientsToAddListView.getItems().add(I);
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
        ingredientsListView.getItems().remove(ItoDelete); //deletes the selected Ingredient object from the list view
        recipeControl.ingredientsToAddListView.getItems().remove(ItoDelete);
        hashTableAccess.remove(ItoDelete);
        ingredientList.delete(ItoDelete);
    }

    public void deleteAllIngredients(ActionEvent actionEvent) {
        ingredientList.clear(); //clears all elements from generic list.
        ingredientsListView.getItems().clear(); //^^ ^^ ^^ from list view.
        recipeControl.ingredientsToAddListView.getItems().clear();
    }

    public void refreshIngredientListView(ActionEvent actionEvent) {
        ingredientsListView.getItems().clear(); //deletes listview content
        ingredientList.iterate(getIngredientsListView()); //iterates over each element in the bakeygoods list and adds each element to the listview.
    }

    public String ingredientRadioButtonChoice() {
        if (inGrams.isSelected()) {
            return "Grams";
        } else {
            return "Millilitres";
        }
    }

    public void saveAllData() throws IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File(fileName())));
        out.writeObject(ingredientList);
        out.close();
    }

    public void loadAllData() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File((fileName()))));
        ingredientList = (GenList<Ingredient>) in.readObject();
        in.close();
        populateContent();
    }

    public String fileName(){return "ingredients.dat";}

    private void populateContent(){
        ingredientList.iterate(getIngredientsListView());
        ingredientList.iterate(recipeControl.ingredientsToAddListView);
    }
}
