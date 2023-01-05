package com.example.bakinginformationsystem;

import com.example.bakinginformationsystem.controllers.BakeryGoodController;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class HashTable implements Initializable {

    public static HashTable hashTableAccess;
    // The array that will store the hash table
    private Object[] table;

    // The size of the hash table
    private int size;

    // Constructor that initializes the hash table with a given size
    public HashTable(int size) {
        this.size = size;
        table = new Object[size];
    }

    // Hash function for the hash table
    public int hash(Object object) {
        // Use a prime number as the multiplier
        int result = object.hashCode();

        // Mod the result by the size of the hash table to get the index
        return result % size;
    }

    // Method to add an object to the hash table
    public void add(Object object) {
        // Calculate the index for the object
        int index = hash(object);

        // Add the object to the hash table at the calculated index
        table[index] = object;
    }

    // Method to retrieve an object from the hash table
    public Object get(Object object) {
        // Calculate the index for the object
        int index = hash(object);

        // Return the object at the calculated index
        return table[index];
    }

    // Method to remove an object from the hash table
    public void remove(Object object) {
        // Calculate the index for the object
        int index = hash(object);

        // Set the object at the calculated index to null to remove it from the hash table
        table[index] = null;
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        hashTableAccess = this;
    }
}