package geneticAlgorithm;

import shape.Shape;

/**
 * An Individual used in Evolutionary Computation.
 * 
 * Individuals should be able to return a numerical valuation of their fitness
 * as well as return the Shape representation of themselves.
 * 
 * @author Simon Dicken
 * @version 2014-12-06
 */
public interface Individual {

	/**
	 * Method to obtain a numerical representation of the fitness of the 
	 * Individual based on some criteria.
	 * 
	 * @return the fitness value of the Individual.
	 */
	double getFitness();
	
	/**
	 * Method to obtain the Shape of the Individual.
	 * 
	 * @return the Shape representation of the Individual.
	 */
	Shape getShape();
	
}
