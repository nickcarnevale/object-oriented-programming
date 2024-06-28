/* Nick Carnevale
 * CSE7 Final Exam
 * 5/15
 * 
 * Public class Vegetable which extends the abstract class Food
 * 
 * Comprehension #2
 * Constructor Chaining is and OOP term which refers to when a class entends another class
 * The constructor in the derived class can can call upon the super class to implement data members. 
 * This is seen in the vegetable constructor when super(name, price); is used. Basically, it is having the
 * constructor in the derived class call upon the constructor in the super class. 
 * 
 * In this program, whenever there is a vegetable constructor created with the data members name and price, 
 * the Food constructor with those data members is also being called. 
 */

public class Vegetable extends Food{

	//private variables
	private String color;
	private static int numVeg = 0;
	
	//Constructors
	public Vegetable(String color) {
		this.color = color;
		numVeg++;
	}
	
	public Vegetable(String name, double price) {
		super(name,price);
		numVeg++;
	}
	
	public Vegetable(String name, double price, String color) {
		super(name, price);
		this.color = color;
		numVeg++;
	}
	
	//set and get methods
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getNumVeg() {
		return numVeg;
	}

	//override abstract method GetType
	@Override
	public String getType() {
		return "Vegetable";
	}
	
	//override toString
	@Override
	public String toString() {
		return super.toString() + "\tVegetable\t" + color + "\t$" + super.getPrice();
	}	
	
}
