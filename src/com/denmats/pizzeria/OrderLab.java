package com.denmats.pizzeria;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class OrderLab {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayGreetings();
        ArrayList<Order> orders = new ArrayList<>();
        boolean isNewOrder = true;
        while (isNewOrder){
            System.out.println("Make order? (yes/no - any key)");
            if(scanner.next().equalsIgnoreCase("yes")){
                Order order = new Order();
                System.out.println("*************");
                System.out.println("Total: " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(order.getTotalOrderPrice()));
                System.out.println("*************");
                orders.add(order);
            }else {
                displayResults(orders);
                isNewOrder = false;
            }
        }
    }


    private static void displayResults(ArrayList<Order> orders){
        try{
            for(Order order : orders){
                for(int i = 0; i< order.getListOfPizzas().size(); i++){
                    System.out.println("The Client "
                            +order.getCLIENT_NUM()+" "
                            +"wants to order "
                            +order.getListOfPizzas().get(i).getNumOfPizza()
                            +" pizzas "
                            + "\""+order.getListOfPizzas().get(i).getNameOfPizza().toUpperCase()+"\"");
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    private static void displayGreetings(){
        System.out.println("*****PIZZERIA PALERMO*****");
        System.out.println("*****MAKE YOUR PIZZA*****");
    }
}

