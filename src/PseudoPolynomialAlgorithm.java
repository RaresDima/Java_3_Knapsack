public class PseudoPolynomialAlgorithm implements Algorithm {
    private Problem instance;
    public final int ITEM_COUNT;

    /**
     * Sets the class fields to the given parameters
     * @param instance
     */
    PseudoPolynomialAlgorithm(Problem instance) {
        this.instance = instance;
        ITEM_COUNT = instance.getItems().size() + 1;
    }

    /**
     * Simply returns the bigger of the two integers passed as parameters
     * @param x
     * @param y
     * @return
     */
    private int max(int x, int y) {
        if (x >= y) {
            return x;
        }
        else {
            return y;
        }
    }

    @Override
    public void solve() {

        int[][] m = new int[ITEM_COUNT][ITEM_COUNT];

        for (int j = 0; j <= instance.getSack().CAPACITY; ++j){
            m[0][j] = 0;
        }

        for (int i = 1; i <= instance.getItems().size(); ++i) {
            for (int j = 0; j <= instance.getSack().CAPACITY; ++j) {
                if (instance.getItems().elementAt(i-1).WEIGHT > j) {
                    m[i][j] = m[i - 1][j];
                }
                else {
                    m[i][j] = max(m[i - 1][j], m[i - 1][j - instance.getItems().elementAt(i - 1).WEIGHT] + instance.getItems().elementAt(i - 1).COST);
                    if (j == instance.getSack().CAPACITY && m[i][j] == m[i - 1][j - instance.getItems().elementAt(i - 1).WEIGHT] + instance.getItems().elementAt(i - 1).COST) {
                        instance.getSack().addItem(instance.getItems().elementAt(i - 1));
                        while (instance.getSack().currentWeight() > instance.getSack().CAPACITY)
                            instance.getSack().getContents().remove(0);
                    }
                }
            }
        }
    }
}
