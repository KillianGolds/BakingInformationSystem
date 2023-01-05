package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.BakeryGood;
import com.example.bakinginformationsystem.Ingredient;
import com.example.bakinginformationsystem.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.HashTable.hashTableAccess;
import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;

public class HashQueryController implements Initializable {

    public static HashQueryController hashQueryControl;
    @FXML
    public ListView<BakeryGood> bakeryGoodListView;
    @FXML
    public Label fromHashTableClassCheck;
    @FXML
    public Label recastedClassCheck;
    @FXML
    public Button deleteHashTableItem;


    public ListView<BakeryGood> getBakeryGoodListView() {
        return bakeryGoodListView;
    }

    public void setBakeryGoodListView(ListView<BakeryGood> bakeryGoodListView) {
        this.bakeryGoodListView = bakeryGoodListView;
    }
    @FXML
    public ListView<Ingredient> ingredientListView;
    public ListView<Ingredient> getIngredientListView() {
        return ingredientListView;
    }

    public void setIngredientListView(ListView<Ingredient> ingredientListView) {
        this.ingredientListView = ingredientListView;
    }
    @FXML
    public ListView<Recipe> recipeListView;

    public ListView<Recipe> getRecipeListView() {
        return recipeListView;
    }

    public void setRecipeListView(ListView<Recipe> recipeListView) {
        this.recipeListView = recipeListView;
    }

    @FXML
    public Label label1;
    @FXML
    public Label label2;
    @FXML
    public Label hashTableMembershipRecastedLabel;
    @FXML
    public Label hashTableMembershipLabel;
    @FXML
    public Button hashQuery;
    @FXML
    public Button resetCheckLabel;
    @FXML
    public Button refreshAllListView;

    public void queryHashTable(ActionEvent actionEvent) {
        BakeryGood BG = null;
        Ingredient IG = null;
        Recipe RP = null;
        if (!bakeryGoodListView.getSelectionModel().isEmpty()) {
            BG = bakeryGoodListView.getSelectionModel().getSelectedItem();
            System.out.println(hashTableAccess.get((Object) BG));
        } else if (!ingredientListView.getSelectionModel().isEmpty()) {
            IG = ingredientListView.getSelectionModel().getSelectedItem();
            System.out.println(hashTableAccess.get((Object) IG));
        } else if (!recipeListView.getSelectionModel().isEmpty()) {
            RP = recipeListView.getSelectionModel().getSelectedItem();
            System.out.println(hashTableAccess.get((Object) RP));
        }
        if (BG != null) {
            Object value = hashTableAccess.get(BG);
            if(value == null){
               fromHashTableClassCheck.setText("No Object Exists");
               recastedClassCheck.setText("No Object Exists");
               hashTableMembershipLabel.setText("");
               hashTableMembershipRecastedLabel.setText("");
            }
            assert value != null;
            Class<?> valueClass = value.getClass();
            String className = valueClass.getName();
            fromHashTableClassCheck.setText(className);
            hashTableMembershipLabel.setText(value.toString());
            System.out.println(hashTableAccess.get((Object) BG));
            if (value instanceof BakeryGood goodValue) {
                hashTableMembershipRecastedLabel.setText(goodValue.toString());
                Class<?> recastedClass = goodValue.getClass();
                String recastedClassName = recastedClass.getName();
                recastedClassCheck.setText(recastedClassName);
                recastedClassCheck.setText(goodValue.toString());
            }
        } else if (IG != null) {
            Object value = hashTableAccess.get(IG);
            if(value == null){
                fromHashTableClassCheck.setText("No Object Exists");
                recastedClassCheck.setText("No Object Exists");
                hashTableMembershipLabel.setText("");
                hashTableMembershipRecastedLabel.setText("");
            }
            assert value != null;
            Class<?> valueClass = value.getClass();
            String className = valueClass.getName();
            fromHashTableClassCheck.setText(className);
            hashTableMembershipLabel.setText(value.toString());
            System.out.println(hashTableAccess.get((Object) IG));
                if (value instanceof Ingredient IngValue) {
                    hashTableMembershipRecastedLabel.setText(IngValue.toString());
                    Class<?> recastedClass = IngValue.getClass();
                    String recastedClassName = recastedClass.getName();
                    recastedClassCheck.setText(recastedClassName);
                    recastedClassCheck.setText(IngValue.toString());
                }
            } else {
            Object value = hashTableAccess.get(RP);
            if(value == null){
                fromHashTableClassCheck.setText("No Object Exists");
                recastedClassCheck.setText("No Object Exists");
                hashTableMembershipLabel.setText("");
                hashTableMembershipRecastedLabel.setText("");
            }
            assert value != null;
            Class<?> valueClass = value.getClass();
            String className = valueClass.getName();
            fromHashTableClassCheck.setText(className);
            hashTableMembershipLabel.setText(value.toString());
            System.out.println(hashTableAccess.get((Object) RP));
            if (value instanceof Recipe RecipeValue) {
                hashTableMembershipRecastedLabel.setText(RecipeValue.toString());
                Class<?> recastedClass = RecipeValue.getClass();
                String recastedClassName = recastedClass.getName();
                recastedClassCheck.setText(recastedClassName);
                recastedClassCheck.setText(RecipeValue.toString());
            }
        }
    }


    public void resetCheckLabel(ActionEvent actionEvent) {
        hashTableMembershipLabel.setText("");
        recastedClassCheck.setText("");
        hashTableMembershipRecastedLabel.setText("");
        fromHashTableClassCheck.setText("");
    }

    public void deleteObjectFromHashTable(ActionEvent actionEvent) {
        if (!bakeryGoodListView.getSelectionModel().isEmpty()) {
            BakeryGood BG = bakeryGoodListView.getSelectionModel().getSelectedItem();
            System.out.println(hashTableAccess.get((Object) BG));
            hashTableAccess.remove(BG);
        } else if (!ingredientListView.getSelectionModel().isEmpty()) {
            Ingredient IG = ingredientListView.getSelectionModel().getSelectedItem();
            System.out.println(hashTableAccess.get((Object) IG));
            hashTableAccess.remove(IG);
        } else if (!recipeListView.getSelectionModel().isEmpty()) {
            Recipe RP = recipeListView.getSelectionModel().getSelectedItem();
            System.out.println(hashTableAccess.get((Object) RP));
            hashTableAccess.remove(RP);
        }


    }

    public void refreshAllListView(ActionEvent actionEvent) {
        bakeryGoodListView.getItems().clear();
        bakeryGoodControl.bakeryGoodList.iterate(getBakeryGoodListView());
        ingredientListView.getItems().clear();
        ingredientControl.ingredientList.iterate(getIngredientListView());
        recipeListView.getItems().clear();
        recipeControl.recipeList.iterate(getRecipeListView());
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        hashQueryControl = this;
    }


}
