package tss;

import java.util.ArrayList;

public class Theatre {

	// ArrayList of unlimited size to store registered artists

	private ArrayList<Artist> _artist = new ArrayList<Artist>();							

	// ArrayList of unlimited size to store scheduled performances

	private ArrayList<Performance> _performance = new ArrayList<Performance>();														

	// ArrayList of unlimited size to store times of scheduled performances

	private ArrayList<Time> _time = new ArrayList<Time>();

	// overlap contains a Performance object 

	private Performance overlap;

	// Constructor for theatre - with no initialised arrays since ArrayLists were used

	public Theatre() {																	
	}


	// Adds artist to _artist ArrayList

	public void addArtist (Artist name) {													
		_artist.add(name);			
	}


	// Checks if artist has been registered

	public boolean checkArtist (Artist artist) {												
		for (int i = 0; i < _artist.size(); i++) {

			if (artist.equals(_artist.get(i))) {
				return true;
			}

		}
		return false;
	}

	// Check if the performance overlaps with existing performanes

	public int checkPerformance (Performance performanceOne, Time specificTime) {							

		for (int i = 0; i < _performance.size(); i++) {
			if ((performanceOne.overlaps(_performance.get(i))) && (specificTime.checkDate(_time.get(i)))) {
				overlap = _performance.get(i);
				return i;
			}
		}
		return -1;
	}

	// If there is an overlap, method getOverlap will return the existing performance that it overlaps with

	public Performance getOverlap() {
		return overlap;
	}

	// Adds performance (and time) to their corresponding ArrayLists

	public void addPerformance (Performance performance, Time time) {					
		_performance.add(performance);
		_time.add(time);
	}

	// Displays registered artists and scheduled performances

	public void display() {																	
		System.out.println("Theatre: The Powerstation");
		System.out.println("**REGISTERED ARTISTS**");
		if (_artist.size() > 0) {
			for (int i = 0; i < _artist.size(); i++) {
				System.out.println(_artist.get(i).toString());
			}
		}
		else {

			System.out.println("No artists have been registered.");
		}
		System.out.println("**SCHEDULED PERFORMANCES**");
		if (_performance.size() > 0) {
			for (int i = 0; i < _performance.size(); i++) {
				System.out.println(_performance.get(i).toString());
			}
			System.out.println("----------------------------------------------------\n");
		}
		else {

			System.out.println("No performances have been scheduled.");
			System.out.println("----------------------------------------------------\n");
		}

	}

}
