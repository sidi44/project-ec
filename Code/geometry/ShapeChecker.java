package geometry;

import geometry.CircleLimits;

/**
 * 
 * @author Simon Dicken, Martin Wong
 * @version 2015-02-22
 */
public class ShapeChecker {

	public ShapeChecker() {
		
	}
	
	public boolean checkCircle(Circle c, CircleLimits cLimits, WorldLimits wLimits){
		
		double radius = c.getRadius();
		double lowX = c.getReference().getX() - radius; // The leftmost part of the circle
		double highX = c.getReference().getX() + radius; // The rightmost part of the circle
		double lowY = c.getReference().getY() - radius; // The lowest part of the circle
		double highY = c.getReference().getY() + radius; // The highest part of the circle
		
		boolean lowXBool = (lowX >= wLimits.getMinX());
		boolean highXBool = (highX <= wLimits.getMaxX()); 
		
		boolean lowYBool = (lowY >= wLimits.getMinY());
		boolean highYBool = (highY <= wLimits.getMaxY());
		
		boolean rBool = (radius >= cLimits.getMinR()) && (radius <= cLimits.getMaxR());
		
		return lowXBool && highXBool && lowYBool && highYBool && rBool;
	}
	
}
