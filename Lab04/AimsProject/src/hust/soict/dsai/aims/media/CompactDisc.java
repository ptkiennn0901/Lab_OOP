package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

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
	
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("This CD cannot be played.");
		}else {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			for (Track track: tracks) {
				track.play();
			}
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
