/*
 * Author: Jamie Won
 * Date: January 17, 2019
 * Lab 1: Part 3 - Scanner
 */

// Import statements
import java.util.Scanner;

public class TaskInputOutput {

	public static void main (String[] args) {

		Scanner s = new Scanner(System.in); // creates new Scanner

		System.out.println("Give me two numbers, and I will do math for you. What is number 1?");
		int num1 = s.nextInt();
		System.out.println("What is number 2?");
		int num2 = s.nextInt();

		System.out.println("The product of these two numbers is: " + num1*num2);
		System.out.println("The sum of these two numbers is: " + (num1 + num2));

	}

}