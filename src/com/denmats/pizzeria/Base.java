package com.denmats.pizzeria;

import java.text.NumberFormat;
import java.util.Locale;

public class Base {
    private String name;
    private double price;

    Base(){
        this.name = "Pizza(Base)";
        this.price = 1.0;
    }


    double getPrice() {
        return price;
    }

    void setNYBasePrice() {
        this.price = 1.5;
    }

    @Override
    public String toString() {
        return name +"\t"+ NumberFormat.getCurrencyInstance(Locale.GERMANY).format(price);
    }
}

