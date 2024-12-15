package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist, List<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public CompactDisc(String title) {
		super(title);
	}
	
	public List<Track> getTracks(){
		return tracks;
	}
	
	public void addTrack(Track newTrack) {
		boolean included = false;
		for (Track track: tracks) {
			if (track.equals(newTrack)) {
				included = true;
			}
		}
		if (included == false) {
			tracks.add(newTrack);
		}
	}
	
	public void removeTrack(Track newTrack) {
		for (Track track: tracks) {
			if (track.equals(newTrack)) {
				tracks.remove(track);
			}
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for (Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				}catch(PlayerException e) {
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	
	@Override
	public String toString() {
		String str = this.getId() + "." + "CD" + " - " + 
				 this.getTitle() + " - " + 
				 this.getCategory() + " - " + 
				 this.getDirector() + " - " +
				 this.getArtist() + " - " +
				 this.getLength() + ": " + 
				 this.getCost();
		return str;
	}
}
