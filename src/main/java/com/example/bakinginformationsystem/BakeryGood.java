package com.example.bakinginformationsystem;

public class BakeryGood {

    private String goodType;
    private String itemName;
    private String origin;
    private String textDesc;
    private String imageURL;

    public BakeryGood( String goodType, String itemName, String origin, String textDesc, String imageURL){
        this.goodType = goodType;
        this.itemName = itemName;
        this.origin = origin;
        this.textDesc = textDesc;
        this.imageURL = imageURL;
    }

    public String getGoodType() {return goodType;}
    public void setGoodType(String goodType) {this.goodType = goodType;}

    public String getItemName() {return itemName;}
    public void setItemName(String itemName) {this.itemName = itemName;}

    public String getOrigin() {return origin;}
    public void setOrigin(String origin) {this.origin = origin;}

    public String getTextDesc() {return textDesc;}
    public void setTextDesc(String textDesc) {this.textDesc = textDesc;}

    public String getImageURL() {return imageURL;}
    public void setImageURL(String imageURL) {this.imageURL = imageURL;}

    @Override
    public String toString() {
        return "Name: "+itemName+", Type: "+goodType+", Country of Origin: "+origin+".\n"+ "Description: "+textDesc+".\n"+"Image URL: "+imageURL;
    }
}
