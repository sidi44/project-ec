package shapes;

/**
 * A circle which represents the appearance of an Individual in Evolutionary
 * Computation.
 * 
 * An EvolCircle can be mutated or used in cross-over to create EvolCircles
 * with different properties.
 * 
 * @author Martin Wong
 * @version 2014-12-07
 */
public class EvolCircle implements EvolShape {

	private PointXY center;
	private double radius;

	public EvolCircle(PointXY center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public EvolCircle(double centerX, double centerY, double radius) {
		this.center = new PointXY(centerX, centerY);
		this.radius = radius;
	}
	
	/**
	 * The center is the reference point for the EvolCircle.
	 * 
	 * @return center of EvolCircle (PointXY)
	 */
	@Override
	public PointXY getCenter() {
		return this.center;
	}
	
	/**
	 * The radius defines the size of the EvolCircle.
	 * 
	 * @return radius of EvolCircle (double)
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
	 * Calculates the area of an EvolCircle.
	 * 
	 * @return area of EvolCircle (double)
	 */
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	/**
	 * Uniform Mutation, it alters the center or area of an EvolCircle.
	 * In this case vertexMin.getX() represents the lower-bound for the radius,
	 * while vertexMax.getX() represents the upper-bound for the radius.
	 * 
	 * @param centerMin (PointXY)
	 * @param centerMax (PointXY)
	 * @param vertexMin (PointXY)
	 * @param vertexMax (PointXY)
	 */
	@Override
	public void uniformMutation(PointXY centerMin, PointXY centerMax,
								PointXY vertexMin, PointXY vertexMax) {
		
		if(Number.randomInt(0, 1) == 0){ // For center
			double newX = Number.randomDouble(centerMin.getX(), centerMax.getX());
			double newY = Number.randomDouble(centerMin.getY(), centerMax.getY());
			
			this.center.setLocation(newX, newY);
			
		} else { // For radius
			setRadius(Number.randomDouble(vertexMin.getX(), vertexMax.getX()));
		}
		
	}
	
	/**
	 * Non-uniform Mutation, it alters the center or area of an EvolShape.
	 * In this case vertexMin.getX() represents the lower-bound for the radius,
	 * while vertexMax.getX() represents the upper-bound for the radius.
	 * 
	 * @param centerMin (PointXY)
	 * @param centerMax (PointXY)
	 * @param vertexMin (PointXY)
	 * @param vertexMax (PointXY)
	 * @param currentGen (int)
	 * @param maxGen (int)
	 * @param b (double)
	 */
	@Override
	public void nonUniformMutation(PointXY centerMin, PointXY centerMax,
								   PointXY vertexMin, PointXY vertexMax,
								   int currentGen, int maxGen, double b) {
		
		double temp1 = Math.pow(Number.randomDouble(0, 1),(1 - currentGen/maxGen));
		double temp2 = Math.pow(Number.randomDouble(0, 1),(1 - currentGen/maxGen));
		
		temp1 = Math.pow(1 - temp1, b);
		temp2 = Math.pow(1 - temp2, b);
		
		if(Number.randomInt(0, 1) == 0){ // For center
			if(Number.randomInt(0, 1) == 0) { // For x 
				temp1 = -temp1 * (this.center.getX() - centerMin.getX());
			} else {
				temp1 = temp1 * (centerMax.getX() - this.center.getX());
			}
			if(Number.randomInt(0, 1) == 0) { // For y 
				temp2 = -temp2 * (this.center.getY() - centerMin.getY());
			} else {
				temp2 = temp2 * (centerMax.getY() - this.center.getY());
			}
			this.center.setLocation(this.center.getX() + temp1,
									this.center.getY() + temp2);
			
		} else { // For radius
			if(Number.randomInt(0, 1) == 0) {
				temp1 = -temp1 * (this.radius - vertexMin.getX());
			} else {
				temp1 = temp1 * (vertexMax.getX() - this.radius);
			}
			setRadius(this.radius + temp1);
		}
	}
	
	/**
	 * Generates offspring by Flat Crossover with another EvolShape.
	 * If the second parent is not an EvolCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 1 (EvolShape)
	 */
	@Override
	public EvolShape flatCrossover(EvolShape es) {
		EvolShape offspring = this;
		
		if(es instanceof EvolCircle){
			EvolCircle circle = (EvolCircle) es;
			double newX = Number.randomDouble(this.center.getX(), circle.getCenter().getX());
			double newY = Number.randomDouble(this.center.getY(), circle.getCenter().getY());
			
			double newRadius = Number.randomDouble(this.radius, circle.getRadius());
			
			offspring = new EvolCircle(newX, newY, newRadius);
		}
		return offspring;
	}
	
	/**
	 * Generates offspring by Simple Crossover with another EvolShape.
	 * If the second parent is not an EvolCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 2 (EvolShape[])
	 */
	@Override
	public EvolShape[] simpleCrossover(EvolShape es) {
		EvolShape[] offspring = new EvolShape[]{this, es};
		
		if(es instanceof EvolCircle) {
			EvolCircle circle = (EvolCircle) es;
			offspring[0] = new EvolCircle(this.center, circle.getRadius());
			offspring[1] = new EvolCircle(circle.getCenter(), this.radius);
		}
		return offspring;
	}
	
	/**
	 * Generates offspring by Whole Arithmetical Crossover with another
	 * EvolShape.
	 * If the second parent is not an EvolCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 2 (EvolShape[])
	 */
	@Override
	public EvolShape[] wholeCrossover(EvolShape es) {
		double alphaPart = Number.randomDouble(0, 1);
		double[] alpha = new double[]{alphaPart, alphaPart, alphaPart}; // Same alpha
		
		return wholeLocalCOContent(alpha, es);
	}
	
	/**
	 * Generates offspring by Local Arithmetical Crossover with another
	 * EvolShape.
	 * If the second parent is not an EvolCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 2 (EvolShape[])
	 */
	@Override
	public EvolShape[] localCrossover(EvolShape es) {
		double[] alpha = new double[]{Number.randomDouble(0, 1),
									  Number.randomDouble(0, 1),
									  Number.randomDouble(0, 1)}; // Different alpha
		
		return wholeLocalCOContent(alpha, es);
	}
	
	/**
	 * Algorithm for Whole and Local Arithmetical Crossover.
	 * The difference between them depends on the alpha values used.
	 * Whole Arithmetical Crossover uses the same alpha, while
	 * Local Arithmetical Crossover uses different ones.
	 * 
	 * @param alpha (double)
	 * @param es (EvolShape)
	 * @return offspring (EvolShape[])
	 */
	public EvolShape[] wholeLocalCOContent(double[] alpha, EvolShape es){
		EvolShape[] offspring = new EvolShape[]{this, es};
		
		if(es instanceof EvolCircle) {
			EvolCircle circle = (EvolCircle) es;
			double newX = 0;
			double newY = 0;
			double newRadius = 0;

			newX = wholeLocalCOHelper(alpha[0], this.center.getX(), circle.getCenter().getX());
			newY = wholeLocalCOHelper(alpha[1], this.center.getY(), circle.getCenter().getY());
			newRadius = wholeLocalCOHelper(alpha[2], this.radius, circle.getRadius());
			offspring[0] = new EvolCircle(newX, newY, newRadius);
			
			newX = wholeLocalCOHelper(alpha[0], circle.getCenter().getX(), this.center.getX());
			newY = wholeLocalCOHelper(alpha[1], circle.getCenter().getY(), this.center.getX());
			newRadius = wholeLocalCOHelper(alpha[2], circle.getRadius(), this.radius);
			offspring[1] = new EvolCircle(newX, newY, newRadius);
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
	public double wholeLocalCOHelper(double alpha, double h1, double h2){
		return alpha * h1 + (1 - alpha) * h2;
	}

	/**
	 * Generates offspring by Single Arithmetical Crossover with another
	 * EvolShape.
	 * If the second parent is not an EvolCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 2 (EvolShape[])
	 */
	@Override
	public EvolShape[] singleCrossover(EvolShape es) {
		EvolShape[] offspring = new EvolShape[]{this, es};
		
		if(es instanceof EvolCircle) {
			EvolCircle circle = (EvolCircle) es;
			if(Number.randomInt(0, 1) == 0){
				double newX = (this.center.getX() + circle.getCenter().getX()) / 2;
				double newY = (this.center.getY() + circle.getCenter().getY()) / 2;
				offspring[0] = new EvolCircle(newX, newY, this.radius);
				offspring[1] = new EvolCircle(newX, newY, circle.radius);
			} else {
				double newRadius = (this.radius + circle.getRadius()) / 2;
				offspring[0] = new EvolCircle(this.center, newRadius);
				offspring[1] = new EvolCircle(circle.getCenter(), newRadius);
			}
		}
		return offspring;
	}
	
	/**
	 * Generates offspring by BLX-alpha Crossover with another EvolShape.
	 * If the second parent is not an EvolCircle, then return first parent.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @param alpha, a constant (double)
	 * @return offspring: 2 (EvolShape)
	 */
	@Override
	public EvolShape blxAphaCrossover(EvolShape es, double alpha) {
		EvolShape offspring = this;
		
		if(es instanceof EvolCircle) {
			EvolCircle circle = (EvolCircle) es;
			double[] sorted = new double[2];
			double factor = 0;
			double newX = 0;
			double newY = 0;
			double newRadius = 0;
			
			sorted = Number.sort(this.center.getX(), circle.getCenter().getX());
			factor = (sorted[1] - sorted[0]) * alpha;
			newX = Number.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			sorted = Number.sort(this.center.getY(), circle.getCenter().getY());
			factor = (sorted[1] - sorted[0]) * alpha;
			newY = Number.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			sorted = Number.sort(this.radius, circle.getRadius());
			factor = (sorted[1] - sorted[0]) * alpha;
			newRadius = Number.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			offspring = new EvolCircle(newX, newY, newRadius);
		}
		return offspring;
	}
	
	/**
	 * String representation of an EvolCircle.
	 * 
	 * @return information about EvolCircle (string)
	 */
	@Override
	public String toString() {
		return "Shape: Circle, Center: " + center.toString() + ", Radius: "
				+ this.radius + ", Area: " + getArea();
	}
}
