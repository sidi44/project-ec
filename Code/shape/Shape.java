package shapes;

/**
 * Defines the properties which a shape must have.
 * 
 * @author Martin Wong
 * @version 2014-12-07
 */
public interface Shape {

	/**
	 * Calculates the area of a shape.
	 * 
	 * @return area of shape (double)
	 */
	public double getArea();

	/**
	 * The center is the reference point for other vertices (if any).
	 * 
	 * @return center of shape (PointXY)
	 */
	public PointXY getCenter();

}
