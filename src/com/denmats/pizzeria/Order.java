package com.denmats.pizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Order {
    private final int ORDER_NUM;
    private final int CLIENT_NUM;
    private ArrayList<Pizza> listOfPizzas;
    private double totalOrderPrice = 0;

    static int pizzaCounter;

    private Scanner scanner = new Scanner(System.in);

    Order(){
        ORDER_NUM = 9999+(int)(Math.round(Math.random()*(99999-9999)));
        CLIENT_NUM = 999+(int)(Math.round(Math.random()*(9999-999)));
        listOfPizzas = new ArrayList<>();
        pizzaCounter = 0;
        addNewPizza();
    }

    private int getORDER_NUM() {
        return ORDER_NUM;
    }

    int getCLIENT_NUM() {
        return CLIENT_NUM;
    }

    ArrayList<Pizza> getListOfPizzas() {
        return listOfPizzas;
    }


    private void addNewPizza(){
        boolean isNewPizza = true;
        while (isNewPizza){
            System.out.println("New pizza? (yes/no - any key)");
            if(scanner.next().equalsIgnoreCase("yes")){
                Pizza pizza = new Pizza();
                listOfPizzas.add(pizza);
                displayInfo(pizza);
            }else{
                System.out.println(this);
                for(Pizza p: listOfPizzas){
                    System.out.println(p);
                }
                isNewPizza = false;
            }
        }
    }

    private void displayInfo(Pizza pizza){
        String[] orderInfo = new String[4];
        orderInfo[0] = String.valueOf(getORDER_NUM());
        orderInfo[1] = String.valueOf(getCLIENT_NUM());
        orderInfo[2] = pizza.getNameOfPizza();
        orderInfo[3] = String.valueOf(pizza.getNumOfPizza());

        System.out.println(Arrays.toString(orderInfo));
    }

    double getTotalOrderPrice(){
        for(Pizza pizza : listOfPizzas){
            totalOrderPrice += pizza.getTotalPizzasPrice()*pizza.getNumOfPizza();
        }
        return totalOrderPrice;
    }

    @Override
    public String toString() {
        return  "\n*************\n"
                +"Order Number: " + ORDER_NUM +"\n"
                +"Client Number: " + CLIENT_NUM;
    }
}

