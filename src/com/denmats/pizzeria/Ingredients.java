package com.denmats.pizzeria;


public enum Ingredients {
    TOMATO_PASTE("tomatoPaste",1.0),
    SALAMI("salami",1.5),
    PEPPER("pepper",0.6),
    OLIVES("olives",0.5),
    GARLIC("garlic",0.3),
    CORN("corn",0.7),
    CHEESE("cheese",1.0),
    BACON("bacon",1.2);

    private String nameOfIngredient;
    private double priceOfIngredient;

    Ingredients(String name, double price){
        this.nameOfIngredient = name;
        this.priceOfIngredient = price;
    }

    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    public double getPriceOfIngredient() {
        return priceOfIngredient;
    }

    @Override
    public String toString() {
        return  getNameOfIngredient() + "\t" +getPriceOfIngredient() +" \u20AC " +"\n";
    }
}

