package com.example.bakinginformationsystem;

//to be done
public class Recipe {

    private GenList<Ingredient> ingredients;
    //Not sure how to approach measurements of each ingredient. Was thinking of making a new array of
    //measurements that links to the array ingredients. Leaving as an int for now.
    private int measurement;
    private String bakedGood;

    public Recipe(int measurement, String bakedGood) {
        this.measurement = measurement;
        this.bakedGood = bakedGood;
        this.ingredients = new GenList<>();
    }

    //Getters+setters
    public GenList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(GenList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getMeasurement() {
        return measurement;
    }

    public void setMeasurement(int measurement) {
        this.measurement = measurement;
    }

    public String getBakedGood() {
        return bakedGood;
    }

    public void setBakedGood(String bakedGood) {
        this.bakedGood = bakedGood;
    }

    //Methods
    @Override
    public String toString() {
        return "Baked good: " + bakedGood + ", Measurement: " + measurement + ", Ingredients: " + ingredients;
    }
}
