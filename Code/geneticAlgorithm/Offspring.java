package geneticAlgorithm;

import java.util.ArrayList;
import java.util.List;

import shape.EvoShape;

/**
 * The Offspring class encapsulates a list of Offspring generated from a 
 * genetic algorithm's crossover procedure.
 * 
 * The class is parameterised by any class which extends EvoShape.
 * 
 * @author Simon Dicken
 * @version 2015-01-11
 */
public class Offspring<T extends EvoShape> {

	// The list of EvoShapes that form the Offspring.
	List<T> offspringList;
	
	/**
	 * Constructor for Offspring.
	 * Creates an empty list of Offspring.
	 */
	public Offspring() {
		offspringList = new ArrayList<T>();
	}
	
	/**
	 * Add a new offspring to the group of Offspring.
	 * 
	 * @param newOffspring - the new Offspring to add to the group.
	 */
	public void addOffspring(T newOffspring) {
		offspringList.add(newOffspring);
	}
	
	/**
	 * Method to obtain the list of offspring.
	 * 
	 * @return the list of offspring.
	 */
	public List<T> getOffspringList() {
		return offspringList;
	}
	
}
