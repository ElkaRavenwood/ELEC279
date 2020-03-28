/**
 * import statements
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 */
public class Lab5 {
	
	public static void main (String[] args) {
		part1();
		part2();

	}

	public static void part1 () {
		// random number generator
		Random r = new Random();
		
		// initial arraylist
		ArrayList<Integer> intArray = new ArrayList<Integer>(5);
		// adds 10 numbers to intArray
		for (int i = 0; i < 10; i ++) {
			intArray.add(r.nextInt(99));
		}

		// reversed arrayList
		ArrayList<Integer> revIntArray = new ArrayList<Integer>(5);
		// reverses array
		for (int i: intArray) {
			revIntArray.add(0, i);
		}

		// print original
		System.out.println("Old array: " + intArray);
		// print reversed
		System.out.println("New array: " + revIntArray);

		// employee list
		ArrayList<HourlyEmployee> employees = new ArrayList<HourlyEmployee>(100);
		// adds 4 employees
		for (int i = 0; i < 4; i ++) employees.add(new HourlyEmployee("Employee" + i, new Date(), i, i));

		// print employees
		System.out.println("Employees: " + employees);
		// print size
		System.out.println("Employee Size: " + employees.size());

		// new employee
		HourlyEmployee newEmployee = new HourlyEmployee("NewEmployee", new Date(), 14.5, 20);
		// replaces first element with new employee
		employees.set(0, newEmployee);
		// print editted employees
		System.out.println("Employees: "  + employees);
		
		// remove element
		employees.remove(2);
		// trims
		employees.trimToSize();
		// print editted employees
		System.out.println("Employees: "  + employees);
		// print size
		System.out.println("Employee Size: " + employees.size());
	}

	public static void part2() {
		Pair <String> p1 = new Pair <String>("wife1", "husband1");
		Pair <String> p2 = new Pair <String>("wife23", "husband23");
		Pair <String> p3 = new Pair <String>("wife23", "husband23");

		System.out.println("p1 and p2 equal: " + p1.equals(p2));
		System.out.println("p2 and p3 equal: " + p2.equals(p3));
	}

}