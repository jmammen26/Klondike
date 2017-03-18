package JumpFunction;

import org.eclipse.collections.api.list.MutableList;

import java.util.List;

import static org.eclipse.collections.impl.factory.Iterables.mList;

/**
 * Created by Jeevan on 3/17/17.
 */
public class ContainerHeirarchy {
    public GenericContainer getParent(String containerId, ContainerHeirarchyLevel currentLevel) {
        return null;
    }

    public List<GenericContainer> getChildren(String containerId, ContainerHeirarchyLevel currentLevel) {
        return mList();
    }

    public MappedWeight getWeightOfCurrentLevel(GenericContainer gc, List<GenericContainer> children) {
        return null;
    }
}
