package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public boolean equals(Track newTrack) {
		if ((newTrack.getLength() == this.getLength()) && (newTrack.getTitle()==this.getTitle())) {
			return true;
		}
		return false;
	}
	
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}
}
