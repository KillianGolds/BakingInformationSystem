package com.example.bakinginformationsystem;

//to be done
public class Recipe {

    //Not sure how to approach measurements of each ingredient. Was thinking of making a new array of
    //measurements that links to the array ingredients. Leaving as is for now.
    BakeryGood bakedGood;

    GenList<Ingredient> recipeIngredients;
    public GenList<Ingredient> getChosenIngredients() {
        return recipeIngredients;
    }
    public void setChosenIngredients(GenList<Ingredient> chosenIngredients) {
    }

    public Recipe(BakeryGood bakedGood, GenList<Ingredient> recipeIngredients) {
        this.bakedGood = bakedGood;
        this.recipeIngredients = recipeIngredients;
    }

    //Getters+setters
    public BakeryGood getBakedGood() {
        return bakedGood;
    }

    //Methods
    @Override
    public String toString() {
        return "Baked good: " + bakedGood + ", Ingredients: "+ recipeIngredients;
    }
}

