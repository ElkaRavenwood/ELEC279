/*
 * Author: Jamie Won
 * Date: January 17, 2020
 * Lab 1: Part 4b 
 */

// import statements
import java.util.Scanner;

// start of class
public class Lab1Task4 {
	
	public static void main (String[] args) {

		Scanner s = new Scanner(System.in); // creates scanner
		System.out.println("Give me a number and I will give you a multiplication table");
		int num = s.nextInt(); //reads from user
		
		for (int i = 0; i < 20; i ++) {
			System.out.println(num + " x " + i + " = " + num*i); // prints
		}

	}

}