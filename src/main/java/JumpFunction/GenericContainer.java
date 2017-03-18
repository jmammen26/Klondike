package JumpFunction;

import java.util.List;

/**
 * Created by Jeevan on 3/10/17.
 */
public class GenericContainer {
    private ContainerHeirarchyLevel cHL;
    private ContainerHeirarchy cH;
    private String containerId;


    public MappedWeight<ContainerHeirarchyLevel,Fraction> getWeight(){
        List<GenericContainer> children = cH.getChildren(containerId,cHL);
        MappedWeight myWeight = cH.getWeightOfCurrentLevel(this,children);
        GenericContainer parent = cH.getParent(containerId,cHL);
        if(parent!=null) {
            myWeight.combine(parent.getWeight());
        }


        return myWeight;



    }
}
