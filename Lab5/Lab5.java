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
		// part1Employee();
		// part2Pair();
		// part3Triple();
		part4Triple3Type();

	}

	public static void part1Employee () {
		// random number generator
		Random r = new Random();
		
		// initial arraylist
		ArrayList<Integer> intArray = new ArrayList<>(5);
		// adds 10 numbers to intArray
		for (int i = 0; i < 10; i ++) {
			intArray.add(r.nextInt(99));
		}

		// reversed arrayList
		ArrayList<Integer> revIntArray = new ArrayList<>(5);
		// reverses array
		for (int i: intArray) {
			revIntArray.add(0, i);
		}

		// print original
		System.out.println("Old array: " + intArray);
		// print reversed
		System.out.println("New array: " + revIntArray);

		// employee list
		ArrayList<HourlyEmployee> employees = new ArrayList<>(100);
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

	public static void part2Pair() {
		Pair <String> p1 = new Pair <>("wife1", "husband1");
		Pair <String> p2 = new Pair <>("wife23", "husband23");
		Pair <String> p3 = new Pair <>("wife23", "husband23");

		// chekcing equals
		System.out.println("p1 and p2 equal: " + p1.equals(p2));
		System.out.println("p2 and p3 equal: " + p2.equals(p3));
	}

	public static void part3Triple() {
		Triple <String, Double> trip1 = new Triple <> ("Toronto", 547.0, "Montreal");
		Triple <String, Double> trip2 = new Triple <> ("Toronto", 264.5, "Kingston");
		Triple <String, Double> trip3 = new Triple <> ("Toronto", 264.5, "Kingston");

		// chekcing equals
		System.out.println("trip1 and trip2 equal: " + trip1.equals(trip2));
		System.out.println("trip2 and trip3 equal: " + trip2.equals(trip3));
	}

	public static void part4Triple3Type() {
		Triple3Type <String, Double, Integer> person1 = new Triple3Type <> ("Jane Doe", 143.5, 20);
		Triple3Type <String, Double, Integer> person2 = new Triple3Type <> ("John Doe", 180.6, 22);
		Triple3Type <String, Double, Integer> person3 = new Triple3Type <> ("Jane Doe", 143.5, 20);

		// chekcing equals
		System.out.println("Person2 and Person3 equal: " + person2.equals(person3));
		System.out.println("Person1 and Person3 equal: " + person1.equals(person3));
	}

}