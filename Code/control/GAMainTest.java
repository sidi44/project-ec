package control;

import java.util.Random;

import utils.NumberUtils;
import geneticAlgorithm.core.EvoParams;
import geneticAlgorithm.core.GenerationalParams;
import geneticAlgorithm.core.GeneticAlgorithm;
import geneticAlgorithm.core.HeatGeneticAlgorithm;
import geneticAlgorithm.core.Individual;
import geneticAlgorithm.core.Population;
import geneticAlgorithm.core.PopulationTreeSet;
import geneticAlgorithm.crossover.Breeder;
import geneticAlgorithm.crossover.CircleBreederBLXAlpha;
import geneticAlgorithm.function.HeatFunction;
import geneticAlgorithm.mutation.CircleMutatorNonUniform;
import geneticAlgorithm.mutation.Mutator;
import geneticAlgorithm.selection.Selector;
import geneticAlgorithm.selection.SelectorTournament;
import geometry.Circle;
import geometry.CircleLimits;
import geometry.PointXY;
import geometry.ShapeChecker;
import geometry.WorldLimits;
import gui.Renderer;

/**
 * 
 * 
 * @author Simon Dicken
 * @version 2015-02-22
 */
public class GAMainTest {

	public static void main(String[] args) {
		
		long t0 = System.currentTimeMillis();
		
		int pixelWidth = 640;
		int pixelHeight= 480;
		double unitsToPixels = 2;
		
		WorldLimits wLimits = new WorldLimits(0, 0, pixelWidth / unitsToPixels, pixelHeight / unitsToPixels);
		CircleLimits cLimits = new CircleLimits(5, 30);
		
		GenerationalParams genParams = new GenerationalParams(10000, 10, 2, 1.0, 0.5);
		
		Selector<Circle> s = new SelectorTournament<Circle>(2);
		Mutator<Circle> m = new CircleMutatorNonUniform(wLimits, cLimits, new Random(), 0.5, genParams.getMaxIteration());
		//Breeder<Circle> b = new CircleBreederFlat(wLimits, cLimits, new Random());
		Breeder<Circle> b = new CircleBreederBLXAlpha(wLimits, cLimits, new Random(), 0.5);
		EvoParams<Circle> evoParams = new EvoParams<Circle>(s, m, b);
		
		
		//List<Individual> initialPop = new ArrayList<Individual>();
		Population<Individual<Circle>> pop = new PopulationTreeSet<Individual<Circle>>();
		
		for (int i=0; i<genParams.getPopSize(); ++i) {

			Circle c = null;
			ShapeChecker checker = new ShapeChecker();
			
			do {

				double xRef = NumberUtils.randomDouble(wLimits.getMinX(), wLimits.getMaxX());
				double yRef = NumberUtils.randomDouble(wLimits.getMinY(), wLimits.getMaxY());
				double radius = NumberUtils.randomDouble(cLimits.getMinR(), cLimits.getMaxR());
				c = new Circle(new PointXY(xRef, yRef), radius); 
				
			} while (!checker.checkCircle(c, cLimits, wLimits));
			
			Individual<Circle> ind = new Individual<Circle>(c);
			pop.insert(ind);
		}
		
		HeatFunction<Circle> func = new HeatFunction<Circle>(0, 38, pop);
		
		GeneticAlgorithm<Circle> ga = new HeatGeneticAlgorithm<Circle>(pop, evoParams, genParams, func, -100.0, 30.0);
		Renderer rend = new Renderer(pixelWidth, pixelHeight, unitsToPixels);
		
		GeneticController<Circle> gc = new GeneticController<Circle>(ga, rend);
		gc.start();
		
		long t1 = System.currentTimeMillis();
		
		System.out.println("Run time = " + (t1-t0) + "ms");
		
	}
	
}
