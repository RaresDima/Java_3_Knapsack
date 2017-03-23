public class Weapon extends AbstractItem{
    public final Integer DAMAGE;

    /**
     * Sets the class fields to the given parameters
     * @param name
     * @param weight
     * @param cost
     * @param damage
     */
    Weapon(String name, Integer weight, Integer cost, Integer damage) {
        super(name, weight, cost);
        this.DAMAGE = new Integer(damage);
    }
}
