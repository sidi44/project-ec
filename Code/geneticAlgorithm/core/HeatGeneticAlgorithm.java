package geneticAlgorithm.core;

import geneticAlgorithm.function.HeatFunction;
import geometry.PointXY;
import geometry.Shape;

import java.util.Random;

/**
 * 
 * @author Simon Dicken
 * @version 2015-02-22
 */
public class HeatGeneticAlgorithm<T extends Shape> extends GeneticAlgorithm<T> {

	private double globalTemp;
	private double minTemp;
	private double maxTemp;
	
	public HeatGeneticAlgorithm(
			Population<Individual<T>> pop, 
			EvoParams<T> evoParams, 
			GenerationalParams genParams,
			HeatFunction<T> function,
			double minTemp,
			double maxTemp
	) {
		super(pop, evoParams, genParams, function);
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		calculateGlobalTemp(0);
	}
	
	@Override
	protected void calculateFitness(Population<Individual<T>> population) {
		
		getFunction().setGlobalTemp(globalTemp);
		getFunction().setPopulation(getPop());
		
		super.calculateFitness(population);
		
	}
	
	private void calculateGlobalTemp(int generation) {
		
		int yearLength = 400;
		
		int seasonIndicator = generation % yearLength;
		double seasonTempValue = (maxTemp - minTemp)/4;
		int factor = 0;
		if (seasonIndicator < (yearLength/4)) {
			// Winter
			factor = 0;
		} else if (seasonIndicator < (yearLength/2)) {
			// Spring
			factor = 2;
		} else if (seasonIndicator < (3*yearLength/4)) {
			// Summer
			factor = 3;
		} else {
			// Autumn
			factor = 1;
		}
		double mean = minTemp + (seasonTempValue * factor) + (seasonTempValue/2);
		double stddev = 5; //seasonTempValue;
		
		Random r = new Random();
		this.globalTemp = r.nextGaussian()*stddev + mean;
	}

	@Override
	protected void additionalActions() {
		calculateGlobalTemp(getCurrentGen());
		printSummary(currentGen);
	}
	
	private void printSummary(int epoch) {
		
		System.out.println("Epoch: " + epoch);
		System.out.println("Global temperature : " + globalTemp);
		System.out.println("Best fitness: " + getPop().getMax().getFitness());
		System.out.println("Best radius: " + Math.sqrt(getPop().getMax().getRepresentation().getArea()/Math.PI));
		System.out.println("Worst fitness: " + getPop().getMin().getFitness());
		System.out.println("Worst radius: " + Math.sqrt(getPop().getMin().getRepresentation().getArea()/Math.PI));
		System.out.println("Best - worst: " + (getPop().getMax().getFitness() - getPop().getMin().getFitness()));
		System.out.println("Population size: " + getPop().size());
		System.out.println(" ");
		printPopulation();
	}
	
	@Override
	public HeatFunction<T> getFunction() {
		return (HeatFunction<T>) super.getFunction();
	}
	
	public void printPopulation() {
		
		int size = getPop().size();
		for (int i=0; i<size; ++i) {
			Individual<T> ind = getPop().getNthMax(i);
			Shape s = ind.getRepresentation();
			PointXY centre = s.getReference();
			double radius = Math.sqrt(s.getArea() / Math.PI);
			System.out.println("Ind " + i + ": Radius = " + radius + ", X coord = " + centre.getX() + ", Y coord = " + centre.getY());
		}
		System.out.println(" ");
	}
	
}
