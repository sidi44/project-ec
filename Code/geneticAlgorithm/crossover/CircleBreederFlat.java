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
public class CircleBreederFlat extends CircleBreeder {

	
	public CircleBreederFlat(WorldLimits wLimits, CircleLimits cLimits, 
			Random rand) {
		super(wLimits, cLimits, rand);
	}

	@Override
	public List<Circle> crossover(Circle c1, Circle c2) {
		
		List<Circle> offspring = new ArrayList<Circle>();

		int count = 0;
		
		Circle newCircle = null;
		
		do {
			
			double sorted[] = new double[2];
				
			sorted = NumberUtils.sortAscending(c1.getReference().getX(), c2.getReference().getX());
			double newX = NumberUtils.randomDouble(sorted[0], sorted[1]);
				
			sorted = NumberUtils.sortAscending(c1.getReference().getY(), c2.getReference().getY());
			double newY = NumberUtils.randomDouble(sorted[0], sorted[1]);
				
			sorted = NumberUtils.sortAscending(c1.getRadius(), c2.getRadius());
			double newRadius = NumberUtils.randomDouble(sorted[0], sorted[1]);
				
			newCircle = new Circle(new PointXY(newX, newY), newRadius);
		
			if (count > 100) {
				System.exit(0);
			}
			
		} while(!checkCircle(newCircle));
		
		offspring.add(newCircle);
		
		return offspring;
	}

}
