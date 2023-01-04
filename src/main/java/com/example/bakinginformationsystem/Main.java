package com.example.bakinginformationsystem;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.io.IOException;

import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;
import static com.example.bakinginformationsystem.controllers.MainController.mainControl;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;
import static com.example.bakinginformationsystem.controllers.SearchController.searchControl;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 673, 610);
        stage.setTitle("Baking Information System");
        stage.setScene(scene);
        stage.show();



        ToggleGroup ingredientRadioButtons = new ToggleGroup();
        ingredientControl.inMilliliters.setToggleGroup(ingredientRadioButtons);
        ingredientControl.inGrams.setToggleGroup(ingredientRadioButtons);

        ingredientControl.quantity.setVisible(false);
        ingredientControl.quantity.setText("0");

        recipeControl.quantitySelection.setVisible(false);
        recipeControl.quantitySelection.setManaged(false);
        recipeControl.ingredientsToAddListView.setPrefSize(302.5, 132);
        recipeControl.onStart();

        searchControl.onStart();

        recipeControl.ingredientsToAddListView.setCellFactory(ingredientsAddedListView -> new ListCell<Ingredient>() {
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

        searchControl.searchLabel.setVisible(false);
        searchControl.searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            String query = searchControl.searchBox.getText();
            searchControl.search();
            searchControl.searchLists.search(query, searchControl.searchListView);
        });
    }



    public static void main(String[] args) {
        launch();
    }
}