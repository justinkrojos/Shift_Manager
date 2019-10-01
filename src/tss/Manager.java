package tss;

public class Manager {


	// TEST_REGISTER contains a string array of artists to register.

	private static String[] TEST_REGISTER = {
			"The Jesus And Mary Chain",  "Milk and Honey Festival",  "Halestorm",
			"Me First And The Gimme Gimmes"
	};

	// TEST_SCHEDULE contains a 2D string array containing performances to schedule.

	private static String[][] TEST_SCHEDULE = {
			{ "The Jesus And Mary Chain", "2019-03-15T20:30", "150" },  // Schedules successfully (1)
			{ "Milk and Honey Festival", "2018-03-08T19:00", "180" },  // Schedules successfully	
			{ "Me First And The Gimme Gimmes", "2019-03-01T21:00", "180" },  // Ends on midnight
			{ "Me First And The Gimme Gimmes", "2019-03-02T21:00", "200" },  // Ends after midnight
			{ "Jay Rock",  "2019-03-23T21:30", "100" },  // Artist not registered
			{ "Halestorm", "2019-03-15T16:30", "240" },  // Ends on start of 1 (overlap)
			{ "Halestorm", "2019-03-15T21:30", "30" },  // Starts during 1 (overlap)
			{ "Halestorm", "2019-03-15T20:00", "59" },  // Ends during 1 (overlap)
	};

	public static void main (String[] args) {

		// Create Theatre object

		Theatre theatre = new Theatre(); 
		theatre.display();

		// Input test strings of artists and adds artist to the list of registered artists

		for (int i = 0; i < TEST_REGISTER.length; i++) {

			String name = TEST_REGISTER[i];											
			Artist artist = new Artist(name); 								
			theatre.addArtist(artist);			
			System.out.println("The artist " + name + " was successfully registered.");
			theatre.display();


		}

		// Input test strings of performances and schedules performance if it is valid

		int count = 0;
		for (int i = 0; i < TEST_SCHEDULE.length; i++) {

			if (count == 0) {

				// Checks if Artist was previously registered

				String name = TEST_SCHEDULE[i][0];
				Artist artist = new Artist(name);

				if (theatre.checkArtist(artist)) {
					count++;
				}
				else {
					System.out.println("The artist " + "'" + name + "'" + " is not registered.");
				}

				if (count == 1) {

					// Checks if the starting time of the performance is valid (between 00:00 and 24:00)

					String time = TEST_SCHEDULE[i][1];
					Time startTime = new Time(time);

					if (startTime.checkStart()) {
						count++;
					}

					else {
						System.out.println("The performance does not have a starting time between 00:00 and 24:00.");
					}

					if (count == 2) {

						// Checks if the performance finishes before 24:00 or overlaps with another performance, 
						// and schedule performance if all checks were valid

						int duration = Integer.parseInt(TEST_SCHEDULE[i][2], 10);

						Time specificTime = new Time(time, duration);					
						Performance performance = new Performance(artist, time, duration);

						if (specificTime.checkEnd()) {

							if (theatre.checkPerformance(performance, specificTime) == -1) {

								theatre.addPerformance(performance, specificTime);
								count++;
								System.out.println("Performance successfully scheduled.");

							}

							else {
								System.out.println("'" + performance.getArtist() + "' is registered but overlaps with " + theatre.getOverlap() + ".");
							}

						}

						else {
							System.out.println("The desired performance time cannot end at or after midnight.");
						}
					}
				}
			}

			// Displays registered artists and scheduled performances

			theatre.display();
			count = 0;
		}
	}
}
