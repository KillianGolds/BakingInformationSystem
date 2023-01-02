package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.BakeryGood;
import com.example.bakinginformationsystem.GenList;
import com.example.bakinginformationsystem.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

//to be done
public class RecipeController implements Initializable {

    public static RecipeController recipeControl;
    @FXML
    private TextField goodName;
    @FXML
    private TextField ingredientName;   //Included this to add individual ingredients, but I want to set it up so that it can pull from
                                        //the list of ingredients that's already made.
    @FXML
    private TextArea quantity;
    @FXML
    private Button addItem;
    @FXML
    private Button delItem;
    @FXML
    private ListView<Recipe> recipeListView;
    public ListView<Recipe> getRecipeListView() {
        return recipeListView;
    }
    @FXML
    private Button clearItems;
    @FXML
    public Button refreshRecipeListView;

    GenList<Recipe> recipeList = new GenList();


    public void initialize(URL url, ResourceBundle resourceBundle){
        recipeControl = this;
    }

    //Method for adding a bakery item to the listview and linkedlist
    public void addRecipe(ActionEvent actionEvent) {
        if(goodName!=null && ingredientName!=null && quantity!=null){
            Recipe RP = new Recipe(goodName.getText(), ingredientName.getText(), quantity.getText()); //Won't pull constructor from Recipe??

            recipeListView.getItems().add(RP); //adds the recipe to the list view
            recipeList.addLast(RP); //adds the recipe to the recipeList linkedlist
            goodName.clear();
            ingredientName.clear();
            quantity.clear();
        }
    }


    //Method for deleting an item from the list view
    public void deleteRecipe(ActionEvent actionEvent) {
        Recipe RtoDelete = recipeListView.getSelectionModel().getSelectedItem();
        recipeListView.getItems().remove(RtoDelete); //deletes the selected recipe object from the list view
        recipeList.delete(RtoDelete);
    }

    //Deletes all recipes from the generic linked list and the list view.
    public void deleteAllRecipes(ActionEvent actionEvent) {
        recipeList.clear(); //clears all elements from generic list.
        recipeListView.getItems().clear(); //^^ ^^ ^^ from list view.
    }

    //deletes the recipe listview and repopulates it from the generic linked list
    public void refreshRecipeListView(ActionEvent actionEvent) {
        recipeListView.getItems().clear(); //deletes listview content
        recipeList.iterate(getRecipeListView()); //iterates over each element in the recipe list and adds each element to the listview.
    }


}
