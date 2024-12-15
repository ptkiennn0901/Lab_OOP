package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		smUpdateStore.add(addBook);
		addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Store bookStorage = new Store();
            	Book book1 = new Book("To Kill a Mockingbird", "Fiction", 14.99f);
            	bookStorage.addMedia(book1);
            	Book book2 = new Book("1984", "Dystopian", 12.50f);
            	bookStorage.addMedia(book2);
            	Book book3 = new Book("Sapiens: A Brief History of Humankind", 
            			"Non-Fiction", 19.99f);
            	bookStorage.addMedia(book3);
            	Book book4 = new Book("The Great Gatsby", "Classic", 10.99f);
            	bookStorage.addMedia(book4);
            	Book book5 = new Book("The Catcher in the Rye", "Young Adult", 9.49f);
            	bookStorage.addMedia(book5);
            	Book book6 = new Book("Becoming", "Biography", 17.99f);
            	bookStorage.addMedia(book6);
            	Book book7 = new Book("The Alchemist", "Adventure", 15.75f);
            	bookStorage.addMedia(book7);
            	Book book8 = new Book("Harry Potter and the Sorcerer's Stone", 
            			"Fantasy", 22.50f);
            	bookStorage.addMedia(book8);
            	Book book9 = new Book("The Art of War", "Philosophy", 8.99f);
            	bookStorage.addMedia(book9);
                new AddBookToStoreScreen(store, bookStorage, cart);
                dispose();
            }
        });
		JMenuItem addCD = new JMenuItem("Add CD");
		smUpdateStore.add(addCD);
		addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Store cdStorage = new Store();
            	CompactDisc cd1 = new CompactDisc("The Greatest Hits", 
            			"Music", "John Smith", 60, 15.99f);
            	cdStorage.addMedia(cd1);
            	CompactDisc cd2 = new CompactDisc("Science of Sound", 
            			"Documentary", "Alice Johnson", 45, 12.49f);
            	cdStorage.addMedia(cd2);
            	CompactDisc cd3 = new CompactDisc("Action Packed", 
            			"Action", "Michael Bay", 120, 19.99f);
            	cdStorage.addMedia(cd3);
            	CompactDisc cd4 = new CompactDisc("Romance Forever", 
            			"Romance", "Emma Stone", 95, 14.50f);
            	cdStorage.addMedia(cd4);
            	CompactDisc cd5 = new CompactDisc("Laugh Out Loud", 
            			"Comedy", "Chris Rock", 80, 9.99f);
            	cdStorage.addMedia(cd5);
            	CompactDisc cd6 = new CompactDisc("The Wild Planet", 
            			"Nature", "David Attenborough", 50, 17.75f);
            	cdStorage.addMedia(cd6);
            	CompactDisc cd7 = new CompactDisc("Epic Adventures", 
            			"Fantasy", "Peter Jackson", 130, 22.49f);
            	cdStorage.addMedia(cd7);
            	CompactDisc cd8 = new CompactDisc("Cooking Masterclass", 
            			"Lifestyle", "Gordon Ramsay", 70, 13.25f);
            	cdStorage.addMedia(cd8);
            	CompactDisc cd9 = new CompactDisc("The History of Jazz", 
            			"Music", "Miles Davis", 75, 18.00f);
            	cdStorage.addMedia(cd9);
                new AddCompactDiscToStoreScreen(store, cdStorage, cart);
                dispose();
            }
        });
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVD);
		addDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Store dvdStorage = new Store();
            	DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avengers: Endgame", 
            			"Action", 24.99f);
            	dvdStorage.addMedia(dvd1);
            	DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", 
            			"Animation", 19.99f);
            	dvdStorage.addMedia(dvd2);
            	DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Social Network", 
            			"Drama", 14.99f);
            	dvdStorage.addMedia(dvd3);
            	DigitalVideoDisc dvd4 = new DigitalVideoDisc("Interstellar", 
            			"Science Fiction", 22.50f);
            	dvdStorage.addMedia(dvd4);
            	DigitalVideoDisc dvd5 = new DigitalVideoDisc("Parasite", 
            			"Thriller", 18.75f);
            	dvdStorage.addMedia(dvd5);
            	DigitalVideoDisc dvd6 = new DigitalVideoDisc("Frozen II", 
            			"Family", 16.99f);
            	dvdStorage.addMedia(dvd6);
            	DigitalVideoDisc dvd7 = new DigitalVideoDisc("Inception", 
            			"Mystery", 20.00f);
            	dvdStorage.addMedia(dvd7);
            	DigitalVideoDisc dvd8 = new DigitalVideoDisc("Bohemian Rhapsody", 
            			"Biography", 17.49f);
            	dvdStorage.addMedia(dvd8);
            	DigitalVideoDisc dvd9 = new DigitalVideoDisc("The Dark Knight", 
            			"Action", 23.00f);
            	dvdStorage.addMedia(dvd9);
                new AddDigitalVideoDiscToStoreScreen(store, dvdStorage, cart);
                dispose();
            }
        });
		
		menu.add(smUpdateStore);
		JMenuItem menuViewStore = new JMenuItem("View store");
		menuViewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store, cart);
                dispose();
            }
        });
		menu.add(menuViewStore);
		JMenuItem menuViewCart = new JMenuItem("View cart");
		menuViewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(store, cart);
                dispose();
            }
        });
		menu.add(menuViewCart);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton btnViewCart = new JButton("View cart");
		btnViewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(store, cart);
                dispose();
            }
        });
		btnViewCart.setPreferredSize(new Dimension(100, 50));
		btnViewCart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnViewCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
	    center.setLayout(new GridLayout(0, 3, 2, 2)); // Dynamic rows, 3 items per row, with spacing

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    for (Media media : mediaInStore) {
	        MediaStore cell = new MediaStore(media, cart);
	        center.add(cell);
	    }

	    JPanel contentPanel = new JPanel(new BorderLayout());
	    contentPanel.add(center, BorderLayout.NORTH);

	    JScrollPane scrollPane = new JScrollPane(contentPanel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	    JPanel container = new JPanel(new BorderLayout());
	    container.add(scrollPane, BorderLayout.CENTER);

	    return container;
	}
	
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
}
