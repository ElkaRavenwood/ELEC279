/**
 * Code based from Assignment 1
*/
package Assignment1;

// import statements
import java.lang.String;
import java.util.Scanner;
import java.util.Random;
import Assignment2.*;


/**
 * ELEC 279 - Assignment 2
 * Student Number: 20113217
 * Date: March 12, 2020
 * Contents: A class called GuessMaster that runs a guessing game
 * of a noun and its birthday.
 * Editted for assignment 2.
 * @author  Jamie Won
 */
public class GuessMaster {

	// class variables
	private int numberOfCandidateEntities;
	private Entity[] entities;

	// constructor
	public GuessMaster (Entity[] entities) {
		// checks if values given exist
		if (entities == null) {
			System.out.println("Invalid Entities. Fatal Error");
			System.exit(1);
		}
		// sets parameters to class variables
		this.entities = entities.clone();
		this.numberOfCandidateEntities = entities.length;
		System.out.println("Welcome. Let us play GuessMaster.");
		
	}

	public GuessMaster () {
		this.numberOfCandidateEntities = 0;
		this.entities = new Entity[0];
		System.out.println("Welcome. Let us play GuessMaster.");
	}

	/**
	 * Adds a country to the entity list
	 * @param country the country to be added
	 */
	public void addEntity (Entity entity) {
		
		// checks if parameter exists
		if (entity == null) {
			System.out.println("Invalid Entity. Fatal Error");
			System.exit(0);
		}
		// if empty list
		if (this.entities == null) {
			this.entities = new Entity [++this.numberOfCandidateEntities];
			this.entities[0] = entity;
		// copies over old entities if not empty
		} else {
			Entity[] temp = new Entity[++this.numberOfCandidateEntities];
			for (int i = 0; i < this.entities.length; i ++) {
				temp[i] = this.entities[i];
			}
			// adds enw entity
			// finds type of entity
			String entityType = entity.entityType();
			Entity e;
			if (entityType == "country") {
				e = (Country) entity;
			} else if (entityType == "singer") {
				e = (Singer) entity;
			} else if (entityType == "politician") {
				e = (Politician) entity;
			} else {
				e = (Person) entity;
			}
			System.out.println(e.toString());
			temp[this.numberOfCandidateEntities -1] = e;
			// sets new list
			this.entities = temp;
		}
	}

	// start of playGame
	public void playGame (Entity entity) {
		// checks if entity exists
		if (entity == null) {
			System.out.println("Invalid entity. Fatal Error");
			System.exit(0);
		}

		// makes keyboard Scanner
		Scanner s = new Scanner(System.in);

		// makes variable to keep looping
		// boolean gameOver = false;

		// introduces game, asks for guess
		System.out.println("Please guess the birthday of " + entity.getName() + ". Please enter the date in the format of mm/dd/yyyy");
		
		// infinite loop
		while (true){
			// compares result
			String in = s.nextLine();
			
			// if user inputs quit, exits
			if (in.equalsIgnoreCase("quit")) {
				// closes Scanner
				s.close();
				// outputs message, exits
				System.out.println("Quitting...");
				System.exit(0);
			}

			// Converts to date
			Date result = new Date(in);

			// compares
			// if equal
			if (entity.getBorn().equals(result)) {
				// win statement
				System.out.println("BINGO! You got it!");
				// starts next game
				this.playGame(genRandomEntity());
				// closes Scanner
				s.close();
				// exits loop
				return;
				
			// if precedes
			} else if (entity.getBorn().precedes(result)) {
				System.out.println("Incorrect, try an earlier date.");
			// if not precedes
			} else {
				System.out.println("Incorrect, try a later date.");
			}
		}
	}

	// start of playGame - just calls the previous
	public void playGame (int entityInd) {
		// checks if any entities
		if (this.numberOfCandidateEntities == 0) {
			System.out.println("No entities");
		}
		// checks if invalid index (larger than amount of entries
		if (entityInd >= this.numberOfCandidateEntities) {
			System.out.println("Invalid Entity Index. Choosing from available....");
			this.playGame(genRandomEntity());
		}
		// calls other list
		this.playGame(this.entities[entityInd]);
	}

	// start of playGame - no parameters
	// uses genRandomEntity and the first playGame to run 
	public void playGame () {
		// randomly starts the game
		this.playGame(genRandomEntity());
	}

	// start of genRandomEntity
	public Entity genRandomEntity () {
		
		// Generate Random
		Random r = new Random();

		// returns the entity
		return this.entities[r.nextInt(this.numberOfCandidateEntities - 1)];

	}
}