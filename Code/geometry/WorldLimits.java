package geometry;


/**
 * The WorldLimits class defines a rectangular area. This area defines the 
 * extents, or '2D world', within which the Evolutionary Computation algorithm
 * is executed.
 * 
 * @author Simon Dicken
 * @version 2015-02-22
 */
public class WorldLimits {
	
	// The top left and bottom right extents of the rectangular area/'world'.
	private PointXY minPoint;
	private PointXY maxPoint;
	
	/**
	 * Constructor to create WorldLimits using doubles.
	 * 
	 * @param minX - the minimum extent of the area in the x-axis.
	 * @param minY - the minimum extent of the area in the y-axis.
	 * @param maxX - the maximum extent of the area in the x-axis.
	 * @param maxY - the maximum extent of the area in the y-axis.
	 */
	public WorldLimits(double minX, double minY, double maxX, double maxY) {
		minPoint = new PointXY(minX, minY);
		maxPoint = new PointXY(maxX, maxY);
	}
	
	/**
	 * Constructor to create WorldLimits using PointXYs.
	 * 
	 * @param minPoint - the top left corner of the rectangular area.
	 * @param maxPoint - the bottom right corner of the rectangular area.
	 */
	public WorldLimits(PointXY minPoint, PointXY maxPoint) {
		this.minPoint = minPoint;
		this.maxPoint = maxPoint;
	}
	
	/**
	 * Set the minimum extent of the area in the x-axis.
	 * 
	 * @param minX - the minimum extent of the area in the x-axis.
	 */
	public void setMinX(double minX) {
		minPoint.setX(minX);
	}
	
	/**
	 * Set the minimum extent of the area in the y-axis.
	 * 
	 * @param minY - the minimum extent of the area in the y-axis.
	 */
	public void setMinY(double minY) {
		minPoint.setY(minY);
	}
	
	/**
	 * Set the maximum extent of the area in the x-axis.
	 * 
	 * @param maxX - the maximum extent of the area in the x-axis.
	 */
	public void setMaxX(double maxX) {
		maxPoint.setX(maxX);
	}
	
	/**
	 * Set the maximum extent of the area in the y-axis.
	 * 
	 * @param maxX - the maximum extent of the area in the y-axis.
	 */
	public void setMaxY(double maxY) {
		maxPoint.setY(maxY);
	}
	
	/**
	 * Set the top left extent of the rectangular area.
	 * 
	 * @param minPoint - the top left corner of the rectangular area.
	 */
	public void setMinPoint(PointXY minPoint) {
		this.minPoint = minPoint;
	}
	
	/**
	 * Set the bottom right extent of the rectangular area.
	 * 
	 * @param maxPoint - the bottom right corner of the rectangular area.
	 */
	public void setMaxPoint(PointXY maxPoint) {
		this.maxPoint = maxPoint;
	}
	
	/**
	 * Get the minimum extent of the area in the x-axis.
	 * 
	 * @return the minimum extent of the area in the x-axis.
	 */
	public double getMinX() {
		return minPoint.getX();
	}
	
	/**
	 * Get the minimum extent of the area in the y-axis.
	 * 
	 * @return the minimum extent of the area in the y-axis.
	 */
	public double getMinY() {
		return minPoint.getY();
	}
	
	/**
	 * Get the maximum extent of the area in the x-axis.
	 * 
	 * @return the maximum extent of the area in the x-axis.
	 */
	public double getMaxX() {
		return maxPoint.getX();
	}
	
	/**
	 * Get the maximum extent of the area in the y-axis.
	 * 
	 * @return the maximum extent of the area in the y-axis.
	 */
	public double getMaxY() {
		return maxPoint.getY();
	}
	
	/**
	 * Get the top left extent of the rectangular area.
	 * 
	 * @return the top left extent of the rectangular area.
	 */
	public PointXY getMaxPoint() {
		return maxPoint;
	}
	
	/**
	 * Get the bottom right extent of the rectangular area.
	 * 
	 * @return the bottom right extent of the rectangular area.
	 */
	public PointXY getMinPoint() {
		return minPoint;
	}
}
