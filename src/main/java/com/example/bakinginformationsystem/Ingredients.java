package com.example.bakinginformationsystem;

//to be done
public class Ingredients{

    private String ingrName;
    private String ingrDesc;
    private int calories;

    //Constructor
    public Ingredients(String ingrName, String ingrDesc, int calories){
        this.ingrName = ingrName;
        this.ingrDesc = ingrDesc;
        this.calories = calories;
    }

    //Getters+Setters
    public String getIngrName() {
        return ingrName;
    }

    public void setIngrName(String ingrName) {
        this.ingrName = ingrName;
    }

    public String getIngrDesc() {
        return ingrDesc;
    }

    public void setIngrDesc(String ingrDesc) {
        this.ingrDesc = ingrDesc;
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
        return "Name: " + ingrName + ", Description: " + ingrDesc + ", Calories: " + calories;
    }
}
