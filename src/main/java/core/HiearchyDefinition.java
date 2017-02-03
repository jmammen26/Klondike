package core;

/**
 * Created by davidsuarez on 1/26/17.
 */
public class HiearchyDefinition {

    public String id;
    public String[] parents;
    public String[] children;

    public HiearchyDefinition(String[] parents, String[] children) {
        this.parents = parents;
        this.children = children;
    }
}
