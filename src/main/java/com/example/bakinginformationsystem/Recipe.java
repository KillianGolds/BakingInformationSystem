package com.example.bakinginformationsystem;

//to be done
public class Recipe {

    //Not sure how to approach measurements of each ingredient. Was thinking of making a new array of
    //measurements that links to the array ingredients. Leaving as is for now.
    private int quantity;
    private String bakedGood;

    public Recipe(int quantity, String bakedGood) {
        this.quantity = quantity;
        this.bakedGood = bakedGood;
    }

    //Getters+setters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBakedGood() {
        return bakedGood;
    }

    public void setBakedGood(String bakedGood) {
        this.bakedGood = bakedGood;
    }

    //Methods
//    @Override
//    public String toString() {
//        return "Baked good: " + bakedGood + ", Measurement: " + measurement + ", Ingredients: " + ingredients;
//    }
}
