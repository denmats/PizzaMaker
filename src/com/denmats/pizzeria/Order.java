package com.denmats.pizzeria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Order {
    private final int ORDER_NUM;
    private final int CLIENT_NUM;
    private ArrayList<Pizza> listOfPizzas;
    private double totalOrderPrice = 0;
    private LocalDateTime now;

    static int pizzaCounter;

    private Scanner scanner = new Scanner(System.in);

    Order(){
        ORDER_NUM = 10_000+(int)(Math.round(Math.random()*(100_000-10_001)));//89_999 -> min 10_000 , max 99_999
        CLIENT_NUM = 1_000+(int)(Math.round(Math.random()*(10_000-1_001)));//8_999-> min 1_000 , max 9_999
        now = LocalDateTime.now();
        listOfPizzas = new ArrayList<>();
        pizzaCounter = 0;
        addNewPizza();
    }

    int getORDER_NUM() {
        return ORDER_NUM;
    }

    int getCLIENT_NUM() {
        return CLIENT_NUM;
    }

    LocalDateTime getOrderDate(){return now; }

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
        Object[] orderInfo =
                new Object[]{getORDER_NUM(),getCLIENT_NUM(),pizza.getNumOfPizza(),pizza.getNumOfPizza(),getOrderDate()};

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

