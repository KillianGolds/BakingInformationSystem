package com.example.bakinginformationsystem.controllers;

import com.example.bakinginformationsystem.GenList;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bakinginformationsystem.controllers.BakeryGoodController.bakeryGoodControl;
import static com.example.bakinginformationsystem.controllers.IngredientController.ingredientControl;
import static com.example.bakinginformationsystem.controllers.RecipeController.recipeControl;

public class SearchController implements Initializable {
    public static SearchController searchControl;
    @FXML
    public Button viewAll;
    @FXML
    public Button viewBakedGoods;
    @FXML
    public Button viewIngredients;
    @FXML
    public Button viewRecipes;
    @FXML
    public ListView<String> searchListView;
    @FXML
    public Button refreshSearchListView;
    @FXML
    public TextField searchBox;
    public Label searchLabel;
    public Button sortAlphabeticallyAscending;
    public Button sortAlphabeticallyDescending;
    public Button sortCaloriesAscending;
    public Button sortCaloriesDescending;

    String searchTerm;

    public GenList<String> searchLists = new GenList<>();
    public GenList<String> resultsList = new GenList<>();


    public void Search(String searchTerm){
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }


    public ListView<String> getSearchListView() {
        return searchListView;
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        searchControl = this;
    }

    public void onStart(){

    }

