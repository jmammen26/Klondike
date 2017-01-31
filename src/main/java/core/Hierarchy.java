package core;

import java.util.List;
import java.util.Map;


public class Hierarchy {

    public Map<String, HiearchyDefinition> structure;

    public Hierarchy(Map<String, HiearchyDefinition> hd) {
        this.structure = hd;
    }

    public void getParents(String id) {
        structure.get(id);
    }

    public void getChildren(String id) {

    }
}

