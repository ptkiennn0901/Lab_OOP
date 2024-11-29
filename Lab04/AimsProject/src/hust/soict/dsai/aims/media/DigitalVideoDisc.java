package hust.soict.dsai.aims.media;


public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	@Override
	public String toString() {
		String str = this.getId() + "." + "DVD" + " - " + 
				 this.getTitle() + " - " + 
				 this.getCategory() + " - " + 
				 this.getDirector() + " - " +
				 this.getLength() + ": " + 
				 this.getCost();
		return str;
	}
	
	public boolean isMatch(String title) {
		if (this.getTitle().equals(title)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isMatch(int id) {
		if (this.getId() == id) {
			return true;
		}else {
			return false;
		}
	}
	
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("This DVD cannot be played");
		}else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
	}
	
	@Override
    public int compareTo(Media other) {
        if (other instanceof DigitalVideoDisc) {
        	DigitalVideoDisc otherDVD = (DigitalVideoDisc) other;
            int titleComparison = this.getTitle().compareToIgnoreCase(otherDVD.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return Double.compare(otherDVD.getCost(), this.getCost());
        }
        return super.compareTo(other);
    }
}
