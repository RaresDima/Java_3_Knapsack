import org.jetbrains.annotations.NotNull;

public abstract class AbstractItem implements Item, Comparable<AbstractItem>{
    public final String NAME;
    public final Integer WEIGHT;
    public final Integer COST;

    /**
     * Sets the class fields to the constructor parameters
     * @param name
     * @param weight
     * @param cost
     */
    AbstractItem(String name, Integer weight, Integer cost) {
        this.NAME   = new String(name);
        this.WEIGHT = new Integer(weight);
        this.COST   = new Integer(cost);
    }

    /**
     * Implementing the Item interface getProfit method
     * @return
     */
    @Override
    public double getProfit() {
        return ((COST / 1.0) / (WEIGHT / 1.0));
    }

    /**
     * Returns 1 if this object is greater than the parameter, 0 if they are equal or -1 if it is smaller
     * @param item
     * @return
     */
    @Override
    public int compareTo(@NotNull AbstractItem item) {
        if (this.getProfit() > item.getProfit()) {
            return 1;
        }
        else if (this.getProfit() < item.getProfit()) {
            return -1;
        }
        else if (this.getProfit() == item.getProfit()) {
            if (this.NAME.compareTo(item.NAME) > 0) {
                return 1;
            }
            else if (this.NAME.compareTo(item.NAME) < 0) {
                return 0;
            }
            else if (this.NAME.compareTo(item.NAME) == 0) {
                return 0;
            }
        }
        return 0;
    }
}
