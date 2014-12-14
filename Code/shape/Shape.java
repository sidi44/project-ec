package shapes;

/**
 * Defines the properties which a shape must have.
 * 
 * @author Martin Wong
 * @version 2014-12-14
 */
public interface Shape {

	/**
	 * The reference point for other vertices (if any).
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
