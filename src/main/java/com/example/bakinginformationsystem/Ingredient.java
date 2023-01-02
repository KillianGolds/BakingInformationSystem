package com.example.bakinginformationsystem;

//to be done
public class Ingredient {

    private String ingredientName;
    private String ingredientDescription;
    private int calories;

    //Constructor
    public Ingredient(String ingredientName, String ingredientDescription, int calories){
        this.ingredientName = ingredientName;
        this.ingredientDescription = ingredientDescription;
        this.calories = calories;
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

    //Methods
    @Override
    public String toString(){
        return "Name: " + ingredientName + ", Description: " + ingredientDescription + ", Calories: " + calories;
    }
}
