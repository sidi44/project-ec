package Shapes;

/**
 * Requirements for each shape.
 */
public interface Shape {
	
	/**
	 * Calculates the area shape.
	 * @return area of shape (double)
	 */
	public double getArea();
	
	/**
	 * @return center of shape (PointXY)
	 */
	public PointXY getCenter();

}
