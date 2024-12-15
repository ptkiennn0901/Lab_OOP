package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{

	public AddCompactDiscToStoreScreen(Store store, Store itemStorage, Cart cart) {
		super(store, itemStorage, cart);
		setTitle("CD Storage");
	}

}
