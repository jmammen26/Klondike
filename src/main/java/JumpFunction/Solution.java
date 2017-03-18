package JumpFunction;

import jdk.nashorn.internal.runtime.ScriptObject;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;

import java.util.List;
import java.util.Set;

import static org.eclipse.collections.impl.factory.Iterables.mList;
import static org.eclipse.collections.impl.list.mutable.FastList.newList;

/**
 * Created by Jeevan on 12/14/16.
 */
public class Solution {
    private List<ServiceContainer> containersInSolution;
    public Solution(){}
    public Solution(List<ServiceContainer> containersInSolution){
        this.containersInSolution=containersInSolution;
    }
    public static Solution genrateRandomInitialState(List<ServiceContainer> solutionSpace, int numberOfInstances) {
        MutableList<ServiceContainer> serviceContainers = mList();
        while(solutionSpace.size()<numberOfInstances){
            serviceContainers.add(solutionSpace.get((int) (Math.random()*solutionSpace.size())));
        }
        return new Solution(serviceContainers);
    }

    public SolutionCost getCost() {
        return new SolutionCost();
    }

    public Solution swapAndCreateNewSolution() {
        return null;
    }

    public List<ServiceContainer> getContainersInSolution() {
        return containersInSolution;
    }

    public void setContainersInSolution(List<ServiceContainer> containersInSolution) {
        this.containersInSolution = containersInSolution;
    }

    public List<ServiceContainer> getContainers() {
        return containersInSolution;
    }
}
