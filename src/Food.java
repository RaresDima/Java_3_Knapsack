public class Food extends AbstractItem{
    public final Integer HP_RESTORED;

    /**
     * Sets the class fields to the given parameters
     * @param name
     * @param weight
     * @param cost
     * @param hpRestored
     */
    Food(String name, Integer weight, Integer cost, Integer hpRestored) {
        super(name, weight, cost);
        this.HP_RESTORED = new Integer(hpRestored);
    }
}
