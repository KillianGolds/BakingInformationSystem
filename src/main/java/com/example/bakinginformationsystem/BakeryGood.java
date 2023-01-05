package com.example.bakinginformationsystem;

import java.io.Serializable;

public class BakeryGood implements Serializable {

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

    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + goodType.hashCode();
        result = prime * result + itemName.hashCode();
        result = prime * result + origin.hashCode();
        result = prime * result + textDesc.hashCode();
        result = prime * result + imageURL.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Bakery Good: "+itemName+"\nType: "+goodType+", Country of Origin: "+origin+".\n"+ "Description: "+textDesc+".\n"+"Image URL: "+imageURL;
    }



}
