package geneticAlgorithm;

import shape.PointXY;

/**
 * The ReferenceLimits class defines a rectangular area. This area defines the 
 * extents, or '2D world', within which an EvoShape can exist.
 * 
 * @author Simon Dicken
 * @version 2015-01-11
 */
public class ReferenceLimits {
	
	// The top left and bottom right extents of the rectangular area/'world'.
	private PointXY minPoint;
	private PointXY maxPoint;
	
	/**
	 * Constructor to create ReferenceLimits using doubles.
	 * 
	 * @param minX - the minimum extent of the area in the x-axis.
	 * @param minY - the minimum extent of the area in the y-axis.
	 * @param maxX - the maximum extent of the area in the x-axis.
	 * @param maxY - the maximum extent of the area in the y-axis.
	 */
	public ReferenceLimits(double minX, double minY, double maxX, double maxY) {
		minPoint = new PointXY(minX, minY);
		maxPoint = new PointXY(maxX, maxY);
	}
	
	/**
	 * Constructor to create ReferenceLimits using PointXYs.
	 * 
	 * @param minPoint - the top left corner of the rectangular area.
	 * @param maxPoint - the bottom right corner of the rectangular area.
	 */
	public ReferenceLimits(PointXY minPoint, PointXY maxPoint) {
		this.minPoint = new PointXY(minPoint.getX(), minPoint.getY());
		this.maxPoint = new PointXY(maxPoint.getX(), maxPoint.getY());
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
		this.minPoint.setX(minPoint.getX());
		this.minPoint.setY(minPoint.getY());
	}
	
	/**
	 * Set the bottom right extent of the rectangular area.
	 * 
	 * @param maxPoint - the bottom right corner of the rectangular area.
	 */
	public void setMaxPoint(PointXY maxPoint) {
		this.maxPoint.setX(maxPoint.getX());
		this.maxPoint.setY(maxPoint.getY());
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
		return new PointXY(maxPoint.getX(), maxPoint.getY());
	}
	
	/**
	 * Get the bottom right extent of the rectangular area.
	 * 
	 * @return the bottom right extent of the rectangular area.
	 */
	public PointXY getMinPoint() {
		return new PointXY(minPoint.getX(), minPoint.getY());
	}
}
