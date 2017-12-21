package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import pointOfSale.groceries.Grocery;
import pointOfSale.groceries.Meat;
import pointOfSale.groceries.Produce;

public class GroceryIO {

	public static ArrayList<Grocery> readGroceries(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(fileName));
		ArrayList<Grocery> groceries = new ArrayList<Grocery>();
		while (fileReader.hasNextLine()) {
			try {
				String nextLine = fileReader.nextLine();
				Grocery grocery = readGrocery(nextLine);
				boolean duplicate = false;
				for (int i = 0; i < groceries.size(); i++) {
					Grocery g = groceries.get(i);
					if (grocery.getName().equals(g.getName())) {
						duplicate = true;
					}
				}
				if (!duplicate) {
					groceries.add(grocery);
				}
			} catch (IllegalArgumentException e) {
				// skip the line
			}
		}
		fileReader.close();
		return groceries;
	}

	/**
	 * reads file and creates the Grocery object
	 * 
	 * @param nextLine
	 *            = string containing grocery item information
	 * @return Grocery object
	 */
	private static Grocery readGrocery(String nextLine) {
		try {
			Scanner sc = new Scanner(nextLine);
			sc.useDelimiter(" ");
			String name = sc.next();
			int weight = sc.nextInt();
			int price = sc.nextInt();
			int id = sc.nextInt();
			Grocery grocery = null;
			if (id == 1) {
				grocery = new Grocery(price, id, weight, name);
			}
			if (id == 2) {
				grocery = new Meat(price, id, weight, name);
			}
			if (id == 3) {
				grocery = new Produce(price, id, weight, name);
			}
			sc.close();
			return grocery;
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("invalid arg");
		}
	}

}
