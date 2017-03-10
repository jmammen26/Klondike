package JumpFunction;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.List;

import static org.eclipse.collections.impl.factory.Iterables.mList;

/**
 * Created by Jeevan on 1/26/17.
 */
public class SolutionUtility {
    public  Solution genrateRandomInitialState(final List<ServiceContainer> solutionSpace, Requirements requirements) {
        MutableList<Integer> randomContainerSlots = FastList.newList();
        for(int i = 0 ; i < requirements.getNumberOfInstances(); i ++){
            randomContainerSlots.add((int) (Math.random() * solutionSpace.size()));
        }
        return new Solution(randomContainerSlots.collect(num -> solutionSpace.get(num)));

    }
    public Solution swapAndCreateNewSolution(Solution currentSolution,List<ServiceContainer> solutionSpace){
        int randomIndexInSolutionSpace = (int) Math.random() * solutionSpace.size();
        int randomIndexInCurrentSolution = (int) Math.random() * currentSolution.getContainers().size();
        ServiceContainer containerToSwapWith=solutionSpace.get(randomIndexInSolutionSpace);
        return swapContainerInSlot(currentSolution,containerToSwapWith,randomIndexInCurrentSolution);
    }
    public Solution swapContainerInSlot(Solution originalSolution, ServiceContainer containerToSwapWith, int randomIndexInCurrentSolution) {
        MutableList<ServiceContainer> newSolutionsContainers= FastList.newList(originalSolution.getContainers());
        newSolutionsContainers.set(randomIndexInCurrentSolution,containerToSwapWith);
        return new Solution(newSolutionsContainers);
    }
}
