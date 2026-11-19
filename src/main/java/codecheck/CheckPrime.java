package codecheck;

/**
 * CodeCheck #4: CheckPrime
 *
 * Given a positive int (>= 2), determine whether or not it is prime.
 *
 * Examples:
 * - 23 -> true
 * - 120 -> false
 */
public class CheckPrime {
    public boolean checkPrime(int num) {
        int count = 2;
        while (count < num) {
            if (num % count == 0) {
                return false;
            }
            count++;
        }
        return true;
    }
}