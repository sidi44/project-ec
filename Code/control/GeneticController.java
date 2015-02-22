package control;

import geneticAlgorithm.core.GenerationalParams;
import geneticAlgorithm.core.GeneticAlgorithm;
import geneticAlgorithm.core.Individual;
import geneticAlgorithm.core.Population;
import geometry.Shape;
import gui.Renderer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Simon Dicken
 * @version 2015-02-22
 */
public class GeneticController<T extends Shape> {

	private GeneticAlgorithm<T> genAlg;
	private Renderer rend;
	
	public GeneticController(GeneticAlgorithm<T> genAlg, Renderer rend) {
		this.genAlg = genAlg;
		this.rend = rend;
	}
	
	public void start() {
		
		GenerationalParams genParams = genAlg.getGenParams();
		int maxIteration = genParams.getMaxIteration();
		
		for (int i=0; i<maxIteration; ++i) {
			genAlg.nextIteration();
			List<Shape> shapes = new ArrayList<Shape>();
			fillShapes(shapes);
			
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				
			}
			
			rend.renderShapes(shapes);
		}
		
	}
	
	private void fillShapes(List<Shape> shapes) {
		Population<Individual<T>> pop = genAlg.getPop();
		int size = pop.size();
		
		for (int i=0; i<size; ++i) {
			Shape s = pop.getNthMax(i).getRepresentation();
			shapes.add(s);
		}
	}
}
