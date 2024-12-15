package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}

	public List<String> getAuthors() {
		return authors;
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public void addAuthor(String authorName) {
		boolean added = false;
		for (String author: authors) {
			if (authorName == author) {
				added = true;
			}
		}
		if (added == false) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		boolean included = false;
		for (String author: authors) {
			if (authorName == author) {
				included = true;
			}
		}
		if (included) {
			authors.remove(authorName);
		}
	}
	
	@Override
	public String toString() {
		String str = this.getId() + "." + "Book" + " - " + 
				 this.getTitle() + " - " + 
				 this.getCategory() + " - " +
				 this.getAuthors() + ": " +
				 this.getCost();
		return str;
	}
	
}
