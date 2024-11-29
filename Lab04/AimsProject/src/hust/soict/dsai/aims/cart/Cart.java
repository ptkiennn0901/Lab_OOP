package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	private List<Media> itemsOrdered = new ArrayList<Media>(); 
	
	public void addMedia(Media item) {
		if (itemsOrdered.contains(item)==false) {
			itemsOrdered.add(item);
			System.out.println("Item added successfully!");
		}
	}
	
	public void removeMedia(Media item) {
		if (itemsOrdered.contains(item)) {
			itemsOrdered.remove(item);
			System.out.println("Item removed successfully!");
		}else {
            System.out.println("Item not found in the cart.");
        }
	}
	
	public float totalCost() {
		float sum = 0;
		for (Media item: itemsOrdered) {
			if (item!=null) {
				sum += item.getCost();
			}
		}
		return sum;
	}
	
	public void getAllTitles() {
		for (Media item: itemsOrdered) {
			System.out.println(item.getTitle());
		}
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: ");
		for (Media item: itemsOrdered) {
			System.out.println(item.toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	
	public void search(int id) {
		boolean found = false;
		for (Media item: itemsOrdered) {
			if (item.isMatch(id)) {
				System.out.println(item.toString());
				found = true;
			}
		}
		if (found == false) {
			System.out.println("No match is found");
		}
	}
	
	public void search(String title) {
		boolean found = false;
		for (Media item: itemsOrdered) {
			if (item.isMatch(title)) {
				System.out.println(item.toString());
				found = true;
			}
		}
		if (found == false) {
			System.out.println("No match is found");
		}
	}
	
	public void sortByTitleCost() {
//		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		Collections.sort(itemsOrdered);
	}
	
	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
//		Collections.sort(itemsOrdered);
	}
	
	public int getNumberOfMedia() {
		return itemsOrdered.size();
	}
	
	public void empty() {
		itemsOrdered = new ArrayList<Media>();
	}
}
