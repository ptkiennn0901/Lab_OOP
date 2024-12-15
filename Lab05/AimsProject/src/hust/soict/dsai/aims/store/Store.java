package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private List<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media item) {
		if (itemsInStore.contains(item)==false) {
			itemsInStore.add(item);
			System.out.println("Item added successfully!");
		}else {
			System.out.println("This item is already in the store.");
		}
	}
	
	public void removeMedia(Media item) {
		if (itemsInStore.contains(item)) {
			itemsInStore.remove(item);
			System.out.println("Item removed successfully!");
		}else {
            System.out.println("Item not found in the store.");
        }
	}
	
	public void print() {
		System.out.println("These are all products in our store:");
		for (Media item: itemsInStore) {
			System.out.println(item.toString());
		}
	}
	
	public Media search(String title) {
		for (Media item: itemsInStore) {
			if (item.isMatch(title)) {
				return item;
			}
		}
		return null;
	}

	public ArrayList<Media> getItemsInStore() {
		return (ArrayList<Media>) itemsInStore;
	}
}
