/* Nick Carnevale
 * CSE7 Final Exam
 * 5/15
 * 
 * Public abstract class Food used to create a vegetable and fruit concrete class
 * 
 * Comprehension #1
 * The class Food is defined as a abstract class because food can further be defined
 * in this program as either a vegetable or a fruit, which are its concrete classes.
 * We will not be able to instantiate the food class with the key word new, without the food being
 * either a Fruit or a Vegetable, because those classes will inherit the food class. 
 * 
 * The method, getType() is abstract because we want to use polymorphism to have the
 * fruit and vegetable classes have different getType methods, overrided within them. 
 * Therefore, whenever getType() is called on a food, depending whether it is a fruit
 * or vegetable, it will use the corresponding getType() method. 
 * 
 */

public abstract class Food implements Comparable<Food>{

	//private variables
	private String name;
	private double price;
	private static int numFood = 0;
	
	//protected constructors
	protected Food(String name, double price) {
		this.name = name;
		this.price = price;
		numFood++;
	}
	
	protected Food() {
		numFood++;
	}
	
	protected Food(String name) {
		this.name = name;
		numFood++;
	}
	
	//set methods
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	//get methods
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getNumFoods() {
		return numFood;
	}
	
	//abstract method
	public abstract String getType();
	
	//override toString
	@Override
	public String toString() {
		if(name.length()>7) {
			return name + "\t";
		}
		else return name + "\t\t";
	}
	
	//override equals from java.util.Object
	public boolean equals(Object o) {
		if(o instanceof Food) {
			Food f = (Food) o;
			return name.equals(f.getName().toLowerCase());
		}
		else return false;
	}
	
	//override comparable method compareTo
	public int compareTo(Food f) {
		
		if(price > f.getPrice()) 
			return 1;
		else if(price < f.getPrice())
			return -1;
		else
			return 0;
	}

}
