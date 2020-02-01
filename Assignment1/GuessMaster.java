/*
 * ELEC 279 - Assignment 1
 * Author: Jamie Won
 * Student Number: 20113217
 * Date: January 29, 2020
 * Contents: A class called GuessMaster that runs a guessing game
 * of a noun and its birthday.
 */

// import statements
import java.lang.String;
import java.util.Scanner;
import java.util.Random;


// start of class
public class GuessMaster {

	// class variables
	private int numberOfCandidateEntities;
	private Entity[] entities;

	// constructor
	public GuessMaster (Entity[] entities) {
		// checks if values given exist
		if (entities == null) {
			System.out.println("Invalid Entities. Fatal Error");
			System.exit(0);
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

	// start of addEntity
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
			temp[this.numberOfCandidateEntities -1] = new Entity(entity.getName(), entity.getBorn());
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

	// main method
	public static void main (String [] args) {

		// test entities
		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity usa = new Entity("United States", new Date("July", 4, 1776));

		// creates GuessMaster and adds entities
		GuessMaster gm = new GuessMaster();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(usa);

		// creates entities, then a guessmaster
		// Entity[] ents = new Entity[3];
		// ents[0] = trudeau;
		// ents[1] = dion;
		// ents[2] = usa;
		// GuessMaster gm = new GuessMaster(ents); 

		// plays game
		gm.playGame();
		// gm.playGame(trudeau); // selected entity
		// gm.playGame(3); // invalid index case

	}
}