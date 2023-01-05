package com.example.bakinginformationsystem;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.*;

import static com.example.bakinginformationsystem.HashTable.hashTableAccess;
import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.HashQueryController.hashQueryControl;
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


        bakeryGoodControl.editBakeryItem.setVisible(false);
        bakeryGoodControl.updateBakeryItem.setVisible(false);
        ingredientControl.updateIngredientItem.setVisible(false);
        ingredientControl.editIngredientItem.setVisible(false);

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

        hashTableAccess = new HashTable(10);

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
        try {
            hashQueryControl.bakeryGoodListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                hashQueryControl.ingredientListView.getSelectionModel().clearSelection();
                hashQueryControl.recipeListView.getSelectionModel().clearSelection();
            });

            hashQueryControl.ingredientListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                hashQueryControl.bakeryGoodListView.getSelectionModel().clearSelection();
                hashQueryControl.recipeListView.getSelectionModel().clearSelection();
            });

            hashQueryControl.recipeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                hashQueryControl.bakeryGoodListView.getSelectionModel().clearSelection();
                hashQueryControl.ingredientListView.getSelectionModel().clearSelection();
            });
        }catch(IndexOutOfBoundsException ignore){

        }
    }

    public static void saveAllData() throws IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File(fileName())));
        out.writeObject(hashTableAccess);
        out.close();
//        try (FileOutputStream fos = new FileOutputStream("hashtable.dat");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(hashTableAccess);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void loadAllData() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File((fileName()))));
        hashTableAccess = (HashTable) in.readObject();
        in.close();
        populateContent();
    }

    public static String fileName(){return "hashtable.dat";}

    private static void populateContent(){
//        ingredientList.iterate(getIngredientsListView());
//        ingredientList.iterate(recipeControl.ingredientsToAddListView);
    }



    public static void main(String[] args) {
        launch();
    }
}