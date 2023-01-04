package com.example.bakinginformationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.io.IOException;

import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;

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


    }

    public static void main(String[] args) {
        launch();
    }
}