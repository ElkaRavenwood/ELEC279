/*
 * Author: Jamie Won
 * Date: January 17, 2019
 * Lab 1: Part 4a - work hour calculator
 */

// import statements
import java.util.Scanner;

// start of class
public class WorkHourApp {

	public static void main (String[] args) {

		Scanner s = new Scanner(System.in); // creates keyboard scanner
		System.out.println("What is the number of hours you work per day?"); // finds number of hours worked
		int hoursPerDay = s.nextInt();
		System.out.println("What is the number of days you work?"); // finds number of days worked
		int numDays = s.nextInt();

		for (int i = 0; i < numDays; i ++) {
			System.out.println("Day "+ (i + 1) + ": The total number of hours worked is: " + hoursPerDay*(i+1));
		}

	}

}