package shape;

import java.util.List;

import geneticAlgorithm.WorldLimits;

/**
 * A shape which represents the appearance of an Individual in Evolutionary
 * Computation.
 * 
 * An EvoShape can be mutated or used in cross-over to create EvoShapes with
 * different properties.
 * 
 * @author Martin Wong
 * @version 2015-01-15
 */
public interface EvoShape extends Shape {
	
	/**
	 * Uniform Mutation, it alters the center or area of an EvoShape.
	 * 
	 * @param wLimits (WorldLimits)
	 */
	void uniformMutation(WorldLimits wLimits);
	
	/**
	 * Non-uniform Mutation, it alters the center or area of an EvoShape.
	 * 
	 * @param wLimits (WorldLimits)
	 * @param currentGen (int)
	 * @param maxGen (int)
	 */
	void nonUniformMutation(WorldLimits wLimits, double b, int currentGen, int maxGen);
	
	/**
	 * Generates offspring by Flat Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 1 EvoShape (List<EvoShape>)
	 */
	List<EvoShape> flatCrossover(EvoShape es);
	
	/**
	 * Generates offspring by Simple Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 EvoShapes (List<EvoShape>)
	 */
	List<EvoShape> simpleCrossover(EvoShape es);
	
	/**
	 * Generates offspring by Whole Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 EvoShapes (List<EvoShape>)
	 */
	List<EvoShape> wholeCrossover(EvoShape es);
	
	/**
	 * Generates offspring by Local Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 EvoShapes (List<EvoShape>)
	 */
	List<EvoShape> localCrossover(EvoShape es);
	
	/**
	 * Generates offspring by Single Arithmetical Crossover with another
	 * EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @return offspring: 2 EvoShapes (List<EvoShape>)
	 */
	List<EvoShape> singleCrossover(EvoShape es);
	
	/**
	 * Generates offspring by BLX-alpha Crossover with another EvoShape.
	 * 
	 * @param es, the second parent (EvoShape)
	 * @param ep (EvoParemeters)
	 * @return offspring: 1 EvoShape (List<EvoShape>)
	 */
	List<EvoShape> blxAphaCrossover(EvoShape es, WorldLimits wLimits, double alpha);

}
