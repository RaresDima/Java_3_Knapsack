import java.util.Vector;

public class Knapsack {
    public final Integer CAPACITY;
    private Vector<AbstractItem> contents;

    /**
     * Sets the class fields to the given parameters
     * @param capacity
     */
    Knapsack(Integer capacity) {
        this.CAPACITY = new Integer(capacity);
        this.contents = new Vector<>();
    }

    /**
     * Returns the contents object
     * @return
     */
    public Vector<AbstractItem> getContents() {
        return contents;
    }

    /**
     * Adds the given item to the list of contents in the sack
     * @param item
     */
    public void addItem(AbstractItem item) {
        this.contents.addElement(item);
    }

    /**
     * Sorts the contents of the contents list according to profit factor and then name
     */
    public void sort() {
        for (int i = 0; i < contents.size() - 1; ++i) {
            if (contents.elementAt(i).compareTo(contents.elementAt(i + 1)) > 0) {
                contents.set(i + 1, contents.set(i, contents.elementAt(i + 1)));
                i = -1;
            }
        }
    }

    /**
     * Returns the total weight of all the items in the Knapsack
     * @return
     */
    public int currentWeight() {
        int weight = 0;
        for (AbstractItem i : contents) {
            weight += i.WEIGHT;
        }
        return weight;
    }

    /**
     * Returns the total cost of all the items in this Knapsack
     * @return
     */
    public int currentCost() {
        int cost = 0;
        for (AbstractItem i : contents) {
            cost += i.COST;
        }
        return cost;
    }

}
