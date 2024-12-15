package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CartScreenController {
	
	private Cart cart;
	
	private Store store;
	
    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private RadioButton radioBtnFilterId;
    
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private Label lbtotalCost;

    @FXML
    private MenuItem menuViewStore;
    
    @FXML
    private MenuItem menuViewCart;
    
    @FXML
    private MenuItem menuAddBook;
    
    @FXML
    private MenuItem menuAddCD;
    
    @FXML
    private MenuItem menuAddDVD;
    
    public CartScreenController(Store store, Cart cart) {
    	super();
    	this.cart = cart;
    	this.store = store;
    }
    
    @FXML
    private void initialize() {
    	
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	btnPlay.setVisible(true);
    	btnRemove.setVisible(true);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>(){
    				
    			@Override
    			public void changed(ObservableValue<? extends Media> observable, Media oldValue,
    					Media newValue) {
    				if (newValue!=null) {
    					updateButtonBar(newValue);
    				}
    				updateTotalCost();
    			}
    			});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override 
    		public void changed(ObservableValue<? extends String> observable, String oldValue,
    				String newValue) {
    			showFilteredMedia(newValue);
    		}
    	});
    	
    	if (cart.getItemsOrdered().size()==0) {
    		lbtotalCost.setText("0 $");
    	}else {
    		updateTotalCost();
    	}
    	
    }
    
    void showFilteredMedia(String newValue) {
    	FilteredList<Media> filteredMedia = new FilteredList<>(cart.getItemsOrdered(), m -> true);
		if (radioBtnFilterTitle.isSelected()) {
			filteredMedia.setPredicate(media -> {
			    if (tfFilter.getText() == null || tfFilter.getText().isEmpty()) {
			        return true; 
			    }
			    String filterText = tfFilter.getText().toLowerCase();
			    return media.getTitle().toLowerCase().contains(filterText);
			});
			tblMedia.setItems(filteredMedia);
		}else {
			filteredMedia.setPredicate(media -> {
			    if (tfFilter.getText() == null || tfFilter.getText().isEmpty()) {
			        return true; 
			    }
			    String filterText = tfFilter.getText().toLowerCase();
			    int intText = Integer.parseInt(filterText);
			    return media.getId() == intText;
			});
			tblMedia.setItems(filteredMedia);
		}
	}

	void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}else {
    		btnPlay.setVisible(false);
    	}
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateTotalCost();
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	this.cart.empty();
    	System.out.println("An order is created!");
    	placeOrderDialog();
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	updateTotalCost();
    }
    
    void placeOrderDialog() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);

        VBox vbox = new VBox(new Text("An order is created!"), new Button("Ok."));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        Button okButton = (Button) vbox.getChildren().get(1); 

        okButton.setOnAction(event -> {
            dialogStage.close(); 
        });

        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	try {
			playDialog(media);
		} catch (PlayerException e) {
			Stage dialogStage = new Stage();
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        
	        VBox vbox = new VBox(new Text(e.getMessage()), new Button("Ok."));
	        vbox.setAlignment(Pos.CENTER);
	        vbox.setPadding(new Insets(15));

	        Button okButton = (Button) vbox.getChildren().get(1); 

	        okButton.setOnAction(event1 -> {
	            dialogStage.close(); 
	        });

	        dialogStage.setScene(new Scene(vbox));
	        dialogStage.show();
		}
    }
    
    void playDialog (Media media) throws PlayerException{
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        
        String playText = "";
        if (media instanceof DigitalVideoDisc) {
        	DigitalVideoDisc dvd = (DigitalVideoDisc) media;
        	if (dvd.getLength() > 0) {
        		playText = "Playing DVD: " + dvd.getTitle() + "\nDVD length: " + dvd.getLength();
        	}else {
        		throw new PlayerException("ERROR: DVD length is non-positive");
        	}
        }else {
        	CompactDisc cd = (CompactDisc) media;
        	if (cd.getLength() > 0) {
        		for (Track track: cd.getTracks()) {
        			if (track.getLength() > 0) {
        				playText += "\nPlaying Track: " + track.getTitle() + 
        						"\nTrack length: " + track.getLength();
        			}else {
        				throw new PlayerException("ERROR: Track length is non-positive");
        			}
        		}
        	}else {
        		throw new PlayerException("ERROR: CD length is non-positive");
        	}
        }
        VBox vbox = new VBox(new Text(playText), new Button("Ok."));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        Button okButton = (Button) vbox.getChildren().get(1); 

        okButton.setOnAction(event -> {
            dialogStage.close(); 
        });

        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }
    
    void updateTotalCost() {
    	float totalFloat = cart.totalCost();
    	String totalString = String.format("%.2f", totalFloat) + " $";
    	lbtotalCost.setText(totalString);
    }
    
    @FXML
    void addBook(ActionEvent event) {
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
    	
//    	Stage stage = (Stage) btnPlaceOrder.getScene().getWindow();
//        stage.close();
        
        new AddBookToStoreScreen(store, bookStorage, cart);
    }

    @FXML
    void addCD(ActionEvent event) {
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
    	
//    	Stage stage = (Stage) btnPlaceOrder.getScene().getWindow();
//        stage.close();
        
        new AddCompactDiscToStoreScreen(store, cdStorage, cart);
    }

    @FXML
    void addDVD(ActionEvent event) {
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
    	
//    	Stage stage = (Stage) btnPlaceOrder.getScene().getWindow();
//        stage.close();
        
        new AddDigitalVideoDiscToStoreScreen(store, dvdStorage, cart);
    }

    @FXML
    void viewStore(ActionEvent event) {
//    	Stage stage = (Stage) btnPlaceOrder.getScene().getWindow();
//        stage.close();
        
    	new StoreScreen(store, cart);
    }

    @FXML
    void viewCart(ActionEvent event) {
//    	Stage stage = (Stage) btnPlaceOrder.getScene().getWindow();
//        stage.close();
        
    	new CartScreen(store, cart);
    }
    
}
