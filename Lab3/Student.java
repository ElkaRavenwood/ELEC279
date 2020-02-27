/**
 * Date: February 14, 2020
 * Lab 2: Part 1
 * @author: Jamie Won
 */

public class Student extends Person {

	// class variables
	private int courses;
	private String[] codes;
	private int[] grades;
	static final int maxCourses = 20;

	/** Student
	 * constructor
	 * @param name the student's name
	 * @param address the student's address
	 * @param id the student's student id number
	 */
	public Student (String name, String address, int id) {
		super(name, address, id);
		courses = 0;
		codes = new String [maxCourses];
		grades = new int [maxCourses];
	}

	/**
	 * Overrides the person's toString
	 * @return the new string to be returned, marks as a student
	 */
	public String toString () {
		return "Student: " + super.toString();
	}

	/** 
	 * Adds a grade to the GradStudent
	 * @param code the course code
	 * @param grade the grade of the course 
	 */
	public void addGrade (String code, int grade) {
		
		if (courses != maxCourses) { // if less than max courses are being taken
			codes[courses] = code; // adds course
			grades[courses] = grade; // adds grade
			courses++; // increments courses taken
		}

	}

	/**
	 * Prints the course grades
	 */
	public void printGrades () {
		for (int i = 0; i < courses; i ++) System.out.println(codes[i] + ":" + grades[i]);		
	}

}