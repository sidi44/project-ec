package geneticAlgorithm;

import java.util.List;

/**
 * A Population used in Evolutionary Computation.
 * 
 * A Population should be comprised of a collection of Individuals. It should 
 * be possible to manipulate the Population by adding/removing Individuals and
 * also 'peek' at the Population. 
 * 
 * @author Simon Dicken
 * @version 2014-12-06
 */
public interface Population {

	/**
	 * Method to insert the given Individual into the Population.
	 * 
	 * @param ind - the Individual to insert.
	 * @return true if the Individual is successfully inserted, false 
	 * otherwise.
	 */
	public boolean insert(Individual ind);
	
	/**
	 * Removes the Individual with the highest fitness value from the 
	 * Population.
	 * The Individual is discarded.
	 */
	public void removeMax();
	
	/**
	 * Removes the Individual with the lowest fitness value from the 
	 * Population.
	 * The Individual is discarded.
	 */
	public void removeMin();	
	
	/**
	 * Removes the N Individuals with the highest fitness values from the 
	 * Population.
	 * The Individuals are discarded.
	 * 
	 * @param n - the number of Individuals to remove from the Population.
	 */
	public void removeMaxN(int n);
	
	/**
	 * Removes the N Individuals with the lowest fitness values from the 
	 * Population.
	 * The Individuals are discarded.
	 * 
	 * @param n - the number of Individuals to remove from the Population.
	 */
	public void removeMinN(int n);
	
	/**
	 * Removes the Individual with nth the highest fitness value from the 
	 * Population.
	 * The Individual is discarded.
	 * 
	 * @param n - the rank of the Individual to remove (high-low). 
	 * 0 is the top-ranked individual, (size-1) is the bottom ranked 
	 * Individual.
	 */
	public void removeNthMax(int n);
	
	/**
	 * Removes the Individual with nth the lowest fitness value from the 
	 * Population.
	 * The Individual is discarded.
	 * 
	 * @param n - the rank of the Individual to remove (low-high). 
	 * 0 is the top-ranked individual, (size-1) is the bottom ranked 
	 * Individual.
	 */
	public void removeMinNth(int n);
	
	/**
	 * Obtains the Individual with the highest fitness value from the 
	 * Population.
	 * The Individual is not removed from the Population.
	 * 
	 * @return the Individual with the highest fitness value.
	 */
	public Individual getMax();
	
	/**
	 * Obtains the Individual with the lowest fitness value from the 
	 * Population.
	 * The Individual is not removed from the Population.
	 * 
	 * @return the Individual with the lowest fitness value.
	 */
	public Individual getMin();	
	
	/**
	 * Obtains the Individual with the nth highest fitness value from the 
	 * Population.
	 * The Individual is not removed from the Population.
	 * 
	 * @param n - the rank of the Individual to remove (high-low). 
	 * 0 is the top-ranked individual, (size-1) is the bottom ranked 
	 * Individual.
	 * @return the nth ranked Individual in the Population (high-low).
	 */
	public Individual getNthMax(int n);
	
	/**
	 * Obtains the Individual with the nth lowest fitness value from the 
	 * Population.
	 * The Individual is not removed from the Population.
	 * 
	 * @param n - the rank of the Individual to remove (low-high). 
	 * 0 is the top-ranked individual, (size-1) is the bottom ranked 
	 * Individual.
	 * @return the nth ranked Individual in the Population (low-high).
	 */
	public Individual getNthMin(int n);
	
	/**
	 * Obtains the list of all Individuals of which the Population is 
	 * comprised.
	 * 
	 * @return the list of all Individuals of which the Population is 
	 * comprised.
	 */
	public List<Individual> getAll();
	
}
