import java.util.Random;

public class RandomAlgorithm implements Algorithm {
    private Problem instance;
    private Random randomGenerator;

    /**
     * Sets the class members to the given parameters
     * @param instance
     */
    RandomAlgorithm(Problem instance) {
        this.instance = instance;
        randomGenerator = new Random();
    }

    /**
     * Will return a random item index from the list of items in the Problem instance of this object
     * @return
     */
    private int selectRandomItem() {
        return randomGenerator.nextInt(instance.getItems().size());
    }

    /**
     * Will add random items to the instance sack until the next item would go over the sack's capacity
     */
    @Override
    public void solve() {
        AbstractItem selectedItem;
        while (true) {
            selectedItem = instance.getItems().elementAt(selectRandomItem());                             // SELECT A RANDOM ITEM
            if (selectedItem.WEIGHT + instance.getSack().currentWeight() < instance.getSack().CAPACITY) { // IF THE ITEM FITS IN THE SACK...
                instance.getSack().addItem(selectedItem);                                                 //    ...IT IS ADDED TO ITS CONTENTS...
                instance.getItems().removeElement(selectedItem);                                          //    ...AND THE ITEM IS REMOVED FROM THE AVAILABLE ITEMS
            }
            else {                                                                                        // ELSE...
                break;                                                                                    //    ...THE SACK IS "FULL" SO THE ALGORITHM ENDS
            }
        }
    }
}
