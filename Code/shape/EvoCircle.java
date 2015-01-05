package shape;

/**
 * A circle which represents the appearance of an Individual in Evolutionary
 * Computation.
 * 
 * An EvoCircle can be mutated or used in cross-over to create EvoCircles
 * with different properties.
 * 
 * @author Martin Wong
 * @version 2015-01-05
 */
public class EvoCircle implements EvoShape {

	private PointXY reference;
	private double radius;
	
	/**
	 * Creates an instance of EvoCircle, using a reference point and radius.
	 * 
	 * @param reference (PointXY)
	 * @param radius (double)
	 */
	public EvoCircle(PointXY reference, double radius) {
		this.reference = reference;
		this.radius = radius;
	}
	
	/**
	 * Creates an instance of EvoCircle,
	 * using the reference point: (referenceX, referenceY) and radius.
	 * 
	 * @param referenceX (double)
	 * @param referenceY (double)
	 * @param radius (double)
	 */
	public EvoCircle(double referenceX, double referenceY, double radius) {
		this.reference = new PointXY(referenceX, referenceY);
		this.radius = radius;
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
	 * Sets radius to the parameter value provided.
	 * 
	 * @param radius (double)
	 */
	public void setRadius(double radius) {
		this.radius = radius;
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
	 * Uniform Mutation, it alters the reference or area of an EvoCircle.
	 * 
	 * @param ep (EvoParameters)
	 */
	@Override
	public void uniformMutation(EvoParameters ep) {
		
		if (ep instanceof EvoParametersCircle) {
		EvoParametersCircle epc = (EvoParametersCircle) ep;
		
			if (NumberUtils.randomInt(0, 1) == 0) { // For reference
				double randX = NumberUtils.randomDouble(epc.getReferenceXMin(),
														epc.getReferenceXMax());
				double randY = NumberUtils.randomDouble(epc.getReferenceYMin(),
														epc.getReferenceYMax());
				this.reference.setX(randX);
				this.reference.setY(randY);
				
			} else { // For radius
				double randRadius = NumberUtils.randomDouble(epc.getRadiusMin(),
															 epc.getRadiusMax());
				setRadius(randRadius);
			}
		}
		
	}
	
	/**
	 * Non-uniform Mutation, it alters the reference or area of an EvoShape.
	 * In this case vertexMin.getX() represents the lower-bound for the radius,
	 * while vertexMax.getX() represents the upper-bound for the radius.
	 * 
	 * @param ep (EvoParameters)
	 * @param currentGen (int)
	 * @param maxGen (int)
	 */
	@Override
	public void nonUniformMutation(EvoParameters ep, int currentGen, int maxGen) {
		
		if (ep instanceof EvoParametersCircle) {
			EvoParametersCircle epc = (EvoParametersCircle) ep;
			
			double genFactor = 1 - (currentGen / maxGen);
			double temp1 = Math.pow(NumberUtils.randomDouble(0, 1), genFactor);
			double temp2 = Math.pow(NumberUtils.randomDouble(0, 1), genFactor);
			
			temp1 = Math.pow(1 - temp1, epc.getB());
			temp2 = Math.pow(1 - temp2, epc.getB());
			
			if (NumberUtils.randomInt(0, 1) == 0) { // For reference
				if (NumberUtils.randomInt(0, 1) == 0) { // For x 
					temp1 = - temp1 * (this.reference.getX() - epc.getReferenceXMin());
				} else {
					temp1 = temp1 * (epc.getReferenceXMax() - this.reference.getX());
				}
				
				if (NumberUtils.randomInt(0, 1) == 0) { // For y 
					temp2 = - temp2 * (this.reference.getY() - epc.getReferenceYMin());
				} else {
					temp2 = temp2 * (epc.getReferenceYMax() - this.reference.getY());
				}
				
				double newX = this.reference.getX() + temp1;
				double newY = this.reference.getY() + temp2;
				
				this.reference.setXY(newX, newY);
				
			} else { // For radius
				if (NumberUtils.randomInt(0, 1) == 0) {
					temp1 = -temp1 * (this.radius - epc.getRadiusMin());
				} else {
					temp1 = temp1 * (epc.getRadiusMax() - this.radius);
				}
				
				double newRadius = this.radius + temp1;
				
				setRadius(newRadius);
			}
		}
	}
	
	/**
	 * Generates offspring by Flat Crossover with another EvoShape.
	 * If the second parent is not an EvoCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 1 (EvoShape)
	 */
	@Override
	public EvoShape flatCrossover(EvoShape es) {
		EvoShape offspring = this;
		double sorted[] = new double[2];
		
		if (es instanceof EvoCircle) {
			EvoCircle circle = (EvoCircle) es;
			
			sorted = NumberUtils.sortAscending(this.reference.getX(), circle.getReference().getX());
			double newX = NumberUtils.randomDouble(sorted[0], sorted[1]);
			
			sorted = NumberUtils.sortAscending(this.reference.getY(), circle.getReference().getY());
			double newY = NumberUtils.randomDouble(sorted[0], sorted[1]);
			
			double newRadius = NumberUtils.randomDouble(this.radius, circle.getRadius());
			
			offspring = new EvoCircle(newX, newY, newRadius);
		}
		return offspring;
	}
	
	/**
	 * Generates offspring by Simple Crossover with another EvoShape.
	 * If the second parent is not an EvoCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 (EvoShape[])
	 */
	@Override
	public EvoShape[] simpleCrossover(EvoShape es) {
		EvoShape[] offspring = new EvoShape[]{this, es};
		
		if (es instanceof EvoCircle) {
			EvoCircle circle = (EvoCircle) es;
			offspring[0] = new EvoCircle(this.reference, circle.getRadius());
			offspring[1] = new EvoCircle(circle.getReference(), this.radius);
		}
		return offspring;
	}
	
	/**
	 * Generates offspring by Whole Arithmetical Crossover with another
	 * EvoShape.
	 * If the second parent is not an EvoCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 (EvoShape[])
	 */
	@Override
	public EvoShape[] wholeCrossover(EvoShape es) {
		double alphaPart = NumberUtils.randomDouble(0, 1);
		double[] alpha = new double[]{alphaPart, alphaPart, alphaPart}; // Same alpha
		
		return wholeLocalCOContent(alpha, es);
	}
	
	/**
	 * Generates offspring by Local Arithmetical Crossover with another
	 * EvoShape.
	 * If the second parent is not an EvoCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 (EvoShape[])
	 */
	@Override
	public EvoShape[] localCrossover(EvoShape es) {
		double[] alpha = new double[]{NumberUtils.randomDouble(0, 1),
									  NumberUtils.randomDouble(0, 1),
									  NumberUtils.randomDouble(0, 1)}; // Different alpha
		
		return wholeLocalCOContent(alpha, es);
	}
	
	/**
	 * Algorithm for Whole and Local Arithmetical Crossover.
	 * The difference between them depends on the alpha values used.
	 * Whole Arithmetical Crossover uses the same alpha, while
	 * Local Arithmetical Crossover uses different ones.
	 * 
	 * @param alpha (double)
	 * @param es (EvoShape)
	 * @return offspring (EvoShape[])
	 */
	public EvoShape[] wholeLocalCOContent(double[] alpha, EvoShape es) {
		EvoShape[] offspring = new EvoShape[]{this, es};
		
		if (es instanceof EvoCircle) {
			EvoCircle circle = (EvoCircle) es;
			double newX = 0;
			double newY = 0;
			double newRadius = 0;

			newX = wholeLocalCOHelper(alpha[0], this.reference.getX(), circle.getReference().getX());
			newY = wholeLocalCOHelper(alpha[1], this.reference.getY(), circle.getReference().getY());
			newRadius = wholeLocalCOHelper(alpha[2], this.radius, circle.getRadius());
			offspring[0] = new EvoCircle(newX, newY, newRadius);
			
			newX = wholeLocalCOHelper(alpha[0], circle.getReference().getX(), this.reference.getX());
			newY = wholeLocalCOHelper(alpha[1], circle.getReference().getY(), this.reference.getX());
			newRadius = wholeLocalCOHelper(alpha[2], circle.getRadius(), this.radius);
			offspring[1] = new EvoCircle(newX, newY, newRadius);
		}
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
	 * If the second parent is not an EvoCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 (EvoShape[])
	 */
	@Override
	public EvoShape[] singleCrossover(EvoShape es) {
		EvoShape[] offspring = new EvoShape[]{this, es};
		
		if (es instanceof EvoCircle) {
			EvoCircle circle = (EvoCircle) es;
			if (NumberUtils.randomInt(0, 1) == 0) {
				double newX = (this.reference.getX() + circle.getReference().getX()) / 2;
				double newY = (this.reference.getY() + circle.getReference().getY()) / 2;
				offspring[0] = new EvoCircle(newX, newY, this.radius);
				offspring[1] = new EvoCircle(newX, newY, circle.radius);
			} else {
				double newRadius = (this.radius + circle.getRadius()) / 2;
				offspring[0] = new EvoCircle(this.reference, newRadius);
				offspring[1] = new EvoCircle(circle.getReference(), newRadius);
			}
		}
		return offspring;
	}
	
	/**
	 * Generates offspring by BLX-alpha Crossover with another EvoShape.
	 * If the second parent is not an EvoCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @param ep (EvoParameters)
	 * @return offspring: 1 (EvoShape)
	 */
	@Override
	public EvoShape blxAphaCrossover(EvoShape es, EvoParameters ep) {
		EvoShape offspring = this;
		
		if (es instanceof EvoCircle) {
			EvoCircle circle = (EvoCircle) es;
			
			if (ep instanceof EvoParametersCircle) {
				EvoParametersCircle epc = (EvoParametersCircle) ep;
				
				double[] sorted = new double[2];
				double factor = 0;
				double newX = 0;
				double newY = 0;
				double newRadius = 0;
				
				sorted = NumberUtils.sortAscending(this.reference.getX(), circle.getReference().getX());
				factor = (sorted[1] - sorted[0]) * epc.getAlpha();
				newX = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);
				
				sorted = NumberUtils.sortAscending(this.reference.getY(), circle.getReference().getY());
				factor = (sorted[1] - sorted[0]) * epc.getAlpha();
				newY = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);
				
				sorted = NumberUtils.sortAscending(this.radius, circle.getRadius());
				factor = (sorted[1] - sorted[0]) * epc.getAlpha();
				newRadius = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);
				
				offspring = new EvoCircle(newX, newY, newRadius);
			}
		}
		return offspring;
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
