# PizzaMaker
Assignment:

Create a console app "Pizzeria Palermo". The app permits to order custom pizzas. Making your own custom pizza you may to rename your pizza, choose base of pizza: -"Standard" or open pizza; -"NY" (New York type) or closed pizza; Also you may to set number of pizzas you want to order. There must be a possibility to change the ordered quantity

There are some constraints: 1.You may to order up 10 pizzas at once; 2.The length of the pizza's name might be more or equal 4 letters and less or equal than 20 letters; If the name doesn't meet with the restriction above, then name sets "Anonymous_" + ordinal number of pizza.

3.Order number and Client number are set automatic at once. Order number contains 5 figures getting random. Client number contains 4 figures getting random. Order and Client numbers mustn't change while the app is working.

Stage I: Class Pizza includes pizza's name, ordered quantity, a set of ingredients (this set must be empty at the beginning) Create other necessary classes as well.

There are only 8 ingredients available to order at this moment:
TOMATO_PASTE	1,00 €
SALAMI	1,50 €
PEPPER	0,60 €
OLIVES	0,50 €
GARLIC	0,30 €
CORN	0,70 €
CHEESE	1,00 €
BACON	1,20 €

After creating order need to be displayed short information about it.
[Order number: Client number: Pizza's name: Amount of ordered pizza]

example: [90998, 4210, Anonymous_1, 3]
Stage II: You need to create method "addIngredient()", which allowed to add ingredients from the list to your pizza. It is not allowed to add more than 8 ingredients into one pizza. If you add 8 ingredients, the sign will appear: "Pizza is full."

There is no possibility to add repetitive ingredients. After creating the order, check for
repetitive ingredients. If they are, ask for repeat the order.
Stage III: After the order is completed, create method toString() printing a bill similar to that: It is important to keep a such format!

*************
Order Number: 55071
Client Number: 7188
Pizza's Name: Margarita
--------------
Pizza(Base)	1,50 €
tomatoPaste	1.0 €
 salami	1.5 €
 pepper	0.6 €
 corn	0.7 €
 olives	0.5 €
 bacon	1.2 €
--------------
Pizza's price: 7,00 €
Quantity: 3

Pizza's Name: Pepperoni
--------------
Pizza(Base)	1,00 €
tomatoPaste	1.0 €
 salami	1.5 €
 pepper	0.6 €
 olives	0.5 €
 garlic	0.3 €
 corn	0.7 €
 cheese	1.0 €
 bacon	1.2 €
--------------
Pizza's price: 7,80 €
Quantity: 3

Pizza's Name: Anonymous_3
--------------
Pizza(Base)	1,50 €
salami	1.5 €
 tomatoPaste	1.0 €
 corn	0.7 €
 pepper	0.6 €
--------------
Pizza's price: 5,30 €
Quantity: 2

*************
Total: 55,00 €
*************
Stage End: Program ends with signature: example:

The Client 7188 wants to order 3 pizzas "MARGARITA"
The Client 7188 wants to order 3 pizzas "PEPPERONI"
The Client 7188 wants to order 2 pizzas "ANONYMOUS_3"
The Client 8726 wants to order 7 pizzas "MYPIZZA1"
The Client 8726 wants to order 2 pizzas "PIZZA_FOR_FRIEND"
