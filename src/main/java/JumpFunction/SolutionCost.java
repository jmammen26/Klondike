package JumpFunction;

import java.util.List;

/**
 * Created by Jeevan on 12/14/16.
 */
public class SolutionCost {
    public List<MappedWeight<ContainerHeirarchyLevel,MathExpression>> weightsOfSolution;
    public int compareTo(SolutionCost cost) {
        return 0;
    }
    public static SolutionCost maxCost() {
        return new SolutionCost();
    }
}
