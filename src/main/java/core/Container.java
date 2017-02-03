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

    public int calculateCost() {

        int childCost = 0;
        String[] children = getChildren();
        for(String id : children) {
            Container childContainer = queryDB(id);
            childCost += childContainer.calculateCost();

        }

        return cost + childCost;
    }

    public String[] getChildren() {
        return hierarchy.getChildren(id);
    }

    public void getParents() {
        hierarchy.getParents(id);
    }

    public Container queryDB(String id) {
        return null;
    }
}
