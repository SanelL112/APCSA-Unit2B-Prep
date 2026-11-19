package review;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Unit 2B Practice FRQ Part (a): Box.packBox
 *
 * A shipping company packs items into boxes using the Box class.
 * Items are packed one at a time in the order returned by getItemWeight().
 * Packing stops when the next item would make the total weight greater than
 * maxWeight. That item is not packed. Return the number of items packed.
 */
public class Box {

    private static Queue<Double> testWeights = null;

    /**
     * Loads a deterministic sequence of item weights for unit testing.
     */
    public static void setTestWeights(double... weights) {
        testWeights = new ArrayDeque<>();
        for (double w : weights) {
            testWeights.add(w);
        }
    }

    /**
     * Clears any deterministic test weights so getItemWeight() returns random weights.
     */
    public static void resetTestWeights() {
        testWeights = null;
    }

    /**
     * Returns the weight of the next item to consider packing.
     * Uses the deterministic test queue when configured via setTestWeights().
     */
    public static double getItemWeight() {
        if (testWeights != null) {
            if (testWeights.isEmpty()) {
                throw new IllegalStateException("Test weight queue exhausted — check your loop termination condition!");
            }
            return testWeights.remove();
        }
        return 1.0 + Math.random() * 10.0;
    }

    /**
     * Packs items one at a time in the order returned by getItemWeight().
     * Stops when the next item would make the total weight strictly greater
     * than maxWeight (that item is not packed).
     *
     * @param maxWeight maximum allowed total weight for the box
     * @return the number of items packed
     */
    public static int packBox(double maxWeight) {
        throw new UnsupportedOperationException("TODO: implement packBox");
    }
}