    //deletes the search listview and repopulates it from the generic linked list
    public void refreshSearchListView(ActionEvent actionEvent) {
        // Set the cell factory for the ListView
        searchListView.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    // Set the text and style of the cell based on the type of the item
                    if (item.startsWith("Header:")) {
                        setText(item.substring(7));
                        setStyle("-fx-font-weight: bold");
                    } else {
                        setText(item);
                        setStyle("");
                    }
                }
            }
        });

        searchListView.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    // Set the text of the cell
                    setText(item);

                    // Set the style based on the section that the item belongs to
                    if (item.startsWith("Bakery")) {
                        setStyle("-fx-background-color: lightgray");
                    } else if (item.startsWith("Ingredient")) {
                        setStyle("-fx-background-color: lightblue");
                    } else if (item.startsWith("Recipe")) {
                        setStyle("-fx-background-color: lightgreen");
                    } else {
                        setStyle("");
                    }
                }
            }
        });
        searchListView.getItems().clear(); //deletes listview content

        bakeryGoodControl.bakeryGoodList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.

        ingredientControl.ingredientList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.

        recipeControl.recipeList.iterateObjecttoString(getSearchListView());
        searchLabel.setText("All Items");
        searchLabel.setVisible(true);
    }

    public void search() {
        resultsList.clear();
        searchLists.clear();
        bakeryGoodControl.bakeryGoodList.addAllElementsToListFromListAsString(searchLists);
        ingredientControl.ingredientList.addAllElementsToListFromListAsString(searchLists);;
        recipeControl.recipeList.addAllElementsToListFromListAsString(searchLists);;

    }

    public void viewAll(ActionEvent actionEvent) {
        // Set the cell factory for the ListView
        searchListView.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    // Set the text and style of the cell based on the type of the item
                    if (item.startsWith("Header:")) {
                        setText(item.substring(7));
                        setStyle("-fx-font-weight: bold");
                    } else {
                        setText(item);
                        setStyle("");
                    }
                }
            }
        });

        searchListView.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    // Set the text of the cell
                    setText(item);

                    // Set the style based on the section that the item belongs to
                    if (item.startsWith("Bakery")) {
                        setStyle("-fx-background-color: lightgray");
                    } else if (item.startsWith("Ingredient")) {
                        setStyle("-fx-background-color: lightblue");
                    } else if (item.startsWith("Recipe")) {
                        setStyle("-fx-background-color: lightgreen");
                    } else {
                        setStyle("");
                    }
                }
            }
        });
        searchListView.getItems().clear(); //deletes listview content

        bakeryGoodControl.bakeryGoodList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.

        ingredientControl.ingredientList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.

        recipeControl.recipeList.iterateObjecttoString(getSearchListView());
        searchLabel.setText("All Items");
        searchLabel.setVisible(true);
    }

    public void viewBakedGoods(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        bakeryGoodControl.bakeryGoodList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        searchLabel.setText("Baked Goods");
        searchLabel.setVisible(true);
    }

    public void viewIngredients(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        ingredientControl.ingredientList.iterateObjecttoString(getSearchListView()); //iterates over each element in the search list and adds each element to the listview.
        searchLabel.setText("Ingredients");
        searchLabel.setVisible(true);
    }

    public void viewRecipes(ActionEvent actionEvent) {
        searchListView.getItems().clear(); //deletes listview content
        recipeControl.recipeList.iterateObjecttoString(getSearchListView());
        searchLabel.setText("Recipes");
        searchLabel.setVisible(true);
    }

    //The algorithm starts by comparing the first two elements of the list and swapping them if necessary, to ensure that the first element is the smallest.
    //It then compares the second and third elements and swaps them if necessary.
    //This process continues until the second to last element is reached.
    //The algorithm then starts over with the second element and repeats the process until the list is fully sorted.
    public void sortAlphaAscending(ActionEvent actionEvent) {
        for (int i = 0; i < searchListView.getItems().size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < searchListView.getItems().size(); j++) {
                if (searchListView.getItems().get(j).compareTo(searchListView.getItems().get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the elements
            String temp = searchListView.getItems().get(i);
            searchListView.getItems().set(i, searchListView.getItems().get(minIndex));
            searchListView.getItems().set(minIndex, temp);
        }
    }

    public void sortCalorieAscending(ActionEvent actionEvent) {
        String selectedItem = searchListView.getSelectionModel().getSelectedItem();


        int colonIndex = selectedItem.indexOf(':');
        String valueString = selectedItem.substring(colonIndex + 1).trim();


        int value = Integer.parseInt(valueString);
        for (int i = 0; i < searchListView.getItems().size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < searchListView.getItems().size(); j++) {
                if (searchListView.getItems().get(j).compareTo(searchListView.getItems().get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the elements
            String temp = searchListView.getItems().get(i);
            searchListView.getItems().set(i, searchListView.getItems().get(minIndex));
            searchListView.getItems().set(minIndex, temp);
        }
    }



    public void sortAlphaDescending(ActionEvent actionEvent) {
        for (int i = 0; i < searchListView.getItems().size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < searchListView.getItems().size(); j++) {
                if (searchListView.getItems().get(j).compareTo(searchListView.getItems().get(maxIndex)) > 0) {
                    maxIndex = j;
                }
            }
            // Swap the elements
            String temp = searchListView.getItems().get(i);
            searchListView.getItems().set(i, searchListView.getItems().get(maxIndex));
            searchListView.getItems().set(maxIndex, temp);
        }
    }





//        for (int i = 0; i < searchListView.getItems().size() - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < searchListView.getItems().size(); j++) {
//                if (searchListView.getItems().get(j).compareTo(searchListView.getItems().get(minIndex)) > 0) {
//                    minIndex = j;
//                }
//            }
//            // Swap the elements
//            String temp = searchListView.getItems().get(i);
//            searchListView.getItems().set(i, searchListView.getItems().get(minIndex));
//            searchListView.getItems().set(minIndex, temp);

    //        searchListView.setCellFactory(lv -> {
//            ListCell<String> cell = new ListCell<>();
//            cell.textProperty().bind(cell.itemProperty());
//            cell.disableProperty().bind(Bindings.createBooleanBinding(() -> {
//                String item = cell.getItem();
//                return item != null && (item.contains("Bakery Goods:\n=======================================================") || item.contains("\nIngredients:\n=======================================================") || item.contains("\nRecipes:\n======================================================="));
//            }, cell.itemProperty()));
//            return cell;
//        });
    // Set the cell factory for the ListView
//        searchListView.setCellFactory(listView -> new ListCell<String>() {
//            @Override
//            protected void updateItem(String item, boolean empty) {
//                super.updateItem(item, empty);
//
//                if (item == null || empty) {
//                    setText(null);
//                    setStyle("");
//                } else {
//                    // Create a Group for the cell
//                    Group group = new Group();
//
//                    // Add the item to the Group as a Label
//                    group.getChildren().add(new Label(item));
//
//                    // Set the managed property of the Group to false
//                    group.setManaged(false);
//
//                    // Set the cell to the Group
//                    setGraphic(group);
//
//                    // Set the style based on the section that the item belongs to
//                    if (item.startsWith("Bakery")) {
//                        setStyle("-fx-background-color: lightgray");
//                    } else if (item.startsWith("Ingredient")) {
//                        setStyle("-fx-background-color: lightblue");
//                    } else if (item.startsWith("Recipe")) {
//                        setStyle("-fx-background-color: lightgreen");
//                    } else {
//                        setStyle("");
//                    }
//                }
//            }
//        });
}
//        // Get the indices of the headers
//        GenList<Integer> headerIndices = new GenList<>();
//        for (int i = 0; i < searchListView.getItems().size(); i++) {
//            if (searchListView.getItems().get(i).startsWith("Header:")) {
//                headerIndices.addLast(i);
//            }
//        }
//
//        // Sort the items in the ListView
//        for (int i = 0; i < searchListView.getItems().size() - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < searchListView.getItems().size(); j++) {
//                if (searchListView.getItems().get(j).compareTo(searchListView.getItems().get(minIndex)) < 0) {
//                    minIndex = j;
//                }
//            }
//            // Swap the elements
//            String temp = searchListView.getItems().get(i);
//            searchListView.getItems().set(i, searchListView.getItems().get(minIndex));
//            searchListView.getItems().set(minIndex, temp);
//        }
//
//        // Move the headers back to the top of their sections
//        for (int i = 0; i < headerIndices.size(); i++) {
//            int headerIndex = headerIndices.get(i);
//            String header = searchListView.getItems().get(headerIndex);
//            searchListView.getItems().remove(headerIndex);
//            searchListView.getItems().add(headerIndex, header);
//        }
//    }


//    public void sortAlphaAscending(ActionEvent actionEvent) {
//        for (int i = 0; i < searchListView.getItems().size() - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < searchListView.getItems().size(); j++) {
//                if (searchListView.getItems().get(j).compareTo(searchListView.getItems().get(minIndex)) < 0) {
//                    minIndex = j;
//                }
//            }
//            // Swap the elements
//            String temp = searchListView.getItems().get(i);
//            searchListView.getItems().set(i, searchListView.getItems().get(minIndex));
//            searchListView.getItems().set(minIndex, temp);
//        }
//    }