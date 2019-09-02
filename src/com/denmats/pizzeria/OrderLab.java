package com.denmats.pizzeria;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.sql.*;

public class OrderLab {
    private static Scanner scanner = new Scanner(System.in);

    static{
        System.out.println("*****PIZZERIA PALERMO*****");
        System.out.println("*****MAKE YOUR PIZZA*****");
    }

    public static void main(String[] args) {
       // displayGreetings();
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
                displayResults(orders); //show results in console
                putResultsIntoDB(orders); //write down results into mysql database
                new JTableForResults(); //display results in JTable
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

    private static void putResultsIntoDB(ArrayList<Order> orders){
        String url = "jdbc:mysql://localhost/pizzeria?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String uname = "root";
        String pass = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, uname, pass);

            Statement statement = conn.createStatement();


            for(Order order : orders){
                for(int i = 0; i< order.getListOfPizzas().size(); i++){

                    int order_num = order.getORDER_NUM();
                    int client_num = order.getCLIENT_NUM();
                    String pizza_name = order.getListOfPizzas().get(i).getNameOfPizza().toUpperCase();
                    int pizza_quantity = order.getListOfPizzas().get(i).getNumOfPizza();

                    statement.executeUpdate("INSERT INTO `orders`(" +
                            "id, order_num, client_num, pizza_name, pizza_quantity) values (" +
                            "null, '"+order_num+"', '"+client_num+"','"+pizza_name+"','"+pizza_quantity+"')");
                }
            }

            statement.close();
            conn.close();
        }
        catch (ClassNotFoundException e1){
            System.out.println(e1.getMessage());
        }
        catch (SQLException e2){
            e2.printStackTrace();
        }
    }
}

