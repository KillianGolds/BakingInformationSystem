package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.BakeryGood;
import com.example.bakinginformationsystem.GenList;
import com.example.bakinginformationsystem.Ingredient;
import com.example.bakinginformationsystem.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.HashTable.hashTableAccess;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;

//to be done
public class BakeryGoodController implements Initializable {

    public static BakeryGoodController bakeryGoodControl;
    @FXML
    private TextField goodType;
    @FXML
    private TextField itemName;
    @FXML
    private TextArea textDesc;
    @FXML
    private TextField origin;
    @FXML
    private TextArea imageURL;
    @FXML
    private Button addItem;
    @FXML
    private Button delItem;
    @FXML
    private ListView<BakeryGood> goodsListView;
    public ListView<BakeryGood> getGoodsListView() {
        return goodsListView;
    }
    @FXML
    private Button clearItems;
    @FXML
    public Button refreshGoodsListView;

    public GenList<BakeryGood> bakeryGoodList = new GenList();


    public void initialize(URL url, ResourceBundle resourceBundle){
        bakeryGoodControl = this;
    }

    //Method for adding a bakery item to the listview and linkedlist
    public void addBakeryGood(ActionEvent actionEvent) {
        if(goodType!=null && itemName!=null && textDesc!=null && origin!=null && imageURL!=null){
            BakeryGood BG = new BakeryGood(goodType.getText(), itemName.getText(), textDesc.getText(), origin.getText(),imageURL.getText());
            goodsListView.getItems().add(BG); //adds the bakerygood to the list view
            bakeryGoodList.addLast(BG); //adds the bakerygood to the bakerygoodlist linkedlist
            hashTableAccess.add((Object) BG);
            recipeControl.bakeryGoodChoiceBox.getItems().add(BG);
            goodType.clear();
            itemName.clear();
            textDesc.clear();
            origin.clear();
            imageURL.clear();

        }
    }


    //Method for deleting an item from the list view
    public void deleteBakeryItem(ActionEvent actionEvent) {
        BakeryGood BGtoDelete = goodsListView.getSelectionModel().getSelectedItem();
        goodsListView.getItems().remove(BGtoDelete); //deletes the selected bakerygood object from the list view
        recipeControl.bakeryGoodChoiceBox.getItems().remove(bakeryGoodList.getIndexOf(BGtoDelete));
        bakeryGoodList.delete(BGtoDelete);
    }

    //Deletes all bakery items from the generic linked list and the list view.
    public void deleteAllBakeryItem(ActionEvent actionEvent) {
        bakeryGoodList.clear(); //clears all elements from generic list.
        goodsListView.getItems().clear(); //^^ ^^ ^^ from list view.
        recipeControl.bakeryGoodChoiceBox.getItems().clear();
    }

    //deletes the bakery goods listview and repopulates it from the generic linked list
    public void refreshBakeryGoodListView(ActionEvent actionEvent) {
        goodsListView.getItems().clear(); //deletes listview content
        bakeryGoodList.iterate(getGoodsListView()); //iterates over each element in the bakeygoods list and adds each element to the listview.
    }

//    static final class ListContainer genericLists {
//        GenList<BakeryGood> bakeryGoodGenList;
//        GenList<Recipe> recipeGenList;
//        GenList<Ingredient> ingredientGenList;
//    }
//
//
//
//    public void save() throws Exception{
//        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File(fileName())));
//        out.writeObject(genericList);
//        out.close();
//    }
//
//    @SuppressWarnings("unchecked")
//    public void load() throws Exception{
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File((fileName()))));
//        CONTENT = (Main.Content) in.readObject();
//        in.close();
//        populateContent();
//    }
//
//    public String fileName(){return "BakerySystem.dat";}
}