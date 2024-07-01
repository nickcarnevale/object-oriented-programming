/* Nick Carnevale
 * CSE7 Final Exam
 * 5/15
 * 
 * Public class Fruit which extends the abstract class Food
 * 
 * Comprehension #3
 * Overriding methods means that there is a new method being created over the previous method,
 * with the same parameters. The name and parameters are the same but the function is different
 * 
 * Overloading methods means that the names of the methods are the same, but there are more, fewer, or different 
 * parameters for that method. This differentiates the method, even though the names are the same. 
 * 
 * Overridden methods are used in this class to override abstract methods called in Food.
 * Overloaded methods are used in the constructor so multiple different types of fruit can be instantiated. 
 */

public class Fruit extends Food{

	//private variables
	private boolean seeds;
	private static int numFruit = 0;
	
	//Constructors
	public Fruit(boolean seeds) {
		this.seeds = seeds;
		numFruit++;
	}
	
	public Fruit(String name, double price) {
		super(name,price);
		numFruit++;
	}
	
	public Fruit(String name, double price, boolean seeds) {
		super(name, price);
		this.seeds = seeds;
		numFruit++;
	}
	
	public Fruit(String name) {
		super(name);
		numFruit++;
	}
	
	//get and set methods
	public void setSeeds(boolean seeds) {
		this.seeds = seeds;
	}
	
	public boolean getSeeds() {
		return seeds;
	}
	
	public int getNumFruit() {
		return numFruit;
	}
	
	//override abstract method getType
	@Override
	public String getType() {
		return "Fruit";
	}
	
	//override toString
	@Override
	public String toString() {
		if(seeds) {
			return super.toString() + "\tFruit (Seeded)" + "\t\t$" + super.getPrice();
		}
		else return super.toString() + "\tFruit (Seedless)" + "\t$" + super.getPrice();
		
	}
	
}
