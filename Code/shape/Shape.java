package shape;

/**
 * Defines the properties which a shape must have.
 * 
 * @author Martin Wong
 * @version 2015-01-05
 */
public interface Shape {

	/**
	 * The reference point for the shape.
	 * 
	 * @return reference point of shape (PointXY)
	 */
	public PointXY getReference();
	
	/**
	 * Calculates the area of a shape.
	 * 
	 * @return area of shape (double)
	 */
	public double getArea();

}
