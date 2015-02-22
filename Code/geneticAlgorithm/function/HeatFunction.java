package geneticAlgorithm.function;

import geneticAlgorithm.core.Individual;
import geneticAlgorithm.core.Population;
import geometry.Shape;

/**
 * 
 * @author Simon Dicken
 * @version 2015-02-22
 */
public class HeatFunction<T extends Shape> implements Function<T> {
	
	private double globalTemp;
	private double optimumTemp;
	private Population<? extends Individual<T>> pop;

	public HeatFunction(
			double globalTemp, 
			double optimumTemp, 
			Population<? extends Individual<T>> pop) 
	{
		this.globalTemp = globalTemp;
		this.optimumTemp = optimumTemp;
		this.pop = pop;
	}
	
	@Override
	public void evaluate(Individual<T> ind) {
		
		// currently ignoring the 'heat' from the rest of the population.
		
		Shape shape = ind.getRepresentation();
		double temp = globalTemp + shape.getArea()/5;
		double fitness = 50.0 / (Math.abs(temp - optimumTemp));
		ind.setFitness(fitness);
		
		// obviously get rid of this:
		pop.size();
	}
	
	public void setGlobalTemp(double globalTemp) {
		this.globalTemp = globalTemp;
	}
	
	public void setOptimumTemp(double optimumTemp) {
		this.optimumTemp = optimumTemp;
	}
	
	public void setPopulation(Population<? extends Individual<T>> pop) {
		this.pop = pop;
	}	
	

}
