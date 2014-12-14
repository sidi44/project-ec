package shapes;

/**
 * Represents an (x, y) co-ordinate.
 * 
 * @author Martin Wong
 * @version 2014-12-14
 */
public class PointXY{
	
	private double x;
	private double y;
	
	public PointXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the x co-ordinate.
	 * 
	 * @return x (double)
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Returns the y co-ordinate.
	 * 
	 * @return y (double)
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * Sets x to the parameter value provided.
	 * 
	 * @param x (double)
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Sets y to the parameter value provided.
	 * 
	 * @param y (double)
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Sets x and y to the parameter values provided.
	 * 
	 * @param x (double)
	 * @param y (double)
	 */
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Calculates the distance between 2 points using Pythagoras.
	 * 
	 * @param point (PointXY)
	 * @return distance (double)
	 */
	public double getDistance(PointXY point) {
		return Math.sqrt(Math.pow(point.getX() - this.x, 2)
						 + Math.pow(point.getY() - this.y, 2));
	}
	
	/**
	 * String representation of a PointXY co-ordinate.
	 * 
	 * @return PointXY in the form: "(x, y)" (string)
	 */
	@Override
	public String toString(){
		return "(" + getX() + ", " + getY() + ")";
	}

}
