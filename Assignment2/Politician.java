/**
 * Code unique to Assignment 2 (ELEC 279)
 * Student Number: 20113217
 * Date: March 12, 2020
 * @author Jamie Won
 */
package Assignment2;

import Assignment1.*;

/**
 * A class representing a politician
 * Inherits from person
 */
public class Politician extends Person {

	private String party;
	
	/**
	 * General Constructor
	 * Sets to specified gender, name, date
	 * @param party the name of the party
	 * @param gender the gender of the politician
	 * @param name the name of the politician
	 * @param born the politician's birthdate
	 */
	public Politician (String party, String gender, String name, Date born) {
		this.setName(name);
		this.setBorn(new Date(born));
		this.setGender(gender);
		this.party = party;
	}

	/**
	 * Default Constructor
	 * Sets to default name, date, gender, party
	 */
	public Politician () {
		super();
		this.party = "NoParty";
	}

	/**
	 * Copy constructor
	 * Makes a deep copy of politician
	 * @param politician the politician to be copied
	 */
	public Politician (Politician politician) {
		this.setName(politician.getName());
		this.setBorn(new Date (politician.getBorn()));
		this.setGender(politician.getGender());
		this.party = politician.getParty();
	}

	/** 
	 * Accessor for party
	 * @return the party's name
	 */
	public String getParty () {
		return this.party;
	}

	/**
	 * Mutator for party
	 * @param party the new party
	 */
	public void setParty (String party) {
		this.party = party;
	}

	/**
	 * Clones the current party
	 * @return a deep copy of the party
	 */
	public Politician clone (Politician politician) {
		return new Politician(politician);
	}

	/**
	 * Displays information of party
	 * @return the converted information
	 */
	 public String toString () {
		return super.toString() + "The party is " + this.party + ".";
	}

	/**
	 * Returns the entity type in a sentence
	 * @return the entity type
	 */
	public String entityType () {
		return "This entity is a politician!";
	}

}