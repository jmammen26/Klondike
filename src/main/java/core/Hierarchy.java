package core;

import java.util.Map;


public class Hierarchy {

    public Map<String, HiearchyDefinition> structure;

    public Hierarchy(Map<String, HiearchyDefinition> hd) {
        this.structure = hd;
    }

    public String[] getParents(String id) {
        return structure.get(id).parents;
    }

    public String[] getChildren(String id) {
        return structure.get(id).children;
    }
}

