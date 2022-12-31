package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.BakeryGood;
import com.example.bakinginformationsystem.GenList;
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
    @FXML
    private Button clearItems;

    GenList bakeryGoodList = new GenList();


    public void initialize(URL url, ResourceBundle resourceBundle){
        bakeryGoodControl = this;
    }

    //Method for adding a bakery item to the listview and linkedlist
    public void addBakeryGood(ActionEvent actionEvent) {
        if(goodType!=null && itemName!=null && textDesc!=null && origin!=null && imageURL!=null){
            BakeryGood BG = new BakeryGood(goodType.getText(), itemName.getText(), textDesc.getText(), origin.getText(),imageURL.getText());
            goodsListView.getItems().add(BG); //adds the bakerygood to the list view
            bakeryGoodList.addFirst(BG); //adds the bakerygood to the bakerygoodlist linkedlist
        }
    }


    //Method for deleting an item from the list view
    public void deleteBakeryItem(ActionEvent actionEvent) {
        BakeryGood BGtoDelete = goodsListView.getSelectionModel().getSelectedItem();
        goodsListView.getItems().remove(BGtoDelete); //deletes the selected bakerygood object from the list view
        //still to make delete from linkedlist part.
    }
}
