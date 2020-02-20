/*
 * Author: Jamie Won
 * Date: January 17, 2020
 * Lab 1: Part 2c- Importing classes
 */

// Import statements
import java.util.Date;

public class DateAppTask {

	public static void main (String[] args) {

		Date todaysDate = new Date(); // creates a new date object
		
		System.out.println(todaysDate); // prints todaysDate to screen


		/***** Start of Part 3 ******/

		// learning data types
		// variable declarations
		int min = 10, max = 20, average = 5;
		String myRole = "Driver";
		byte myFirstByte = 22;
		double pi = 3.14159;
		char myChar = 'N';

		// printing to screen
		System.out.println("I am now the " + myRole);
		System.out.println("Our minimum score is " + min);
		System.out.println("We have a byte " + myFirstByte);
		System.out.println("And double type is " + pi);
		System.out.println("A char looks like " + myChar);

		// learning while loops
		// variable declarations
		int count = 1 ; // counter
		while ( count <= 10) {
			
			System.out.println(todaysDate); // prints out date
			count = count + 1 ; // Increment count
		
		}

		// learning for loops
		for (count = 1 ; count <= 25 ; count++) {
			System.out.println(todaysDate); // prints out date
		}

		// learning nested loops

		for ( int row = 1 ; row <= 5 ; row++) {

			for ( int column = 1 ; column <= 10 ; column++) {
				System.out.print(row * column + "\t"); // Prints each row
			}

			System.out.println(); // new line
		}

	}

}