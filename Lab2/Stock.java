/*
 * Author: Jamie Won
 * Date: January 24, 2020
 * Lab 2: Part 2
 */

// import statements
import java.lang.*; 
import java.util.*; 

// start of class
public class Stock {

	// class variables
	private int day;
	private int month;
	private int year;
	private String name;
	private int[] values = new int[7];

	// default constructor
	public Stock() {
		day = 1;
		month = 1;
		year = 1;
		name = "";
		// values should already be all zeros
	}

	public Stock (int dayIn, int monthIn, int yearIn, String nameIn, int[] valIn) {

		boolean checkVal = true;

		// System.out.println("val in  length: " + valIn.length);
		for (int i = 0; i < valIn.length; i ++) {
			if (valIn[i] < 0) checkVal = false;
			break;
		}
		if (checkDate(dayIn, monthIn, yearIn)) {
			year = yearIn;
			day = dayIn;
			month = monthIn;
		} else {
			System.out.println("Invalid date.");
			year = 1;
			day = 1;
			month = 1;
		}

		if (checkVal && valIn.length == 7) {
			values = valIn.clone();
		} else {
			System.out.println("invalid values. ");
		}

		name = nameIn;

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

	public String getName() {
		return name;
	}

	public int getValue(int ind) {
		if (ind > values.length -1) {
			System.out.println("ArrayIndexOutOfBoundsException");
			return 0;
		}
		return values[ind];
	}

	public void setName(String nameIn) {
		name = nameIn;
	} 

	public void setValue(int val, int ind) {
		if (val > 0 && ind < values.length -1) {
			values[ind] = val;
		} else {
			System.out.println("Invalid value or index.");
		}
	}

	// setter
	public boolean checkDate(int dayIn, int monthIn, int yearIn) {

		// checks if being a leap year matters
		boolean leap = false;
		boolean dayOK = true;

		// checks if a valid month
		if (monthIn < 1 || monthIn > 12) {
			System.out.println("Invalid month entered");
			return false;
		} 

		// leap year
		// if (year % 4 == 0 && year % 100 != 0)
		
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
			System.out.println("Invalid date entered");
			return false;
		} 
		
		return true;
	}

	// prints to screen
	public void printStock() {
		System.out.println(name + ": " + day + "." + month + "." + year + " values: " + Arrays.toString(values));
	}

	//gets mean
	public double getMeanValue() {
		double avg = Arrays.stream(values).average().getAsDouble();
		System.out.println("Mean: " + avg);
		return avg;
	}


}