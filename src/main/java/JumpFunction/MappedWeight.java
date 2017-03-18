package JumpFunction;

import java.util.HashMap;

import static org.eclipse.collections.impl.factory.Iterables.mSet;

/**
 * Created by Jeevan on 3/10/17.
 */
public class MappedWeight<K extends ContainerHeirarchyLevel,V extends MathExpression> implements Weight<MappedWeight>  {

    private HashMap<K,V> weights;
    public MappedWeight(){
        weights= new HashMap();
    }

    public MappedWeight<K,V> combine(MappedWeight gcWeight) {
        MappedWeight result = new MappedWeight();
        result.weights.putAll(weights);
        result.weights.putAll(gcWeight.weights);
        return  result;
    }



}
