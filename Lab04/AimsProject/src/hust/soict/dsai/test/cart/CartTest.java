package hust.soict.dsai.test.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "Geogre Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 12.5f);
		cart.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "Geogre Lucas", 90, 24.95f);
		cart.addMedia(dvd4);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "Geogre Lucas", 90, 12.95f);
		cart.addMedia(dvd5);
		
		List<String> authors = new ArrayList<String>();
		Book book1 = new Book("Math", "Research", 12.5f, authors);
		book1.addAuthor("A");
		book1.addAuthor("B");
		book1.removeAuthor("B");
		cart.addMedia(book1);
		
		cart.addMedia(dvd3);
		
		cart.print();
		cart.removeMedia(dvd1);
		cart.removeMedia(dvd1);
		
		List<Track> tracks = new ArrayList<Track>();
		CompactDisc cd1 = new CompactDisc("Aladin", "B", "C", 12, 18.5f, "D", tracks);
		cart.addMedia(cd1);
		
		cart.print();
		
		cart.sortByCostTitle();
		cart.print();
		
		cart.sortByTitleCost();
		cart.print();
	}
}
