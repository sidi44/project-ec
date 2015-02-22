package geometry;

/**
 * A circle which represents the appearance of an Individual in Evolutionary
 * Computation.
 * 
 * An EvoCircle can be mutated or used in cross-over to create EvoCircles
 * with different properties.
 * 
 * @author Martin Wong, Simon Dicken
 * @version 2015-02-22
 */
public class Circle implements Shape {

	private PointXY reference;
	private double radius;
	
	/**
	 * Creates an instance of Circle, using a reference point (centre) and 
	 * radius.
	 * 
	 * @param reference (PointXY)
	 * @param radius (double)
	 */
	public Circle(PointXY reference, double radius) {
		this.reference = reference;
		this.radius = radius;
	}
	
	/**
	 * Creates an instance of Circle, using the reference point (centre) as 
	 * (referenceX, referenceY) and radius.
	 * 
	 * @param referenceX (double)
	 * @param referenceY (double)
	 * @param radius (double)
	 */
	public Circle(double referenceX, double referenceY, double radius) {
		this.reference = new PointXY(referenceX, referenceY);
		this.radius = radius;
	}
	
	/**
	 * The reference is center of the Circle.
	 * 
	 * @return reference of Circle (PointXY)
	 */
	@Override
	public PointXY getReference() {
		return this.reference;
	}
	
	/**
	 * The radius defines the size of the Circle.
	 * 
	 * @return radius of Circle (double)
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * Sets reference to the parameter value provided.
	 * 
	 * @param reference (PointXY)
	 */
	public void setReference(PointXY reference) {
		this.reference = reference;
	}
	
	/**
	 * Sets radius to the parameter value provided.
	 * 
	 * @param radius (double)
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Calculates the area of an Circle.
	 * 
	 * @return area of Circle (double)
	 */
	@Override
	public double getArea() {
		double radiusSq = Math.pow(radius, 2);
		return Math.PI * radiusSq;
	}
	
	
	/**
	 * String representation of an Circle.
	 * 
	 * @return information about Circle (string)
	 */
	@Override
	public String toString() {
		return "Shape: Circle, "
				+ "Reference: " + this.reference.toString()
				+ ", Radius: " + this.radius
				+ ", Area: " + getArea();
	}
}
