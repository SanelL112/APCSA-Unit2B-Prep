package review;

import java.util.ArrayDeque;
import java.util.Queue;

public class Box {

    private static Queue<Double> testWeights = null;

    public static void setTestWeights(double... weights) {
        testWeights = new ArrayDeque<>();
        for (double w : weights) {
            testWeights.add(w);
        }
    }

    public static void resetTestWeights() {
        testWeights = null;
    }

    public static double getItemWeight() {
        if (testWeights != null) {
            if (testWeights.isEmpty()) {
                throw new IllegalStateException("Test weight queue exhausted");
            }
            return testWeights.remove();
        }
        return 1.0 + Math.random() * 10.0;
    }

    public static int packBox(double maxWeight) {
        int count = 0;
        double total = 0;
        double next = getItemWeight();
        while (total + next <= maxWeight) {
            count++;
            total += next;
            next = getItemWeight();
        }
        return count;
    }
}
