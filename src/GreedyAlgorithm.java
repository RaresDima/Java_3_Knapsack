public class GreedyAlgorithm implements Algorithm {
    private Problem instance;

    /**
     * Sets the class members to the given parameters
     * @param instance
     */
    GreedyAlgorithm(Problem instance) {
        this.instance = instance;
    }

    /**
     * Returns the index of the item with the biggest profit from the available items in the Problem instance
     * @return
     */
    public int selectGreedyItem() {
        AbstractItem greedyItem = instance.getItems().elementAt(0);
        for (AbstractItem i : instance.getItems()) {
            if (i.getProfit() >= greedyItem.getProfit() && i.WEIGHT <= greedyItem.WEIGHT) {
                greedyItem = i;
            }
        }
        return instance.getItems().indexOf(greedyItem);
    }

    @Override
    public void solve() {
        AbstractItem selectedItem;
        while (true) {
            selectedItem = instance.getItems().elementAt(selectGreedyItem());
            if (selectedItem.WEIGHT + instance.getSack().currentWeight() < instance.getSack().CAPACITY) { // IF THE ITEM FITS IN THE SACK...
                instance.getSack().addItem(selectedItem);                                                 //    ...IT IS ADDED TO ITS CONTENTS...
                instance.getItems().removeElement(selectedItem);                                          //    ...AND THE ITEM IS REMOVED FROM THE AVAILABLE ITEMS
            }
            else {                                                                                        // ELSE THERE ARE NO MORE ITEMS...
                break;                                                                                    //    ...THE SACK IS "FULL" SO THE ALGORITHM ENDS
            }
        }
    }
}
