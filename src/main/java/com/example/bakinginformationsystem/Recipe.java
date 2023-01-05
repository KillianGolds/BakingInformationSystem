package com.example.bakinginformationsystem;

import java.io.Serializable;

//to be done
public class Recipe implements Serializable {

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    private int totalCalories;

    private BakeryGood bakedGood;

    public GenList<Ingredient> recipeIngredients;
    public GenList<Ingredient> getChosenIngredients() {
        return recipeIngredients;
    }
    public void setChosenIngredients(GenList<Ingredient> chosenIngredients) {
    }

    public Recipe(BakeryGood bakedGood) {
        this.bakedGood = bakedGood;
        this.recipeIngredients = new GenList<Ingredient>();
        this.totalCalories = getTotalCalories();
    }

    //Getters+setters
    public BakeryGood getBakedGood() {
        return bakedGood;
    }

    //Methods

    public void addIngredient(Ingredient ingredient) {
        recipeIngredients.addLast(ingredient);
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + bakedGood.hashCode();
        result = prime * result + recipeIngredients.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Recipe:\n" + bakedGood + recipeIngredients;
    }
}

