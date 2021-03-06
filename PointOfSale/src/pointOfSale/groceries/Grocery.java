/**
 * 
 */
package pointOfSale.groceries;

/**
 * A grocery is an item in the store that has a name, price, weight, and id.
 * @author Austin Green
 *
 */
public class Grocery {
	
	private int price;
	
	private String name;
	
	private int id;
	
	private int weight;
	
	private int idCount = 0;
	
	public Grocery (int price, int id, int weight, String name){
		setID(id);
		this.name = name;
		this.weight = weight;
		this.price = price;
		
	}
	
	public int setID(int id) {
		idCount++;
		return this.id = 1000 + idCount;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWeight() {
		return this.weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grocery [price=" + price + ", name=" + name + ", id=" + id + ", weight=" + weight + "]";
	}
	

}
