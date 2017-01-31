package core;

public abstract class Container {

    private Hierarchy hierarchy;
    private String id;
    public int cost;

    public Container(Hierarchy hierarchy, String id) {
        this.id = id;
        this.hierarchy = hierarchy;
        this.cost = 10;

    }

    public void calculateCost() {
        hierarchy.getChildren();
    }

    public void getChildren() {

    }

    public void getParent() {
    }
}
