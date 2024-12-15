package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	
	@Override
	public int compare(Media item1, Media item2) {
        int titleComparison = item1.getTitle().compareToIgnoreCase(item2.getTitle());
        if (titleComparison == 0) {
            return Double.compare(item2.getCost(), item1.getCost());
        }
        
        return titleComparison;
    }
}
