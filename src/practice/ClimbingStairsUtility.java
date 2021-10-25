package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingStairsUtility {
	
	private static void findAllPossibleWaysToClimbStairs(List<String> op, int[] possibleSteps, int stairLen, int stepsTook, String steps) {
		if (stepsTook>stairLen) {
			return;
		}
		
		for (int i=0; i<possibleSteps.length; i++) {
			findAllPossibleWaysToClimbStairs(op, possibleSteps, stairLen, stepsTook+possibleSteps[i], steps+possibleSteps[i]);
			if (stepsTook>=stairLen) {
				op.add(steps);
				return;
			}
		}
	}
	
	private static void findAllPossibleWaysToClimbStairsV2(List<Integer> op, int[] possibleSteps, int stairLen, int stepsTook) {
		if (stepsTook>stairLen) {
			return;
		}
		
		for (int i=0; i<possibleSteps.length; i++) {
			findAllPossibleWaysToClimbStairsV2(op, possibleSteps, stairLen, stepsTook+possibleSteps[i]);
			if (stepsTook>=stairLen) {
				op.set(0, op.get(0)+1);
				return;
			}
		}
	}
	

	public static void main(String[] args) {
		List<Integer> op = Arrays.asList(1);
		List<String> opp = new ArrayList<>();
		int[] possibleSteps = {1,2,3};
		int stairLen=2;
		int stepsTook=0;
		int count=0;
		ClimbingStairsUtility.findAllPossibleWaysToClimbStairs(opp, possibleSteps, stairLen, stepsTook, "");
		ClimbingStairsUtility.findAllPossibleWaysToClimbStairsV2(op, possibleSteps, stairLen, stepsTook);
		System.out.println(op.get(0));
		System.out.println(opp);
	}

}
