package codecheck;

/**
 * CodeCheck #3: ApproxPi
 *
 * The Leibniz approximation for pi is:
 * pi/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
 * Given a number of terms (>= 1), return the Leibniz approximation for pi
 * to that many terms.
 *
 * Examples:
 * - 1 -> 4.0
 * - 25 -> 3.1815766854350325
 */
public class ApproxPi {
    public double approxPi(int terms) {
        double total = 0.0;
        int denominator = 1;
        boolean subtract = false;
        for (int i = 0; i < terms; i++) {
            if (i % 2 == 0) {
                subtract = false;
            } else {
                subtract = true;
            }
            if (subtract) {
                total -= (double) 1 / denominator;

            } else {
                total += (double) 1 / denominator;
            }

            denominator += 2;


        }
        return total*4;
    }

}

