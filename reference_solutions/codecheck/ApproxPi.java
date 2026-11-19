package codecheck;

public class ApproxPi {
    public double approxPi(int terms) {
        double sum = 0.0;
        for (int i = 0; i < terms; i++) {
            double term = 1.0 / (2 * i + 1);
            if (i % 2 == 0) {
                sum += term;
            } else {
                sum -= term;
            }
        }
        return sum * 4.0;
    }
}
