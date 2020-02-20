/*
 * Author: Jamie Won
 * Date: January 24, 2020
 * Lab 2: Part 1
 */

// import statements
import java.util.*;

// start of class
public class Activity {

	// class variables
	private int day;
	private int month;
	private int year;

	// default constructor
	public Activity() {
		day = 1;
		month = 1;
		year = 1;
	}

	public Activity(int dayIn, int monthIn, int yearIn) {
		setDate(dayIn, monthIn, yearIn);
	}

	// getters
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	// setter
	public void setDate(int dayIn, int monthIn, int yearIn) {

		// checks if being a leap year matters
		boolean leap = false;
		boolean dayOK = true;
		
		// checks if valid year
		if (yearIn < 0) {
			System.out.println("Invalid year entered. Setting to previous/Year 1");
			if (year == 0) year = 1;
		} else {
			year = yearIn;
		}
		// checks if a valid month
		if (monthIn < 1 || monthIn > 12) {
			System.out.println("Invalid month entered. Setting to previous/January");
			if (month == 0) month = 1;
		} else {
			month = monthIn;	
		} 
	
		// checks if valid date
		if (dayIn > 31) {
			dayOK = false;
		}
		// if feb and (not leap year and over 28) or (leap and over 29), bad
		if (month == 2 && ((!leap && dayIn > 28) || (leap && dayIn > 29))) { 
			dayOK = false;
		}

		if (dayIn > 30 &&((month > 8 && month%2 != 0)||(month > 3 && month%2 == 0))) { // if 30 day month
			dayOK = false;
		}

		if (!dayOK) {
			System.out.println("Invalid date entered. Setting to previous/the first.");
			if (day == 0) day = 1;
		} else {
			day = dayIn;
		}

	}

	// prints to screen
	public void printDate() {
		System.out.println("The date is (dd.mm.yyyy): " + day + "." + month + "." + year);
	}


}