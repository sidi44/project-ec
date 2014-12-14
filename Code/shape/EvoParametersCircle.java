package shapes;

/**
 * Represents Evolutionary Computation Parameters required for mutation and
 * cross-overs specifically for EvoCircles.
 * 
 * @author Martin Wong
 * @version 2014-12-14
 */
public class EvoParametersCircle extends EvoParameters {

	private double radiusMin;
	private double radiusMax;
	
	public EvoParametersCircle(double alpha, double b, double referenceXMin,
							   double referenceXMax, double referenceYMin,
							   double referenceYMax, double radiusMin,
							   double radiusMax) {
		super(alpha, b, referenceXMin, referenceXMax, referenceYMin, referenceYMax);
		this.radiusMin = radiusMin;
		this.radiusMax = radiusMax;
	}
	
	/**
	 * Returns the minimum radius value.
	 * 
	 * @return radiusMin (double)
	 */
	public double getRadiusMin() {
		return this.radiusMin;
	}
	
	/**
	 * Returns the maximum radius value.
	 * 
	 * @return radiusMax (double)
	 */
	public double getRadiusMax() {
		return this.radiusMax;
	}
	
	/**
	 * Sets radiusMin to the parameter value provided.
	 * 
	 * @param radiusMin (double)
	 */
	public void setRadiusMin(double radiusMin) {
		this.radiusMin = radiusMin;
	}
	
	/**
	 * Sets radiusMax to the parameter value provided.
	 * 
	 * @param radiusMax (double)
	 */
	public void setRadiusMax(double radiusMax) {
		this.radiusMax = radiusMax;
	}
	
	/**
	 * String representation of EvoParametersCircle.
	 * 
	 * @return EvoParametersCircle in the form: "Property = value" (string)
	 */
	@Override
	public String toString() {
		return super.toString() + ", Radius Min = " + getRadiusMin()
				+ ", Radius Max = " + getRadiusMax();
	}

}