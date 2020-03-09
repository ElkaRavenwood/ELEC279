/**
 * Code based from Assignment 1
*/
package Assignment1;

// imports
import java.lang.String;

/**
 * ELEC 279 - Assignment 2
 * Student Number: 20113217
 * Date: March 12, 2020
 * Contents: A class called entity with class variables String name, Date born
 * Contains a corresponding constructor for each in Date, as well as a toString method that
 * prints the object's information and another that compares two entities
 * @author Jamie Won
 */
abstract public class Entity {

	private String name;
	private Date born;
	private double difficulty;
	
	/**
	 * A constructor for the generic case of an Entity
	 * @param name The name of the entity
	 * @param born The entity's birthdate
	 */
	public Entity(String name, Date born) {
		if (name == null || born == null || name == "") {
			System.out.println("Fatal Error");
			System.exit(1);
		}
		this.name = name;
		this.born = new Date(born);
	}

	/**
	 * default counstructor
	 */
	public Entity() {
		this.name = "No Name";
		this.born = new Date();
	}

	/**
	 * A copy constructor for entity
	 */
	public Entity(Entity e) {
		name = e.getName();
		born = new Date (e.getBorn());
		difficulty = e.getDifficulty();
	}

	/**
	 * Mutator for name
	 */
	public void setName (String name) {
		this.name = name;
	}

	/**
	 * Mutator for born
	 */
	public void setBorn (Date born) {
		this.born.setDate(born.getMonth(), born.getDay(), born.getYear());
	}

	/**
	 * Mutator for difficulty
	 */
	public void setDifficulty (double difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Accessor for name
	 * @return the entity's name
	 */
	public String getName () {
		return this.name;
	}

	/**
	 * Accessor for born
	 * @return the entity's birthdate
	 */
	public Date getBorn () {
		return this.born;
	}

	/**
	 * Accessor for difficulty
	 * @return the entity's difficulty
	 */
	public double getDifficulty () {
		return this.difficulty;
	}


	/**
	 * Transcribes the entity's details to a string
	 * @return the entity's details
	 */
	public String toString () {
		return ("\nName: " + this.name + "\nBorn at: " + this.born.toString());
	}

	/**
	 * Compares an entity to the current one
	 * @param entity The entity this one is being compared to
	 * @return whether or not the entities are equal
	 */
	public boolean equals (Entity entity) {
		System.out.println(this.name == entity.getName() + " " + this.born.equals(entity.getBorn()));
		return (entity != null && this.name == entity.getName() && this.born.equals(entity.getBorn()));
	}

	/**
	 * Calculates and returns a number of tickets based on the difficulty
	 * @return The calculated ticket number
	*/
	public int getAwardedTicketNumber() {
		return (int)(difficulty*100);
	}

	/**
	 * Abstract method to be overriden in descendents
	 * @return a short description of the type of entity
	 */
	abstract public String entityType();

	/**
	 * Abstract method to be overrident in descendents
	 * @return a deep copy of the entity
	 */
	abstract public Entity clone();

	/**
	 * Public method that returns a message introducing the game. Calls entityType()
	 * @return the welcome message
	 */
	public String welcomeMessage() {
		return "Welcome, let's begin the game! This entity is a " + entityType() + "!";
	}

	/**
	 * Public method that returns a closing message for each round of correct guessing
	 * @return the closing message
	 */
	public String closingMessage() {
		return "Congratulations!\nThe detailed information of the entity you guessed is: " + toString();
	}

}