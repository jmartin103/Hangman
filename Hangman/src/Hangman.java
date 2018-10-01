import java.util.*;

public class Hangman {

	/* An array of randomly drawn words. The user will have to guess one of 
	   these words to win. */
	private static String[] words = {"freedom", "acquaint", "friend", "ought", 
			"little", "remember", "kayak", "pontoon", "tornado", 
			"gazebo", "yacht", "segue", "brother", "country", "zombie", 
			"haiku", "light", "grave", "haphazard", "sunrise", "football", 
			"school", "random", "shallow", "beach", "hurricane", "attorney", 
			"vanilla", "hound", "senior", "beautiful", "politics", "diamond", 
			"power", "college", "student", "insurance", "nationwide", "peanut", 
			"critical", "program", "algorithm", "music", "image", "cousin", 
			"uncle", "aunt", "father", "mother", "grandparent", "guitar", 
			"graduate", "government", "federal", "president", "chemistry", 
			"hail", "university", "doctor", "lawyer", "camera", "picture", 
			"house", "movie", "record", "understand", "desperate", "forever", 
			"repeat", "quarter", "game", "logic", "theory", "hazard", "love", 
			"book", "magazine", "party", "recreation", "park", "hike", "always", 
			"grill", "chicken", "beef", "pork", "gasoline", "hotel", "highway", 
			"visual", "professor", "physics", "airport", "expose", "solution", 
			"problem", "mayor", "mozzarella", "blizzard", "jawbreaker"
	};
	
	public static void main(String[] args) {
		// Generate a random word from the above array
		String word = words[(int) (Math.random() * words.length)];
		Scanner sc = new Scanner(System.in); // Scanner to scan letter guessed
		
		int wordLen = word.length(); // The length of the word to be guessed
		System.out.println("I am thinking of a word that contains "
				+ "" + wordLen + " letters. Can you guess it?");
		char out[] = new char[wordLen]; // Char array with *'s
		
		// Initialize the number of incorrect and correct guesses
		int misses = 0, correctGuesses = 0;
		
		// Set output char array to '*' symbol for each unguessed letter
		for (int i = 0; i < wordLen; i++) {
			out[i] = '*';
		}
		
		/* Have user guess letters for the word generated. If the player 
		 * guesses correctly, increment the number of correct guesses. The
		 * game ends either when the player successfully guesses the word, or
		 * when the player has reached five misses. In the latter case, the 
		 * correct word is displayed on the screen. The player is shown how
		 * many misses they currently have before guessing each letter.
		 */
		while (correctGuesses < wordLen) {
			System.out.println("You currently have " + misses + " misses. "
					+ "If you reach 5 misses, you lose.");
			System.out.println(out); // Print out '*' array
			
			System.out.print("Guess a letter: "); // Prompt user for a letter
			char guessedLetter = sc.next().charAt(0); // Scan letter in scanner
			boolean guessed = false; // Initialize guessed to false
			
			/* Scan through the randomly generated word, and if the guessed 
			 * letter matches any character in the word, change the asterisk 
			 * in the out array to the guessed letter, according to its 
			 * position, and then set guessed value to true. 
			 */
			for (int i = 0; i < wordLen; i++) {
				// User guessed a correct letter
				if (guessedLetter == word.charAt(i) && out[i] == '*') {
					out[i] = word.charAt(i);
					guessed = true;
					correctGuesses++;
				}	
			}

			if (!guessed) { // Player guessed incorrectly, increment number of misses
				System.out.println("Sorry, wrong letter!");
				misses++;
			}
			
			// Player has reached five misses; display correct word and terminate
			if (misses == 5) {
				System.out.println("You lose! The word I was thinking of was"
						+ " \"" + word + "\"!");
				System.exit(0); // Terminate program
			}
			
			// Player has successfully guessed the word
			if (correctGuesses == wordLen) {
				System.out.println(out); // Print word
				System.out.println("Congrats! You win!");
				System.exit(0); // Terminate program
			}
		}
	}
}
