package com.example.bakinginformationsystem;

//to be done
public class Recipe {

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
    }

    //Getters+setters
    public BakeryGood getBakedGood() {
        return bakedGood;
    }

    //Methods

    public void addIngredient(Ingredient ingredient) {
        recipeIngredients.addLast(ingredient);
    }
    @Override
    public String toString() {
        return "Recipe:\n" + bakedGood + recipeIngredients;
    }
}

