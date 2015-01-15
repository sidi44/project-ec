package shape;

/**
 * A class which defines the limits specific to circles,
 * i.e. the minimum and maximum radius.
 * 
 * @author Martin Wong
 * @version 2015-01-15
 */
public class CircleLimits {
	
	private double minR;
	private double maxR;
	
	/**
	 * Creates an instance of CircleLimits,
	 * using minimum radius and maximum radius 
	 * 
	 * @param minR (double)
	 * @param maxR (double)
	 */
	public CircleLimits(double minR, double maxR) {
		this.minR = minR;
		this.maxR = maxR;
	}
	
	/**
	 * Returns the minimum value of radius.
	 * 
	 * @return minR (double)
	 */
	public double getMinR() {
		return this.minR;
	}
	
	/**
	 * Returns the maximum value of radius.
	 * 
	 * @return maxR (double)
	 */
	public double getMaxR() {
		return this.maxR;
	}
	
	/**
	 * Set the minimum value of radius.
	 * 
	 * @param minR (double)
	 */
	public void setMinR(double minR) {
		this.minR = minR;
	}
	
	/**
	 * Set the maximum value of radius.
	 * 
	 * @param maxR (double)
	 */
	public void setMaxR(double maxR) {
		this.maxR = maxR;
	}
	
	/**
	 * String representation of CircleLimits.
	 * 
	 * @return representation of CircleLimits (string)
	 */
	@Override
	public String toString() {
		return "Minimum Radius: " + getMinR() +
				", Maximum Radius:" + getMaxR();
	}

}
