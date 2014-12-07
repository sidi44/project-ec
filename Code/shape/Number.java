package shapes;

import java.util.Arrays;
import java.util.Random;

/**
 * Class with static methods for random number generation and
 * number manipulation.
 * 
 * @author Martin Wong
 * @version 2014-12-07
 */
public class Number {
	
	/**
	 * Sort two numbers into ascending order.
	 * 
	 * @param num1 (double)
	 * @param num2 (double)
	 * @return sorted numbers (double[])
	 */
	public static double[] sort(double num1, double num2){
		double[] sorted = new double[]{num1, num2};
		Arrays.sort(sorted);
		return sorted;
		
	}
	
	/**
	 * Generates a random int within int boundaries (inclusive) provided.
	 * The lower-bound and upper-bound ints can be provided in any order, as
	 * they will be sorted prior to random number generation.
	 * 
	 * @param boundary1 (int)
	 * @param boundary2 (int)
	 * @return random int in within the boundaries (int)
	 */
	public static int randomInt(int boundary1, int boundary2){
		double[] sorted = sort(boundary1, boundary2);
		
		int min = (int) sorted[0];
		int max = (int) sorted[1];
		
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min; // + 1 for inclusive
	}
	
	/**
	 * Generates a random double within double boundaries (inclusive) provided.
	 * The lower-bound and upper-bound doubles can be provided in any order, as
	 * they will be sorted prior to random number generation.
	 * 
	 * @param boundary1 (double)
	 * @param boundary2 (double)
	 * @return random double in range (double)
	 */
	public static double randomDouble(double boundary1, double boundary2) {
		double[] sorted = sort(boundary1, boundary2);
		
		Random r = new Random();
		return r.nextDouble() * (sorted[1] - sorted[0]) + sorted[1];
	}
	
}
