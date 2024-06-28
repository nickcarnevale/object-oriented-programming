/* Nick Carnevale
 * CSE7 Final Exam
 * 5/15
 * 
 * This class tests the Food, fruit and vegetable classes previously created
 * 
 * Comprehension #4
 * When the grocery cart array is printed, the compiler knows which toString() method 
 * because of dynamic polymorphism. In other words, because toString is overridden in the fruit
 * and vegetable classes, when the Food is an instance of either the fruit or vegetable class, the compiler
 * will use the respective toString method to print
 */

import java.util.Scanner;
public class FoodTest{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        Food[] groceryCart = new Food[16];
        groceryCart[0] = new Vegetable("Romaine", 1.09, "Green");
        groceryCart[1] = new Fruit("Mango", 3.79, true);
        groceryCart[2] = new Vegetable ("Brussel Sprouts", 4.56, "Green");
        groceryCart[3] = new Fruit("Blueberry", 0.89, false);
        groceryCart[4] = new Vegetable("Purple Carrots", 1.56, "Purple");
        groceryCart[5] = new Vegetable("Spinach", 2.32, "Green");
        groceryCart[6] = new Vegetable("Carrots", 1.45, "Orange");
        groceryCart[7] = new Vegetable("Potatoes", 3.99, "Red");
        groceryCart[8] = new Vegetable("Broccoli", 5.21, "Green");
        groceryCart[9] = new Vegetable("Turnip", .99, "White");
        groceryCart[10] = new Vegetable("Onions", 1.99, "Yellow");
        groceryCart[11] = new Fruit("Apples", 5.79, true);
        groceryCart[12] = new Fruit("Banana", .78, false);
        groceryCart[13] = new Fruit("Kiwi", 2.65, true);
        groceryCart[14] = new Fruit("Strawberry", 4.79, true);
        groceryCart[15] = new Fruit("Watermelon", 6.32, false);

        System.out.println("Items in your cart");
        display(groceryCart);

        sortByPrice(groceryCart);

        System.out.println("\nCart sorted by price");
        display(groceryCart);

        int search = getInt(scan);
        scan.nextLine(); //clearing the scanner of a new line character

        for(int i =0; i<search; i++){
            System.out.println("What item would you like to search for? ");
            String searchName = scan.nextLine();
            searchByName(groceryCart, searchName);

        }

        checkOut(groceryCart);
    }
    public static int getInt(Scanner s){
        boolean loopNeeded = true;
        int num = 0;
        do{
            System.out.println("How many items would you like to search for? ");
            if(s.hasNextInt()){
                num = s.nextInt();
                if(num > 0 ){
                    loopNeeded= false;
                } else {
                    System.out.println("Enter a num greater than 0");
                }
            } else {
                System.out.println("not a number");
                s.nextLine();
            }
        }while(loopNeeded);
        return num;
    }
    
    //method to return average and total of cart
    public static void checkOut(Food[]cart){
    	double total = 0;
    	double average = 0;
    	for(int i = 0; i < cart.length; i++) {
    		total += cart[i].getPrice();
    		average += cart[i].getPrice();
    	}
    	average /= cart.length;
    	
    	System.out.printf("The average cost per item in your cart is: $%.2f", average);
    	System.out.printf("\nThe total cost for everything in your cart is: $%.2f", total);

    }
    public static void display(Food[]list){
    	for(int i = 0; i < list.length; i++) {
    		if(list[i] != null)
    		System.out.println(list[i]);
    	}
    }
    
    //method to sort array by price
    public static void sortByPrice(Food[]list){
    	java.util.Arrays.sort(list);
    }
    
    //method to search array by name using Food.equals method 
    public static void searchByName(Food[]list, String name){
    	boolean found = false;
    	name.toLowerCase();
    	Food f = new Fruit(name);
    	
    	for(int i = 0; i < list.length; i++) {
    		if(f.equals(list[i])) {
    			found = true;
    			System.out.printf("Item Found:\n%S\n",list[i]);
    		}
    	}
    	if(!found) {
    		System.out.println("Item Not Found");

    	}
    }
}