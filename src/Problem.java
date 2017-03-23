import java.util.Vector;

public class Problem {
    private Knapsack sack;
    private Vector<AbstractItem> items;

    /**
     * Sets the class fields to the given parameters
     * @param sack
     * @param items
     */
    Problem(Knapsack sack, Vector<AbstractItem> items) {
        this.sack = sack;
        this.items = items;
    }

    /**
     * Returns a parsed String representation of the contents of the current instance
     * @return
     */
    public String toString() {

        this.sack.sort();

        StringBuffer buff = new StringBuffer("");

        buff.append(" * Problem\n");
        buff.append("\t * Sack\n");
        buff.append("\t\t * Value: " + this.getSack().currentCost() + "\n");
        buff.append("\t\t * Capacity: " + this.sack.CAPACITY + "\n");
        buff.append("\t\t * Contents:\n");
        for (AbstractItem item : this.sack.getContents()) {
            buff.append("\t\t\t * \"" + item.NAME + "\"\n");
            buff.append("\t\t\t\t * Weight:\t" + item.WEIGHT + "\n");
            buff.append("\t\t\t\t * Cost:\t" + item.COST + "\n");
            buff.append("\t\t\t\t * Profit:\t" + item.getProfit() + "\n");
        }
        buff.append("\n\t * Items:\n");
        for (AbstractItem item : this.items) {
            buff.append("\t\t * \"" + item.NAME + "\"\n");
            buff.append("\t\t\t * Weight:\t" + item.WEIGHT + "\n");
            buff.append("\t\t\t * Cost:\t" + item.COST + "\n");
            buff.append("\t\t\t * Profit:\t" + item.getProfit() + "\n");
        }
        buff.append("\n\n\n");

        return new String(buff);
    }

    /**
     * Returns the item list of the this object
     * @return
     */
    public Vector<AbstractItem> getItems() {
        return items;
    }

    /**
     * Returns the Knapsack member of this object
     * @return
     */
    public Knapsack getSack() {
        return sack;
    }
}
