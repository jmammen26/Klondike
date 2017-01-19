package JumpFunction;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Jeevan on 11/19/16.
 */
public class RandomJumpFunction {


    public Set<Solution> bestSolutions;
    public SolutionCost currentBestCost;
    public int temperature;
    public double threshold;
    public long timeDurationToRunForInMillis;

    public Set<Solution> jumpRandomlyAndFindBestSolutions(Set<Container> solutionSpace, int clusterSize, Requirements requirements) {
        long timeToRunTill = timeDurationToRunForInMillis + System.currentTimeMillis();
        Solution initialSolution = Solution.genrateRandomInitialState(solutionSpace, requirements);
        currentBestCost = SolutionCost.maxCost();
        bestSolutions.add(initialSolution);
        while (timeToRunTill > System.currentTimeMillis()) {
            Solution newSolutionToJumpToo = initialSolution.swapAndCreateNewSolution();
            initialSolution = jumpIfInitialSolutionIsBetter(initialSolution, newSolutionToJumpToo);
            SolutionCost costOfSolutionToJumpToo = initialSolution.getCost();
            if (costOfSolutionToJumpToo.compareTo(currentBestCost) > 0) {
                currentBestCost = costOfSolutionToJumpToo;

            }
            if (bestSolutions.add(initialSolution)) {

            }
        }
        return bestSolutions;
    }

    private Solution jumpIfInitialSolutionIsBetter(Solution initialSolution, Solution newSolutionToJumpToo) {
        if (initialSolution.getCost().compareTo(newSolutionToJumpToo.getCost()) > 0) {
            int degrees = (int) (Math.random() * temperature);
            if (degrees > threshold) {
                return newSolutionToJumpToo;
            } else {
                return initialSolution;
            }
        } else {
            return newSolutionToJumpToo;
        }
    }
}
