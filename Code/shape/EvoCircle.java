package shape;

import java.util.ArrayList;
import java.util.List;

import geneticAlgorithm.WorldLimits;

/**
 * A circle which represents the appearance of an Individual in Evolutionary
 * Computation.
 * 
 * An EvoCircle can be mutated or used in cross-over to create EvoCircles
 * with different properties.
 * 
 * @author Martin Wong
 * @version 2015-01-20
 */
public class EvoCircle implements EvoShape {

	private PointXY reference;
	private double radius;
	private CircleLimits cLimits; // Limits for circle radius
	
	/**
	 * Creates an instance of EvoCircle, using a 
	 * reference point, radius and circle limits.
	 * 
	 * @param reference (PointXY)
	 * @param radius (double)
	 * @param cLimits (CircleLimits)
	 */
	public EvoCircle(PointXY reference, double radius, CircleLimits cLimits) {
		this.reference = reference;
		this.radius = radius;
		this.cLimits = cLimits;
	}
	
	/**
	 * Creates an instance of EvoCircle, using the
	 * reference point: (referenceX, referenceY), radius and circle limits.
	 * 
	 * @param referenceX (double)
	 * @param referenceY (double)
	 * @param radius (double)
	 * @param cLimits (CircleLimits)
	 */
	public EvoCircle(double referenceX, double referenceY, double radius, CircleLimits cLimits) {
		this.reference = new PointXY(referenceX, referenceY);
		this.radius = radius;
		this.cLimits = cLimits;
	}
	
	/**
	 * The reference is center of the EvoCircle.
	 * 
	 * @return reference of EvoCircle (PointXY)
	 */
	@Override
	public PointXY getReference() {
		return this.reference;
	}
	
	/**
	 * The radius defines the size of the EvoCircle.
	 * 
	 * @return radius of EvoCircle (double)
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * The circleLimits defines the limit for radius of EvoCircle.
	 * 
	 * @return circle limits of EvoCircle (CircleLimits)
	 */
	public CircleLimits getCLimits() {
		return this.cLimits;
	}
	
	/**
	 * Sets reference to the parameter value provided.
	 * 
	 * @param reference (PointXY)
	 */
	public void setReference(PointXY reference) {
		this.reference = reference;
	}
	
	/**
	 * Sets radius to the parameter value provided.
	 * 
	 * @param radius (double)
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Sets cLimits to the parameter value provided.
	 * 
	 * @param cLimits (CircleLimits)
	 */
	public void setCLimits(CircleLimits cLimits) {
		this.cLimits = cLimits;
	}
	
	/**
	 * Calculates the area of an EvoCircle.
	 * 
	 * @return area of EvoCircle (double)
	 */
	@Override
	public double getArea() {
		double radiusSq = Math.pow(radius, 2);
		return Math.PI * radiusSq;
	}
	
	/**
	 * Uniform Mutation, it alters the reference or radius of an EvoCircle.
	 * 
	 * @param wLimits (WorldLimits)
	 */
	@Override
	public void uniformMutation(WorldLimits wLimits) {
		if (NumberUtils.randomInt(0, 1) == 0) { // For reference		
			double refMinX = wLimits.getMinX() + this.cLimits.getMinR();
			double refMaxX = wLimits.getMaxX() - this.cLimits.getMinR();
			double refMinY = wLimits.getMinY() + this.cLimits.getMinR();
			double refMaxY = wLimits.getMaxY() - this.cLimits.getMinR();
			
			double newX = NumberUtils.randomDouble(refMinX, refMaxX);
			double newY = NumberUtils.randomDouble(refMinY, refMaxY);
			this.reference.setX(newX);
			this.reference.setY(newY);
			
		} else { // For radius
			double newRadius = NumberUtils.randomDouble(this.cLimits.getMinR(),
														this.cLimits.getMaxR());
			setRadius(newRadius);
		}
	}
	
