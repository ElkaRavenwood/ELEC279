/*
 * Author: ELEC279
 * Test cases
*/
public class Test {

	public static void main (String[] args) {

		// test case: part 1
		Person p1 = new Person ("Julia", "181 University Ave.", 121456);
		System.out.println(p1.toString());
		Student s1 = new Student ("John", "189 University Ave.", 246718);
		s1.addGrade("ELEC 279", 97);
		s1.addGrade("ELEC 221", 68);
		System.out.println(s1.toString());
		s1.printGrades();

		// expected output
		/*
		 * Julia: 121456 (181 University Ave.)
		 * Student: John: 246718 (189 University Ave.)
		 * ELEC 279:97
		 * ELEC 221:68
		 */

		GradStudent s2 = new GradStudent ("Tom", "92 Reg. st.", 1014);
		System.out.println(s2.toString());
		s2.addGrade("ELEC 279", 97);
		s2.addGrade("ELEC 221", 88);
		s2.setComitteeNum(6);
		s2.addGrade("CompI", "PASS");
		s2.addGrade("CompII", "PASS");
		s2.addGrade("Thesis Defense first trial", "FAIL");
		s2.addGrade("Thesis Defense second trial", "FAIL");
		s2.printExamGrades();
		s2.printGrades();

		// expected output
		/*
		 * Grad Student: Tom: 1014 (92 Reg. st.)
		 * CompI :PASS
		 * COMPII :PASS
		 * Thesis Defense first trial: FAIL
		 * Thesis Defense second trial: FAIL
		 * ELEC 279:97
		 * ELEC 221:88
		 */

	}
}