package com.example.bakinginformationsystem;

public class HashTable {
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
        int prime = 31;
        int result = 1;

        // Hash the fields of the object using the prime number multiplier
        result = prime * result + object.field1.hashCode();
        result = prime * result + object.field2.hashCode();
        result = prime * result + object.field3.hashCode();

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
}