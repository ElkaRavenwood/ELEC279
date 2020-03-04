/**
 * Code unique to Assignment 2 (ELEC 279)
 * Student Number: 20113217
 * Date: March 12, 2020
 * @author Jamie Won
 */
package Assignment2;

import Assignment1.*;

/**
 * A class representing a person
 * Inherits from entity
 */
public class Person extends Entity {

	private String gender;

	/**
	 * General Constructor
	 * Sets to specified gender, name, date
	 * @param gender the name of the gender
	 * @param name the name of the person
	 * @param born the person's birthdate
	 */
	public Person (String gender, String name, Date born) {
		this.gender = gender;
		this.setName(name);
		this.setBorn(new Date(born));
	}

	/**
	 * Default Constructor
	 * Sets to default name, date and gender
	 */
	public Person () {
		super();
		this.gender = "NoGender";
	}

	/**
	 * Copy constructor
	 * Makes a deep copy of person
	 * @param person the person to be copied
	 */
	public Person (Person person) {
		this.setName(person.getName());
		this.setBorn(new Date (person.getBorn()));
		this.gender = person.getGender();
	}

	/** 
	 * Accessor for gender
	 * @return the gender's name
	 */
	public String getGender () {
		return this.gender;
	}

	/**
	 * Mutator for gender
	 * @param gender the new gender
	 */
	public void setGender (String gender) {
		this.gender = gender;
	}

	/**
	 * Clones the current person
	 * @return a deep copy of the person
	 */
	public Person clone (Person person) {
		return new Person(person);
	}

	/** 
	 * Overrides abstract clone
	 * @return the entity
	 */
	public Entity clone () {
		return (Entity) clone(this);
	}
	
	/**
	 * Displays information of person
	 * @return the converted information
	 */
	 public String toString () {
		return super.toString() + "The gender is " + this.gender + ".";
	}

	/**
	 * Returns the entity type in a sentence
	 * @return the entity type
	 */
	public String entityType () {
		return "This entity is a person!";
	}
}