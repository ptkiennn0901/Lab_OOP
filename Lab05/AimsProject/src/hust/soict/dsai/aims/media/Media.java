package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media implements Comparable<Media>{
	
	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbMedia = 0;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media(String title) {
		this.title = title;
		this.nbMedia++;
		this.id = nbMedia;
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.nbMedia++;
		this.id = nbMedia;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public boolean isMatch(int id) {
		if (this.getId() == id) {
			return true;
		}
		return false;
	}
	
	public boolean isMatch(String title) {
		if (this.getTitle().equals(title)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String str = this.getId() + "." + 
				 this.getTitle() + " - " + 
				 this.getCategory() + " - " + 
				 this.getCost();
		return str;
	}
	
	public boolean equals(Media otherItem) throws NullPointerException{
		if (otherItem!=null) {
			if (this.getTitle().toLowerCase().equals(otherItem.getTitle().toLowerCase())) {
				return true;
			}
		}else {
			throw new NullPointerException("ERROR: Comparing to null");
		}
		return false;
	}

	@Override
    public boolean equals(Object obj) throws ClassCastException{
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (obj instanceof Media) {
        	Media other = (Media) obj;
            return this.getTitle().toLowerCase().equals(other.getTitle().toLowerCase());
        }else {
        	throw new ClassCastException("ERROR: The given object is not of the type media");
        }
    }

	
	@Override
	public int compareTo(Media other) {
	    int titleComparison = this.getTitle().compareToIgnoreCase(other.getTitle());
	    if (titleComparison != 0) {
	        return titleComparison;
	    }
	    return Double.compare(other.getCost(), this.getCost());
	}
	
//	public int compareTo(Media other) {
//		int costComparison = Double.compare(other.getCost(), this.getCost());
//	    if (costComparison != 0) {
//	        return costComparison;
//	    }
//	    return  this.getTitle().compareToIgnoreCase(other.getTitle());
//	}
}
