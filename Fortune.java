import java.util.*;
import java.util.Random;

class Fortune  {
	
	// Random constructor
	public static Random rand = new Random();
	
	// Phrases
	public static String [][] phrases = {
			{"eat a squirrel", "do the stinky laundry"}, // 0
			{"see a rainbow!", "swim with highly intelligent but evil dolphins"}, // 1
			{"be a victim of a wave of hermit crabs that scowl, then siddle in for a vicious nibble.", "have a can of lemon Spindrift fall into the wrong hands ruining everything."},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
	};
	
	// Copy messages
	public static String [] messages = {
			"have someone close betray them tonight",
			"DEATH",
			"have failed all classes",
			"see a happy butterfly",
			"have a fantastic day"
			
	};

	// Convert to integer
	public static int convertToInt (char letter){
		int a = letter;
		return a - 97;
	}
	
	
	// Check for repeats
	public static int counter(char letter, String name) {
			
		// Count how many occurrences of letter
		int count = 0;
		for (int i=0; i < name.length(); i++){
			
			if (letter == name.charAt(i)){
				count++;			
			}
		}
		
		return count;
	}

	
	
	
	public static void main(String[] args)  
	{
		// Get  name
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter your name: ");
		String input = sc.nextLine();  
		String name = input.toLowerCase();
		System.out.print("Hello: "+ input +"\n");
		System.out.println("I am your humble Fortune Teller, I will peer into the heavens with my awesome power and predict your various fortunes!\n");

		
		// Iterate through letters
		for (int i=0; i < name.length(); i++){
			
			// Get the letter
			char letter = name.charAt(i);
			String phrase;
			
			// Check if more than one of the same letter
			int count = counter(letter, name);
			if (count > 1) {
				System.out.println("Sorry you have more than one of the same letter");
				int randIndex = rand.nextInt(messages.length);
				phrase = messages[randIndex];
			}
			
			// Otherwise do this
			else {
				// Convert letter into number
				int num = convertToInt(letter); // number 1-26
				
				// Get possible phrases (index with 'num')
				String[] possible_phrases = phrases[num];
				
				// Two phrases per letter
				phrase = (name.length() % 2 == 0 ? possible_phrases[0] : possible_phrases[1]);
				
				
			}
			
			// Time frame: Get quantity of given unit
			String[] units = {"hour(s)", "day(s)", "minute(s)", "millisecond(s)", "month(s)", "year(s)"};
			int quantity = rand.nextInt(10) + 1;
			int unitIndex = rand.nextInt(units.length);
			String unit = units[unitIndex];
			

			// Print out final statement
			System.out.println("In " + quantity + " " + unit + ", " + input + " will " + phrase);
			
		}
	}
}  
  