	/**
	 * Non-uniform Mutation, it alters the reference or radius of an EvoCircle.
	 * 
	 * @param wLimits (WorldLimits)
	 * @param b (double)
	 * @param currentGen (int)
	 * @param maxGen (int)
	 */
	@Override
	public void nonUniformMutation(WorldLimits wLimits, double b, int currentGen, int maxGen) {	
		EvoCircle possibleEC = null;
		double refMinX = wLimits.getMinX() + this.cLimits.getMinR();
		double refMaxX = wLimits.getMaxX() - this.cLimits.getMinR();
		double refMinY = wLimits.getMinY() + this.cLimits.getMinR();
		double refMaxY = wLimits.getMaxY() - this.cLimits.getMinR();
		
		double genFactor = 1 - (currentGen / maxGen);
		double temp1 = Math.pow(NumberUtils.randomDouble(0, 1), genFactor);
		double temp2 = Math.pow(NumberUtils.randomDouble(0, 1), genFactor);
		
		temp1 = Math.pow(1 - temp1, b);
		temp2 = Math.pow(1 - temp2, b);
		
		if (NumberUtils.randomInt(0, 1) == 0) { // For reference
			if (NumberUtils.randomInt(0, 1) == 0) { // For x 
				temp1 = - temp1 * (this.reference.getX() - refMinX);
			} else {
				temp1 = temp1 * (refMaxX - this.reference.getX());
			}
			
			if (NumberUtils.randomInt(0, 1) == 0) { // For y 
				temp2 = - temp2 * (this.reference.getY() - refMinY);
			} else {
				temp2 = temp2 * (refMaxY - this.reference.getY());
			}
			
			double newX = this.reference.getX() + temp1;
			double newY = this.reference.getY() + temp2;
			
			possibleEC = new EvoCircle(newX, newY, this.radius, this.cLimits);
			
			if(possibleEC.checkEvoCircle(wLimits)) {
				this.reference.setXY(newX, newY);
			}
			
		} else { // For radius
			if (NumberUtils.randomInt(0, 1) == 0) {
				temp1 = -temp1 * (this.radius - this.cLimits.getMinR());
			} else {
				temp1 = temp1 * (this.cLimits.getMinR() - this.radius);
			}
			
			double newRadius = this.radius + temp1;
			
			possibleEC = new EvoCircle(this.reference, newRadius, this.cLimits);
			
			if(possibleEC.checkEvoCircle(wLimits)) {
				setRadius(newRadius);
			}
		}
	}
	
	/**
	 * Generates offspring by Flat Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @throws exception: if es is not an instance of EvoCircle (IllegalArgumentException)
	 * @return offspring: 1 EvoCircle (List<EvoShape>)
	 */
	@Override
	public List<EvoShape> flatCrossover(EvoShape es) throws IllegalArgumentException {
		if(!(es instanceof EvoCircle)) {
			throw new IllegalArgumentException("Es must be an EvoCircle!");
			
		} else {
			List<EvoShape> offspring = new ArrayList<EvoShape>();
			EvoCircle circle = (EvoCircle) es;
			double sorted[] = new double[2];
			
			sorted = NumberUtils.sortAscending(this.reference.getX(), circle.getReference().getX());
			double newX = NumberUtils.randomDouble(sorted[0], sorted[1]);
			
			sorted = NumberUtils.sortAscending(this.reference.getY(), circle.getReference().getY());
			double newY = NumberUtils.randomDouble(sorted[0], sorted[1]);
			
			double newRadius = NumberUtils.randomDouble(this.radius, circle.getRadius());
			
			EvoShape osItem1 = new EvoCircle(newX, newY, newRadius, this.cLimits);
			offspring.add(osItem1);
			
			return offspring;
		}
	}
	
	/**
	 * Generates offspring by Simple Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @throws exception: if es is not an instance of EvoCircle (IllegalArgumentException)
	 * @return offspring: 2 EvoCircles (List<EvoShape>)
	 */
	@Override
	public List<EvoShape> simpleCrossover(EvoShape es) throws IllegalArgumentException {
		if(!(es instanceof EvoCircle)) {
			throw new IllegalArgumentException("Es must be an EvoCircle!");
			
		} else {
			List<EvoShape> offspring = new ArrayList<EvoShape>();
			EvoCircle circle = (EvoCircle) es;

			EvoShape osItem1 = new EvoCircle(this.reference, circle.getRadius(), this.cLimits);
			EvoShape osItem2 = new EvoCircle(circle.getReference(), this.radius, this.cLimits);
			
			offspring.add(osItem1);
			offspring.add(osItem2);
			
			return offspring;
		}
	}
	
	/**
	 * Generates offspring by Whole Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @throws exception: if es is not an instance of EvoCircle (IllegalArgumentException)
	 * @return offspring: 2 EvoCircles (List<EvoShape>)
	 */
	@Override
	public List<EvoShape> wholeCrossover(EvoShape es) throws IllegalArgumentException {
		if(!(es instanceof EvoCircle)) {
			throw new IllegalArgumentException("Es must be an EvoCircle!");
			
		} else {
			List<EvoShape> offspring = new ArrayList<EvoShape>();
			EvoCircle circle = (EvoCircle) es;
			
			double alphaPart = NumberUtils.randomDouble(0, 1);
			double[] alpha = new double[]{alphaPart, alphaPart, alphaPart}; // Same alpha
			
			offspring = wholeLocalCOContent(alpha, circle);
			
			return offspring;
		}
	}
	
