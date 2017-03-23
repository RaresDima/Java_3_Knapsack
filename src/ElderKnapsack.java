import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class ElderKnapsack {

    /**
     * Generates and returns a sample Problem object with a sack and some items
     */
    public static Problem generateSampleProblem(){
        Knapsack sack = new Knapsack(10);
        Vector<AbstractItem> items = new Vector<>();

        items.addElement(new Book("Dragon Rising", 3, 5, 100));
        items.addElement(new Book("A Blade in the Dark", 3, 5, 60));
        items.addElement(new Book("Blade of the Nerevar", 3, 6, 150));
        items.addElement(new Food("Cabbage", 2, 4, 10));
        items.addElement(new Food("Rabbit", 2, 4, 25));
        items.addElement(new Food("Cake", 1, 3, 15));
        items.addElement(new Weapon("Ancient Nord Sword", 4, 9, 15));
        items.addElement(new Weapon("Ebony Bow", 3, 8, 30));
        items.addElement(new Weapon("Imperial Dagger", 3, 5, 5));

        return new Problem(sack, items);
    }

    /**
     * Runs a simple demonstration of the random algorithm
     */
    public static void randomDemo() {
        Problem instance = generateSampleProblem();

        Algorithm solver = new RandomAlgorithm(instance);

        solver.solve();

        System.out.println(instance.toString());
    }

    /**
     * Runs a simple demonstration of the greedy algorithm
     */
    public static void greedyDemo() {
        Problem instance = generateSampleProblem();

        Algorithm solver = new GreedyAlgorithm(instance);

        solver.solve();

        System.out.println(instance.toString());
    }

    /**
     * Runs a simple demonstration of the pseudo polynomial algorithm
     */
    public static void pseudoPolynomialDemo() {
        long start = System.nanoTime();

        Problem instance = generateSampleProblem();
        Algorithm solver = new PseudoPolynomialAlgorithm(instance);
        solver.solve();

        long stop = System.nanoTime();

        System.out.println(instance.toString());

        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory()/1024 + " kB");
        System.out.println("Free memory:  " + Runtime.getRuntime().freeMemory()/1024 + " kB");
        System.out.println("Used memory:   " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024 + " kB");
        System.out.println("Time:      " + (stop - start)/1000000.0 + " ms");
    }

    /**
     * Runs a demonstration of a random problem, with itemCount items with weights between 1 and 75% of the sack capacity and values from 1 to 30
     * @param itemCount
     * @param sackCapacity
     */
    public static void pseudoPolynomialRandom(int itemCount, int sackCapacity) throws IOException{

        Problem instance = new Problem(new Knapsack(sackCapacity), new Vector<AbstractItem>());

        Random randomGenerator = new Random();

        // GENERATES itemCount RANDOM ITEMS
        for (Integer i = 0; i < itemCount; ++i)
            instance.getItems().addElement(new Book("Item " + i.toString(),
                                                    randomGenerator.nextInt(instance.getSack().CAPACITY * 1 / 3) + 1,
                                                    randomGenerator.nextInt(instance.getSack().CAPACITY * 3) + 1 + instance.getSack().CAPACITY,
                                                    30));

        Algorithm solver    = new PseudoPolynomialAlgorithm(instance);
        StatCounter counter = new StatCounter();

        counter.start();
        solver.solve();
        counter.stop();

        FileWriter fd = new FileWriter("output.txt");
        fd.write(instance.toString());
        fd.write(counter.toString());
        fd.flush();
        fd.close();
    }



    public static void main(String[] args) throws IOException{
        pseudoPolynomialRandom(1000, 150);
    }
}
