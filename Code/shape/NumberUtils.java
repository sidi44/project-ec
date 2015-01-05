package shape;

import java.util.Arrays;
import java.util.Random;

/**
 * Class with static methods for random number generation and
 * number manipulation.
 * 
 * @author Martin Wong
 * @version 2015-01-05
 */
public class NumberUtils {
	
	/**
	 * Sort two numbers into ascending order.
	 * 
	 * @param num1 (double)
	 * @param num2 (double)
	 * @return sorted numbers (double[])
	 */
	public static double[] sortAscending(double num1, double num2) {
		double[] sorted = new double[]{num1, num2};
		Arrays.sort(sorted);
		return sorted;
	}
	
	/**
	 * Generates a random int within min (inclusive) and max (inclusive) provided.
	 * 
	 * @param min (int)
	 * @param max (int)
	 * @throws IllegalArgumentException: if min > max
	 * @return random int in range (int)
	 */
	public static int randomInt(int min, int max) throws IllegalArgumentException {
		if (min > max) {
			throw new IllegalArgumentException("Min cannot be more than Max!");
		} else {
			Random r = new Random();
			return r.nextInt((max - min) + 1) + min; // + 1 for inclusive
		}
	}
	
	/**
	 * Generates a random double within min (inclusive) and max (inclusive) provided.
	 * If min > max, an IllegalArgumentException will be thrown and max will be returned.
	 * 
	 * @param min (double)
	 * @param max (double)
	 * @throws IllegalArgumentException: if min > max
	 * @return random double in range (double)
	 */
	public static double randomDouble(double min, double max) throws IllegalArgumentException {
		if (min > max) {
			throw new IllegalArgumentException("Min cannot be more than Max!");
		} else {
			Random r = new Random();
			return r.nextDouble() * (max - min) + min;
		}
	}
	
}
