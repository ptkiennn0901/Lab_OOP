package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "Geogre Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", "Unknown", 90, 12.5f);
		store.addMedia(dvd3);
		
		List<String> authors1 = new ArrayList<String>();
		authors1.add("A");
		authors1.add("B");
		Book book1 = new Book("Math", "Research", 12.5f, authors1);
		store.addMedia(book1);
		
		List<String> authors2 = new ArrayList<String>();
		authors2.add("C");
		authors2.add("D");
		Book book2 = new Book("Romeo and Juliet", "Romantic", 20.5f, authors2);
		store.addMedia(book2);
		
		List<String> authors3 = new ArrayList<String>();
		authors3.add("A");
		authors3.add("B");
		Book book3 = new Book("Machine learning", "Education", 17.75f, authors3);
		store.addMedia(book3);
		
		List<Track> tracks1 = new ArrayList<Track>();
		Track track1 = new Track("Chapter 1", 30);
		tracks1.add(track1);
		Track track2 = new Track("Chapter 2", 30);
		tracks1.add(track2);
		Track track3 = new Track("Chapter 3", 30);
		tracks1.add(track3);
		CompactDisc cd1 = new CompactDisc("Aladin", "Animation", 
				"Unknown", 90, 18.5f, "D", tracks1);
		store.addMedia(cd1);
		
		List<Track> tracks2 = new ArrayList<Track>();
		Track track4 = new Track("Part 1", 30);
		tracks2.add(track4);
		Track track5 = new Track("Part 2", 30);
		tracks2.add(track5);
		Track track6 = new Track("Part 3", 30);
		tracks2.add(track6);
		CompactDisc cd2 = new CompactDisc("Star Wars", 
				"Science Fiction", "Geogre Lucas", 90, 18.5f, "D", tracks2);
		store.addMedia(cd2);
		
		List<Track> tracks3 = new ArrayList<Track>();
		Track track7 = new Track("Session 1", 30);
		tracks3.add(track7);
		Track track8 = new Track("Session 2", 30);
		tracks3.add(track8);
		Track track9 = new Track("Session 3", 27);
		tracks3.add(track9);
		CompactDisc cd3 = new CompactDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f, "D", tracks3);
		store.addMedia(cd3);
		
		Cart cart = new Cart();
		
		//GUI
		new StoreScreen(store, cart);
				
		//UI
		int status = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			if (status == 0) {
				showMenu();
				try {
					choice = sc.nextInt();
					if (choice == 1) {
						status = 1;
					}else if (choice == 2) {
						updateStoreMenu();
						try {
							choice = sc.nextInt();
							sc.nextLine();
							if (choice == 1) {
								selectTypeMenu();
								try {
									choice = sc.nextInt();
									sc.nextLine();
									if (choice == 1) {
										System.out.print("Enter DVD's title: ");
										String title = sc.nextLine().trim();
										System.out.println();
										System.out.print("Enter DVD's category: ");
										String category = sc.nextLine().trim();
										System.out.println();
										System.out.print("Enter DVD's director: ");
										String director = sc.nextLine().trim();
										System.out.println();
										System.out.print("Enter DVD's length: ");
										int length = sc.nextInt();
										sc.nextLine();
										System.out.print("Enter DVD's cost: ");
										float cost = sc.nextFloat();
										sc.nextLine();
										DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
										store.addMedia(dvd);
									}else if (choice == 2) {
										System.out.print("Enter book's title: ");
										String title = sc.nextLine().trim();
										System.out.println();
										System.out.print("Enter book's category: ");
										String category = sc.nextLine().trim();
										System.out.println();
										System.out.print("Enter book's cost: ");
										float cost = sc.nextFloat();
										sc.nextLine();
										Book book = new Book(title, category, cost);
										store.addMedia(book);
									}else if (choice == 3) {
										System.out.print("Enter CD's title: ");
										String title = sc.nextLine().trim();
										System.out.println();
										System.out.print("Enter CD's category: ");
										String category = sc.nextLine().trim();
										System.out.println();
										System.out.print("Enter CD's director: ");
										String director = sc.nextLine().trim();
										System.out.println();
										System.out.print("Enter CD's length: ");
										int length = sc.nextInt();
										sc.nextLine();
										System.out.print("Enter CD's cost: ");
										float cost = sc.nextFloat();
										sc.nextLine();
										CompactDisc cd = new CompactDisc(title, category, director, length, cost);
										store.addMedia(cd);
									}else if (choice == 0) {
										status = 0;
									}else {
										System.out.println("Wrong input! Please choose a number: 0-1-2-3");
									}
								} catch (java.util.InputMismatchException e) {
					                System.out.println("Invalid input! Please enter a valid integer.");
					                sc.nextLine();
					            }
							}else if (choice == 2){
								selectTypeMenu();
								try{
									choice = sc.nextInt();
									sc.nextLine();
									if (choice == 1) {
										System.out.print("Enter media's title: ");
										String title = sc.nextLine().trim();
										DigitalVideoDisc item = new DigitalVideoDisc(title);
										store.removeMedia(item);
									}else if (choice == 2) {
										System.out.print("Enter media's title: ");
										String title = sc.nextLine().trim();
										Book item = new Book(title);
										store.removeMedia(item);
									}else if (choice == 3) {
										System.out.print("Enter media's title: ");
										String title = sc.nextLine().trim();
										CompactDisc item = new CompactDisc(title);
										store.removeMedia(item);
									}else if (choice == 0){
										status = 0;
									}else {
										System.out.println("Wrong input! Please choose a number: 0-1-2-3");
									}
								}catch (java.util.InputMismatchException e) {
					                System.out.println("Invalid input! Please enter a valid integer.");
					                sc.nextLine();
					            }
							}else if (choice == 0) {
								status = 0;
							}else {
								System.out.println("Wrong input! Please choose a number: 0-1-2");
							}
						}catch (java.util.InputMismatchException e) {
			                System.out.println("Invalid input! Please enter a valid integer.");
			                sc.nextLine();
			            }
					}else if (choice == 3) {
						status = 2;
					}else if (choice == 0){
						System.out.println("Thanks for using our app. See you soon!");
						break;
					}else {
						System.out.println("Wrong input! Please choose a number: 0-1-2-3");
					}
				}catch (java.util.InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a valid integer.");
	                sc.nextLine();
	            }
			}
				
			if (status == 1) {
				store.print();
				storeMenu();
				try {
					choice = sc.nextInt();
					sc.nextLine();
					if (choice == 1) {
						System.out.println("Enter item's title: ");
						String title = sc.nextLine().trim();
						System.out.println(title);
						Media item = store.search(title);
						System.out.println(item);
						if (item != null) {
							mediaDetailsMenu();
							choice = sc.nextInt();
							sc.nextLine();
							if (choice == 1) {
								try {
									cart.addMedia(item);
								} catch (LimitExceededException e) {
									System.out.println(e.getMessage());
								}
							}else if (choice == 2) {
								if ((item instanceof DigitalVideoDisc)) {
									DigitalVideoDisc thisItem = (DigitalVideoDisc) item;
									try {
										thisItem.play();
									} catch (PlayerException e) {
										System.out.println(e.getMessage());
									}
								}else if ((item instanceof CompactDisc)) {
									CompactDisc thisItem = (CompactDisc) item;
									try {
										thisItem.play();
									} catch (PlayerException e) {
										System.out.println(e.getMessage());
									}
								}else {
									System.out.println("Only CD and DVD can be played");
								}
							}else if (choice == 0) {
								status = 1;
							}else {
								System.out.println("Wrong input! Please choose a number: 0-1-2");
							}
						}else {
							System.out.println("This product is currently not available"
									+ " in our store. Please find another one.");
						}
					}else if (choice == 2) {
						System.out.println("Enter item's title: ");
						String title = sc.nextLine();
						Media item = store.search(title);
						if (item != null) {
							try {
								cart.addMedia(item);
							} catch (LimitExceededException e) {
								System.out.println(e.getMessage());
							}
							System.out.println(cart.getNumberOfMedia());
						}else {
							System.out.println("This product is currently not available"
									+ " in our store. Please find another one.");
						}
					}else if (choice == 3) {
						System.out.println("Enter item's title: ");
						String title = sc.nextLine().trim();
						Media item = store.search(title);
						if (item != null) {
							if ((item instanceof DigitalVideoDisc)) {
								DigitalVideoDisc thisItem = (DigitalVideoDisc) item;
								try {
									thisItem.play();
								} catch (PlayerException e) {
									System.out.println(e.getMessage());
								}
							}else if ((item instanceof CompactDisc)) {
								CompactDisc thisItem = (CompactDisc) item;
								try {
									thisItem.play();
								} catch (PlayerException e) {
									System.out.println(e.getMessage());
								}
							}else {
								System.out.println("Only CD and DVD can be played");
							}
						}else {
							System.out.println("This product is currently not available"
									+ " in our store. Please find another one.");
						}
					}else if (choice == 4){
						cart.print();
					}else if (choice == 0) {
						status = 0;
					}else {
						System.out.println("Wrong input! Please choose a number: 0-1-2-3-4");
					}
				} catch (java.util.InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a valid integer.");
	                sc.nextLine();
	            }
			}
			
			if (status == 2) {
				cart.print();
				cartMenu();
				try {
					choice = sc.nextInt();
					sc.nextLine();
					if (choice == 1) {
						filterMenu();
						try {
							choice = sc.nextInt();
							sc.nextLine();
							if (choice == 1) {
								System.out.println("Enter item's id: ");
								int id = sc.nextInt();
								sc.nextLine();
								cart.search(id);
							}else if (choice == 2) {
								System.out.println("Enter item's title: ");
								String title = sc.nextLine();
								cart.search(title);
							}else if (choice == 0) {
								status = 2;
							}else {
								System.out.println("Wrong input! Please choose a number: 0-1-2");
							}
						}catch (java.util.InputMismatchException e) {
			                System.out.println("Invalid input! Please enter a valid integer.");
			                sc.nextLine();
			            }
					}else if (choice == 2) {
						sortMenu();
						try {
							choice = sc.nextInt();
							if (choice == 1) {
								cart.sortByCostTitle();
								System.out.println("Cart sorted successfully !");
							}else if (choice == 2) {
								cart.sortByTitleCost();
								System.out.println("Cart sorted successfully !");
							}else if (choice == 0) {
								status = 2;
							}else {
								System.out.println("Wrong input! Please choose a number: 0-1-2");
							}
						}catch (java.util.InputMismatchException e) {
			                System.out.println("Invalid input! Please enter a valid integer.");
			                sc.nextLine();
			            }
					}else if (choice == 3) {
						selectTypeMenu();
						try {
							choice = sc.nextInt();
							sc.nextLine();
							if (choice == 1) {
								System.out.print("Enter media's title: ");
								String title = sc.nextLine().trim();
								DigitalVideoDisc item = new DigitalVideoDisc(title);
								cart.removeMedia(item);
							}else if (choice == 2) {
								System.out.print("Enter media's title: ");
								String title = sc.nextLine().trim();
								Book item = new Book(title);
								cart.removeMedia(item);
							}else if (choice == 3) {
								System.out.print("Enter media's title: ");
								String title = sc.nextLine().trim();
								CompactDisc item = new CompactDisc(title);
								cart.removeMedia(item);
							}else if (choice == 0){
								status = 0;
							}else {
								System.out.println("Wrong input! Please choose a number: 0-1-2-3");
							}
						}catch (java.util.InputMismatchException e) {
			                System.out.println("Invalid input! Please enter a valid integer.");
			                sc.nextLine();
			            }
					}else if (choice == 4){
						System.out.println("Enter item's title: ");
						String title = sc.nextLine().trim();
						Media item = store.search(title);
						if (item != null) {
							if ((item instanceof DigitalVideoDisc)) {
								DigitalVideoDisc thisItem = (DigitalVideoDisc) item;
								try {
									thisItem.play();
								} catch (PlayerException e) {
									System.out.println(e.getMessage());
								}
							}else if ((item instanceof CompactDisc)) {
								CompactDisc thisItem = (CompactDisc) item;
								try {
									thisItem.play();
								} catch (PlayerException e) {
									System.out.println(e.getMessage());
								}
							}else {
								System.out.println("Only CD and DVD can be played");
							}
						}else {
							System.out.println("This product is currently not available"
									+ " in your cart. Please find another one.");
						}
					}else if (choice == 5) {
						cart.empty();
						System.out.println("An order is created!");
					}else if (choice == 0) {
						status = 0;
					}else {
						System.out.println("Wrong input! Please choose a number: 0-1-2-3-4-5");
					}
				}catch (java.util.InputMismatchException e) {
	                System.out.println("Invalid input! Please enter a valid integer.");
	                sc.nextLine();
	            }
			}
		}
			
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void updateStoreMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a Media");
		System.out.println("2. Remove a Media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void filterMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void sortMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by cost");
		System.out.println("2. Sort by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void selectTypeMenu() {
		System.out.println("Choose one of the following media: ");
		System.out.println("--------------------------------");
		System.out.println("1. DVD");
		System.out.println("2. Book");
		System.out.println("3. CD");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
}

