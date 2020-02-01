/*
 * ELEC 279 - Assignment 1
 * Author: Jamie Won
 * Student Number: 20113217
 * Date: January 29, 2020
 * Contents: A class called entity with class variables String name, Date born
 * Contains a corresponding constructor for each in Date, as well as a toString method that
 * prints the object's information and another that compares two entities
 */

// imports
import java.lang.String;

// start of class
public class Entity {

	private String name;
	private Date born;

	// constructors
	public Entity(String name, Date born) {
		if (name == null || born == null || name == "") {
			System.out.println("Fatal Error");
			System.exit(0);
		}
		this.name = name;
		this.born = new Date(born);
	}

	public Entity() {
		this.name = "No Name";
		this.born = new Date();
	}

	// mutators
	public void setName (String name) {
		this.name = name;
	}

	public void setBorn (Date born) {
		this.born.setDate(born.getMonth(), born.getDay(), born.getYear());
	}

	// accessors
	public String getName () {
		return this.name;
	}

	public Date getBorn () {
		return this.born;
	}

	// toString
	public String toString () {
		return (this.name + ", born on " + this.born.getMonth() + " " + this.born.getDay() + ", " + this.born.getYear());
	}

	// equals
	public boolean equals (Entity entity) {
		System.out.println(this.name == entity.getName() + " " + this.born.equals(entity.getBorn()));
		return (entity != null && this.name == entity.getName() && this.born.equals(entity.getBorn()));
	}

}