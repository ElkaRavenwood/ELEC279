/**
 * Code unique to Assignment 2 (ELEC 279)
 * Student Number: 20113217
 * Date: March 12, 2020
 * @author Jamie Won
 */
package Assignment2;

import Assignment1.*;

/**
 * A class representing a country
 * Inherits from entity
 */
public class Country extends Entity {

	private String capital;
	private String entityType;

	/**
	 * General Constructor
	 * Sets to specified capital, name, date
	 * @param capital the name of the capital
	 * @param name the name of the country
	 * @param born the country's birthdate
	 * @param difficulty the country's difficulty
	 */
	public Country (String name, Date born, String capital, double difficulty) {
		if (capital == null) capital = "NoCapital"
		this.capital = capital;
		this.setName(name);
		this.setBorn(new Date(born));
		this.setDifficulty(difficulty);
	}

	/**
	 * Default Constructor
	 * Sets to default name, date and capital
	 */
	public Country () {
		super();
		this.capital = "NoCapital";
	}

	/**
	 * Copy constructor
	 * Makes a deep copy of Country
	 * @param country the country to be copied
	 */
	public Country (Country country) {
		this.setName( country.getName());
		this.setBorn(new Date (country.getBorn()));
		this.capital = country.getCapital();
		this.setDifficulty(country.getDifficulty());
	}

	/** 
	 * Accessor for capital
	 * @return the capital's name
	 */
	public String getCapital () {
		return this.capital;
	}

	/**
	 * Mutator for capital
	 * @param capital the new capital
	 */
	public void setCapital (String capital) {
		this.capital = capital;
	}

	/**
	 * Clones the current country
	 * @return a deep copy of the country
	 */
	public Country clone (Country country) {
		return new Country(country);
	}

	/** 
	 * Overrides abstract clone
	 * @return the entity
	 */
	public Entity clone () {
		return (Entity) clone(this);
	}

	/**
	 * Displays information of country
	 * @return the converted information
	 */
	 public String toString () {
		return super.toString() + "The capital is " + this.capital + ".";
	}

	/**
	 * Returns the entity type in a sentence
	 * @return the entity type
	 */
	public String entityType () {
		return "country";
	}
}