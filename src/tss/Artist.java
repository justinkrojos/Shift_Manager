package tss;

/**
 * Template for tss.Artist. You must implement the constructor and methods
 * shown. You may add fields, constructors, and methods, but do not change
 * the signatures of those provided.
 */
public class Artist {
	/**
	 * Create an artist object with the provide name.
	 * @param name The name of the artist.
	 */

	// _name is a string that stores the artist's name

	private String _name;

	// Constructor

	public Artist(String name) {											
		System.out.println("@Artist object created with name " + name);
		_name = name;
	}

	@Override

	// Returns name of the artist in type String

	public String toString() {
		return _name;
		// return null;
	}
	@Override

	// Returns true or false as to whether or not the input object equals the artists name

	public boolean equals(Object obj) {

		if (obj.equals(_name)) {
			return true;
		}
		else {
			return false;
		}

	}
}