	/**
	 * Generates offspring by Local Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @throws exception: if es is not an instance of EvoCircle (IllegalArgumentException)
	 * @return offspring: 2 EvoCircles (List<EvoShape>)
	 */
	@Override
	public List<EvoShape> localCrossover(EvoShape es) throws IllegalArgumentException {
		if(!(es instanceof EvoCircle)) {
			throw new IllegalArgumentException("Es must be an EvoCircle!");
			
		} else {
			List<EvoShape> offspring = new ArrayList<EvoShape>();
			
			try {
				EvoCircle circle = (EvoCircle) es;
				double[] alpha = new double[]{NumberUtils.randomDouble(0, 1),
						  NumberUtils.randomDouble(0, 1),
						  NumberUtils.randomDouble(0, 1)}; // Different alpha

				offspring = wholeLocalCOContent(alpha, circle);
				
			} catch(IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
			
			return offspring;
		}
	}
	
	/**
	 * Algorithm for Whole and Local Arithmetical Crossover.
	 * The difference between them depends on the alpha values used.
	 * Whole Arithmetical Crossover uses the same alpha, while
	 * Local Arithmetical Crossover uses different ones.
	 * 
	 * @param alpha (double)
	 * @param circle (EvoCircle)
	 * @return offspring: 2 EvoCircles (List<EvoShape>)
	 */
	public List<EvoShape> wholeLocalCOContent(double[] alpha, EvoCircle circle) {
		List<EvoShape> offspring = new ArrayList<EvoShape>();
			double newX = 0;
			double newY = 0;
			double newRadius = 0;

			newX = wholeLocalCOHelper(alpha[0], this.reference.getX(), circle.getReference().getX());
			newY = wholeLocalCOHelper(alpha[1], this.reference.getY(), circle.getReference().getY());
			newRadius = wholeLocalCOHelper(alpha[2], this.radius, circle.getRadius());
			EvoShape osItem1 = new EvoCircle(newX, newY, newRadius, this.cLimits);
			
			newX = wholeLocalCOHelper(alpha[0], circle.getReference().getX(), this.reference.getX());
			newY = wholeLocalCOHelper(alpha[1], circle.getReference().getY(), this.reference.getX());
			newRadius = wholeLocalCOHelper(alpha[2], circle.getRadius(), this.radius);
			EvoShape osItem2 = new EvoCircle(newX, newY, newRadius, this.cLimits);
			
			offspring.add(osItem1);
			offspring.add(osItem2);
			
			return offspring;
	}
	
	/**
	 * Carries out a frequently used operation in Whole and Local Arithmetical Crossover.
	 * 
	 * @param alpha (double)
	 * @param h1 (double)
	 * @param h2 (double)
	 * @return result (double)
	 */
	public double wholeLocalCOHelper(double alpha, double h1, double h2) {
		double part1 = alpha * h1;
		double part2 = (1 - alpha) * h2;
		return part1 + part2;
	}

	/**
	 * Generates offspring by Single Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @throws exception: if es is not an instance of EvoCircle (IllegalArgumentException)
	 * @return offspring: 2 EvoCircles (List<EvoShape>)
	 */
	@Override
	public List<EvoShape> singleCrossover(EvoShape es) throws IllegalArgumentException {
		if(!(es instanceof EvoCircle)) {
			throw new IllegalArgumentException("Es must be an EvoCircle!");
			
		} else {
			List<EvoShape> offspring = new ArrayList<EvoShape>();
			EvoCircle circle = (EvoCircle) es;
			EvoShape osItem1 = null;
			EvoShape osItem2 = null;
			
			if (NumberUtils.randomInt(0, 1) == 0) {
				double newX = (this.reference.getX() + circle.getReference().getX()) / 2;
				double newY = (this.reference.getY() + circle.getReference().getY()) / 2;
				osItem1 = new EvoCircle(newX, newY, this.radius, this.cLimits);
				osItem2 = new EvoCircle(newX, newY, circle.radius, this.cLimits);
			} else {
				double newRadius = (this.radius + circle.getRadius()) / 2;
				osItem1 = new EvoCircle(this.reference, newRadius, this.cLimits);
				osItem2 = new EvoCircle(circle.getReference(), newRadius, this.cLimits);
			}
			
			offspring.add(osItem1);
			offspring.add(osItem2);
				
			return offspring;
		}
	}
	
	/**
	 * Generates offspring by BLX-alpha Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @param alpha (double)
	 * @throws exception: if es is not an instance of EvoCircle (IllegalArgumentException)
	 * @return offspring: 1 EvoCircle (List<EvoShape>)
	 */
	@Override
	public List<EvoShape> blxAphaCrossover(EvoShape es, WorldLimits wLimits, double alpha) throws IllegalArgumentException {
		if(!(es instanceof EvoCircle)) {
			throw new IllegalArgumentException("Es must be an EvoCircle!");
			
		} else {
			List<EvoShape> offspring = new ArrayList<EvoShape>();
			EvoCircle circle = (EvoCircle) es;

			double[] sorted = new double[2];
			double factor = 0;
			double newX = 0;
			double newY = 0;
			double newRadius = 0;
			
			sorted = NumberUtils.sortAscending(this.reference.getX(), circle.getReference().getX());
			factor = (sorted[1] - sorted[0]) * alpha;
			newX = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			sorted = NumberUtils.sortAscending(this.reference.getY(), circle.getReference().getY());
			factor = (sorted[1] - sorted[0]) * alpha;
			newY = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			sorted = NumberUtils.sortAscending(this.radius, circle.getRadius());
			factor = (sorted[1] - sorted[0]) * alpha;
			newRadius = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			EvoCircle osItem1 = new EvoCircle(newX, newY, newRadius, this.cLimits);
			
			if(osItem1.checkEvoCircle(wLimits)) {
				offspring.add(osItem1);
			}
			
			return offspring;
		}
	}
	
	/**
	 * Checks whether an EvoCircle is within the evolutionary world.
	 * 
	 * @param wLimits: the co-ordinates of the evolutionary world (WorldLimits)
	 * @return boolean: whether EvoCircle is within the evolutionary world (boolean)
	 */
	public boolean checkEvoCircle(WorldLimits wLimits){
		
		double lowX = this.reference.getX() - this.radius; // The leftmost part of the circle
		double highX = this.reference.getX() + this.radius; // The rightmost part of the circle
		double lowY = this.reference.getY() - this.radius; // The lowest part of the circle
		double highY = this.reference.getY() + this.radius; // The highest part of the circle
		
		boolean lowXBool = NumberUtils.withinLimits(lowX, wLimits.getMinX(), wLimits.getMinX()); // Is lowX within limits
		boolean highXBool = NumberUtils.withinLimits(highX, wLimits.getMinX(), wLimits.getMinX()); // Is highX within limits
		
		boolean lowYBool = NumberUtils.withinLimits(lowY, wLimits.getMinY(), wLimits.getMaxY()); // Is lowY within limits
		boolean highYBool = NumberUtils.withinLimits(highY, wLimits.getMinY(), wLimits.getMaxY()); // Is highY within limits
		
		boolean rBool = NumberUtils.withinLimits(this.radius, this.cLimits.getMinR(), this.cLimits.getMaxR()); // Is radius within limits
		
		return lowXBool && highXBool && lowYBool && highYBool && rBool;
	}
	
	/**
	 * Checks whether a list of EvoCircles are within the evolutionary world.
	 * 
	 * @param listES (List<EvoShape>)
	 * @param wLimits: the co-ordinates of the evolutionary world (WorldLimits)
	 * @throws exception: if listES contains at least one EvoShape which is not an EvoCircle
	 * @return boolean: whether EvoCricle is within the evolutionary world (boolean)
	 */
	public static boolean checkListEvoCircle(List<EvoShape> listES, WorldLimits wLimits) throws IllegalArgumentException {
		boolean result = true;
		
		for(EvoShape es : listES) {
			if(!(es instanceof EvoCircle)) {
				throw new IllegalArgumentException("Es must be an EvoCircle!");
				
			} else {
				EvoCircle circle = (EvoCircle) es;
				result = circle.checkEvoCircle(wLimits);
				if(!result) break;
			}
		}
		
		return result;
	}
	
	/**
	 * String representation of an EvoCircle.
	 * 
	 * @return information about EvoCircle (string)
	 */
	@Override
	public String toString() {
		return "Shape: Circle, "
				+ "Reference: " + this.reference.toString()
				+ ", Radius: " + this.radius
				+ ", Area: " + getArea();
	}
}
