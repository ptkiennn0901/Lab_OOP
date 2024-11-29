package hust.soict.dsai.aims.store;
import java.util.ArrayList;
public class Store {
	private ArrayList<String> itemsInStore;
	
	public Store() {
		this.itemsInStore = new ArrayList<>();
	
	}
	//two methods called addDVD and removeDVD
	public void addDVD(String dvd) {
		if (dvd == null||dvd.isEmpty()) {
			System.out.println("Invalid.");
		}
		else{
			itemsInStore.add(dvd);
			System.out.println("Successfully added " + dvd +" to the list");
		}
		
	}
	
	public void removeDVD(String dvd) {
		if(itemsInStore.isEmpty()) {
			System.out.println("Invalid.");
		}
		else {
			itemsInStore.remove(dvd);
			System.out.println(dvd + " has been removed from the store.");
		}
	}
	
	//displayDVD (for the store test)
    public void displayDVDs() {
        if (itemsInStore.isEmpty()) {
            System.out.println("No DVDs.");
        } else {
            System.out.println("DVDs available in the store: " + itemsInStore);
        }
    }
	

}
