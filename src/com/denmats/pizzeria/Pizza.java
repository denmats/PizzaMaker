package com.denmats.pizzeria;

import java.text.NumberFormat;
import java.util.*;


public class Pizza {
    private int pizzaID;
    private String nameOfPizza;
    private int numberOfPizza;
    private ArrayList<Ingredients> ingredients;
    private double totalPizzasIngredientsPrice;
    private Base base;


    Pizza(){
        setPizzaID();
        setNameOfPizza();
        setNumOfPizza();
        changeNumOfPizza();
        base = new Base();
        chooseBaseOfPizza();
        ingredients = new ArrayList<>();
        showAvailableIngredients();
        addIngredient();
        setTotalPizzaPrice();
    }

    private void setPizzaID(){
        pizzaID = ++Order.pizzaCounter;
    }

    private int getPizzaID(){
        return pizzaID;
    }

    private void setNameOfPizza(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name your pizza: ");
        try{
            if(scanner.hasNextLine()) {
                String name = scanner.nextLine();
                if (name.length() >= 4 && name.length() <= 20) {
                    this.nameOfPizza = name;
                } else {
                    this.nameOfPizza = "Anonymous_" + getPizzaID();
                }
            }
        }catch (InputMismatchException e){
            e.getMessage();
        }
    }

    String getNameOfPizza(){
        return this.nameOfPizza;
    }

    private void setNumOfPizza() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many pizzas? ");
        try{
            int number = scanner.nextInt();
            if(number > 0 && number <= 10){
                this.numberOfPizza = number;
            }else{
                System.err.println("It is not allowed to order more than 10 pizzas.");
                System.out.println("It is set 1 pizza.");
                this.numberOfPizza = 1;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    int getNumOfPizza(){
        return this.numberOfPizza;
    }

    private void changeNumOfPizza(){
        System.out.println("Change the number of pizzas? (yes/no - any key)");
        Scanner scanner = new Scanner(System.in);
        try{
            if(scanner.nextLine().equalsIgnoreCase("yes")){
                setNumOfPizza();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void chooseBaseOfPizza(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Standard BASE or NY? (N - for NY/default - any key)");

        if(scanner.nextLine().equalsIgnoreCase("N")){
            this.base.setNYBasePrice();
        }
    }



    private void showAvailableIngredients(){
        System.out.println("Available Ingredients: ");
        int counter = 1;
        for(Ingredients ingredient : Ingredients.values()){
            System.out.println("["+counter+"] "+ingredient.name()+"\t"
                    + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(ingredient.getPriceOfIngredient()));
            counter++;
        }
    }

    private void addIngredient(){
        Scanner scanner = new Scanner(System.in);
        boolean isNextIngredient = true;
        while(isNextIngredient) {
            System.out.println("Enter number of ingredient: (q - exit)");
            switch (scanner.next().charAt(0)) {
                case '1':
                    ingredients.add(Ingredients.TOMATO_PASTE);
                    break;
                case '2':
                    ingredients.add(Ingredients.SALAMI);
                    break;
                case '3':
                    ingredients.add(Ingredients.PEPPER);
                    break;
                case '4':
                    ingredients.add(Ingredients.OLIVES);
                    break;
                case '5':
                    ingredients.add(Ingredients.GARLIC);
                    break;
                case '6':
                    ingredients.add(Ingredients.CORN);
                    break;
                case '7':
                    ingredients.add(Ingredients.CHEESE);
                    break;
                case '8':
                    ingredients.add(Ingredients.BACON);
                    break;
                case 'q':
                case 'Q':
                    isNextIngredient = false;
                    break;
                default:
                    System.out.println("Make a proper choice");
                    break;
            }

            if(ingredients.size() == 8) {
                System.out.println("The pizza is full");
                System.err.println("You're not allowed to add more than 8 ingredients.");
                isNextIngredient = false;
            }
        }
        checkRepetitiveIngredient();
    }



    private void checkRepetitiveIngredient(){
        Set<Ingredients> check ;
        boolean isRepetitiveIngredient = true;
        while(isRepetitiveIngredient){
            check = new HashSet<>(ingredients);
            if(check.size() != ingredients.size()){
                System.err.println("Repetitive ingredients are forbidden");
                System.out.println("Repeat your order properly");
                ingredients.clear();
                addIngredient();
            }else {
                isRepetitiveIngredient = false;
            }
        }
    }

    private void setTotalPizzaPrice(){
        totalPizzasIngredientsPrice = 0;
        for(Ingredients ingredient : ingredients){
            totalPizzasIngredientsPrice += ingredient.getPriceOfIngredient();
        }
    }

    double getTotalPizzasPrice(){
        return totalPizzasIngredientsPrice + base.getPrice();
    }


    @Override
    public String toString() {
        return "Pizza's Name: " + nameOfPizza + "\n"
                +"--------------\n"
                +base+"\n"
                +ingredients
                .toString()
                .replace("[","")
                .replace("]","")
                .replace(",","")
                +"--------------\n"
                +"Pizza's price: "+ NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getTotalPizzasPrice())+"\n"
                +"Quantity: " + numberOfPizza + "\n";
    }


    //Inside class Base
    private static class Base {
        private String name;
        private double price;

        Base() {
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
            return name + "\t" + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(price);
        }
    }//End of class Base
}//End of class Pizza
