package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{

	public AddDigitalVideoDiscToStoreScreen(Store store, Store itemStorage, Cart cart) {
		super(store, itemStorage, cart);
		setTitle("DVD Storage");
	}

}
