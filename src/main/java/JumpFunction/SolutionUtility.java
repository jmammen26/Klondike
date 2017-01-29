package JumpFunction;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.List;
import java.util.Set;

import static org.eclipse.collections.impl.factory.Iterables.mList;

/**
 * Created by Jeevan on 1/26/17.
 */
public class SolutionUtility {
    public  Solution genrateRandomInitialState(final List<Container> solutionSpace, Requirements requirements) {
        MutableList<Integer> randomContainerSlots = FastList.newList();
        for(int i = 0 ; i < requirements.getNumberOfInstances(); i ++){
            randomContainerSlots.add((int) (Math.random() * solutionSpace.size()));
        }
        return new Solution(randomContainerSlots.collect(num -> solutionSpace.get(num)));

    }
    public Solution swapAndCreateNewSolution(Solution currentSolution,List<Container> solutionSpace){
        int randomIndexInSolutionSpace = (int) Math.random() * solutionSpace.size();
        int randomIndexInCurrentSolution = (int) Math.random() * currentSolution.getContainers().size();
        Container containerToSwapWith=solutionSpace.get(randomIndexInSolutionSpace);
        return swapContainerInSlot(currentSolution,containerToSwapWith,randomIndexInCurrentSolution);
    }
    public Solution swapContainerInSlot(Solution originalSolution,Container containerToSwapWith, int randomIndexInCurrentSolution) {
        MutableList<Container> newSolutionsContainers= FastList.newList(originalSolution.getContainers());
        newSolutionsContainers.set(randomIndexInCurrentSolution,containerToSwapWith);
        return new Solution(newSolutionsContainers);
    }
}
