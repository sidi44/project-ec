package shape;

import java.util.Iterator;
import java.util.List;

import geneticAlgorithm.WorldLimits;

/**
 * Class with static methods for checking whether EvoShapes
 * are within the evolutionary world.
 * 
 * @author Martin Wong
 * @version 2015-01-15
 */
public class EvoWorldUtils {
	
	/**
	 * Checks whether an EvoCircle is within the evolutionary world.
	 * 
	 * @param circle (EvoCircle)
	 * @param wLimits (WorldLimits)
	 * @throws exception: if NumberUtils.withinLimits has illegal arguments (IllegalArgumentException)
	 * @return boolean (boolean)
	 */
	public static boolean checkEvoCircle(EvoCircle circle, WorldLimits wLimits) throws IllegalArgumentException {
		double x = circle.getReference().getX();
		double y = circle.getReference().getY();
		double r = circle.getRadius();
		CircleLimits cLimits = circle.getCLimits();
		
		double refMinX = wLimits.getMinX() + cLimits.getMinR();
		double refMaxX = wLimits.getMaxX() - cLimits.getMinR();
		double refMinY = wLimits.getMinY() + cLimits.getMinR();
		double refMaxY = wLimits.getMaxY() - cLimits.getMinR();
		
		boolean xBool = NumberUtils.withinLimits(x, refMinX, refMaxX);
		boolean yBool = NumberUtils.withinLimits(y, refMinY, refMaxY);
		boolean rBool = NumberUtils.withinLimits(r, cLimits.getMinR(), cLimits.getMaxR());
		
		return xBool && yBool && rBool;
	}
	
	/**
	 * Checks whether a list of EvoCircles are within the evolutionary world.
	 * 
	 * @param listES (List<EvoShape>)
	 * @param wLimits (WorldLimits)
	 * @throws exception: if listES contains at least one EvoShape which is not an EvoCircle, or, 
	 * if NumberUtils.checkEvoCircle has illegal arguments (IllegalArgumentException)
	 * @return boolean (boolean)
	 */
	public static boolean checkListEvoCircle(List<EvoShape> listES, WorldLimits wLimits) throws IllegalArgumentException {
		boolean result = true;
		Iterator<EvoShape> it = listES.iterator();
		
		while(it.hasNext()) {
			EvoShape es = it.next();
			if(!(es instanceof EvoCircle)) {
				throw new IllegalArgumentException("Es must be an EvoCircle!");
				
			} else {
				EvoCircle circle = (EvoCircle) es;
				result = result && checkEvoCircle(circle, wLimits);
				if(!result) break;
			}
		}
		
		return result;
	}
	
	/**
	 * Checks whether an EvoPolygon is within the evolutionary world.
	 * 
	 * @param circle (EvoCircle)
	 * @param wLimits (WorldLimits)
	 * @throws exception: if NumberUtils.withinLimits has illegal arguments (IllegalArgumentException)
	 * @return boolean (boolean)
	 */
	public static boolean checkEvoPolygon(EvoPolygon polygon, WorldLimits wLimits) throws IllegalArgumentException {
		return true;
	}
	
	/**
	 * Checks whether a list of EvoCircles are within the evolutionary world.
	 * 
	 * @param listES (List<EvoShape>)
	 * @param wLimits (WorldLimits)
	 * @throws exception: if listES contains at least one EvoShape which is not an EvoPolygon, or, 
	 * if NumberUtils.checkEvoPolygon has illegal arguments (IllegalArgumentException)
	 * @return boolean (boolean)
	 */
	public static boolean checkListEvoPolygon(List<EvoShape> listES, WorldLimits wLimits) throws IllegalArgumentException {
		return true;
	}
}
