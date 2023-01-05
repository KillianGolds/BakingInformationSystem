package com.example.bakinginformationsystem;

import java.io.Serializable;

//to be done
public class Ingredient implements Serializable {

    private String ingredientName;
    private String ingredientDescription;
    private int calories;
    private String measurementUnit;
    private double quantity;

    //Constructor
    public Ingredient(String ingredientName, String ingredientDescription, int calories, String measurementUnit, double quantity){
        this.ingredientName = ingredientName;
        this.ingredientDescription = ingredientDescription;
        this.calories = calories;
        this.measurementUnit = measurementUnit;
        this.quantity = quantity;
    }

    //Getters+Setters
    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredientDescription = ingredientDescription;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(int calories) {
        this.measurementUnit = measurementUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + ingredientName.hashCode();
        result = prime * result + ingredientDescription.hashCode();
        result = prime * result + calories;
        result = prime * result + measurementUnit.hashCode();

        return result;
    }

    //Methods
    @Override
    public String toString(){
        return "Ingredient: " + ingredientName + "\nCalories: " + calories +", Quantity: "+quantity+" "+measurementUnit.toLowerCase()+"\nTextual Description: " + ingredientDescription;

    }

    public String toString2(){
        return "Name: " + ingredientName +", Calories: " + calories + ", Measurement Unit: " + measurementUnit +"\nTextual Description: " + ingredientDescription;
    }
}
