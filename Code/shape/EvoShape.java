package shape;

/**
 * A shape which represents the appearance of an Individual in Evolutionary
 * Computation.
 * 
 * An EvoShape can be mutated or used in cross-over to create EvoShapes with
 * different properties.
 * 
 * @author Martin Wong
 * @version 2015-01-05
 */
public interface EvoShape extends Shape {
	
	/**
	 * Uniform Mutation, it alters the center or area of an EvoShape.
	 * 
	 * @param ep (EvoParameters)
	 */
	void uniformMutation(EvoParameters ep);
	
	/**
	 * Non-uniform Mutation, it alters the center or area of an EvoShape.
	 * 
	 * @param ep (EvoParameters)
	 * @param currentGen (int)
	 * @param maxGen (int)
	 */
	void nonUniformMutation(EvoParameters ep, int currentGen, int maxGen);
	
	/**
	 * Generates offspring by Flat Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 1 (EvoShape)
	 */
	EvoShape flatCrossover(EvoShape es);
	
	/**
	 * Generates offspring by Simple Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 (EvoShape[])
	 */
	EvoShape[] simpleCrossover(EvoShape es);
	
	/**
	 * Generates offspring by Whole Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 (EvoShape[])
	 */
	EvoShape[] wholeCrossover(EvoShape es);
	
	/**
	 * Generates offspring by Local Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 (EvoShape[])
	 */
	EvoShape[] localCrossover(EvoShape es);
	
	/**
	 * Generates offspring by Single Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 (EvoShape[])
	 */
	EvoShape[] singleCrossover(EvoShape es);
	
	/**
	 * Generates offspring by BLX-alpha Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @param ep (EvoParemeters)
	 * @return offspring: 1 (EvoShape)
	 */
	EvoShape blxAphaCrossover(EvoShape es, EvoParameters ep);

}
