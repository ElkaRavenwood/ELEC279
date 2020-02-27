/**
 * Date: February 14, 2020
 * Lab 2: Part 2
 * @author Jamie Won
 */

public class GradStudent extends Student {
	
	// class variables
	private int comitteeNum;
	private int examsTaken;
	private String[] examNames;
	private String[] examGrades;
	private final int maxExams = 6;

	/** GradStudent
	 * constructor
	 * @param name the student's name
	 * @param address the student's address
	 * @param id the student's student id number
	 */
	public GradStudent (String name, String address, int id) {
		super(name, address, id);
		comitteeNum = 0;
		examsTaken = 0;
		examNames = new String[maxExams];
		examGrades = new String[maxExams];
	}

	/** 
	 * @return the current comittee num
	 */
	public int getComitteeNum () {
		return comitteeNum;
	}

	/** 
	 * @param num new committee num
	 */
	public void setComitteeNum (int num) {
		comitteeNum = num;
	}

	/** 
	 * Overrides the Student's toString
	 * @return the new string to be returned, marks as a grad student
	 */
	public String toString () {
		return "Grad " + super.toString();
	}

	/** 
	 * Adds a grade to the GradStudent
	 * @param exam the name of the exam written
	 * @param grade the grade of the exam (pass/fail)
	 */
	public void addGrade (String exam, String grade) {
		examNames[examsTaken] = exam;
		examGrades[examsTaken] = grade;
		examsTaken++;
	}

	/** 
	 * Prints the grad level course exam grades
	 */
	public void printExamGrades() {
		for (int i = 0; i < examsTaken; i ++) System.out.println(examNames[i] + ":" + examGrades[i]);
	}


}