package pointOfSale.groceries;

public class Produce extends Grocery {

	private int idCount = 0;

	private int id;

	public Produce(int price, int id, int weight, String name) {
		super(price, id, weight, name);
		setID(id);
	}

	public int setID(int id) {
		idCount++;
		return this.id = 3000 + idCount;
	}

}
