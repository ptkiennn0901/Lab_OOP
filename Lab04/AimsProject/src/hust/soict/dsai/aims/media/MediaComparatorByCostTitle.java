package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	
	@Override
	public int compare(Media item1, Media item2) {
        int costComparison = Double.compare(item2.getCost(), item1.getCost());
        if (costComparison == 0) {
            return item1.getTitle().compareToIgnoreCase(item2.getTitle());
        }
        return costComparison;
    }
}
