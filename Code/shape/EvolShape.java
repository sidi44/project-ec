package Shapes;

/**
 * Requirements for each shape.
 */
public interface EvolShape extends Shape {
	
	/**
	 * Uniform Mutation.
	 * @param centerMin (PointXY)
	 * @param centerMax (PointXY)
	 * @param vertexMin (PointXY)
	 * @param vertexMax (PointXY)
	 */
	void uniformMutation(PointXY centerMin, PointXY centerMax, PointXY vertexMin, PointXY vertexMax);
	
	/**
	 * Non-uniform Mutation.
	 * @param centerMin (PointXY)
	 * @param centerMax (PointXY)
	 * @param vertexMin (PointXY)
	 * @param vertexMax (PointXY)
	 * @param currentGen (int)
	 * @param maxGen (int)
	 * @param b (double)
	 */
	void nonUniformMutation(PointXY centerMin, PointXY centerMax, PointXY vertexMin, PointXY vertexMax, int currentGen, int maxGen, double b);
	
	/**
	 * Flat Crossover.
	 * @param es (EvolShape)
	 * @return offspring (EvolShape)
	 */
	EvolShape flatCrossover(EvolShape es);
	
	/**
	 * Simple Crossover.
	 * @param es (EvolShape)
	 * @return offspring (EvolShape[])
	 */
	EvolShape[] simpleCrossover(EvolShape es);
	
	/**
	 * Whole Arithmetical Crossover.
	 * @param es (EvolShape)
	 * @return offspring (EvolShape[])
	 */
	EvolShape[] wholeCrossover(EvolShape es);
	
	/**
	 * Local Arithmetical Crossover.
	 * @param es (EvolShape)
	 * @return offspring (EvolShape[])
	 */
	EvolShape[] localCrossover(EvolShape es);
	
	/**
	 * Single Arithmetical Crossover.
	 * @param es (EvolShape)
	 * @return offspring (EvolShape[])
	 */
	EvolShape[] singleCrossover(EvolShape es);
	
	/**
	 * BLX-alpha Crossover.
	 * @param es (EvolShape)
	 * @param alpha (double)
	 * @return offspring (EvolShape)
	 */
	EvolShape blxAphaCrossover(EvolShape es, double alpha);

}
