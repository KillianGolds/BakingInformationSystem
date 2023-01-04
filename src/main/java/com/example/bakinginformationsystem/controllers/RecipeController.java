package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.BakeryGood;
import com.example.bakinginformationsystem.GenList;
import com.example.bakinginformationsystem.Ingredient;
import com.example.bakinginformationsystem.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;

//TODO tidy up recipe output
public class RecipeController implements Initializable {

    public static RecipeController recipeControl;
    @FXML
    public ChoiceBox<BakeryGood> bakeryGoodChoiceBox;
    @FXML
    public Button addToChosenIngredients;
    @FXML
    public Button removeFromChosenIngredients;
    @FXML
    public Button addRecipe;
    @FXML
    public ListView<Recipe> recipeListView;

    public ListView<Recipe> getRecipeListView() {
        return recipeListView;
    }
    @FXML
    public Button delRecipe;
    @FXML
    public Button clearAllRecipes;
    @FXML
    public Button refreshRecipesListView;
    @FXML
    public VBox quantitySelection;
    @FXML
    public Button enterQuantity;
    @FXML
    public TextField enteredQuantity;

    @FXML
    public Label ingredientName;

    public Label getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(Label ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Ingredient selectedIngredient;

    public Ingredient getSelectedIngredient() {
        return selectedIngredient;
    }
    public void setSelectedIngredient(Ingredient selectedIngredient) {
        this.selectedIngredient = selectedIngredient;
    }

    GenList<Recipe> recipeList = new GenList<>();

    GenList<Ingredient> chosenIngredients = new GenList<>();

    public GenList<Ingredient> getChosenIngredients() {
        return chosenIngredients;
    }

    public void setChosenIngredients(GenList<Ingredient> chosenIngredients) {
        this.chosenIngredients = chosenIngredients;
    }

    @FXML
    public ListView<Ingredient> ingredientsToAddListView;
    @FXML
    public ListView<Ingredient> ingredientsAddedListView;

    public void onStart() {
        bakeryGoodChoiceBox.setConverter(new StringConverter<BakeryGood>() {
            @Override
            public String toString(BakeryGood bakeryGood) {
                if (bakeryGood != null) {
                    return bakeryGood.getItemName();
                }else{
                    return "";
                }
            }
            @Override
            public BakeryGood fromString(String string) {
                // This method is not used in this example
                return null;
            }
        });

    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        recipeControl = this;
    }

//    Method for adding a recipe to the listview and linkedlist
    public void addRecipe(ActionEvent actionEvent) {
        chosenIngredients.addAll(ingredientsAddedListView);
        Recipe RP = new Recipe(bakeryGoodChoiceBox.getSelectionModel().getSelectedItem(), getChosenIngredients());
        recipeListView.getItems().add(RP); //adds the recipe to the list view
        recipeList.addLast(RP); //adds the recipe to the recipeList linkedlist
        ingredientsAddedListView.getItems().clear();
        System.out.print(RP);
    }

//    public void addRecipe(ActionEvent actionEvent) {
//        chosenIngredients.addAll(ingredientsAddedListView);
//        Recipe RP = new Recipe(bakeryGoodChoiceBox.getSelectionModel().getSelectedItem(), getChosenIngredients());
//
//        ObservableList<TreeItem<String>> rootItems = recipeTreeView.getRoot().getChildren();
//        int numTrees = rootItems.size();
//        int treeNum = numTrees+1;
//        String rootName = "rootItem"+treeNum;
//
//        if(numTrees > 0){
//            TreeItem<Object> rootName = new TreeItem<>(bakeryGoodChoiceBox.getSelectionModel().getSelectedItem());
//            rootName.setExpanded(true);
//            recipeTreeView.setRoot(rootName);
//
//            TreeItem<Object> childItem = new TreeItem<>("Recipe:");
//            rootName.getChildren().add(childItem);
//
//            for (int i = 0; i < chosenIngredients.size(); i++ ) {
//                TreeItem<Object> grandchildItem = new TreeItem<>(chosenIngredients.findByIndex(i));
//                childItem.getChildren().add(grandchildItem);
//            }
//        }
//
//        TreeItem<Object> rootItem = new TreeItem<>(bakeryGoodChoiceBox.getSelectionModel().getSelectedItem());
//        rootItem.setExpanded(true);
//        recipeTreeView.setRoot(rootItem);
//
//        TreeItem<Object> childItem = new TreeItem<>("Recipe:");
//        rootItem.getChildren().add(childItem);
//
//        for (int i = 0; i < chosenIngredients.size(); i++ ) {
//            TreeItem<Object> grandchildItem = new TreeItem<>(chosenIngredients.findByIndex(i));
//            childItem.getChildren().add(grandchildItem);
//        }
//
////        TreeItem<Object> grandchildItem = new TreeItem<>(Ingredient);
////        childItem.getChildren().add(grandchildItem);
//
//
//        recipeListView.getItems().add(RP); //adds the recipe to the list view
//        recipeList.addLast(RP); //adds the recipe to the recipeList linkedlist
//        System.out.print(RP);
//    }

    //TODO Still need to finish adding the recipe once finished with selecting ingredients will have to decide upon how we handle the data structure.
    //TODO possibly changing the recipeListView to a tree list but will need a lot of nested generic linked listing work done, still figuring out
    //TODO after adding a recipe to its generic list, clear chosenIngredient listview
//    public void addRecipe(ActionEvent actionEvent) {
//    }


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

    //Method changed recipe scene to prompt user to input the quantity of an ingredient after selecting an ingredient
    public void addToChosenIngredientsListView(ActionEvent actionEvent) {
        if(bakeryGoodChoiceBox.getSelectionModel().getSelectedItem()!=null && ingredientsToAddListView.getSelectionModel().getSelectedItem()!=null){
            Ingredient I = ingredientsToAddListView.getSelectionModel().getSelectedItem();
            ingredientsToAddListView.setVisible(false);
            quantitySelection.setPrefSize(302.5, 132);
            quantitySelection.setManaged(true);
            ingredientName.setText(I.getIngredientName());
            quantitySelection.setVisible(true);
            ingredientsToAddListView.setManaged(false);
            setSelectedIngredient(I);
        }
    }
    //Method passed the chosen ingredient onto the next method once the enter button is pressed.
    public void enterClicked(ActionEvent actionEvent) {
        ingredientsAddedListView.setCellFactory(ingredientsAddedListView -> new ListCell<Ingredient>() {
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
        quantityPassed(getSelectedIngredient());
    }

    //method adds the chosen ingredient to the list view along with the desired quantity, along with reverting the scene back to allowing user to pick more ingredients for the recipe.
    public void quantityPassed(Ingredient I) {
        Ingredient Ing = ingredientControl.ingredientList.find(I);
        Ing.setQuantity(Double.parseDouble(enteredQuantity.getText()));
        ingredientsAddedListView.getItems().add(Ing);
        recipeControl.quantitySelection.setVisible(false);
        recipeControl.quantitySelection.setManaged(false);
        ingredientsToAddListView.setManaged(true);
        ingredientsToAddListView.setVisible(true);
        ingredientsToAddListView.getSelectionModel().clearSelection();
        enteredQuantity.clear();
    }

    //removes a selected item from the chosen Ingredients ListView.
    public void removeFromChosenIngredientsListView(ActionEvent actionEvent) {
        if(bakeryGoodChoiceBox!=null && ingredientsAddedListView.getSelectionModel().getSelectedItem()!=null) {
            Object I = ingredientsAddedListView.getSelectionModel().getSelectedItem();
            ingredientsAddedListView.getItems().remove(I);
        }
    }
}


