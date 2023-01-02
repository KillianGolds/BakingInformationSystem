package com.example.bakinginformationsystem;

//to be done
public class Ingredient {

    private String ingredientName;
    private String ingredientDescription;
    private int calories;
    private String measurementUnit;

    //Constructor
    public Ingredient(String ingredientName, String ingredientDescription, int calories, String measurementUnit){
        this.ingredientName = ingredientName;
        this.ingredientDescription = ingredientDescription;
        this.calories = calories;
        this.measurementUnit = measurementUnit;
    }

    //Getters+Setters
    public String getIngredientNameName() {
        return ingredientName;
    }

    public void setIngredientNameName(String ingrName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientNameDesc() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingrDesc) {
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

    //Methods
    @Override
    public String toString(){
        return "Name: " + ingredientName + ", Description: " + ingredientDescription + ", Calories: " + calories + ", Measurement Unit: " + measurementUnit;
    }
}
