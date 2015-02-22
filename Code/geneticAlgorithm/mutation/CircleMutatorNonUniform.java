package geneticAlgorithm.mutation;

import geometry.Circle;
import geometry.CircleLimits;
import geometry.PointXY;
import geometry.WorldLimits;

import java.util.Random;

import utils.NumberUtils;

/**
 * 
 * @author Simon Dicken, Martin Wong
 * @version 2015-02-22
 */
public class CircleMutatorNonUniform extends CircleMutator {

	private double b;
	private double maxGen;
	
	public CircleMutatorNonUniform(WorldLimits wLimits, CircleLimits cLimits, 
			Random rand, double b, double maxGen) {
		super(wLimits, cLimits, rand);

		this.b = b;
		this.maxGen = maxGen;
		
	}

	@Override
	public void mutate(Circle c) {
		
		// Used to check for infinite loop.
		int count = 0;

		PointXY oldRef = c.getReference();
		double oldRadius = c.getRadius();

		do {
			// Randomly select a gene to mutate.
			// 0 = reference, 1 = radius.
			int geneSelect = NumberUtils.randomInt(0, 1);

			// Ensure we reset any invalid changes to the reference/radius whilst looping.
			c.setReference(oldRef);
			c.setRadius(oldRadius);

			if (geneSelect == 0) { // For reference

				PointXY newRef = mutateReference(oldRef);
				c.setReference(newRef);

			} else { // For radius

				double newRadius = mutateRadius(oldRadius);
				c.setRadius(newRadius);

			}

			++count;
			if (count > 100) {
				// We've been through a lot of loops, something really doesn't look right...
				// (This should be changed to something more reasonable at some point)
				System.err.println("Error during mutation. Exiting...");
				System.exit(0);
			}

		} while(!checkCircle(c));

	}

	private PointXY mutateReference(PointXY oldRef) {
		
		double refMinX = wLimits.getMinX() + this.cLimits.getMinR();
		double refMaxX = wLimits.getMaxX() - this.cLimits.getMinR();
		double refMinY = wLimits.getMinY() + this.cLimits.getMinR();
		double refMaxY = wLimits.getMaxY() - this.cLimits.getMinR();

		double newX = mutateGeneNonUniform(oldRef.getX(), refMinX, refMaxX);
		double newY = mutateGeneNonUniform(oldRef.getY(), refMinY, refMaxY);
		
		return new PointXY(newX, newY);
	}
	
	private double mutateRadius(double oldRadius) {
		
		double radMin = cLimits.getMinR();
		double radMax = cLimits.getMaxR();

		double newRadius = mutateGeneNonUniform(oldRadius, radMin, radMax);
		
		return newRadius;
	}
	
	private double mutateGeneNonUniform(double currentVal, double minVal, double maxVal) {
		
		double genFactor = (1.0 * getCurrentGen()) / maxGen;
		
		double r = NumberUtils.randomDouble(0, 1);
		double tPart = Math.pow(r, (1 - genFactor));
		double t = Math.pow((1 - tPart), b);
		
		double newGeneVal = 0;
		double tau = NumberUtils.randomDouble(0, 1);
		if (tau >= 0.5) {
			newGeneVal = currentVal + (maxVal - currentVal) * t;
		} else {
			newGeneVal = currentVal - (currentVal - minVal) * t;
		}
		
		return newGeneVal;
	}
	
	
	
}
