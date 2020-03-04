/**
 * Code unique to Assignment 2 (ELEC 279)
 * Student Number: 20113217
 * Date: March 12, 2020
 * @author Jamie Won
 */
package Assignment2;

import Assignment1.*;

/**
 * A class representing a singer
 * Inherits from person
 */
public class Singer extends Person {

	private String debutAlbum;
	private Date debutAlbumReleaseDate;

	/**
	 * General Constructor
	 * Sets to specified gender, name, date
	 * @param debutAlbum the name of the debut album
	 * @param debutAlbumReleaseDate the release date of the debut album
	 * @param name the name of the singer
	 * @param born the singer's birthdate
	 */
	public Singer (String debutAlbum, Date debutAlbumReleaseDate, String name, Date born) {
		this.setName(name);
		this.setBorn(new Date(born));
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = new Date (debutAlbumReleaseDate);
		
	}

	/**
	 * Default Constructor
	 * Sets to default name, date, album name and album date
	 */
	public Singer () {
		super();
		this.debutAlbum = "NoAlbum";
		this.debutAlbumReleaseDate = new Date();
	}

	/**
	 * Copy constructor
	 * Makes a deep copy of singer
	 * @param singer the singer to be copied
	 */
	public Singer (Singer singer) {
		this.setName(singer.getName());
		this.setBorn(new Date (singer.getBorn()));
		this.debutAlbum = singer.getDebutAlbum();
		this.debutAlbumReleaseDate = new Date (singer.getDebutAlbumReleaseDate());
	}

	/** 
	 * Accessor for debutAlbum
	 * @return the debutAlbum's name
	 */
	public String getDebutAlbum () {
		return this.debutAlbum;
	}

	/**
	 * Mutator for debutAlbum
	 * @param debutAlbum the new debutAlbum
	 */
	public void setDebutAlbum (String debutAlbum) {
		this.debutAlbum = debutAlbum;
	}

	/** 
	 * Accessor for debutAlbumReleaseDate
	 * @return the debutAlbumReleaseDate's name
	 */
	public Date getDebutAlbumReleaseDate () {
		return this.debutAlbumReleaseDate;
	}

	/**
	 * Mutator for debutAlbumReleaseDate
	 * @param debutAlbumReleaseDate the new debutAlbumReleaseDate
	 */
	public void setDebutAlbumReleaseDate (Date debutAlbumReleaseDate) {
		this.debutAlbumReleaseDate = new Date (debutAlbumReleaseDate);
	}

	/**
	 * Clones the current singer
	 * @return a deep copy of the singer
	 */
	public Singer clone (Singer singer) {
		return new Singer(singer);
	}

	// /** 
	//  * Overrides abstract clone
	//  * @return the entity
	//  */
	// public Entity clone () {
	// 	return (Entity) clone(this);
	// }
	
	/**
	 * Displays information of singer
	 * @return the converted information
	 */
	 public String toString () {
		return super.toString() + "The debut album name is " + this.debutAlbum + " and its release date is " + this.debutAlbumReleaseDate +".";
	}

	/**
	 * Returns the entity type in a sentence
	 * @return the entity type
	 */
	public String entityType () {
		return "This entity is a singer!";
	}

}