public class Book extends AbstractItem{
    public final Integer PAGES;

    /**
     * Sets the class fields to the given parameters
     * @param name
     * @param weight
     * @param cost
     * @param pages
     */
    Book(String name, Integer weight, Integer cost, Integer pages) {
        super(name, weight, cost);
        this.PAGES = new Integer(pages);
    }
}
