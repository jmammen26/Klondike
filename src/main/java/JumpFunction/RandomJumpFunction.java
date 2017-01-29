package JumpFunction;


import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


/**
 * Created by Jeevan on 11/19/16.
 */
public class RandomJumpFunction {

    public List<Container> solutionSpace;
    public Set<Solution> bestSolutions;
    public SolutionCost currentBestCost;
    public int temperature;
    public double threshold;
    public long timeDurationToRunForInMillis;
    public SolutionUtility solutionUtility;

    public RandomJumpFunction(List<Container> sampleSpace){
        solutionUtility = new SolutionUtility();

    }
    public Set<Solution> jumpRandomlyAndFindBestSolutions(int clusterSize, Requirements requirements) {
        long timeToRunTill = timeDurationToRunForInMillis + System.currentTimeMillis();
        Solution initialSolution = solutionUtility.genrateRandomInitialState(solutionSpace, requirements);
        currentBestCost = SolutionCost.maxCost();
        bestSolutions.add(initialSolution);
        while (timeToRunTill > System.currentTimeMillis()) {
            Solution newSolutionToJumpToo = solutionUtility.swapAndCreateNewSolution(initialSolution,solutionSpace);
            initialSolution = jumpIfInitialSolutionIsBetter(initialSolution, newSolutionToJumpToo);
            SolutionCost costOfSolutionToJumpToo = initialSolution.getCost();
            if (costOfSolutionToJumpToo.compareTo(currentBestCost) > 0) {
                currentBestCost = costOfSolutionToJumpToo;
                bestSolutions.add(initialSolution);
            } else if (costOfSolutionToJumpToo.compareTo(currentBestCost) == 0){
                bestSolutions.add(initialSolution);
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
