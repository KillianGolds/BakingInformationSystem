package com.example.bakinginformationsystem;

//to be done
public class Ingredient {

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

    //Methods
    public String toString(){
        return "Name: " + ingredientName + ", Description: " + ingredientDescription + ", Calories: " + calories + ", Measurement Unit: " + measurementUnit;
    }

    public String toString2(){
        return "Name: " + ingredientName + ", Description: " + ingredientDescription + ", Calories: " + calories +"\nQuantity: "+quantity+" "+measurementUnit;
    }
}
