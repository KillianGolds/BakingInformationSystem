package com.example.bakinginformationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//Jordan if you see this, fixed a bunch of errors with the folder set up, should all be gucci going forward as if its a regular root, boilerplate code for ingredients and recipes still needs doing if you wanted to tap away at that, have a look at BakeryGood class if you want to see my usual conventions.

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 673, 610);
        stage.setTitle("Baking Information System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}