package geneticAlgorithm.mutation;

import geometry.Circle;
import geometry.CircleLimits;
import geometry.ShapeChecker;
import geometry.WorldLimits;

import java.util.Random;

/**
 * 
 * @author Simon Dicken
 * @version 2015-02-22
 */
public abstract class CircleMutator implements Mutator<Circle> {

	protected WorldLimits wLimits;
	protected CircleLimits cLimits;
	protected Random rand;
	private int currentGen;
	
	public CircleMutator(WorldLimits wLimits, CircleLimits cLimits, Random rand) {
		this.wLimits = wLimits;
		this.cLimits = cLimits;
		this.rand = rand;
		this.currentGen = 0;
	}
	
	protected boolean checkCircle(Circle c) {
		
		ShapeChecker checker = new ShapeChecker();
		return checker.checkCircle(c, cLimits, wLimits);
		
	}
	
	@Override
	public void setCurrentGen(int currentGen) {
		this.currentGen = currentGen;
	}
	
	protected int getCurrentGen() {
		return currentGen;
	}
	
}
