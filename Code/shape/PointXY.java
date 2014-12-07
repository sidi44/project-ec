package shapes;

import java.awt.geom.Point2D;

/**
 * Represents an (x, y) co-ordinate.
 * 
 * @author Martin Wong
 * @version 2014-12-07
 */
public class PointXY extends Point2D.Double {
	
	public PointXY() {
		super();
	}
	
	public PointXY(double x, double y) {
		super(x, y);
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
