package tss;

/**
 * Template for tss.Performance. You must implement the constructor and methods
 * shown. You may add fields, constructors, and methods, but do not change
 * the signatures of those provided.
 */
public class Performance {

	private Artist _artist;
	private String _sstartTime;
	private int _startTime;			
	private int _endTime;
	private int _duration;

	// Constructor (Note that _startTime and _endTime refers to integer values.)

	public Performance(Artist artist, String startTime, int duration) {
		System.out.println("@Performance object created with artist " + artist + " at " + startTime + " with duration " + duration);
		_artist = artist;
		_sstartTime = startTime;
		_startTime = (Integer.valueOf(startTime.substring(11, 13)) * 60) + Integer.valueOf(startTime.substring(14));
		_endTime = (Integer.valueOf(startTime.substring(11, 13)) * 60) + Integer.valueOf(startTime.substring(14)) + duration;
		_duration = duration;
	}


	/**
	 * Return the artist for this performance.
	 * @return The {@link Artist} for this performance.
	 */

	// Method that returns the artist

	public Artist getArtist() {
		return _artist;
	}

	/**
	 * Determine whether this performance overlaps with the performance provided.
	 * Performance A overlaps with performance B if A's start time is before B's, but it
	 * finishes after B starts, or vice versa.
	 * @param existingPerformance The {@link Performance} to compare against.
	 * @return true if the two performances overlap otherwise false.
	 */
	public boolean overlaps(Performance existingPerformance) {
		if (_startTime <= existingPerformance.getStart() && (_endTime >= existingPerformance.getStart()))  {
			return true;
		}
		if 	(existingPerformance.getStart() <= _startTime && (existingPerformance.getEnd() >= _startTime)) {
			return true;
		}
		return false;
	}

	@Override

	// Method that a useful string representation of the performance

	public String toString() {
		return _sstartTime + " (" + _duration + ") " + _artist;
	}


	// Methods that returns the start and end times of the performance

	public int getStart() {
		return _startTime;
	}
	public int getEnd() {
		return _endTime;
	}
}
