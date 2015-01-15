package shape;

import java.util.Arrays;
import java.util.Random;

/**
 * Class with static methods for random number generation and
 * number manipulation.
 * 
 * @author Martin Wong
 * @version 2015-01-15
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
	 * @throws exception: if min > max (IllegalArgumentException)
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
	 * 
	 * @param min (double)
	 * @param max (double)
	 * @throws exception: if min > max (IllegalArgumentException)
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
	
	
	/**
	 * Checks whether a double is within min (inclusive) and max (inclusive) provided.
	 * If min > max, an IllegalArgumentException will be thrown.
	 * 
	 * @param val (double)
	 * @param min (double)
	 * @param max (double)
	 * @throws exception: if min > max (IllegalArgumentException)
	 * @return inLimits (boolean)
	 */
	public static boolean withinLimits(double val, double min, double max) {
		if (min > max) {
			throw new IllegalArgumentException("Min cannot be more than Max!");
		} else {
			return (val >= min) && (val <= max);
		}
	}
	
}
