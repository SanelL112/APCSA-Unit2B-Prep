package codecheck;

public class LargestDigit {
    public int largestDigit(int num) {
        int max = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit > max) {
                max = digit;
            }
            num /= 10;
        }
        return max;
    }
}
