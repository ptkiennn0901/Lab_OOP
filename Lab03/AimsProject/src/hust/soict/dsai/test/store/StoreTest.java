package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		
		store.addDVD("Clueless");
		store.addDVD("Legally Blonde");
		store.addDVD("Doraemon");
		store.displayDVDs();
		
		
		store.removeDVD("Clueless");
		store.removeDVD("Doraemon");
		store.displayDVDs();
	}
}
