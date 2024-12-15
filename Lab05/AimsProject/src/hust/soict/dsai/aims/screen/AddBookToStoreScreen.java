package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen{

	public AddBookToStoreScreen(Store store, Store itemStorage, Cart cart) {
		super(store, itemStorage, cart);
		setTitle("Book Storage");
	}
	
}
