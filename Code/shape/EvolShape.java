package shapes;

/**
 * A shape which represents the appearance of an Individual in Evolutionary
 * Computation.
 * 
 * An EvolShape can be mutated or used in cross-over to create EvolShapes with
 * different properties.
 * 
 * @author Martin Wong
 * @version 2014-12-07
 */
public interface EvolShape extends Shape {
	
	/**
	 * Uniform Mutation, it alters the center or area of an EvolShape.
	 * 
	 * @param centerMin (PointXY)
	 * @param centerMax (PointXY)
	 * @param vertexMin (PointXY)
	 * @param vertexMax (PointXY)
	 */
	void uniformMutation(PointXY centerMin, PointXY centerMax,
						 PointXY vertexMin, PointXY vertexMax);
	
	/**
	 * Non-uniform Mutation, it alters the center or area of an EvolShape.
	 * 
	 * @param centerMin (PointXY)
	 * @param centerMax (PointXY)
	 * @param vertexMin (PointXY)
	 * @param vertexMax (PointXY)
	 * @param currentGen (int)
	 * @param maxGen (int)
	 * @param b (double)
	 */
	void nonUniformMutation(PointXY centerMin, PointXY centerMax,
							PointXY vertexMin, PointXY vertexMax,
							int currentGen, int maxGen, double b);
	
	/**
	 * Generates offspring by Flat Crossover with another EvolShape.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 1 (EvolShape)
	 */
	EvolShape flatCrossover(EvolShape es);
	
	/**
	 * Generates offspring by Simple Crossover with another EvolShape.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 2 (EvolShape[])
	 */
	EvolShape[] simpleCrossover(EvolShape es);
	
	/**
	 * Generates offspring by Whole Arithmetical Crossover with another
	 * EvolShape.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 2 (EvolShape[])
	 */
	EvolShape[] wholeCrossover(EvolShape es);
	
	/**
	 * Generates offspring by Local Arithmetical Crossover with another
	 * EvolShape.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 2 (EvolShape[])
	 */
	EvolShape[] localCrossover(EvolShape es);
	
	/**
	 * Generates offspring by Single Arithmetical Crossover with another
	 * EvolShape.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @return offspring: 2 (EvolShape[])
	 */
	EvolShape[] singleCrossover(EvolShape es);
	
	/**
	 * Generates offspring by BLX-alpha Crossover with another EvolShape.
	 * 
	 * @param es, the second parent (EvolShape)
	 * @param alpha, a constant (double)
	 * @return offspring: 2 (EvolShape)
	 */
	EvolShape blxAphaCrossover(EvolShape es, double alpha);

}
