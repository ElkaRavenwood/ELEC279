/**
 * import statements
 */
import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Lab5 {
	
	public static void main (String[] args) {
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
		System.out.println(intArray);
		// print reversed
		System.out.println(revIntArray);

	}

}