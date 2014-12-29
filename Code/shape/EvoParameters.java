package shape;

/**
 * Represents Evolutionary Computation Parameters required for mutation and
 * cross-overs.
 * 
 * @author Martin Wong
 * @version 2014-12-28
 */
public class EvoParameters {
	
	private double alpha;
	private double b;
	private double referenceXMin;
	private double referenceXMax;
	private double referenceYMin;
	private double referenceYMax;
	
	public EvoParameters (double alpha, double b, double referenceXMin,
						 double referenceXMax, double referenceYMin,
						 double referenceYMax) {
		this.alpha = alpha;
		this.b = b;
		this.referenceXMin = referenceXMin;
		this.referenceXMax = referenceXMax;
		this.referenceYMin = referenceYMin;
		this.referenceYMax = referenceYMax;
	}
	
	/**
	 * Returns alpha.
	 * 
	 * @return alpha (double)
	 */
	public double getAlpha () {
		return this.alpha;
	}
	
	/**
	 * Returns b.
	 * 
	 * @return b (double)
	 */
	public double getB () {
		return this.b;
	}
	
	/**
	 * Returns the minimum x reference value.
	 * 
	 * @return referenceXMin (double)
	 */
	public double getReferenceXMin () {
		return this.referenceXMin;
	}
	
	/**
	 * Returns the maximum x reference value.
	 * 
	 * @return referenceXMax (double)
	 */
	public double getReferenceXMax () {
		return this.referenceXMax;
	}
	
	/**
	 * Returns the minimum y reference value.
	 * 
	 * @return referenceYMin (double)
	 */
	public double getReferenceYMin () {
		return this.referenceYMin;
	}
	
	/**
	 * Returns the maximum y reference value.
	 * 
	 * @return referenceYMax (double)
	 */
	public double getReferenceYMax() {
		return this.referenceYMax;
	}
	
	/**
	 * Sets alpha to the parameter value provided.
	 * 
	 * @param alpha (double)
	 */
	public void setAlpha (double alpha) {
		this.alpha = alpha;
	}
	
	/**
	 * Sets b to the parameter value provided.
	 * 
	 * @param b (double)
	 */
	public void setB (double b) {
		this.b = b;
	}
	
	/**
	 * Sets referenceXMin to the parameter value provided.
	 * 
	 * @param referenceXMin (double)
	 */
	public void setReferenceXMin (double referenceXMin) {
		this.referenceXMin = referenceXMin;
	}
	
	/**
	 * Sets referenceXMax to the parameter value provided.
	 * 
	 * @param referenceXMax (double)
	 */
	public void setReferenceXMax (double referenceXMax) {
		this.referenceXMax = referenceXMax;
	}
	
	/**
	 * Sets referenceYMin to the parameter value provided.
	 * 
	 * @param referenceYMin (double)
	 */
	public void setReferenceYMin (double referenceYMin) {
		this.referenceYMin = referenceYMin;
	}
	
	/**
	 * Sets referenceYMax to the parameter value provided.
	 * 
	 * @param referenceYMax (double)
	 */
	public void setReferenceYMax (double referenceYMax) {
		this.referenceYMax = referenceYMax;
	}
	
	/**
	 * String representation of EvoParameters.
	 * 
	 * @return EvoParameters in the form: "Property = value" (string)
	 */
	@Override
	public String toString () {
		return "Alpha = " + getAlpha()
				+ ", b = " + getB()
				+ ", Reference X Min = " + getReferenceXMin()
				+ ", Reference X Max = " + getReferenceXMax()
				+ ", Reference Y Min = " + getReferenceYMin()
				+ ", Reference Y Max = " + getReferenceYMax();
	}

}
