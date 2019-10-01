package tss;

public class Time {

	private int _startTime;
	private int _endTime;
	private int _day;
	private int _year;
	private int _duration;

	// Constructor for Time - note that _startTime and _endTime 

	public Time(String startTime, int duration) {
		System.out.println("@Time object created with startTime " + startTime + " with " + duration);
		_startTime = (Integer.valueOf(startTime.substring(11, 13)) * 60) + Integer.valueOf(startTime.substring(14));
		_endTime = (Integer.valueOf(startTime.substring(11, 13)) * 60) + Integer.valueOf(startTime.substring(14)) + duration;
		_duration = duration;
		_year = Integer.valueOf(startTime.substring(0, 4));
		_day = Integer.valueOf(startTime.substring(5, 7))*12 + Integer.valueOf(startTime.substring(8, 10));
	}

	// Returns the start time in minutes

	public Time(String startTime) {
		_startTime = (Integer.valueOf(startTime.substring(11, 13)) * 60) + Integer.valueOf(startTime.substring(14));
	}

	// Checks if the dates of the performance is the same as an existing performance

	public boolean checkDate(Time performanceDate) {

		if ((_day == performanceDate.getDay()) && (_year == performanceDate.getYear())) {
			return true;
		}
		else {
			return false;
		}

	}


	// Returns the duration of the performance in minutes

	public int getDuration() {
		return _duration;
	}

	// Returns the start times, end times, day and year of the performance

	public int getStart() {
		return _startTime;
	}

	public int getEnd() {
		return _endTime;
	}

	public int getDay() {
		return _day;
	}

	public int getYear() {
		return _year;
	}

	// Checks whether or not the starting time is between 00:00 and 24:00

	public boolean checkStart() {
		if ((_startTime >= 0) || (_startTime <= 24*60)) {
			return true;
		}
		else {
			return false;
		}
	}

	// Checks whether or not the ending time ends before 24:00

	public boolean checkEnd() {
		if (_endTime < 24*60) {
			return true;
		}
		else {
			return false;
		}
	}



}
