package geneticAlgorithm.crossover;

import geometry.Circle;
import geometry.CircleLimits;
import geometry.PointXY;
import geometry.WorldLimits;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.NumberUtils;

/**
 * 
 * @author Simon Dicken, Martin Wong
 * @version 2015-02-22
 */
public class CircleBreederBLXAlpha extends CircleBreeder {

	private double alpha;
	
	public CircleBreederBLXAlpha(WorldLimits wLimits, CircleLimits cLimits, 
			Random rand, double alpha) {
		super(wLimits, cLimits, rand);
		
		this.alpha = alpha;
	}

	@Override
	public List<Circle> crossover(Circle c1, Circle c2) {
		
		List<Circle> offspring = new ArrayList<Circle>();

		int count = 0;
		
		Circle newCircle = null;
		
		do {
		
			double[] sorted = new double[2];
			double factor = 0;
			double newX = 0;
			double newY = 0;
			double newRadius = 0;

			sorted = NumberUtils.sortAscending(c1.getReference().getX(), c2.getReference().getX());
			factor = (sorted[1] - sorted[0]) * alpha;
			newX = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);

			sorted = NumberUtils.sortAscending(c1.getReference().getY(), c2.getReference().getY());
			factor = (sorted[1] - sorted[0]) * alpha;
			newY = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);

			sorted = NumberUtils.sortAscending(c1.getRadius(), c2.getRadius());
			factor = (sorted[1] - sorted[0]) * alpha;
			newRadius = NumberUtils.randomDouble(sorted[0] - factor, sorted[1] + factor);

			newCircle = new Circle(new PointXY(newX, newY), newRadius);
		
			if (count > 100) {
				System.exit(0);
			}
			
		} while(!checkCircle(newCircle));
		
		offspring.add(newCircle);
		
		return offspring;
	}

}
