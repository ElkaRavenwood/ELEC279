/*
 * Author: Jamie WOn
 * Date: January 31, 2020
 * Contents: Main class, runs a GuessMaster game
 * Kept separate so that there isn't a permanent testcase
 * in GuessMaster
 */

public class main {

	public static void main (String [] args) {

		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
		Entity usa = new Entity("United States", new Date("July", 4, 1776));

		GuessMaster gm = new GuessMaster();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(usa);

		gm.playGame();

	}

}