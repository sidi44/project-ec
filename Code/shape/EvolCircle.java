package Shapes;

/**
 * Represents the shape: Circle.
 * Has mutation and cross-overs.
 */
public class EvolCircle implements EvolShape {

	private PointXY center;
	private double radius;

	public EvolCircle(PointXY center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public PointXY getCenter() {
		return this.center;
	}
	
	/**
	 * @return radius of circle (double)
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * Sets radius to parameter value.
	 * @param radius (double)
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public void uniformMutation(PointXY centerMin, PointXY centerMax, PointXY vertexMin, PointXY vertexMax) {
		if(Number.randomInt(0, 1) == 0){ // For center
			this.center.setLocation(Number.randomDouble(centerMin.getX(), centerMax.getX()), Number.randomDouble(centerMin.getY(), centerMax.getY()));
		} else { // For radius
			setRadius(Number.randomDouble(vertexMin.getX(), vertexMax.getX()));
		}
	}

	@Override
	public void nonUniformMutation(PointXY centerMin, PointXY centerMax, PointXY vertexMin, PointXY vertexMax, int currentGen, int maxGen, double b) {
		double temp1 = Math.pow(1 - Math.pow(Number.randomDouble(0, 1), (1 - currentGen/maxGen)), b);
		double temp2 = Math.pow(1 - Math.pow(Number.randomDouble(0, 1), (1 - currentGen/maxGen)), b);
		
		if(Number.randomInt(0, 1) == 0){ // For center
			if(Number.randomInt(0, 1) == 0) { // For x 
				temp1 *= -(this.center.getX() - centerMin.getX());
			} else {
				temp1 *= (centerMax.getX() - this.center.getX());
			}
			if(Number.randomInt(0, 1) == 0) { // For y 
				temp2 *= -(this.center.getY() - centerMin.getY());
			} else {
				temp2 *= centerMax.getY() - this.center.getY();
			}
			this.center.setLocation(this.center.getX() + temp1, this.center.getY() + temp2);
			
		} else { // For radius
			if(Number.randomInt(0, 1) == 0) {
				temp1 *= -(this.radius - vertexMin.getX());
			} else {
				temp1 *= vertexMax.getX() - this.radius;
			}
			setRadius(this.radius + temp1);
		}
	}

	@Override
	public EvolShape flatCrossover(EvolShape es) {
		EvolShape offspring = this;
		
		if(es instanceof EvolCircle){
			EvolCircle circle = (EvolCircle) es;
			PointXY newPoint = new PointXY(Number.randomDouble(this.center.getX(), circle.getCenter().getX()), Number.randomDouble(this.center.getY(), circle.getCenter().getY()));
			double newRadius = Number.randomDouble(this.radius, circle.getRadius());
			
			offspring = new EvolCircle(newPoint, newRadius);
		}
		return offspring;
	}

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

	@Override
	public EvolShape[] wholeCrossover(EvolShape es) {
		double alphaPart = Number.randomDouble(0, 1);
		double[] alpha = new double[]{alphaPart, alphaPart, alphaPart}; // Same alpha
		
		return wholeLocalCOContent(alpha, es);
	}

	@Override
	public EvolShape[] localCrossover(EvolShape es) {
		double[] alpha = new double[]{Number.randomDouble(0, 1), Number.randomDouble(0, 1), Number.randomDouble(0, 1)}; // Different alpha
		
		return wholeLocalCOContent(alpha, es);
	}
	
	/**
	 * Algorithm for Whole and Local Arithmetical Cross
	 * @param alpha (double)
	 * @param es (EvolShape)
	 * @return offspring (EvolShape[])
	 */
	public EvolShape[] wholeLocalCOContent(double[] alpha, EvolShape es){
		EvolShape[] offspring = new EvolShape[]{this, es};
		
		if(es instanceof EvolCircle) {
			EvolCircle circle = (EvolCircle) es;
			PointXY newPoint = new PointXY();
			double newRadius = 0;

			newPoint.setLocation(wholeLocalCOHelper(alpha[0], this.center.getX(), circle.getCenter().getX()), wholeLocalCOHelper(alpha[1], this.center.getY(), circle.getCenter().getY()));
			newRadius = wholeLocalCOHelper(alpha[2], this.radius, circle.getRadius());
			offspring[0] = new EvolCircle(newPoint, newRadius);
			
			newPoint.setLocation(wholeLocalCOHelper(alpha[0], circle.getCenter().getX(), this.center.getX()), wholeLocalCOHelper(alpha[1], circle.getCenter().getY(), this.center.getX()));
			newRadius = wholeLocalCOHelper(alpha[2], circle.getRadius(), this.radius);
			offspring[1] = new EvolCircle(newPoint, newRadius);
		}
		return offspring;
	}
	
	/**
	 * Carries out a frequently used operation in Whole and Local Arithmetical Crossover.
	 * @param alpha (double)
	 * @param h1 (double)
	 * @param h2 (double)
	 * @return result (double)
	 */
	public double wholeLocalCOHelper(double alpha, double h1, double h2){
		return alpha * h1 + (1 - alpha) * h2;
	}

	@Override
	public EvolShape[] singleCrossover(EvolShape es) {
		EvolShape[] offspring = new EvolShape[]{this, es};
		
		if(es instanceof EvolCircle) {
			EvolCircle circle = (EvolCircle) es;
			if(Number.randomInt(0, 1) == 0){
				PointXY newPoint = new PointXY((this.center.getX() + circle.getCenter().getX()) / 2, (this.center.getY() + circle.getCenter().getY()) / 2);
				offspring[0] = new EvolCircle(newPoint, this.radius);
				offspring[1] = new EvolCircle(newPoint, circle.radius);
			} else {
				double newRadius = (this.radius + circle.getRadius()) / 2;
				offspring[0] = new EvolCircle(this.center, newRadius);
				offspring[1] = new EvolCircle(circle.getCenter(), newRadius);
			}
		}
		return offspring;
	}

	@Override
	public EvolShape blxAphaCrossover(EvolShape es, double alpha) {
		EvolShape offspring = this;
		
		if(es instanceof EvolCircle) {
			EvolCircle circle = (EvolCircle) es;
			double factor = 0;
			double[] sorted = new double[2];
			double[] xy = new double[2];
			double newRadius = 0;
			
			sorted = Number.sort(this.center.getX(), circle.getCenter().getX());
			factor = (sorted[1] - sorted[0]) * alpha;
			xy[0] = Number.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			sorted = Number.sort(this.center.getY(), circle.getCenter().getY());
			factor = (sorted[1] - sorted[0]) * alpha;
			xy[1] = Number.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			sorted = Number.sort(this.radius, circle.getRadius());
			factor = (sorted[1] - sorted[0]) * alpha;
			newRadius = Number.randomDouble(sorted[0] - factor, sorted[1] + factor);
			
			offspring = new EvolCircle(new PointXY(xy[0], xy[1]), newRadius);
		}
		return offspring;
	}
	
	/**
	 * Returns string representation of circle.
	 */
	public String toString() {
		return "Shape: Circle, Center: " + center.toString() + ", Radius: "
				+ this.radius + ", Area: " + getArea();
	}
}
