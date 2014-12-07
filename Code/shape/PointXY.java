package Shapes;

import java.awt.geom.Point2D;

/**
 * Represents the an (x, y) co-ordinate.
 */
public class PointXY extends Point2D.Double {
	
	public PointXY() {
		super();
	}
	
	public PointXY(double x, double y) {
		super(x, y);
	}
	
	/**
	 * String representation of (x, y) co-ordinate.
	 */
	@Override
	public String toString(){
		return "(" + getX() + ", " + getY() + ")";
	}

}
